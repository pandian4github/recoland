package com.housing.recoland.beans;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class GeoLocationDist {
    private Double latitude;
    private Double longitude;
    private String locationName;
    private Double distance;

    public GeoLocationDist() {
    }

    public GeoLocationDist(Double latitude, Double longitude, String locationName, Double distance) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationName = locationName;
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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
