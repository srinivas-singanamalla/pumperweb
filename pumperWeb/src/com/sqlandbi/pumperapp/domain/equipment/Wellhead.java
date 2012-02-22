package com.sqlandbi.pumperapp.domain.equipment;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Wellhead extends Equipment {
	
	@Persistent
	private Double tubingPressure;
	
	@Persistent
	private Double casingPressure;
	
	@Persistent
	private Long downTime;
	
	@Persistent
	private String comments;
	
	@Persistent
	private Integer producingMethod;
	
	public enum ProducingMethodType {
		FLOWING,
		GAS_LIFT,
		HYDRAULIC,
		INJECTION,
		PLATFORM,
		PLUNGER
	}

	public Double getTubingPressure() {
		return tubingPressure;
	}

	public void setTubingPressure(Double tubingPressure) {
		this.tubingPressure = tubingPressure;
	}

	public Double getCasingPressure() {
		return casingPressure;
	}

	public void setCasingPressure(Double casingPressure) {
		this.casingPressure = casingPressure;
	}

	public Long getDownTime() {
		return downTime;
	}

	public void setDownTime(Long downTime) {
		this.downTime = downTime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getProducingMethod() {
		return producingMethod;
	}

	public void setProducingMethod(Integer producingMethod) {
		this.producingMethod = producingMethod;
	}
	
	

}
