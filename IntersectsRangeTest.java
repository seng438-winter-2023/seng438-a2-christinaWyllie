/*
 * Class: SENG 438
 * Assignment: 2
 * File: GetCumulativePercentageTest.java
 * Purpose: Test the getCumulativePercentages method in the class DataUtilities. 
 * 
 * # of Tests: 8
 * Failures: 4
 * Author: Maitry Rohit
 * Date: Feb 9, 2023
*/


package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class IntersectsRangeTest {
    private Range testRange;
  
    //Range set up to be used as mock 
    //Will be used for every test specified below
    @Before
    public void setUp() throws Exception { 
    	testRange = new Range(-5.0, 5.0);
    }
    
    /* Test: intersectInvalidLowerBound
     * Description: Sends a lower bound that is greater than the upper bound 
     * 
     * Assumption: An assumption is made that this data will intersect 
     * because if the bounds were switched it would return true
     */

    @Test  
    public void intersectInvalidLowerBound() {
    	assertTrue("Given range should intersect with initialized range, but does not.",
    	testRange.intersects(17, 4.75));
    }
    
    /* Test: intersectInvalidUpperBound
     * Description: Sends a upper bound that is greater than the lower bound 
     * 
     * Assumption: An assumption is made that this data will intersect 
     * because if the bounds were switched it would return true
     */
    @Test
    public void intersectInvalidUpperBound(){
    	assertTrue("Given range should intersect with initialized range, but does not.",
    	testRange.intersects(7.0, -3.0));
    }
    
    
    /* Note: Equivalence Test
     * Test: intersectWithinRange
     * Description: When given bound that is within the mock range the test passes
     * Expected Return: True
     */
    @Test
    public void intersectWithinRange()  {
    	assertTrue("Given range should intersect with initialized range, but does not.",
    			testRange.intersects(-4.99, 4.99));
    }
    
    /* Note: Boundary Test
     * Test: intersectIsRange
     * Description: Gives an intersect range equal to the mock range
     * Expected Return: True
     */
    @Test
    public void intersectIsRange()  {
    	assertTrue("Given range should intersect with initialized range, but does not.",
    			testRange.intersects(-5, 5));
    }
    
    /* Note: Equivalence Test
     * Test: intersectOverlappingLowerBound
     * Description: Lower bound given is within the range but the upper bound is not
     * Expected Return: True
     */
    @Test
    public void intersectOverlappingLowerBound() {
        assertTrue("Given range should intersect with initialized range, but does not.",
        		testRange.intersects(4.38, 7.38));
    }
    
    
    /* Note: Equivalence Test
     * Test: intersectOverlappingUpperBound
     * Description: Upper bound given is within the range but the lower bound is not
     * Expected Return: True
     */
    @Test
    public void intersectOverlappingUpperBound() {
    	assertTrue("Given range should intersect with initialized range, but does not.",
    			testRange.intersects(-10, -4.75));
    }  
    
    /* Note: Equivalence Test
     * Test: intersectNoOverlappingBoundLHS
     * Description: Neither the upper or lower bound should overlap with the 
     * given range on the left hand side of range 
     * Expected Return: False
     */
    @Test
    public void NoOverlappingBoundLHS() {
        assertFalse("Given range should not intersect with initialized range, but does.",
        testRange.intersects(-10, -5.01));
    }  
    
    /* Note: Equivalence Test
     * Test: intersectNoOverlappingBoundRHS
     * Description: Neither the upper or lower bound should overlap with the 
     * given range on the right hand side range
     * Expected Return: False
     */
    @Test
    public void NoOverlappingBoundRHS() {
        assertFalse("Given range should not intersect with initialized range, but does.",
        testRange.intersects(5.01, 10));
    }  
}
