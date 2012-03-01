package com.sqlandbi.pumperapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sqlandbi.pumperapp.dao.StopDAO;
import com.sqlandbi.pumperapp.domain.StopDetails;

public class StopServiceImpl implements StopService {
	
	@Autowired
	private StopDAO stopDAO;

	@Override
	public StopDetails addStopDetails(StopDetails stopDetails) {
		if (exists(stopDetails.getStopId())) {
			return null;
		}
		return stopDAO.addStopDetails(stopDetails);
	}
	
	@Override
	public boolean exists(Long stopId) {
		StopDetails details = stopDAO.getStopDetails(stopId);
		return details != null;
	}

}
