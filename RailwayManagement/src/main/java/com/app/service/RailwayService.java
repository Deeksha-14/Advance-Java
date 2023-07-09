package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.RailRespDTO;
import com.app.entities.CategoryE;
import com.app.entities.Railway;

public interface RailwayService {
	//add rail
	ApiResponse addRail(RailRespDTO r);
	
	//delete
	ApiResponse deleteRail(Long railId);
	
	//view by category
	RailRespDTO findBycategory(CategoryE category); 
	
	//get all
	List<Railway> getAllRailway();
	
	
	
}
