package com.jacaranda.miPrimeraAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jacaranda.miPrimeraAPI.model.State;

public interface StateRepository extends JpaRepository <State,String>{

}
