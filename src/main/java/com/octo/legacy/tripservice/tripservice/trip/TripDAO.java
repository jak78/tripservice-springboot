package com.octo.legacy.tripservice.tripservice.trip;

import com.octo.legacy.tripservice.tripservice.exception.CollaboratorCallException;
import com.octo.legacy.tripservice.tripservice.user.User;

import java.util.List;

public class TripDAO {

	public static List<Trip> findTripsByUser(User user) {
		throw new CollaboratorCallException(
				"TripDAO database not initialized.");
	}
	
}