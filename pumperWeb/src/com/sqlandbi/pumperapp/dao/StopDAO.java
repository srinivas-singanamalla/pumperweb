package com.sqlandbi.pumperapp.dao;

import java.util.Collection;
import java.util.List;

import com.sqlandbi.pumperapp.domain.Stop;
import com.sqlandbi.pumperapp.domain.equipment.Equipment;

public interface StopDAO {
	
	public Stop addStopDetails(Stop stopDetails);
	
	public void updateStopDetails(Long id, Stop newDetails);
	
	public Stop getStopDetails(Long id);
	
	public Collection<Stop> getStopDetailsList();
	
	public void deleteStopDetails(Long id);

	public Collection<Equipment> getEquipments(Long stopId);
	
	public void deleteEquipment(Long equipmentId);

	Equipment addEquipment(Long stopId, Equipment equipment);

	void deleteEquipments(Long stopId);
}
