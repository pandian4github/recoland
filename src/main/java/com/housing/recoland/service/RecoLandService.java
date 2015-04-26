package com.housing.recoland.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.housing.recoland.beans.GeoLocationDist;
import com.housing.recoland.beans.LatLong;
import com.housing.recoland.beans.RecommendedLand;
import com.housing.recoland.db.dao.DBUtils;
import com.housing.recoland.db.models.*;
import com.housing.recoland.service.utils.*;
import com.housing.recoland.utils.JsonUtils;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class RecoLandService {
    public static String getRecommendedLands(String username) throws SQLException, ClassNotFoundException {
        Set<LandDetails> landDetailsList = Sets.newHashSet();
        for (BrowseHistory browseHistory : DBUtils.getBrowseHistory(username)) {
            landDetailsList.addAll(LandDetailsUtils.getClosestLandDetails(browseHistory.getLatitude(),
                    browseHistory.getLongitude()));
        }

        if (landDetailsList.size() == 0) {
            landDetailsList = new HashSet<LandDetails>(DBUtils.getLandDetails());
        }
        List<FoodHistory> foodHistoryList = DBUtils.getFoodHistory(username);
        List<MovieHistory> movieHistoryList = DBUtils.getMovieHistory(username);
        List<BrowseHistory> browseHistoryList = DBUtils.getBrowseHistory(username);
        List<HotelDetails> allHotelDetailsList = DBUtils.getHotelDetails();
        List<TheaterDetails> allTheaterDetailsList = DBUtils.getTheaterDetails();

        List<RecommendedLand> recommendedLands = Lists.newArrayList();
        for (LandDetails landDetails : landDetailsList) {
            Double score = 0.0;

            //Get score based on food interests
            List<HotelDetails> hotelDetailsList = HotelDetailsUtils.getClosestHotelDetails(landDetails.
                    getLatitude(), landDetails.getLongitude());
            List<String> cuisineList = Lists.transform(foodHistoryList, new Function<FoodHistory, String>() {
                @Override
                public String apply(FoodHistory input) {
                    return input.getCuisineType();
                }
            });
            Set<String> cuisineSet = new HashSet<String>(cuisineList);
            score += RatingCalculator.getHotelRating(hotelDetailsList, cuisineSet, landDetails);

            //Get score based on movie interests
            List<TheaterDetails> theaterDetailsList = TheaterDetailsUtils.getClosestTheaterDetails(landDetails.
                    getLatitude(), landDetails.getLongitude());
            List<String> movieTypeList = Lists.transform(movieHistoryList, new Function<MovieHistory, String>() {
                @Override
                public String apply(MovieHistory input) {
                    return input.getMovieLanguage();
                }
            });
            Set<String> movieTypeSet = new HashSet<String>(movieTypeList);
            score += RatingCalculator.getTheaterRating(theaterDetailsList, movieTypeSet, landDetails);

            //Get score based on search history
            Set<LatLong> latLongs = Sets.newHashSet();
            for (BrowseHistory browseHistory : browseHistoryList) {
                latLongs.add(new LatLong(browseHistory.getSearchLatitude(), browseHistory.getLongitude()));
            }
            score += RatingCalculator.getInterestedPlacesRating(latLongs, landDetails);

            Double userRating = RatingCalculator.getUserRating(DBUtils.getUserRatings(), landDetails);
            score += userRating;

            //Set hotel list
            List<HotelDetails> newHotelDetailsList = Lists.newArrayList();
            for (HotelDetails hotelDetails : hotelDetailsList) {
                if (cuisineList.contains(hotelDetails.getCuisineType())) {
                    hotelDetails.setDistance(DistanceCalculator.getDistance(hotelDetails.getLatitude(), hotelDetails.getLongitude(),
                            landDetails.getLatitude(), landDetails.getLongitude()));
                    newHotelDetailsList.add(hotelDetails);
                }
            }

            //Set theater list
            List<TheaterDetails> newTheaterDetailsList = Lists.newArrayList();
            for (TheaterDetails theaterDetails : theaterDetailsList) {
                if (movieTypeSet.contains(theaterDetails.getMovieType())) {
                    theaterDetails.setDistance(DistanceCalculator.getDistance(theaterDetails.getLatitude(), theaterDetails.getLongitude(),
                            landDetails.getLatitude(), landDetails.getLongitude()));
                    newTheaterDetailsList.add(theaterDetails);
                }
            }

            //Set search location list
            List<GeoLocationDist> geoLocationDists = Lists.newArrayList();
            for (BrowseHistory browseHistory : browseHistoryList) {
                geoLocationDists.add(new GeoLocationDist(browseHistory.getSearchLatitude(),
                        browseHistory.getSearchLongitude(),
                        browseHistory.getSearchLocationName(),
                        DistanceCalculator.getDistance(browseHistory.getSearchLatitude(),
                        browseHistory.getSearchLongitude(), landDetails.getLatitude(), landDetails.getLongitude())));
            }

            recommendedLands.add(new RecommendedLand(landDetails, score, geoLocationDists, newHotelDetailsList,
                    newTheaterDetailsList, userRating));
        }
        Collections.sort(recommendedLands, new Comparator<RecommendedLand>() {
            @Override
            public int compare(RecommendedLand o1, RecommendedLand o2) {
                return o2.getScore().compareTo(o1.getScore());
            }
        });
        Map<String, Object> responseMap = Maps.newHashMap();
        responseMap.put("browseHistory", browseHistoryList);
        responseMap.put("hotels", allHotelDetailsList);
        responseMap.put("theaters", allTheaterDetailsList);
        responseMap.put("recommendedLands", recommendedLands);
        return JsonUtils.DEFAULT.toJson(responseMap);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(getRecommendedLands("vignesh"));
    }
}
