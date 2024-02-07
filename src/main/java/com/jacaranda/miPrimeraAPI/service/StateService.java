package com.jacaranda.miPrimeraAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.miPrimeraAPI.model.State;
import com.jacaranda.miPrimeraAPI.model.StateDTO;
import com.jacaranda.miPrimeraAPI.repository.StateRepository;

@Service
public class StateService {

	
	@Autowired
	private StateRepository stateRepository;
	
	public State get(String id) {
		return stateRepository.findById(id).orElse(null);
	}
	
	public State save(State state) {
		return stateRepository.save(state);
	}
	
	public  List<StateDTO> getAll(){
		List<State> list = stateRepository.findAll();
		return StateDTO.convertProvinceToDTO(list);
	}
	
	public State update(State state) {
		State result;
		if(this.get(state.getCodState())==null) {
			result = null;
			
		}else {
			result = this.save(state);
		}
		
		return result;
	}
	
	
	public Boolean delete(String cod) {
		Boolean result = true;
		if(this.get(cod)==null) {
			result = false;
			
		}else {
			 this.stateRepository.delete(this.get(cod));
		}
		
		return result;
	}
	
	
	
	
}
