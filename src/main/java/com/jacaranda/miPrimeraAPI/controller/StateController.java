package com.jacaranda.miPrimeraAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.miPrimeraAPI.model.State;
import com.jacaranda.miPrimeraAPI.service.StateService;

@RestController
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/state")
	public List<State>getAll(){
		return this.stateService.getAll();
	}

}
