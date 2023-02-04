/**
 * 
 */
package org.jfree.data.DataUtilitiesTests;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.junit.*;
import java.lang.Number;
import java.security.InvalidParameterException;


/**
 * @author sobia
 *
 */
public class DataUtilitiesTests {

	private Number[] myNumberArray;
	private Number[][] myNumberArray2D;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		double[] myDoubleArray = {1.0, 1, 2.01, 5};
		myNumberArray = DataUtilities.createNumberArray(myDoubleArray);
		
		double[][] my2DDoubleArray = {{1.0}, {1, 2.01}, {5}};
		myNumberArray2D = DataUtilities.createNumberArray2D(my2DDoubleArray);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createNumberArrayValidInputLengthTest() 
	{
		Double[] expectedDoubleArray = {1.0, 1.0, 2.01, 5.0};
		assertEquals(expectedDoubleArray.length, myNumberArray.length);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void createNumberArrayInvalidCharInputTest() throws InvalidParameterException
	{
		double[] myCharArray = {};
		myNumberArray = DataUtilities.createNumberArray(myCharArray);
	}
	
//	@Test
//	public void createNumberArrayThrowsException() {
//		fail("Not yet implemented");
//	}
//	
//	@Test
//	public void createNumberArray2DInvalidInputTest() {
//		fail("Not yet implemented");
//	}
//	
	//Test that putting in a valid 2D double array creates the expected Double Array
	@Test
	public void createNumberArray2DValidInputTest() 
	{
		Double[][] expected2DDoubleArray = {{1.0}, {1.0, 2.01}, {5.0}};
		assertArrayEquals(expected2DDoubleArray, myNumberArray2D);
	}
	
	// Test that array created has the correct number of rows
	@Test
	public void createNumberArray2DCorrectRowsTest() 
	{
		Double[][] expected2DDoubleArray = {{1.0}, {1.0, 2.01}, {5.0}};
		assertEquals(expected2DDoubleArray.length, myNumberArray2D.length);
	}
	
	// Test that array created has the correct number of columns
	@Test
	public void createNumberArray2DCorrectColumnsTest() 
	{
		Double[][] expected2DDoubleArray = {{1.0}, {1.0, 2.01}, {5.0}};
		for(int i = 0; i < expected2DDoubleArray.length; i++)
		{
			assertEquals(expected2DDoubleArray[i].length, myNumberArray2D[i].length);
		}
		
	}
//	
//	@Test
//	public void createNumberArray2DThrowsExceptionTest() {
//		fail("Not yet implemented");
//	}

}

