package com.sqlandbi.pumperapp.domain.equipment;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.sqlandbi.pumperapp.domain.Stop;

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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Gasmeter) {
			Gasmeter gm = (Gasmeter)obj;
			return gm.maxPressure.equals(this.maxPressure) && 
				   super.equals(obj);
		}
		return false;
 		
	}
	
}
