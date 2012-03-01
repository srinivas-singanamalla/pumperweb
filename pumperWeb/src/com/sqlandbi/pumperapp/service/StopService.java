package com.sqlandbi.pumperapp.service;

import com.sqlandbi.pumperapp.domain.StopDetails;

public interface StopService {	
	
	public StopDetails addStopDetails(StopDetails stopDetails);
	
	public boolean exists(Long stopId);

}
