package com.sqlandbi.pumperapp.domain.readings;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class WellheadReading extends Reading {
	
	@Persistent
	private Double tubingPressure;
	
	@Persistent
	private Double casingPressure;
	
	@Persistent
	private Double chokeSize;
	
	@Persistent
	private Integer dailyProducingStatus;
	
	@Persistent
	private Double downtime;
	
	@Persistent
	private String comments;

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

	public Double getChokeSize() {
		return chokeSize;
	}

	public void setChokeSize(Double chokeSize) {
		this.chokeSize = chokeSize;
	}

	public Integer getDailyProducingStatus() {
		return dailyProducingStatus;
	}

	public void setDailyProducingStatus(Integer dailyProducingStatus) {
		this.dailyProducingStatus = dailyProducingStatus;
	}

	public Double getDowntime() {
		return downtime;
	}

	public void setDowntime(Double downtime) {
		this.downtime = downtime;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof WellheadReading) {
			WellheadReading that = (WellheadReading)obj;
			if (super.equals(obj) && 
				this.casingPressure.equals(that.casingPressure) &&
				this.tubingPressure.equals(that.tubingPressure) &&
				this.dailyProducingStatus.equals(that.dailyProducingStatus) &&
				this.downtime.equals(that.downtime) && 
				this.chokeSize.equals(that.chokeSize) &&
				this.comments.equals(that.comments)) {
				return true;
			}
		}
		return false;
	}

}
