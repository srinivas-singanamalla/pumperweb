package com.sqlandbi.pumperapp.dao.readings;

import java.util.Collection;
import java.util.Collections;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.util.CollectionUtils;

import com.sqlandbi.pumperapp.dao.PMF;
import com.sqlandbi.pumperapp.domain.readings.GasmeterReading;
import com.sqlandbi.pumperapp.domain.readings.Reading;

public abstract class GenericReadingDAOImpl<T extends Reading> implements ReadingDAO<T> {
	
	@Override
	public T addReading(T reading) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			return pm.makePersistent(reading);
		} finally {
			pm.close();
		}
	}

	@Override
	public void updateReading(Long id, T newDetails) { //TODO fix me
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    
		try {
			T e = (T) pm.getObjectById(this.getReadingClass(), id);
	    	if (e != null) {
	    		newDetails.setReadingId(id);
	    		pm.makePersistent(newDetails);
	    	}
	    } finally {
	        pm.close();
	    }
		
	}

	@Override
	public Collection<T> getReadings(Long startTime, Long endTime) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			Query query = getQuery(pm);
			query.setOrdering("date descending");
			Collection<T> results = (Collection<T>)query.execute(startTime, endTime);
			Collection<T> list = pm.detachCopyAll(results);
			if (CollectionUtils.isEmpty(list)) {
				return Collections.emptyList();
			}
			return list;
		} finally {
			pm.close();
		}
	}

	private Query getQuery(PersistenceManager pm) {
		Query query = pm.newQuery(this.getReadingClass(),
                "date >= startTime && date < endTime");
		query.declareImports("import java.util.Date");
		query.declareParameters("Date startTime, Date endTime");
		return query;
	}
	
	protected abstract Class getReadingClass();
	
	@Override
	public void deleteReadings(Long startTime, Long endTime) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			
			Query query = getQuery(pm);
			Collection<T> results = (Collection<T>)query.execute(startTime, endTime);
			pm.deletePersistentAll(results);
		} finally {
	        pm.close();
	    }
		
	}

}
