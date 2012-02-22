package com.sqlandbi.pumperapp.dao;

import java.util.Collection;

import com.sqlandbi.pumperapp.domain.StopDetails;

public interface RouteDAO {
	
	Collection<StopDetails> getStops();

}
