package com.sqlandbi.pumperapp.domain.readings;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class GasmeterReading extends Reading {
	
	@Persistent
	private Double linePressure;
	
	@Persistent
	private Double differential;
	
	@Persistent
	private Double temperature;

	public Double getLinePressure() {
		return linePressure;
	}

	public void setLinePressure(Double linePressure) {
		this.linePressure = linePressure;
	}

	public Double getDifferential() {
		return differential;
	}

	public void setDifferential(Double differential) {
		this.differential = differential;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof GasmeterReading) {
			GasmeterReading that = (GasmeterReading)obj;
			if (super.equals(obj) && this.differential.equals(that.getDifferential()) &&
					this.linePressure.equals(that.linePressure) && this.temperature.equals(that.temperature)) {
				return true;
			}
		}
		return false;
		
	}

	
}
