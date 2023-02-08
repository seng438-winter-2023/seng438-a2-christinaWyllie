package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range exampleEqualRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1);
    	exampleEqualRange = new Range(1, 1);
    }

    //testing method getLowerBound() for case where upper bound != lower bound
    @Test
    public void lowerBoundRange() {
    	assertEquals("The lower bound of -1 and 1 should be -1",
    	-1, exampleRange.getLowerBound(), .000000001d);
    }
    
    //testing method getLowerBound() for case where upper bound == lower bound
    @Test
    public void lowerBoundEqualRange() {
    	assertEquals("The lower bound of 1 and 1 should be 1",
    	1, exampleEqualRange.getLowerBound(), .000000001d);
    }
    
    //testing method getUpperBound() for case where upper bound != lower bound
    @Test
    public void upperBoundRange() {
    	assertEquals("The upper bound of -1 and 1 should be 1",
    	1, exampleRange.getUpperBound(), .000000001d);
    }
    
    //testing method getUpperBound() for case where upper bound == lower bound
    @Test
    public void upperBoundEqualRange() {
    	assertEquals("The upper bound of 1 and 1 should be 1",
    	1, exampleEqualRange.getUpperBound(), .000000001d);
    }
    
    //testing method getLength() for range with length greater than 0
    @Test
    public void lengthRange() {
    	assertEquals("The length of range -1 and 1 should be 2",
    	2, exampleRange.getLength(), .000000001d);
    }
    
    //testing method getLength() for range with length 0
    @Test
    public void lengthEqualRange() {
    	assertEquals("The length of range 1 and 1 should be 0",
    	0, exampleEqualRange.getLength(), .000000001d);
    }
    
    //testing method contains() for valid value between boundary
    @Test
    public void rangeContainsValueInRange() {
    	assertTrue("The range of -1 to 1 contains 0 ",
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
    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}