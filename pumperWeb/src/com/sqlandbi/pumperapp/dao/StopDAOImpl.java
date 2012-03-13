package com.sqlandbi.pumperapp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.google.appengine.api.datastore.Key;
import com.sqlandbi.pumperapp.dao.StopDAO;
import com.sqlandbi.pumperapp.domain.Stop;
import com.sqlandbi.pumperapp.domain.equipment.Equipment;
import com.sqlandbi.pumperapp.domain.equipment.Gasmeter;
import com.sqlandbi.pumperapp.domain.equipment.Tank;
import com.sqlandbi.pumperapp.domain.equipment.Wellhead;

@Component
public class StopDAOImpl implements StopDAO {

	final List<Class<? extends Equipment>> equipmentClassList =
	        Arrays.asList(Wellhead.class, Tank.class, Gasmeter.class);
	
	@Override
	public Stop addStopDetails(Stop stopDetails) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			return pm.makePersistent(stopDetails);
		} finally {
			pm.close();
		}		
	}

	@Override
	public void updateStopDetails(Long id, Stop newDetails) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    
		try {
	    	Stop e = pm.getObjectById(Stop.class, id);
	    	if (e != null) {
	    		newDetails.setStopId(e.getStopId());
	    		pm.makePersistent(newDetails);
	    	}
	    } finally {
	        pm.close();
	    }
		
	}

	@Override
	public Stop getStopDetails(Long id) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try {
			Stop e = pm.getObjectById(Stop.class, id);
			return e;
		}finally {
			pm.close();
		}
	}

	@Override
	public Collection<Stop> getStopDetailsList() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		javax.jdo.Query query = pm.newQuery(Stop.class);
		Collection<Stop> results = (Collection<Stop>) query.execute();
		Collection<Stop> list = pm.detachCopyAll(results);
		if (CollectionUtils.isEmpty(list)) {
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public void deleteStopDetails(Long id) {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Stop e = pm.getObjectById(Stop.class, id);
			pm.deletePersistent(e);
		}finally {
			pm.close();
		}
	}

	@Override
	public Collection<Equipment> getEquipments(Long stopId) {
		Collection<Equipment> list = null;
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		for (Class<? extends Equipment> equipmentClass : equipmentClassList) {
			Query query = pm.newQuery(equipmentClass,
	                "stopId == stopIdParam");
			query.declareParameters("Long stopIdParam");
			Collection<Equipment> wellheads = (Collection<Equipment>)query.execute(stopId);
			if (!CollectionUtils.isEmpty(wellheads)) {
				if (list == null) {
					list = new ArrayList<Equipment>();
				}
				list.addAll(pm.detachCopyAll(wellheads));
			}
		}
		return list != null ? list : new ArrayList<Equipment>();
	}

	@Override
	public Equipment addEquipment(Long stopId, Equipment equipment) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Equipment storedequipment = null;
		try {
			equipment.setStopId(stopId);
			storedequipment = pm.makePersistent(equipment);
			return storedequipment;
		} finally {
			pm.close();
		}
	}

	@Override
	public void deleteEquipments(Long stopId) {
		Collection<Equipment> list = null;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			for (Class<? extends Equipment> equipmentClass : equipmentClassList) {
				Query query = pm.newQuery(equipmentClass,
		                "stopId == stopIdParam");
				query.declareParameters("Long stopIdParam");
				Collection<Equipment> wellheads = (Collection<Equipment>)query.execute(stopId);
				if (!CollectionUtils.isEmpty(wellheads)) {
					if (list == null) {
						list = new ArrayList<Equipment>();
					}
					list.addAll(pm.detachCopyAll(wellheads));
				}
			}
			
			for (Equipment equipment : list) {
				Equipment e = pm.getObjectById(Equipment.class, equipment.getEquipmentId());
				pm.deletePersistent(e);
			}
		} finally {
			pm.close();
		}
	}
	@Override
	public void deleteEquipment(Long equipmentId) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Equipment e = pm.getObjectById(Equipment.class, equipmentId);
			pm.deletePersistent(e);
		}finally {
			pm.close();
		}
	}

}
