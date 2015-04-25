package com.housing.recoland.service.utils;

import java.util.List;
import java.util.Set;

import com.housing.recoland.beans.LatLong;
import com.housing.recoland.db.models.HotelDetails;
import com.housing.recoland.db.models.LandDetails;
import com.housing.recoland.db.models.TheaterDetails;

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
        double score = 0;
        int hotelCount = 0;
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
        double averageScore = score / theaterCount;
        return (averageScore / 100) * 3;
    }
    
    public static double getInterestedPlacesRating(List<LatLong> latLongList){
    	double score = 0;
    	for(LatLong latLong: latLongList){
    		
    	}
    	
    	return 0;
    }
}