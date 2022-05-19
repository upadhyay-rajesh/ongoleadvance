package com.instagramboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.instagramboot.dao.InstagramDAOInterface;
import com.instagramboot.entity.InstagramUser;

@Service
@Transactional
@Scope(scopeName = "prototype")
public class InstagramService implements InstagramServiceInterface{
	
	@Autowired
	private InstagramDAOInterface idao;

	@Override
	public String createProfileService(InstagramUser iu) {
		idao.save(iu);
		return "profile created ";
	}

	@Override
	public List<InstagramUser> getAllProfileService() {
		return idao.findAll();
		
	}

	@Override
	public InstagramUser getProfileService(String uid) {
		// TODO Auto-generated method stub
		InstagramUser ss=null;
		Optional<InstagramUser> oo=idao.findById(uid);
		if(oo.isPresent()) {
			ss=oo.get();
		}
		return ss;
	}

	@Override
	public String deleteProfileService(String uid) {
		idao.deleteById(uid);
		return "profile deleted";
	}

	@Override
	public String editProfileService(InstagramUser iu) {
		idao.saveAndFlush(iu);
		return "profile edited";
	}

	@Override
	public String loginProfileService(String uid, String password) {
		InstagramUser uu=idao.findByIdandPassword(uid, password);
		if(uu!=null) {
		return "profile found";
		}
		else {
			return "profile not found";
		}
	}

}












