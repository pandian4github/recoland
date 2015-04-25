package com.housing.recoland.service.utils;

import com.housing.recoland.db.dao.DBUtils;
import com.housing.recoland.db.models.HotelDetails;
import com.housing.recoland.db.models.TheaterDetails;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class TheaterDetailsUtils {
    public static List<TheaterDetails> getClosestTheaterDetails(Double latitude, Double longitude)
            throws SQLException, ClassNotFoundException {
        List<TheaterDetails> allTheaterDetails = DBUtils.getTheaterDetails();
        for (TheaterDetails theaterDetails : allTheaterDetails) {
            theaterDetails.setDistance(DistanceCalculator.getDistance(theaterDetails.getLatitude(), theaterDetails.getLongitude(),
                    latitude, longitude));
        }
        Collections.sort(allTheaterDetails, new Comparator<TheaterDetails>() {
            @Override
            public int compare(TheaterDetails o1, TheaterDetails o2) {
                return ((o1.getDistance() < o2.getDistance()) ? 1 : 0);
            }
        });
        return allTheaterDetails.subList(0, 5);
    }
}
