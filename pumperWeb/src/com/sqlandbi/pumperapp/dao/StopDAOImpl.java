package com.sqlandbi.pumperapp.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.jdo.PersistenceManager;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.sqlandbi.pumperapp.dao.StopDAO;
import com.sqlandbi.pumperapp.domain.StopDetails;

@Component
public class StopDAOImpl implements StopDAO {

	@Override
	public StopDetails addStopDetails(StopDetails stopDetails) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			return pm.makePersistent(stopDetails);
		} finally {
			pm.close();
		}		
	}

	@Override
	public void updateStopDetails(Long id, StopDetails newDetails) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    
		try {
	    	StopDetails e = pm.getObjectById(StopDetails.class, id);
	    	if (e != null) {
	    		newDetails.setStopId(e.getStopId());
	    		pm.makePersistent(newDetails);
	    	}
	    } finally {
	        pm.close();
	    }
		
	}

	@Override
	public StopDetails getStopDetails(Long id) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			StopDetails e = pm.getObjectById(StopDetails.class, id);
			return e;
		}finally {
			pm.close();
		}
	}

	@Override
	public Collection<StopDetails> getStopDetailsList() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		javax.jdo.Query query = pm.newQuery(StopDetails.class);
		Collection<StopDetails> results = (Collection<StopDetails>) query.execute();
		Collection<StopDetails> list = pm.detachCopyAll(results);
		if (CollectionUtils.isEmpty(list)) {
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public void deleteStopDetails(Long id) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			StopDetails e = pm.getObjectById(StopDetails.class, id);
			pm.deletePersistent(e);
		}finally {
			pm.close();
		}
	}

}
