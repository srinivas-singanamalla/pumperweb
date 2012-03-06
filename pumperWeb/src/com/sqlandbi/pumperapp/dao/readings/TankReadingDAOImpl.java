package com.sqlandbi.pumperapp.dao.readings;

import com.sqlandbi.pumperapp.domain.readings.TankReading;

public class TankReadingDAOImpl extends GenericReadingDAOImpl<TankReading> implements TankReadingDAO {

	@Override
	protected Class getReadingClass() {
		// TODO Auto-generated method stub
		return TankReading.class;
	}


}