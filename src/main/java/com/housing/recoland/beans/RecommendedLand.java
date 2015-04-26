package com.housing.recoland.beans;

import com.housing.recoland.db.models.HotelDetails;
import com.housing.recoland.db.models.LandDetails;
import com.housing.recoland.db.models.TheaterDetails;

import java.util.List;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class RecommendedLand {
    private LandDetails landDetails;
    private Double score;
    private List<GeoLocationDist> geoLocationDists;
    private List<HotelDetails> hotelDetailsList;
    private List<TheaterDetails> theaterDetailsList;
    Double userRating;

    public RecommendedLand() {
    }

    public RecommendedLand(LandDetails landDetails, Double score, List<GeoLocationDist> geoLocationDists,
                           List<HotelDetails> hotelDetailsList, List<TheaterDetails> theaterDetailsList) {
        this.landDetails = landDetails;
        this.score = score;
        this.geoLocationDists = geoLocationDists;
        this.hotelDetailsList = hotelDetailsList;
        this.theaterDetailsList = theaterDetailsList;
    }

    public RecommendedLand(LandDetails landDetails, Double score, List<GeoLocationDist> geoLocationDists,
                           List<HotelDetails> hotelDetailsList, List<TheaterDetails> theaterDetailsList, Double userRating) {
        this.landDetails = landDetails;
        this.score = score;
        this.geoLocationDists = geoLocationDists;
        this.hotelDetailsList = hotelDetailsList;
        this.theaterDetailsList = theaterDetailsList;
        this.userRating = userRating;
    }

    public LandDetails getLandDetails() {
        return landDetails;
    }

    public void setLandDetails(LandDetails landDetails) {
        this.landDetails = landDetails;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<GeoLocationDist> getGeoLocationDists() {
        return geoLocationDists;
    }

    public void setGeoLocationDists(List<GeoLocationDist> geoLocationDists) {
        this.geoLocationDists = geoLocationDists;
    }

    public List<HotelDetails> getHotelDetailsList() {
        return hotelDetailsList;
    }

    public void setHotelDetailsList(List<HotelDetails> hotelDetailsList) {
        this.hotelDetailsList = hotelDetailsList;
    }

    public List<TheaterDetails> getTheaterDetailsList() {
        return theaterDetailsList;
    }

    public void setTheaterDetailsList(List<TheaterDetails> theaterDetailsList) {
        this.theaterDetailsList = theaterDetailsList;
    }

    public Double getUserRating() {
        return userRating;
    }

    public void setUserRating(Double userRating) {
        this.userRating = userRating;
    }
}
