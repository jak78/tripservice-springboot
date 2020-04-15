package com.octo.legacy.tripservice.tripservice.user;

import com.octo.legacy.tripservice.tripservice.exception.CollaboratorCallException;

public class UserSession {

	private static final UserSession userSession = new UserSession();
	
	private UserSession() {
	}
	
	public static UserSession getInstance() {
		return userSession;
	}

	public User getLoggedUser() {
		throw new CollaboratorCallException(
				"UserSession.getLoggedUser() requires the code to be executed inside the application server");
	}

}
