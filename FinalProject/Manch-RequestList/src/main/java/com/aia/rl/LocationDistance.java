package com.aia.rl;

public class LocationDistance {


    public int distance(double lat1, double lon1, double lat2, double lon2) {
         
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
         
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        
        dist = dist * 1609.344; //meter 변환 
        
        return (int)(dist);
    }

	// This function converts decimal degrees to radians
	private  double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	// This function converts radians to decimal degrees
	private  double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

}
