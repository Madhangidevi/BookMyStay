package com.example.project.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.model;
import com.example.project.service.service;



@RestController
public class controller {

	@Autowired
    public service sserv;
    //post mapping
    @PostMapping("/poststay")
    public String postStay(@RequestBody model sr)
    {
    	sserv.saveStay(sr);
    	return "Data saved";
    }
    //get mapping
    @GetMapping("/getstay")
    public List<model>getStayInfo()
    {
    	return sserv.getStay();
    }
    //put mapping
    @PutMapping("/updateStay")
    public model updateStayInfo(@RequestBody model sa)
    {
    	return sserv.updateStay(sa);
    }
    //delete using path variable
    @DeleteMapping("/delete/{id}")
    public String removeStay(@PathVariable("id") int sid)
    {
    	sserv.deleteStay(sid);
    	return "Stay with Id "+sid+" is deleted";	 
    }
    @DeleteMapping("/byReqPam")
    public String removeByRequestPam(@RequestParam("id") int id)
    {
    	sserv.deleteStay(id);
    	return "Stay with Id "+id+" is deleted";	 
    }
    @DeleteMapping("/deleteStayif/{id}")
     public ResponseEntity<String> deleteStayInfo(@PathVariable int id)
     {
    	 boolean deleted=sserv.deleteStayif(id);
    	 if(deleted)
    	 {
    		 return ResponseEntity.ok("Stay with id "+id+" deleted successfully");
    	 }
    	 else
    	 {
    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stay with ID"+id+" not found");
    	 }
     }
    @PutMapping("/putStayif/{id}")
	public ResponseEntity<String> updateStayInfor(@PathVariable int id,@RequestBody model sa)
	{
		boolean updated = sserv.updateStayif(id, sa);
		if(updated)
		{
			return ResponseEntity.ok("Stay with Id" + id+" updated successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with Id " + id + " not found and not updated");
		}
		
	}
    @GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserById (@PathVariable int userid)
	{
	Optional<model> stay = sserv.getUserid(userid);
	
	if(stay!=null)
	{
		return ResponseEntity.ok(stay);
	}
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not avaliable with Id");
	}
}

