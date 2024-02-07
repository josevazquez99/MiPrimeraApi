package com.jacaranda.miPrimeraAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.miPrimeraAPI.model.Town;
import com.jacaranda.miPrimeraAPI.model.TownDTO;



public interface TownRepository extends JpaRepository <Town,String>{


}

