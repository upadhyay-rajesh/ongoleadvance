package com.springbootfirst.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootfirst.dao.FacebookDAOInterface;
import com.springbootfirst.entity.FacebookUser;

@Service
@Transactional
public class FacebookService implements FacebookServiceInterface{
	
	@Autowired
	private FacebookDAOInterface fd;

	@Override
	public String createProfileService(FacebookUser fb) {
		fd.save(fb);
		return "profile created";
	}

}










