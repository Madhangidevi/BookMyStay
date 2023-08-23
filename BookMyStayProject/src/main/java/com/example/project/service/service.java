package com.example.project.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.model.model;
import com.example.project.repo.repository;



@Service
public class service {

	@Autowired
    public repository srepo;
    //post the data 
    public String saveStay(model s)
    {
   	 srepo.save(s);
   	 return "Data is saved to database";
    }
    //get the data
    public List<model> getStay()
    {
   	 return srepo.findAll();
    }
    //update the data(put)
    public model updateStay(model sm)
    {
   	 return srepo.saveAndFlush(sm);
    }
    //delete the data
    public void deleteStay(int stayid)
    {
   	 System.out.println("Delete");
   	 srepo.deleteById(stayid);
    }
    //delete if id is present
    public boolean deleteStayif(int stayid)
    {
   	 if(srepo.existsById(stayid))
   		 srepo.deleteById(stayid);
   	 return false;
    }
   
    public Optional<model> getUserid(int userid)
		{
			Optional<model> stay = srepo.findById(userid);
			if(stay.isPresent())
			{
				return stay;
			}
			return null;
		}
    public boolean updateStayif(int stayid,model hm)
	{
		if(srepo.existsById(stayid)){
			srepo.save(hm);
			return true;
		}
		return false;
	}
}
