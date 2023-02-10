/*
Class: SENG 438
Assignment: 2

File: GetCumulativePercentageTest/java
Purpose: Test the getCumulativePercentages method in the class DataUtilities. 

# of Tests: 4
Failures: 2

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
	        	for(int i = 0; i < 5; i++) { //KeyedValues object is created with keys {0,1,2,3,4} and values {0,1,2,3,4}
	        		allowing(values).getKey(i);
	        		will(returnValue(i));
	        		allowing(values).getValue(i);
	        		will(returnValue(i));
	        	}
	        	allowing(values).getItemCount();
	        	will(returnValue(5)); //Confirms that the KeyedValues object has the correct size
	        }
	    });
	    
	}
	
	
	/* Test: validCumulativePercentage
     * Description: Checks if function returns an array of cumulative percentages that are expected
     * Expected Return: Valid array that is the average percentage of each value in the keyed values array
     */
	@Test
	public void validCumulativePercentage() {
		KeyedValues actual = getCumulativePercentages(values);
		double expected[] = {0.0, 0.1, 0.3, 0.6, 1.0};
		for(int i = 0; i < 5; i++) {
			assertEquals(expected[i], actual.getValue(i));
		}
	}
	
	/* Test: invalidCumulativePercentageNull
     * Description: Sets a KeyedValue object to null and passes it to the function
     * Expected Return: Invalid parameter exception thrown
     */
	@Test (expected = InvalidParameterException.class)
	public void invalidCumulativePercentageNull() throws InvalidParameterException {
		KeyedValues testNull = null;
		
		try {
			getCumulativePercentages(testNull);
		}
		//TA approved try catch is okay for wrong exceptions being thrown by method
		catch(InvalidParameterException e) {
			throw e;
		}
		
		catch(Exception t) {
			
		}
	}
	
	
	/* Test: invalidCumulativePercentage0
     * Description: Sets a KeyedValue object to all 0's and passes it to the function
     * Expected Return: Every value is calculated as NaN (not a number)
     */
	@Test
	public void invalidCumulativePercentage0() throws InvalidParameterException {
		Mockery mockingContext = new Mockery();
	    KeyedValues values1 = mockingContext.mock(KeyedValues.class);
	    mockingContext.checking(new Expectations() {
	        {
	        	for(int i = 0; i < 3; i++) {
	        		allowing(values1).getKey(i); //KeyedValues object is created with keys {0,1,2} and values {0,0,0}
	        		will(returnValue(i));
	        		allowing(values1).getValue(i);
	        		will(returnValue(0));
	        	}
	        	allowing(values1).getItemCount();
	        	will(returnValue(3));
	        }
	    });
	    
	    KeyedValues actual = getCumulativePercentages(values1);
	    for(int i = 0; i < 3; i++) {
			assertEquals(Double.NaN, actual.getValue(i));
		}
	}

}
