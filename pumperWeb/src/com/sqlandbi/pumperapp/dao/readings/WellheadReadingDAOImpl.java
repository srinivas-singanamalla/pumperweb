package com.sqlandbi.pumperapp.dao.readings;

import com.sqlandbi.pumperapp.domain.readings.WellheadReading;

public class WellheadReadingDAOImpl extends GenericReadingDAOImpl<WellheadReading> implements WellheadReadingDAO {

	@Override
	protected Class getReadingClass() {
		// TODO Auto-generated method stub
		return WellheadReading.class;
	}
}
