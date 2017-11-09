package com.amazonaws.lambda.demo;

import static org.junit.Assert.*;

import org.junit.Test;

import homeServer.DatabaseManager;
import homeServer.SystemError;

public class unit {

	@Test
	public void test() {
		SystemError test = new SystemError(2, new DatabaseManager());
		fail("Not yet implemented");
		//assertEquals(expected, actual);
	}

}
