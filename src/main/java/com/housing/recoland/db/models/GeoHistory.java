package com.housing.recoland.db.models;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class GeoHistory {
    private String username;
    private Double latitude;
    private Double longitude;
    private String location;
    private String locationType;

    public GeoHistory() {
    }

    public GeoHistory(String username, Double latitude, Double longitude, String location, String locationType) {
        this.username = username;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location = location;
        this.locationType = locationType;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
}
