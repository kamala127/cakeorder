package com.cakeorder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cakeorder.Entity.User;
import com.cakeorder.dao.Userdao;

@CrossOrigin (origins="*",allowedHeaders="*")
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
	
	@GetMapping("/getuser")
	public User getall(@RequestParam("mailid")String mailid)
	{
		List<User> u = userdao.findAll();
		for(int i=0;i<u.size();i++)
		{
			if(u.get(i).getUserMail().equals(mailid))
			{
				return u.get(i);
			}
		}
		return user;
		
	}
	
	@PutMapping("/updateuser")
	public String updateusers(@RequestBody User u)
	{
		System.out.println(u.getUserMail());
		List<User> uu = userdao.findAll();
		User p =null;
		for(int i=0;i<uu.size();i++)
		{
			if(uu.get(i).getUserMail().equals(u.getUserMail()))
			{
				System.out.println("Hello");
				p=uu.get(i);
				p.setUserName(u.getUserName());
				p.setUserPhonenumber(u.getUserPhonenumber());
				userdao.save(p);
			}
		}
		return "Updated";
		
	}
	
	@DeleteMapping("/deleteuser")
	public String deleteuser(@RequestParam("usermail")String mailid)
	{
		List<User> uu = userdao.findAll();
		for(int i=0;i<uu.size();i++)
		{
			if(uu.get(i).getUserMail().equals(mailid))
			{
				userdao.deleteById(uu.get(i).getUserId());
				
			}
		}
		return "User Deleted";
	}
	
	
}
