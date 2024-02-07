package com.jacaranda.miPrimeraAPI.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pueblos")
public class Town {
	
	@Id
	@Column(name="codpue")
	private String codpue;
	
	@Column(name="nombre")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="codpro")
	private State codpro;

	public String getCodpue() {
		return codpue;
	}

	public void setCodpue(String codpue) {
		this.codpue = codpue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getCodpro() {
		return codpro;
	}

	public void setCodpro(State codpro) {
		this.codpro = codpro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codpue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Town other = (Town) obj;
		return Objects.equals(codpue, other.codpue);
	}
	
	
	

}
