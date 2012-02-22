package com.sqlandbi.pumperapp.domain.equipment;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Gasmeter extends Equipment {

	@Persistent
	private Double maxPressure;

	public Double getMaxPressure() {
		return maxPressure;
	}

	public void setMaxPressure(Double maxPressure) {
		this.maxPressure = maxPressure;
	}
	
	
	
	
}
