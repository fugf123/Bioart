package com.xiaowa.bioart.util;

/**
 * Created by hsdev-08 on 2017-04-14.
 */
public class DistanceUtil {

    private static final Double EARTHRADIUS = 6370996.81;

    public static Double getDistance(Double lng1, Double lat1, Double lng2, Double lat2) {

        lng1 = _getLoop(lng1, -180.0, 180.0);
        lat1 = _getRange(lat1, -74.0, 74.0);
        lng2 = _getLoop(lng2, -180.0, 180.0);
        lat2 = _getRange(lat2, -74.0, 74.0);

        lng1 = degreeToRad(lng1);
        lat1 = degreeToRad(lat1);
        lng2 = degreeToRad(lng2);
        lat2 = degreeToRad(lat2);


        return EARTHRADIUS * Math.acos((Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lng2 - lng1)));
    }


    /**
     * 将v值限定在a,b之间，经度使用
     */
    public static Double _getLoop(Double v, Double a, Double b) {
        while (v > b) {
            v -= b - a;
        }
        while (v < a) {
            v += b - a;
        }
        return v;
    }

    /**
     * 将v值限定在a,b之间，纬度使用
     */
    public static Double _getRange(Double v, Double a, Double b) {
        if (a != null) {
            v = Math.max(v, a);
        }
        if (b != null) {
            v = Math.min(v, b);
        }
        return v;
    }

    public static Double degreeToRad(Double degree) {
        return Math.PI * degree / 180;
    }
}
