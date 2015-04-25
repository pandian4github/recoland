package com.housing.recoland.db.models;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class LandDetails {
    private Double latitude;
    private Double longitude;
    private String areaName;
    private Double area;

    public LandDetails() {
    }

    public LandDetails(Double latitude, Double longitude, String areaName, Double area) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.areaName = areaName;
        this.area = area;
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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }
}
