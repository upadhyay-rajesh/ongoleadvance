package com.instagramboot.service;

import java.util.List;

import com.instagramboot.entity.InstagramUser;

public interface InstagramServiceInterface {

	String createProfileService(InstagramUser iu);

	List<InstagramUser> getAllProfileService();

	InstagramUser getProfileService(String uid);

	String deleteProfileService(String uid);

	String editProfileService(InstagramUser iu);

	String loginProfileService(String uid, String password);

}
