package com.housing.recoland.utils;

import java.util.List;
import java.util.Set;

import com.housing.recoland.db.models.HotelDetails;
import com.housing.recoland.db.models.LandDetails;

public class RatingCalculator {

    public static double getDistanceScore(double distance){
        if(distance<=2){
            return 50;
        } else if(distance<=5){
            return 45;
        } else {
            return 25;
        }
    }

    public static double getHotelRating(List<HotelDetails> hotelList, Set<String> cuisineSet, LandDetails land){
        double score=0;
        int hotelCount=0;
        for(HotelDetails hotel : hotelList){
            if(cuisineSet.contains(hotel.getCuisineType())){
                score += (hotel.getRating() * 10 + getDistanceScore(DistanceCalculator.getDistance(hotel.getLatitude(),
                        hotel.getLongitude(), land.getLatitude(), land.getLongitude())));
                hotelCount++;
            }
        }
        double averageScore = score / hotelCount;
        return (averageScore / 100) * 3;
    }
}