package com.sqlandbi.pumperapp.dao.readings;

import java.util.Collection;
import java.util.Collections;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.util.CollectionUtils;

import com.sqlandbi.pumperapp.dao.PMF;
import com.sqlandbi.pumperapp.domain.readings.GasmeterReading;
import com.sqlandbi.pumperapp.domain.readings.Reading;
import com.sqlandbi.pumperapp.domain.readings.TankReading;

public class GasmeterReadingDAOImpl extends GenericReadingDAOImpl<GasmeterReading> implements GasmeterReadingDAO {

	@Override
	protected Class getReadingClass() {
		// TODO Auto-generated method stub
		return GasmeterReading.class;
	}

	/*@Override
	public GasmeterReading addReading(GasmeterReading reading) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			return pm.makePersistent(reading);
		} finally {
			pm.close();
		}
	}

	@Override
	public void updateReading(Long id, Reading newDetails) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    
		try {
			GasmeterReading e = (GasmeterReading) pm.getObjectById(newDetails.getClass(), id);
	    	if (e != null) {
	    		newDetails.setReadingId(id);
	    		pm.makePersistent(newDetails);
	    	}
	    } finally {
	        pm.close();
	    }
		
	}

	@Override
	public Collection<GasmeterReading> getReadings(Long startTime, Long endTime) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			Query query = getQuery(pm);
			query.setOrdering("date descending");
			Collection<GasmeterReading> results = (Collection<GasmeterReading>)query.execute(startTime, endTime);
			Collection<GasmeterReading> list = pm.detachCopyAll(results);
			if (CollectionUtils.isEmpty(list)) {
				return Collections.emptyList();
			}
			return list;
		} finally {
			pm.close();
		}
	}

	private Query getQuery(PersistenceManager pm) {
		Query query = pm.newQuery(GasmeterReading.class,
                "date >= startTime && date < endTime");
		query.declareImports("import java.util.Date");
		query.declareParameters("Date startTime, Date endTime");
		return query;
	}
	
	@Override
	public void deleteReadings(Long startTime, Long endTime) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			
			Query query = getQuery(pm);
			Collection results = (Collection)query.execute(startTime, endTime);
			pm.deletePersistentAll(results);
		} finally {
	        pm.close();
	    }
		
	}*/
}
