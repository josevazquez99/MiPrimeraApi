package com.jacaranda.miPrimeraAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.miPrimeraAPI.model.TownDTO;
import com.jacaranda.miPrimeraAPI.service.TownService;

@RestController
public class TownController {

	@Autowired
	private TownService townService;

	@GetMapping("/town")
	public List<TownDTO> getAll() {
		return this.townService.getAll();
	}

	// Obtener una ciudad por su ID
	@GetMapping("/town/{id}")
	public TownDTO getById(@PathVariable String id) {
		return townService.getById(id);
	}

	// Crear una nueva ciudad
	@PostMapping("/town")
	public TownDTO create(@RequestBody TownDTO townDTO) {
		return townService.create(townDTO);
	}

	// Actualizar información de una ciudad existente
	@PutMapping("/town/{id}")
	public TownDTO update(@PathVariable String id, @RequestBody TownDTO townDTO) {
		return townService.update(id, townDTO);
	}

	// Eliminar una ciudad por su ID
	@DeleteMapping("/town/{id}")
	public void delete(@PathVariable String id) {
		townService.delete(id);
	}

}
