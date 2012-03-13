package com.sqlandbi.pumperapp.dao;

import java.util.Collection;

import com.sqlandbi.pumperapp.domain.Stop;

public interface RouteDAO {
	
	Collection<Stop> getStops();

}
