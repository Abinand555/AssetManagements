package com.faith.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.faith.bean.AssetManagement;
import com.faith.dao.AssetManagementDao;



@CrossOrigin
@RestController
@RequestMapping("/api")

public class AmcController {
	
	@Autowired
	private AssetManagementDao dao;
	
	
   //Get all Users
	@RequestMapping(value = "/assets", method = RequestMethod.GET)
	public List getAmcDetails(){
		
		List list;
		System.out.println("Get all the Amc Details : ");
		list = dao.getAllAssetDetails();
		
		return list;
	}
		
	
	// DETAILS SELECT asset details BY ID
	@RequestMapping(value = "/assetsbyid/{id}", method = RequestMethod.GET)
	public AssetManagement getAmcDetails(@PathVariable("id") int amcId){
		
		System.out.println("Get the single amc details using id : ");
		AssetManagement objAssetManagement = (AssetManagement) dao.getAmcById(amcId);
		System.out.println(objAssetManagement);
		return objAssetManagement;
		
		
	}
	
	
	//insert details
	@RequestMapping(value = "/insertassets", method = RequestMethod.POST)
	public void insertDetails(@RequestBody AssetManagement amc){
		dao.insertAmc(amc);
	}
	
	
	//UPDATING asset DETAILS
	@RequestMapping(value = "/updateasset/{id}", method = RequestMethod.PUT)
	public void updateDetails(@RequestBody AssetManagement amc,@PathVariable("id") int id){
			
			dao.updateAmc(amc);
		}
	
	
   //Delete assets
	@RequestMapping(value = "/disableassets/{id}", method = RequestMethod.PUT)
	void disableAssets(@PathVariable("id") int amcId){
			
			dao.deleteAmc(amcId);
		}
	}
