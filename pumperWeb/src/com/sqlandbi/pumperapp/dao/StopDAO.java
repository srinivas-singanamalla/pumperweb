package com.sqlandbi.pumperapp.dao;

import java.util.Collection;
import java.util.List;

import com.sqlandbi.pumperapp.domain.StopDetails;

public interface StopDAO {
	
	public StopDetails addStopDetails(StopDetails stopDetails);
	public void updateStopDetails(Long id, StopDetails newDetails);
	public StopDetails getStopDetails(Long id);
	public Collection<StopDetails> getStopDetailsList();

}
