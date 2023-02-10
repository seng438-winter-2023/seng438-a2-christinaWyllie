package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range exampleEqualRange;


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1);
    	exampleEqualRange = new Range(1, 1);
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
    
}
