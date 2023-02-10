package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.junit.*;
import java.lang.Number;
import java.security.InvalidParameterException;


/**
 * @author sobia
 *
 */

public class CreateNumberArrayTest {

	private Number[] myNumberArray;
	private Number[][] myNumberArray2D;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		double[] myDoubleArray = {-12356015.0, 1, 2.01, 50000000};
		myNumberArray = DataUtilities.createNumberArray(myDoubleArray);
		
		double[][] my2DDoubleArray = {{-12356015.0}, {1, 2.01}, {50000000}};
		myNumberArray2D = DataUtilities.createNumberArray2D(my2DDoubleArray);
	}
	
//CreateNumberArray Tests 
	
	/* Equivalence Class Test: Test that valid double[] input creates expected
	 * Double[] output.
	 */
	
	@Test
	public void createNumberArrayValidInput() 
	{
		Double[] expectedDoubleArray = {-12356015.0, 1.0, 2.01, 50000000.0};
		assertArrayEquals(expectedDoubleArray, myNumberArray);
	}
	
	/* Equivalence Class Test: Test that valid double[] input creates expected
	 * length Double[] output.
	 */
	
	@Test
	public void createNumberArrayValidInputLength() 
	{
		Double[] expectedDoubleArray = {-12356015.0, 1.0, 2.01, 50000000.0};
		assertEquals(expectedDoubleArray.length, myNumberArray.length);
	}
	
	/* Boundary Value Test: When given max value that can be held in a double
	 * expected Number array is created. Ensure that variables can hold largest 
	 * positive number without variables overflowing. 
	 */
	
	@Test
	public void createNumberArrayLargeInput() 
	{
		Double[] expectedDoubleArray = {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
		double[] inputArray = {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE};
		myNumberArray = DataUtilities.createNumberArray(inputArray);
		assertEquals(expectedDoubleArray[0], myNumberArray[0]);
	}
	
	/* Boundary Value Test: When given the largest negative number that can be held in a double
	 * expected number array is created. Ensure that variables can hold largest negative double number
	 * without overflowing. 
	 */
	
	@Test
	public void createNumberArraySmallInput() 
	{
		Double[] expectedDoubleArray = {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE};
		double[] inputArray = {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE};
		myNumberArray = DataUtilities.createNumberArray(inputArray);
		assertEquals(expectedDoubleArray[0], myNumberArray[0]);
	}
	
	/* Equivalence Class Test: Pass in empty double array as input and test that 
	 * empty Double array created. Empty double[] is valid input according to documentation
	 * and should create expected Double[].
	 */
	
	@Test
	public void createNumberArrayEmptyInput()
	{
		double[] emptyArray = {};
		Double[] expectedDoubleArray = {};
		myNumberArray = DataUtilities.createNumberArray(emptyArray);
		assertArrayEquals(expectedDoubleArray, myNumberArray);
	}
	
	/* Boundary Value Test: Test that when null passed in as argument, 
	 * InvalidParameterException is thrown
	 * Catch InvalidParameterExeption if thrown and assert that test has passed
	 * Catch all other exceptions and assert that test failed. 
	 * 
	 * Cannot pass in char[], int[], Double[] etc. Gives compilation errors
	 */
	
	@Test //(expected = InvalidParameterException.class)
	public void createNumberArrayThrowsInvalidParameterException() //throws InvalidParameterException
	{	
		// TA: Shohug 
		// Confirmed that try catch is okay for checking whether or not invalid parameter exception is thrown
		
		try 
		{
			double[] invalidArray = null;
			myNumberArray = DataUtilities.createNumberArray(invalidArray); // throws illegal argument exception when invalidArray = null
		}
		
		catch (InvalidParameterException e)
		{
			assertTrue("InvalidParameterException correctly thrown for invalid input null", true);
		}
		
		catch (Exception e)
		{
			fail();
		}

	}

//CreateNumberArray2D Tests
	
	/* Equivalence Class Test: Test that passing in a valid 2D double array creates 
	 * the expected Double Array
	 */
	
	@Test
	public void createNumberArray2DValidInput() 
	{
		Double[][] expected2DDoubleArray = {{-12356015.0}, {1.0, 2.01}, {50000000.0}};
		assertArrayEquals(expected2DDoubleArray, myNumberArray2D);
	}
	
	/* Equivalence Class Test: Test that Double[] array created has the correct 
	 * number of rows
	 */
	
	@Test
	public void createNumberArray2DCorrectRowsLength() 
	{
		Double[][] expected2DDoubleArray = {{-12356015.0}, {1.0, 2.01}, {50000000.0}};
		assertEquals(expected2DDoubleArray.length, myNumberArray2D.length);
	}
	
	/* Equivalence Class Test: Test that array created has the expected 
	 * number of columns for each row
	 */
	
	@Test
	public void createNumberArray2DCorrectColumnsLength() 
	{
		Double[][] expected2DDoubleArray = {{-12356015.0}, {1.0, 2.01}, {50000000.0}};
		for(int i = 0; i < expected2DDoubleArray.length; i++)
		{
			assertEquals(expected2DDoubleArray[i].length, myNumberArray2D[i].length);
		}	
	}
	
	/* Equivalence Class Test: Pass in empty double[][] as input and test that 
	 * empty Double array created. Empty double[][] is valid input and should 
	 * create valid Number array.
	 */
	
	@Test
	public void createNumberArray2DEmptyInput()
	{
		double[][] empty2DArray = {{}, {}, {}};
		Double[][] expected2DDoubleArray = {{}, {}, {}};
		myNumberArray2D = DataUtilities.createNumberArray2D(empty2DArray);
		assertArrayEquals(expected2DDoubleArray, myNumberArray2D);
	}

	/* Boundary Value Test: When given max value that can be held in a double
	 * correct Number array is created, ensure that variables inside createNumberArray can hold 
	 * correct amount of precision. 
	 */
	
	@Test
	public void createNumberArray2DLargeInput() 
	{
		Double[][] expected2DDoubleArray = {{Double.MAX_VALUE, Double.MAX_VALUE}, {Double.MAX_VALUE}, {Double.MAX_VALUE}};
		double[][] inputArray = {{Double.MAX_VALUE, Double.MAX_VALUE}, {Double.MAX_VALUE}, {Double.MAX_VALUE}};
		myNumberArray2D = DataUtilities.createNumberArray2D(inputArray);
		assertEquals(expected2DDoubleArray[0][0], myNumberArray2D[0][0]);
	}
	
	/* Boundary Value Test: When given the largest negative number that can be held in a double
	 * correct number array is created, ensure that variables inside createNumberArray can hold 
	 * correct amount of precision. 
	 */
	
	@Test
	public void createNumberArray2DSmallInput() 
	{
		Double[][] expected2DDoubleArray = {{Double.MIN_VALUE, Double.MIN_VALUE}, {Double.MIN_VALUE}, {Double.MIN_VALUE}};
		double[][] inputArray = {{Double.MIN_VALUE, Double.MIN_VALUE}, {Double.MIN_VALUE}, {Double.MIN_VALUE}};
		myNumberArray2D = DataUtilities.createNumberArray2D(inputArray);
		assertEquals(expected2DDoubleArray[0][0], myNumberArray2D[0][0]);
	}
	
	/* Boundary Value Test: Test that when null passed in as argument, 
	 * InvalidParameterException is thrown
	 * Catch InvalidParameterExeption if thrown and assert that test has passed
	 * Catch all other exceptions and assert that test failed. 
	 * 
	 * Cannot pass in char[][], int[][], Double[][], etc. Gives compilation errors
	 */
	
	@Test //(expected = InvalidParameterException.class)
	public void createNumberArray2DThrowsInvalidParameterException() //throws InvalidParameterException
	{
		// TA: Shohug 
		// Confirmed that try catch is okay for checking whether or not invalid parameter exception is thrown
				
		try
		{
			// Invalid data according to documentation is null, should throw invalid parameter exception
			double[][] invalidArray = null;
			myNumberArray2D = DataUtilities.createNumberArray2D(invalidArray);
		}
		
		catch (InvalidParameterException e)
		{
			// If invalid parameter exception is thrown, assert that test passes 
			assertTrue(true);
		}
		
		catch (Exception e)
		{
			// If any other exception is thrown test fails 
			fail();
		}
	}

}
