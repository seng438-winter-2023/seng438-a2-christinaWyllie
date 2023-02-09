/*
Class: SENG 438

File: GetCumulativePercentageTest/java
Purpose: Test the getCumulativePercentages method in the class DataUtilities. 

# of Tests: 2
Failures: 1

Author: Maitry Rohit
Date: Feb 9, 2023

*/


package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class GetCumulativePercentageTest extends DataUtilities {
	private KeyedValues values;
	@Before
	public void setUp() throws Exception {
		Mockery mockingContext = new Mockery();
	    values = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	        	for(int i = 0; i < 5; i++) {
	        		allowing(values).getKey(i);
	        		will(returnValue(i));
	        		allowing(values).getValue(i);
	        		will(returnValue(i));
	        	}
	        	allowing(values).getItemCount();
	        	will(returnValue(5));
	        }
	    });
	}

	@Test
	public void validCumulativePercentage() {
		KeyedValues actual = getCumulativePercentages(values);
		double expected[] = {0.0, 0.1, 0.3, 0.6, 1.0};
		for(int i = 0; i < 5; i++) {
			assertEquals(expected[i], actual.getValue(i));
		}
	}
	
	@Test (expected = InvalidParameterException.class)
	public void invalidCumulativePercentage() throws InvalidParameterException {
		Mockery mockingContext = new Mockery();
	    KeyedValues values1 = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	        	for(int i = 0; i < 5; i++) {
	        		allowing(values1).getKey(i);
	        		will(returnValue(i));
	        		allowing(values1).getValue(i);
	        		will(returnValue("1"));
	        	}
	        	allowing(values1).getItemCount();
	        	will(returnValue(5));
	        }
	    });
	    
		try {
			getCumulativePercentages(values1);
		}
		
		catch(InvalidParameterException e) {
			throw e;
		}
		
		catch(Exception t) {
			
		}
		
	}

}
