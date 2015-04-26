package com.housing.recoland.db.models;

/**
 * Created by pandian.raju on 26/04/15.
 */
public class UserRating {
    private String username;
    private Double latitude;
    private Double longitude;
    private Double rating;

    public UserRating() {
    }

    public UserRating(String username, Double latitude, Double longitude, Double rating) {
        this.username = username;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
