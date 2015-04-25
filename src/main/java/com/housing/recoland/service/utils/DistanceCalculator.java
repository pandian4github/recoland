package com.housing.recoland.service.utils;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class DistanceCalculator {
    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }
    public static double getDistance(double lat1, double lon1, double lat2, double lon2){
        final int R = 6371; // Radious of the earth
        Double latDistance = toRad(lat2-lat1);
        Double lonDistance = toRad(lon2-lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;
        return distance;
    }

    public static void main(String[] args) {
        System.out.println(getDistance(13.0800844,80.2716314,13.0816206,80.2662401));
        System.out.println(getDistance(12.9250987,77.6086342,12.9316244,77.6094345));
    }
}
