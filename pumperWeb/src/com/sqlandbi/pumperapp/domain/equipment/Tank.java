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
	
	public Integer getStorageStock() {
		return storageStock;
	}

	public void setStorageStock(Integer storageStock) {
		this.storageStock = storageStock;
	}

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
	
	public boolean equals(Object obj) {
		if (obj instanceof Tank) {
			Tank gm = (Tank)obj;
			return gm.radius.equals(this.radius) &&
					gm.height.equals(this.height) &&
					gm.storageStock.equals(this.storageStock) &&
				   super.equals(obj);
		}
		return false;
	}
	

}
