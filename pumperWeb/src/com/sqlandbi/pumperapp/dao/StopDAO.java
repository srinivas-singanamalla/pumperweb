package com.sqlandbi.pumperapp.dao;

import java.util.Collection;
import java.util.List;

import com.sqlandbi.pumperapp.domain.StopDetails;
import com.sqlandbi.pumperapp.domain.equipment.Equipment;

public interface StopDAO {
	
	public StopDetails addStopDetails(StopDetails stopDetails);
	
	public void updateStopDetails(Long id, StopDetails newDetails);
	
	public StopDetails getStopDetails(Long id);
	
	public Collection<StopDetails> getStopDetailsList();
	
	public void deleteStopDetails(Long id);

	public Collection<Equipment> getEquipments(Long stopId);
	
	public void deleteEquipment(Long equipmentId);

	Equipment addEquipment(Long stopId, Equipment equipment);
}
