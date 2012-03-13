package com.sqlandbi.pumperapp.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.appengine.api.datastore.Key;
import com.sqlandbi.pumperapp.domain.equipment.Equipment;

@JsonIgnoreProperties({"equipments"})
@PersistenceCapable
public class Stop {
	
	@Persistent
	private String name;
	
	@Persistent
	private String desc;
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long stopId;		
	
	@Persistent
	private String details;
	
	@Persistent
	private String longitude;
	
	@Persistent
	private String latitude;

	//TODO modified the model, so don't use this. Polymorphism and inheritance does not work in GAP
	@NotPersistent
    private Set<Key> equipments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String description) {
		this.desc = description;
	}

	public Long getStopId() {
		return stopId;
	}

	public void setStopId(Long id) {
		this.stopId = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String lontitude) {
		this.longitude = lontitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public Set<Key> getEquipments() {
		return equipments;
	}

	public void setEquipments(Set<Key> equipments) {
		this.equipments = equipments;
	}

	public Stop clone() {
		Stop stopDetails = new Stop();
		stopDetails.setDesc(desc);
		stopDetails.setDetails(details);
		stopDetails.setStopId(stopId);
		stopDetails.setLatitude(latitude);
		stopDetails.setLongitude(longitude);
		stopDetails.setName(name);
		return stopDetails;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Stop)) {
			return false;
		}
		Stop that = (Stop)obj;
		
		return that.desc.equals(this.desc) && that.name.equals(this.name) && 
				this.details.equals(that.details) && this.latitude.equals(that.latitude) &&
				this.longitude.equals(that.longitude);
 		
	}
}
