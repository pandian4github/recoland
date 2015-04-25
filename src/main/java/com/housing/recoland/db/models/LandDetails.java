package com.housing.recoland.db.models;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class LandDetails {
    private Double latitude;
    private Double longitude;
    private String areaName;
    private Double area;
    private Double distance;

    public LandDetails() {
    }

    public LandDetails(Double latitude, Double longitude, String areaName, Double area) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.areaName = areaName;
        this.area = area;
    }

    public LandDetails(Double latitude, Double longitude, String areaName, Double area, Double distance) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.areaName = areaName;
        this.area = area;
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

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LandDetails) {
            LandDetails ld = (LandDetails) obj;
            return ld.area.equals(area) && ld.areaName.equals(areaName) && ld.latitude.equals(latitude)
                    && ld.longitude.equals(longitude);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return latitude.hashCode() + longitude.hashCode() + area.hashCode() + areaName.hashCode();
    }
}
