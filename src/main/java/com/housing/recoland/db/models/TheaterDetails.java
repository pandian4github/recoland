package com.housing.recoland.db.models;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class TheaterDetails {
    private Double latitude;
    private Double longitude;
    private String movieType;
    private Double rating;
    private Double distance;

    public TheaterDetails() {
    }

    public TheaterDetails(Double latitude, Double longitude, String movieType, Double rating) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.movieType = movieType;
        this.rating = rating;
    }

    public TheaterDetails(Double latitude, Double longitude, String movieType, Double rating, Double distance) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.movieType = movieType;
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

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
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
