package com.housing.recoland.db.models;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class HotelDetails {
    private Double latitude;
    private Double longitude;
    private String cuisineType;
    private Double rating;
    private Double distance;

    public HotelDetails() {
    }

    public HotelDetails(Double latitude, Double longitude, String cuisineType, Double rating) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.cuisineType = cuisineType;
        this.rating = rating;
    }

    public HotelDetails(Double latitude, Double longitude, String cuisineType, Double rating, Double distance) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.cuisineType = cuisineType;
        this.rating = rating;
        this.distance = distance;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
