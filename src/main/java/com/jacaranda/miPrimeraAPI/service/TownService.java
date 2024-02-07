package com.jacaranda.miPrimeraAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.miPrimeraAPI.model.Town;
import com.jacaranda.miPrimeraAPI.repository.TownRepository;

@Service
public class TownService {

	@Autowired
	private TownRepository townRepository;
	
	public Town get(String id) {
		return townRepository.findById(id).orElse(null);
	}
	
	public Town save(Town town) {
		return townRepository.save(town);
	}
	
	public List<Town> getAll(){
		return this.townRepository.findAll();
	}
	
	public Town update(Town town) {
		Town result;
		if(this.get(town.getCodpue())==null) {
			result = null;
			
		}else {
			result = this.save(town);
		}
		
		return result;
	}
	
	
	public Boolean delete(String cod) {
		Boolean result = true;
		if(this.get(cod)==null) {
			result = false;
			
		}else {
			 this.townRepository.delete(this.get(cod));
		}
		
		return result;
	}
}
