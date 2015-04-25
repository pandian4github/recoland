package com.housing.recoland.db.models;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class BrowseHistory {
    private String username;
    private Double latitude;
    private Double longitude;
    private Double searchLatitude;
    private Double searchLongitude;

    public BrowseHistory() {
    }

    public BrowseHistory(String username, Double latitude, Double longitude, Double searchLatitude, Double searchLongitude) {
        this.username = username;
        this.latitude = latitude;
        this.longitude = longitude;
        this.searchLatitude = searchLatitude;
        this.searchLongitude = searchLongitude;
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

    public Double getSearchLatitude() {
        return searchLatitude;
    }

    public void setSearchLatitude(Double searchLatitude) {
        this.searchLatitude = searchLatitude;
    }

    public Double getSearchLongitude() {
        return searchLongitude;
    }

    public void setSearchLongitude(Double searchLongitude) {
        this.searchLongitude = searchLongitude;
    }
}
