package com.housing.recoland.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.housing.recoland.beans.GeoLocationDist;
import com.housing.recoland.beans.LatLong;
import com.housing.recoland.beans.RecommendedLand;
import com.housing.recoland.db.dao.DBUtils;
import com.housing.recoland.db.models.*;
import com.housing.recoland.service.utils.*;
import com.housing.recoland.utils.JsonUtils;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class RecoLandService {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = args[0];

        Set<LandDetails> landDetailsList = Sets.newHashSet();
        for (BrowseHistory browseHistory : DBUtils.getBrowseHistory(userName)) {
            landDetailsList.addAll(LandDetailsUtils.getClosestLandDetails(browseHistory.getLatitude(),
                    browseHistory.getLongitude()));
        }

        List<RecommendedLand> recommendedLands = Lists.newArrayList();
        for (LandDetails landDetails : landDetailsList) {
            Double score = 0.0;

            //Get score based on food interests
            List<FoodHistory> foodHistoryList = DBUtils.getFoodHistory(userName);
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
            List<MovieHistory> movieHistoryList = DBUtils.getMovieHistory(userName);
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
            List<BrowseHistory> browseHistoryList = DBUtils.getBrowseHistory(userName);
            for (BrowseHistory browseHistory : browseHistoryList) {
                latLongs.add(new LatLong(browseHistory.getSearchLatitude(), browseHistory.getLongitude()));
            }
//            score += RatingCalculator.getInterestedPlacesRating(latLongs, landDetails.getLatitude(), landDetails.getLongitude());

            //Set hotel list
            for (HotelDetails hotelDetails : hotelDetailsList) {
                hotelDetails.setDistance(DistanceCalculator.getDistance(hotelDetails.getLatitude(), hotelDetails.getLongitude(),
                        landDetails.getLatitude(), landDetails.getLongitude()));
            }

            //Set theater list
            for (TheaterDetails theaterDetails : theaterDetailsList) {
                theaterDetails.setDistance(DistanceCalculator.getDistance(theaterDetails.getLatitude(), theaterDetails.getLongitude(),
                        landDetails.getLatitude(), landDetails.getLongitude()));
            }

            //Set search location list
            List<GeoLocationDist> geoLocationDists = Lists.newArrayList();
            for (BrowseHistory browseHistory : browseHistoryList) {
                geoLocationDists.add(new GeoLocationDist(browseHistory.getSearchLatitude(), browseHistory.getSearchLongitude(),
                        browseHistory.getSearchLocationName(), DistanceCalculator.getDistance(browseHistory.getSearchLatitude(),
                        browseHistory.getSearchLongitude(), landDetails.getLatitude(), landDetails.getLongitude())));
            }

            recommendedLands.add(new RecommendedLand(landDetails, score, geoLocationDists, hotelDetailsList, theaterDetailsList));
        }
        System.out.println(JsonUtils.DEFAULT.toJson(recommendedLands));
    }

}
