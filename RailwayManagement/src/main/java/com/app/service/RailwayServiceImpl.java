package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.RailNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.RailRespDTO;
import com.app.entities.CategoryE;
import com.app.entities.Railway;
import com.app.repository.RailwayRepository;

@Service
@Transactional
public class RailwayServiceImpl implements RailwayService {

	
	@Autowired
	private RailwayRepository railRepo;
	
	@Autowired
	private ModelMapper mapper;

	
	//post
	@Override
	public ApiResponse addRail(RailRespDTO r) {
		
		if(r.getEndTime().isAfter(r.getStartTime()))
		{
			Railway rail = mapper.map(r, Railway.class);
			railRepo.save(rail);
			return new ApiResponse("rail added successfully!"+r);
		}
		
		return new ApiResponse("End time should be after start time");
	}


	//delete
	@Override
	public ApiResponse deleteRail(Long railId) {
		if(railRepo.existsById(railId))
		{
			railRepo.deleteById(railId);
			return new ApiResponse("rail is deleted"+railId);
		}
		
		return new ApiResponse("rail does not exists!");
	}


	//finder
	@Override
	public RailRespDTO findBycategory(CategoryE category) {
		Railway railByCategory =  railRepo.findByCategory(category).orElseThrow(()->new RailNotFoundException("No rail in the specified category!!"));
		RailRespDTO rrd = mapper.map(railByCategory,RailRespDTO.class);
		return rrd;
	}


//get
	@Override
	public List<Railway> getAllRailway() {
		List<Railway> railList = new ArrayList<>();
		railList = railRepo.findAll();
 		return railList;
 	
	}
//	@Override
//	public List<RailRespDTO> getAllRailway() {
//		List<Railway> railList = new ArrayList<>();
//		railList = railRepo.findAll();
//		List<RailRespDTO> rrd = mapper.map(railList, RailRespDTO.class);
// 		return rrd;
//	}
}
