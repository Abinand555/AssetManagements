package com.faith.bean;

import java.sql.Date;

public class AssetManagement {

	//instance variables
	private int id;
	private String amcName;
	private String investmentOption;
	private int aumRate;
	private int noSchemes;
	private Date updatedtill;
	
	
	
	//default constructor
	public AssetManagement() {
		super();
	}


	
	//parameterized constructor
	public AssetManagement(int id, String amcName, String investmentOption,
			int aumRate, int noSchemes) {
		super();
		this.id = id;
		this.amcName = amcName;
		this.investmentOption = investmentOption;
		this.aumRate = aumRate;
		this.noSchemes = noSchemes;
	}


	//Getters and setters
	public AssetManagement(String amcName, String investmentOption,
			int aumRate, int noSchemes) {
		super();
		this.amcName = amcName;
		this.investmentOption = investmentOption;
		this.aumRate = aumRate;
		this.noSchemes = noSchemes;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAmcName() {
		return amcName;
	}


	public void setAmcName(String amcName) {
		this.amcName = amcName;
	}


	public String getInvestmentOption() {
		return investmentOption;
	}


	public void setInvestmentOption(String investmentOption) {
		this.investmentOption = investmentOption;
	}


	public int getAumRate() {
		return aumRate;
	}


	public void setAumRate(int aumRate) {
		this.aumRate = aumRate;
	}


	public int getNoSchemes() {
		return noSchemes;
	}


	public void setNoSchemes(int noSchemes) {
		this.noSchemes = noSchemes;
	}


	public Date getUpdatedtill() {
		return updatedtill;
	}


	public void setUpdatedtill(Date updatedtill) {
		this.updatedtill = updatedtill;
	}
	
	
	


	
	
	
}
