package com.octo.legacy.tripservice.tripservice;

import com.octo.legacy.tripservice.tripservice.exception.UserNotLoggedInException;
import com.octo.legacy.tripservice.tripservice.trip.Trip;
import com.octo.legacy.tripservice.tripservice.trip.TripDAO;
import com.octo.legacy.tripservice.tripservice.user.User;
import com.octo.legacy.tripservice.tripservice.user.UserSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class TripService {

	@RequestMapping(path="/getTripsByUser", method = GET)
	public List<Trip> getTripsByUser(@RequestParam String userId) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = UserSession.getInstance().getLoggedUser();
		boolean isFriend = false;
		if (loggedUser != null) {
			User user = TripDAO.getUserById(userId);
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = TripDAO.findTripsByUser(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}
	
}
