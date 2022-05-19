package com.instagramboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.instagramboot.entity.InstagramUser;
import com.instagramboot.service.InstagramServiceInterface;

@RestController
public class InstagramController {
	
	@Autowired
	private InstagramServiceInterface instas;

	@PostMapping("createProfile")
	public String createProfile(@RequestBody InstagramUser iu) {
		return instas.createProfileService(iu);
	}
	
	@GetMapping("viewAllProfile")
	public List<InstagramUser> viewAll(){
		return instas.getAllProfileService();
	}
	
	@GetMapping("viewProfile/{id}")
	public InstagramUser viewProfile(@PathVariable("id") String uid){
		return instas.getProfileService(uid);
	}
	
	@DeleteMapping("deleteProfile/{id}")
	public String deleteProfile(@PathVariable("id") String uid) {
		return instas.deleteProfileService(uid);
	}
	
	@PutMapping("editProfile/{id}")
	public String editProfile(@PathVariable("id") String uid,@RequestBody InstagramUser iu) {
		return instas.editProfileService(iu);
	}
	
	@GetMapping("loginUser/{id}/{password}")
	public String loginProfile(@PathVariable("id") String uid,@PathVariable("password") String password) {
		return instas.loginProfileService(uid,password);
	}
}
















