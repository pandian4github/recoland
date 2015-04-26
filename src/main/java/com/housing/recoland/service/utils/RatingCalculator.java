package com.housing.recoland.service.utils;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.housing.recoland.beans.LatLong;
import com.housing.recoland.db.models.HotelDetails;
import com.housing.recoland.db.models.LandDetails;
import com.housing.recoland.db.models.TheaterDetails;
import com.housing.recoland.db.models.UserRating;

public class RatingCalculator {

    public static double getDistanceScore(double distance){
        List<Double> distanceCutoffs = Lists.newArrayList(0.05, 0.1, 0.2, 0.4, 0.6, 0.8, 1.0, 1.4, 1.6, 1.9, 2.4,
                3.0, 4.5, 5.2, 6.0, 7.0, 8.3, 9.5, 11.0, 13.0, 15.0, 17.0, 20.0, 24.0, 30.0);
        if (distance < distanceCutoffs.get(0)) {
            return 50;
        }
        int index;
        for (index = 1; index < distanceCutoffs.size(); index++) {
            if (distance >= distanceCutoffs.get(index - 1) && distance < distanceCutoffs.get(index)) {
                return 50 - (2 * index);
            }
        }
        return 50.0 - (2.0 * index);
    }

    public static double getHotelRating(List<HotelDetails> hotelList, Set<String> cuisineSet, LandDetails land){
        double score = 0;
        int hotelCount = 0;
        for (HotelDetails hotel : hotelList) {
            if(cuisineSet.contains(hotel.getCuisineType())) {
                score += (hotel.getRating() * 10 + getDistanceScore(DistanceCalculator.getDistance(hotel.getLatitude(),
                        hotel.getLongitude(), land.getLatitude(), land.getLongitude())));
                hotelCount++;
            }
        }
        if (hotelCount == 0) {
            return 0.0;
        }
        double averageScore = score / hotelCount;
        averageScore = averageScore * hotelCount / 3;
        averageScore = Math.min(averageScore, 100.0);
        return (averageScore / 100) * 3;
    }

    public static double getTheaterRating(List<TheaterDetails> theaterList, Set<String> movieTypeSet, LandDetails land){
        double score = 0;
        int theaterCount = 0;
        for(TheaterDetails theater : theaterList){
            if(movieTypeSet.contains(theater.getMovieType())){
                score += (theater.getRating() * 10 + getDistanceScore(DistanceCalculator.getDistance(theater.getLatitude(),
                        theater.getLongitude(), land.getLatitude(), land.getLongitude())));
                theaterCount++;
            }
        }
        if (theaterCount == 0) {
            return 0.0;
        }

        double averageScore = score / theaterCount;
        averageScore = averageScore * theaterCount / 3; //3 is a threshold value - minimum number of theaters required in a locality
        averageScore = Math.min(averageScore, 100.0);
        return (averageScore / 100) * 3;
    }

    public static double getInterestedPlacesRating(Set<LatLong> latLongList, LandDetails land){
        double score = 0;
        for(LatLong latLong: latLongList){
            score += getDistanceScore(DistanceCalculator.getDistance(latLong.latitude, latLong.longitude, land.getLatitude(),
                    land.getLongitude()));
        }

        if (latLongList.size() == 0) {
            return 0.0;
        }

        score *= 2;
        score /= latLongList.size();
        return (score / 100) * 4;
    }

    public static double getUserRating(List<UserRating> userRatings, LandDetails landDetails) {
        double sum = 0.0;
        int count = 0;
        for (UserRating userRating : userRatings) {
            if (userRating.getLatitude().equals(landDetails.getLatitude()) && userRating.getLongitude().equals(landDetails.getLongitude())) {
                sum += userRating.getRating();
                count++;
            }
        }
        if (count == 0) {
            return 3;
        }
        double averageScore = sum / count;
        averageScore = averageScore * count / 2;
        averageScore = Math.min(averageScore, 10.0);
        return averageScore;
    }
}

