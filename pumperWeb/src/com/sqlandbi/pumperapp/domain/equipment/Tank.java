package com.sqlandbi.pumperapp.domain.equipment;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Tank extends Equipment {
	
	@Persistent
	private Double radius;
	
	@Persistent
	private Double height;
	
	@Persistent
	private Integer storageStock;
	
	public enum StorageStockType {
		OIL,
		WATER,
		OIL_WATER		
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
	

}
