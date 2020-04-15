package com.octo.legacy.tripservice.tripservice.user;

public class UserSession {

	private static final UserSession userSession = new UserSession();
	public static final ThreadLocal<User> CONTEXT = new ThreadLocal<>();
	
	private UserSession() {
	}
	
	public static UserSession getInstance() {
		return userSession;
	}

	public User getLoggedUser() {
		return CONTEXT.get();
	}

}
