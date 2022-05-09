package com.facebookweb.dao;

import com.facebookweb.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fb);

	int loginProfileDAO(FacebookUser fb);

	FacebookUser viewProfileDAO(FacebookUser fb);

}
