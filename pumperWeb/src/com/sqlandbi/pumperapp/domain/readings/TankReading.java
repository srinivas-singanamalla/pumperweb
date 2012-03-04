package com.sqlandbi.pumperapp.domain.readings;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class TankReading extends Reading {

	@Persistent
	private Double topStart;

	@Persistent
	private Double topEnd;
	
	@Persistent
	private Double bottomStart;
	
	@Persistent
	private Double bbDesc;
	
	@Persistent
	private Double useCalc;
	
	@Persistent
	private Integer purchaserNum;
	
	@Persistent
	private Integer stock;

	public Double getTopStart() {
		return topStart;
	}

	public void setTopStart(Double topStart) {
		this.topStart = topStart;
	}

	public Double getTopEnd() {
		return topEnd;
	}

	public void setTopEnd(Double topEnd) {
		this.topEnd = topEnd;
	}

	public Double getBottomStart() {
		return bottomStart;
	}

	public void setBottomStart(Double bottomStart) {
		this.bottomStart = bottomStart;
	}

	public Double getBbDesc() {
		return bbDesc;
	}

	public void setBbDesc(Double bbDesc) {
		this.bbDesc = bbDesc;
	}

	public Double getUseCalc() {
		return useCalc;
	}

	public void setUseCalc(Double useCalc) {
		this.useCalc = useCalc;
	}

	public Integer getPurchaserNum() {
		return purchaserNum;
	}

	public void setPurchaserNum(Integer purchaserNum) {
		this.purchaserNum = purchaserNum;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof TankReading) {
			TankReading that = (TankReading)obj;
			if (super.equals(that) && 
					this.bbDesc.equals(that.bbDesc) &&
					this.bottomStart.equals(that.bottomStart) &&
					this.purchaserNum.equals(that.purchaserNum) &&
					this.stock.equals(that.stock) && 
					this.topEnd.equals(that.topEnd) &&
					this.topStart.equals(that.topStart) &&
					this.useCalc.equals(that.useCalc) &&
					super.equals(obj)) {
				return true;
			}
		}
		return false;
	}

}
