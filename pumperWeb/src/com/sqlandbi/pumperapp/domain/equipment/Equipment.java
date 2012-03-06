package com.sqlandbi.pumperapp.domain.equipment;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
@PersistenceCapable
public abstract class Equipment {
	
	@Persistent
	private String name;
	
	@Persistent
	private String description;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key equipmentId;
	
	public Key getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Key equipmentId) {
		this.equipmentId = equipmentId;
	}

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
	
	public boolean equals(Object obj) {
		if (obj instanceof Equipment) {
			Equipment gm = (Equipment)obj;
			return gm.getName().equals(this.getName()) &&
				   gm.getDescription().equals(this.getDescription()) &&
				   gm.getEquipmentId().equals(this.getEquipmentId());
		}
		return false;
	}
	
}
