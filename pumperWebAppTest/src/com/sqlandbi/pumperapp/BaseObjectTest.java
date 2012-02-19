package com.sqlandbi.pumperapp;

import org.junit.After;
import org.junit.Before;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class BaseObjectTest {

	private final LocalServiceTestHelper helper =
	        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	    @Before
	    public void setUp() {
	        helper.setUp();
	    }

	    @After
	    public void tearDown() {
	        helper.tearDown();
	    }

}
