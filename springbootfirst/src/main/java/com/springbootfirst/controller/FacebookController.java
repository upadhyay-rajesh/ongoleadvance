package com.springbootfirst.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springbootfirst.entity.FacebookUser;
import com.springbootfirst.service.FacebookServiceInterface;

@RestController
public class FacebookController {
	//@RequestMapping(method = RequestMethod.GET,value = "viewAllProfile")
	
	@Autowired
	private FacebookServiceInterface fs;
	
	@GetMapping("viewAllProfile")
	public List<FacebookUser> all(){
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		
		FacebookUser f1=new FacebookUser();
		f1.setName("Riyaz");
		f1.setPassword("rrrr");
		f1.setEmail("riyaz@gmail.com");
		f1.setAddress("Bangalore");
		
		FacebookUser f2=new FacebookUser();
		f2.setName("Riyaz12");
		f2.setPassword("rrrr12");
		f2.setEmail("riyaz@gmail12.com");
		f2.setAddress("Bangalore12");
		
		ll.add(f1);
		ll.add(f2);
		
		return ll;
	}
	//@RequestMapping(method = RequestMethod.POST,value = "createRecord")
	@PostMapping("createRecord")
	public String createProfile(@RequestBody FacebookUser fb) {
		return fs.createProfileService(fb);
	}
	@PutMapping("updateRecord")
	public String updateProfile() {
		return "profile updated";
	}
	@DeleteMapping("deleteRecord/{uid}")
	public String deleteProfile(@PathVariable("uid") String userid) {
		return "profile deleted for "+userid;
	}

}







