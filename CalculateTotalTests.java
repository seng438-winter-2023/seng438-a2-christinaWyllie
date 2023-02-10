/*
Class: SENG 438

File: CalculateTotalTest/java
Purpose: Test the calculateColumnTotal and calculateRowTotal method in the class DataUtilities. 

# of Tests: 10
Failures: 6

Author: Christina Wyllie
Date: Feb 9, 2023

*/

package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.junit.Before;
import org.junit.Test;
import java.security.*;

import org.jfree.data.*;

public class CalculateTotalTests {
	
	private Values2D values;

	
	/*
	 * SETUP
	 */
	@Before
	public void setUp() throws Exception{
		//create a mockery object for Values2D
		Mockery mockingContext = new Mockery();
	    values = mockingContext.mock(Values2D.class);
	    //create a Values2D object with 3 rows and 3 columns
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            //three rows
	            will(returnValue(3));
	            one(values).getColumnCount();
	            //three columns
	            will(returnValue(3));
	            
	            //populate 0th row
	            one(values).getValue(0, 0);
	            //insert 2.0 into the 0th row and 0th column
	            will(returnValue(2.0));
	            one(values).getValue(0, 1);
	            //insert 2.5 into the 0th row and 1st column
	            will(returnValue(2.5));
	            one(values).getValue(0, 2);
	            //insert 3.8 into the 0th row and 2nd column
	            will(returnValue(3.8));
	            
	            //populate 1st row
	            one(values).getValue(1, 0);
	            //insert 5.0 into the 1st row and 0th column
	            will(returnValue(5.0));
	            one(values).getValue(1, 1);
	            //insert 1.0 into the 1st row and 1st column
	            will(returnValue(1.0));
	            one(values).getValue(1, 2);
	            //insert 3.5 into the 1st row and 2nd column
	            will(returnValue(3.5));
	            
	            //populate 2nd row
	            one(values).getValue(2, 0);
	            //insert 2.0 into the 0th row and 0th column
	            will(returnValue(2.0));
	            one(values).getValue(2, 1);
	            //insert 10.0 into the 2nd row and 1st column
	            will(returnValue(10.0));
	            one(values).getValue(2, 2);
	            //insert 9.8 into the 2nd row and 2nd column
	            will(returnValue(9.8));
	        }
	    });
	}
	
	
	/*
	 * CALCULATECOLUMNTOTAL TESTS
	 */
	@Test
	public void calculateColumnWithLowerBound() {
		//calculating the total in column 0, the lower bound 
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
	    assertEquals("calculated column total with lower bound", 9.0, result, .000000001d);
	}
	
	@Test
	public void calculateColumnWithAboveLowerBound() {
		//calculating the total in column 1, below upper bound and above upper bound
		double result = DataUtilities.calculateColumnTotal(values, 1);
		// verify
	    assertEquals("calculated column total for column 1", 13.5, result, .000000001d);
	}
	
	@Test
	public void calculateColumnWithUpperBound() {
		//calculating the total in column 2, the upper bound
		double result = DataUtilities.calculateColumnTotal(values, 2);
		// verify
	    assertEquals("calculated column total with upper bound", 17.1, result, .000000001d);
	}
	
	@Test
	public void calculateColumnWithNegativeValues() {
		//creating a mockery object specific for this test
		//using negative values to calculate the column total
		Values2D val;
		Mockery mockingContext2 = new Mockery();
	    val = mockingContext2.mock(Values2D.class);
	    //create a Values2D object with 3 rows and 3 columns
	    mockingContext2.checking(new Expectations() {
	        {
	            one(val).getRowCount();
	            //three rows
	            will(returnValue(3));
	            one(val).getColumnCount();
	            //one column
	            will(returnValue(1));
	            
	            //populate 0th row
	            one(val).getValue(0, 0);
	            //insert -2.0 into the 0th row and 0th column
	            will(returnValue(-2.0));
	            one(val).getValue(1, 0);
	            //insert 2.5 into the 1st row and 0th column
	            will(returnValue(2.5));
	            one(val).getValue(2, 0);
	            //insert -3.8 into the 2nd row and 0th column
	            will(returnValue(-3.8));
	        }
	    });
	         
	    double result = DataUtilities.calculateColumnTotal(val, 0);
		// verify
	    assertEquals("Calculated column total with negative values, -3.3, result, .000000001d);
	}
	

	
	@Test 
	public void calculateColumnWithNullData(){
		Values2D val = null;
		try {
			//calculating the total with invalid input, null data
			double result = DataUtilities.calculateColumnTotal(val, 1);
		}
		catch(InvalidParameterException e) {
			//if InvalidParameterException is caught, then the correct exception was thrown
			assertTrue(true);
		}
		catch(Exception e) {
			//else, should fail
			fail("InvalidParameterException was not caught");
		}
	}
	
	/*
	 * CALCULATEROWTOTAL() TESTS
	 */
	@Test
	public void calculateRowWithLowerBound() {
		//calculating the total in row 0, the lower bound 
		double result = DataUtilities.calculateRowTotal(values, 0);
		// verify
	    assertEquals("calculated row total with lower bound", 8.3, result, .000000001d);
	}
	
	@Test
	public void calculateRowWithAboveLowerBound() {
		//calculating the total in row 1. below upper bound and above lower bound
		double result = DataUtilities.calculateRowTotal(values, 1);
		// verify
	    assertEquals("calculated row total for row 1", 9.5, result, .000000001d);
	}
	
	@Test
	public void calculateRowWithUpperBound() {
		//calculating the total in row 2. upper bound
		double result = DataUtilities.calculateRowTotal(values, 2);
		// verify
	    assertEquals("calculated row total with upper bound", 21.8, result, .000000001d);
	}
	
	@Test 
	public void calculateRowWithNullData(){
		Values2D val = null;
		try {
			//calculating the total with invalid input, null data
			double result = DataUtilities.calculateRowTotal(val, 1);
		}
		catch(InvalidParameterException e) {
			//if InvalidParameterException is caught, then the correct exception was thrown
			assertTrue(true);
		}
		catch(Exception e) {
			//else, the test fails
			fail("InvalidParameterException was not caught");
		}
		
	}
	
	@Test
	public void calculateRowWithNegativeValues() {
		Values2D val;
		//creating a mockery object specific for this test
		//using negative values to calculate the row total
		Mockery mockingContext2 = new Mockery();
	    val = mockingContext2.mock(Values2D.class);
	    //create a Values2D object with 3 rows and 3 columns
	    mockingContext2.checking(new Expectations() {
	        {
	            one(val).getRowCount();
	            //one row
	            will(returnValue(1));
	            one(val).getColumnCount();
	            //three columns
	            will(returnValue(3));
	            
	            //populate 0th row
	            one(val).getValue(0, 0);
	            //insert -2.0 into the 0th row and 0th column
	            will(returnValue(-2.0));
	            one(val).getValue(0, 1);
	            //insert 2.5 into the 0th row and 1st column
	            will(returnValue(2.5));
	            one(val).getValue(0, 2);
	            //insert -3.8 into the 0th row and 2nd column
	            will(returnValue(-3.8));
	        }
	    });
	         
	    double result = DataUtilities.calculateRowTotal(val, 0);
		// verify
	    assertEquals("Calculated row total with negative values", -3.3, result, .000000001d);
	}


}
