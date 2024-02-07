package com.jacaranda.miPrimeraAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacaranda.miPrimeraAPI.model.State;
import com.jacaranda.miPrimeraAPI.model.Town;
import com.jacaranda.miPrimeraAPI.model.TownDTO;
import com.jacaranda.miPrimeraAPI.repository.TownRepository;

@Service
public class TownService {

	@Autowired
	private TownRepository townRepository;

	public Town get(String id) {
		return townRepository.findById(id).orElse(null);
	}

	public List<TownDTO> getAll() {
		List<Town> list = townRepository.findAll();
		return TownDTO.getAllTownDTO(list);
	}

	public TownDTO getById(String id) {
		Town town = townRepository.findById(id).orElse(null);
		return town != null
				? new TownDTO(town.getCodpue(), town.getName(), town.getCodpro().getCodState(),
						town.getCodpro().getName())
				: null;
	}

	public TownDTO create(TownDTO townDTO) {
		Town town = new Town();
		town.setCodpue(townDTO.getCodTown());
		town.setName(townDTO.getName());

		// Verificar si townDTO.getCodCity() no es null antes de intentar crear una
		// nueva instancia de State
		if (townDTO.getCodCity() != null) {
			State state = new State();
			state.setCodState(townDTO.getCodCity());
			// Asignar state a town solo si no es null
			town.setCodpro(state);
		}

		// Guardar la ciudad en la base de datos
		town = townRepository.save(town);

		// Crea y devuelve un nuevo TownDTO basado en la ciudad guardada
		return new TownDTO(town.getCodpue(), town.getName(),
				town.getCodpro() != null ? town.getCodpro().getCodState() : null,
				town.getCodpro() != null ? town.getCodpro().getName() : null);
	}

	public TownDTO update(String id, TownDTO townDTO) {
		Town town = townRepository.findById(id).orElse(null);
		if (town != null) {
			town.setCodpue(townDTO.getCodTown());
			town.setName(townDTO.getName());

			// Guarda la ciudad actualizada en la base de datos
			town = townRepository.save(town);

			return new TownDTO(town.getCodpue(), town.getName(), town.getCodpro().getCodState(),
					town.getCodpro().getName());
		}
		return null;
	}

	public void delete(String id) {
		townRepository.deleteById(id);
	}

}
