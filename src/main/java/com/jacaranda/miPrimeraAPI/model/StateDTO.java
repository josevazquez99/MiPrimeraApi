package com.jacaranda.miPrimeraAPI.model;

import java.util.ArrayList;
import java.util.List;

public class StateDTO {

	private String stateCod;
	private String stateName;

	private List<TownDTO> listTown;

	public StateDTO() {
		super();
	}

	public StateDTO(String stateCod, String stateName, List<TownDTO> listTown) {
		super();
		this.stateCod = stateCod;
		this.stateName = stateName;
		this.listTown = listTown;
	}

	public String getStateCod() {
		return stateCod;
	}

	public void setStateCod(String stateCod) {
		this.stateCod = stateCod;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public List<TownDTO> getListTown() {
		return listTown;
	}

	public void setListTown(List<TownDTO> listTown) {
		this.listTown = listTown;
	}

	public static List<StateDTO> convertProvinceToDTO(List<State> list) {
		List<StateDTO> res = new ArrayList<StateDTO>();

		for (State pr : list) {
			List<TownDTO> towns = new ArrayList<TownDTO>();
			for (Town tw : pr.getTowns()) {
				TownDTO twdto = new TownDTO(tw.getCodpue(), tw.getName(), "", "");
				towns.add(twdto);
			}
			StateDTO pdto = new StateDTO(pr.getCodState(), pr.getName(), towns);
			res.add(pdto);

		}

		return res;
	}

}
