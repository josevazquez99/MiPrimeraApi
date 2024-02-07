package com.jacaranda.miPrimeraAPI.model;

import java.util.ArrayList;
import java.util.List;

public class TownDTO {

	private String codTown;
	private String name;
	private String codCity;
	private String city;

	public TownDTO() {
		super();
	}

	public TownDTO(String codTown, String name, String codCity, String city) {
		super();
		this.codTown = codTown;
		this.name = name;
		this.codCity = codCity;
		this.city = city;
	}

	public String getCodTown() {
		return codTown;
	}

	public void setCodTown(String codTown) {
		this.codTown = codTown;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodCity() {
		return codCity;
	}

	public void setCodCity(String codCity) {
		this.codCity = codCity;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public static  List<TownDTO> getAllTownDTO(List<Town> list) {
		List<TownDTO> result = new ArrayList<TownDTO>();

		for (Town town : list) {
			TownDTO tdto = new TownDTO(town.getCodpue(), town.getName(), town.getCodpro().getCodState(),
					town.getCodpro().getName());
			result.add(tdto);
		}

		return result;
	}

	
}
