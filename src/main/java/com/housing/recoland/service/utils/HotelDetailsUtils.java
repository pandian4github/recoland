package com.housing.recoland.service.utils;

import com.housing.recoland.db.dao.DBUtils;
import com.housing.recoland.db.models.HotelDetails;
import com.housing.recoland.db.models.LandDetails;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by pandian.raju on 25/04/15.
 */
public class HotelDetailsUtils {
    public static List<HotelDetails> getClosestHotelDetails(Double latitude, Double longitude)
            throws SQLException, ClassNotFoundException {
        List<HotelDetails> allHotelDetails = DBUtils.getHotelDetails();
        for (HotelDetails hotelDetails : allHotelDetails) {
            hotelDetails.setDistance(DistanceCalculator.getDistance(hotelDetails.getLatitude(), hotelDetails.getLongitude(),
                    latitude, longitude));
        }
        Collections.sort(allHotelDetails, new Comparator<HotelDetails>() {
            @Override
            public int compare(HotelDetails o1, HotelDetails o2) {
                return o1.getDistance().compareTo(o2.getDistance());
            }
        });
        return allHotelDetails.subList(0, Math.min(allHotelDetails.size(), 5));
    }
}
