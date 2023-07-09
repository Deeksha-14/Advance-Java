package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.RailRespDTO;
import com.app.entities.CategoryE;
import com.app.service.RailwayService;

@RestController
@CrossOrigin(origins = "http://Localhost:3000")
@RequestMapping("/railway")
public class RailwayController {
	
	@Autowired
	private RailwayService railService;
	
	@PostMapping("/insert")
	public ResponseEntity<?> addrail(@RequestBody @Valid RailRespDTO addRail)
	{
		return new ResponseEntity<>(railService.addRail(addRail), HttpStatus.CREATED);
	}
	
	@GetMapping("/FindAll")
	public ResponseEntity<?> getAll()
	{
	return new ResponseEntity<>(railService.getAllRailway(), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteRail")
	public ApiResponse deleteRail(Long railId)
	{ 
		return railService.deleteRail(railId);
	}
	
	@GetMapping("{category}")
	public RailRespDTO findbycategory(CategoryE category)
	{
		return railService.findBycategory(category);
	}

}
