package com.facebookweb.service;

import com.facebookweb.dao.FacebookDAO;
import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface {

	public int createProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		
		return fd.createProfileDAO(fb);
	}

	public int loginProfileService(FacebookUser fb) {
FacebookDAOInterface fd=new FacebookDAO();
		
		return fd.loginProfileDAO(fb);
	}

	public FacebookUser viewProfileService(FacebookUser fb) {
FacebookDAOInterface fd=new FacebookDAO();
		
		return fd.viewProfileDAO(fb);
	}

}
