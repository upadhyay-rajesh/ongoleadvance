package com.facebookweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.facebookweb.entity.FacebookUser;

public class FacebookDAO implements FacebookDAOInterface {

	public int createProfileDAO(FacebookUser fb) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajesh");
			PreparedStatement ps=con.prepareStatement("insert into facebookweb values(?,?,?,?)");
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getPassword());
			ps.setString(3,fb.getEmail() );
			ps.setString(4, fb.getAddress());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int loginProfileDAO(FacebookUser fb) {
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajesh");
			PreparedStatement ps=con.prepareStatement("select * from facebookweb where name=? and password=?");
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getPassword());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				i=1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public FacebookUser viewProfileDAO(FacebookUser fb) {
		FacebookUser fs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajesh");
			PreparedStatement ps=con.prepareStatement("select * from facebookweb where name=? ");
			ps.setString(1, fb.getName());
					
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				fs=new FacebookUser();
				fs.setName(res.getString(1));
				fs.setPassword(res.getString(2));
				fs.setEmail(res.getString(3));
				fs.setAddress(res.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return fs;
	}

}




