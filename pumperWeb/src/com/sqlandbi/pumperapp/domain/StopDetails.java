package com.sqlandbi.pumperapp.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class StopDetails {
	
	@Persistent
	private String name;
	
	@Persistent
	private String description;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String details;
	
	@Persistent
	private String lontitude;
	
	@Persistent
	private String latitude;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getLontitude() {
		return lontitude;
	}

	public void setLontitude(String lontitude) {
		this.lontitude = lontitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public StopDetails clone() {
		StopDetails stopDetails = new StopDetails();
		stopDetails.setDescription(description);
		stopDetails.setDetails(details);
		stopDetails.setId(id);
		stopDetails.setLatitude(latitude);
		stopDetails.setLontitude(lontitude);
		stopDetails.setName(name);
		return stopDetails;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof StopDetails)) {
			return false;
		}
		StopDetails that = (StopDetails)obj;
		
		return that.description.equals(this.description) && that.name.equals(this.name) && 
				this.details.equals(that.details) && this.latitude.equals(that.latitude) &&
				this.lontitude.equals(that.lontitude);
 		
	}
}
