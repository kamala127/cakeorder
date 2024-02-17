package com.cakeorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cakeorder.Entity.User;
import com.cakeorder.dao.Userdao;

@RestController
public class UserController {

	@Autowired User user;
	@Autowired Userdao userdao;
	
	@PostMapping("/signup")
	public String adduser(@RequestParam("usermail")String userMail,
			@RequestParam("userpass")String userPass)
	{
		boolean k = false;
		List<User> u = userdao.findAll();
		for(int i=0;i<u.size();i++)
		{
			if(u.get(i).getUserMail().equals(userMail))
			{
				k=true;
			}
		}
		if(k==true)
		{
			return "Already Registered";
		}else
		{
			User uu = new User();
			uu.setPassword(userPass);
			uu.setUserMail(userMail);
			userdao.save(uu);
			
			return "Successfully saved";
		}
		
		
	}
	
	
	@GetMapping("/getalluser")
	public List<User> getall()
	{
		List<User> u = userdao.findAll();
		return u;
	}
	
	
	@PostMapping("/login")
	public boolean login(@RequestParam("mailid")String mailid,
			@RequestParam("password")String password)
	{
		
		List<User> u = userdao.getAll();
		for(int i=0;i<u.size();i++)
		{
			if(u.get(i).getUserMail().equals(mailid)&&u.get(i).getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
		
	}
	
	
}
