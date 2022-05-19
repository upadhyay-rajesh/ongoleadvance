package com.instagramboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.instagramboot.entity.InstagramUser;

@Repository
public interface InstagramDAOInterface extends JpaRepository<InstagramUser, String>{
	
	@Query("from com.instagramboot.entity.InstagramUser iu where iu.email=:em and iu.password=:pw")
	public InstagramUser findByIdandPassword(@Param("em")String id,@Param("pw")String password);

}
