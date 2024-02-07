package com.jacaranda.miPrimeraAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.miPrimeraAPI.model.Town;
import com.jacaranda.miPrimeraAPI.service.TownService;
@RestController
public class TownController {
	
	@Autowired
	private TownService townService;
	
	@GetMapping("/town")
	public List<Town>getAll(){
		return this.townService.getAll();
	}
}
