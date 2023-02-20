package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range exampleEqualRange;
    private Range testRange;


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1);
    	exampleEqualRange = new Range(1, 1);
        testRange = new Range(-5.0, 5.0);
    }

    //testing method getLowerBound() for case where upper bound != lower bound
    @Test
    public void lowerBoundRange() {
    	assertEquals("Lower bound of -1 and 1 ",
    	-1, exampleRange.getLowerBound(), .000000001d);
    }
    
    //testing method getLowerBound() for case where upper bound == lower bound
    @Test
    public void lowerBoundEqualRange() {
    	assertEquals("Lower bound of 1 and 1 ",
    	1, exampleEqualRange.getLowerBound(), .000000001d);
    }
    
    //testing method getUpperBound() for case where upper bound != lower bound
    @Test
    public void upperBoundRange() {
    	assertEquals("Upper bound of -1 and 1 ",
    	1, exampleRange.getUpperBound(), .000000001d);
    }
    
    //testing method getUpperBound() for case where upper bound == lower bound
    @Test
    public void upperBoundEqualRange() {
    	assertEquals("Upper bound of 1 and 1 ",
    	1, exampleEqualRange.getUpperBound(), .000000001d);
    }
    
    //testing method getLength() for range with length greater than 0
    @Test
    public void lengthRange() {
    	assertEquals("Length of range -1 and 1 ",
    	2, exampleRange.getLength(), .000000001d);
    }
    
    //testing method getLength() for range with length 0
    @Test
    public void lengthEqualRange() {
    	assertEquals("Length of range 1 and 1 ",
    	0, exampleEqualRange.getLength(), .000000001d);
    }
    
    //testing method contains() for valid value between boundary
    @Test
    public void rangeContainsValueInRange() {
    	assertTrue("Range of -1 to 1 contains 0 ",
    	exampleRange.contains(0));
    }
    
    //testing method contains() for valid value on lower boundary
    @Test
    public void rangeContainsLowerBound() {
    	assertTrue("The range of -1 to 1 contains -1 ",
    	exampleRange.contains(-1));
    }
    
    //testing method contains() for valid value on upper boundary
    @Test
    public void rangeContainsUpperBound() {
    	assertTrue("The range of -1 to 1 contains 1 ",
    	exampleRange.contains(1));
    }
    
    //testing method contains() for invalid value outside lower boundary
    @Test
    public void rangeContainsPastLowerBound() {
    	assertFalse("The range of -1 to 1 does not contain -1.5 ",
    	exampleRange.contains(-1.5));
    }
    
    //testing method contains() for invalid value outside upper boundary
    @Test
    public void rangeContainsPastUpperBound() {
    	assertFalse("The range of -1 to 1 does not contain 1.5 ",
    	exampleRange.contains(1.5));
    }
    
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
