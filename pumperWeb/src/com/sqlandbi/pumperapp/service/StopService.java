package com.sqlandbi.pumperapp.service;

import com.sqlandbi.pumperapp.domain.Stop;

public interface StopService {	
	
	public Stop addStopDetails(Stop stopDetails);
	
	public boolean exists(Long stopId);

}
