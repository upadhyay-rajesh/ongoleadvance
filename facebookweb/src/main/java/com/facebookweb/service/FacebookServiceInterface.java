package com.facebookweb.service;

import com.facebookweb.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fb);

	int loginProfileService(FacebookUser fb);

	FacebookUser viewProfileService(FacebookUser fb);

}
