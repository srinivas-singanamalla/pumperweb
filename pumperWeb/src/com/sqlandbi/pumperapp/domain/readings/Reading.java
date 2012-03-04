package com.sqlandbi.pumperapp.domain.readings;

import java.util.Calendar;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
@PersistenceCapable
public class Reading {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long readingId;
	
	@Persistent
	private Long date;

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}
	
	public Long getReadingId() {
		return readingId;
	}

	public void setReadingId(Long readingId) {
		this.readingId = readingId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Reading) {
			Reading that = (Reading)obj;
			Calendar thatcal = Calendar.getInstance();
			thatcal.setTimeInMillis(that.getDate());
			
			Calendar thiscal = Calendar.getInstance();
			thiscal.setTimeInMillis(this.getDate());
			
			
			if ( thiscal.get(Calendar.DAY_OF_MONTH) == thatcal.get(Calendar.DAY_OF_MONTH) &&
				 thiscal.get(Calendar.YEAR) == thatcal.get(Calendar.YEAR) &&
				 thiscal.get(Calendar.MONTH) == thatcal.get(Calendar.MONTH)) {
				return true;
			}				
		}
		return false;
	}
	
}
