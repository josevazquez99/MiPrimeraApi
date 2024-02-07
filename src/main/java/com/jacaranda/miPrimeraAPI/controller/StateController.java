package com.jacaranda.miPrimeraAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.miPrimeraAPI.model.StateDTO;
import com.jacaranda.miPrimeraAPI.service.StateService;

@RestController
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/state")
	public List<StateDTO>getAll(){
		return this.stateService.getAll();
	}

}
