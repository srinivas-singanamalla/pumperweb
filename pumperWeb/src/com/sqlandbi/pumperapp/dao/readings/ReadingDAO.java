package com.sqlandbi.pumperapp.dao.readings;

import java.util.Collection;

import com.sqlandbi.pumperapp.domain.readings.GasmeterReading;
import com.sqlandbi.pumperapp.domain.readings.Reading;

public interface ReadingDAO<T> {

	public T addReading(T reading);
	
	public void updateReading(Long id, T newDetails);
	
	public Collection<T> getReadings(Long startTime, Long endTime);
	
	public void deleteReadings(Long startTime, Long endTime);
}
