**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |  9                  |
| -------------- | ------------------- |
| Student Names: |  Christina Wyllie   |
|                |  Maitry Rohit       |
|                |  Sobia Khan         |
|                |  Jamie Stade        |

# 1 Introduction

This assignment focuses on unit testing a black box program. Given a program and documentation, a team of 4 analyzed requirements and created automated unit tests to ensure the application was running as expected. The unit tests are developed on Eclipse in Java using the JUnit library. In addition to learning syntax related to unit testing and JUnit, the team also had to develop their own mocks and stubs. 

# 2 Detailed description of unit test strategy

The team is testing all 5 methods in the data utilities class and 5 methods from Range: intersects(), contains(), getLength(), getLowerBound(), getUpperBound().
We used a combination of boundary value testing and equivalence class testing to design our test cases.

Class DataUtilities:
- calculateColumnTotal()
  - Passes valid input - Returns successful column
    - column == 0 
    - column == data.getColumnCount 
    - 0 < column < data.getColumnCount
  - Creating Values2D object:
    - Negative values
    - Positive values
  - Passes invalid input - Throws InvalidParameterException
      - Null passed in
- calculateRowTotal()
    - Passes valid input - Returns successful column
      - row== 0 
      - Row == data.getRowCount -1
      - 0<row<data.getRowCount -1
    - Creating Values2D object:
      - Negative values
      - Positive values
    - Passes invalid input - Throws InvalidParameterException
      - Null passed in

- createNumberArray()
  - Passes valid input - Returns successful array
      - Numbers in ranges -(max value of double) to +(max value of double)
      - Empty array
      - Normal array
  - Passes invalid input - Throws InvalidParameterException
      - Null passed in

- createNumberArray2D()
    - Passes valid input - Returns successful column
      - Numbers in ranges -(max value of double) to +(max value of double)
      - Empty array
      - Normal array
        - Length
    - Passes invalid input - Throws InvalidParameterException
      - Null passed in

- getCumulativePercentages()
  - Passes valid input - Returns keyed values
    - KeyedValues contains one or more positive values
  - Passes invalid input - Throws InvalidParameterException
    - KeyedValues only contains 0 values
    - Null passed in

Class Range:
- getLength()
  - Assert correct length upper bound > lower bound
  - Assert 0 when upper bound == lower bound
- getLowerBound()
  - Assert correct lower bound
- getUpperBound()
  - Assert correct upper bound
- contains()
  - Assert True for number contained in range (lower bound < number < upper bound)
  - Assert True for lower boundary of range
  - Assert True for upper boundary of range
  - Assert False for number < lower bound
  - Assert False for number > upper bound
- intersects()
  - Pass in lower > upper
  - Pass in upper < lower
  - Valid Input
    - Pass in lower < upper and upper > lower
    - Range that does not intersect on left hand side of range
    - Range that does not intersect on right hand side of range
    - Range that does intersect and is within the bounds
    - Range that is equal to the initialized range

# 3 Test cases developed

A total of 5 test classes were implemented. This is done in order to not only divide test cases by the classes and methods they belong to but also by who is writing them. 

Class Name: GetCumulativePercentageTest
  Test Case Names: 
    - public void validCumulativePercentage()
        - Tests valid positive values and ensures the proper percentages are calculated 
        - PASS
    - public void invalidCumulativePercentageNull()
        - Creates a KeyedValues object that is initialized to null. An invalid parameter exception should be thrown
        - FAIL
    - public void invalidCumulativePercentage0()
        - Creates a KeyedValues object that is initialized to 0. An invalid parameter exception should be thrown
        - PASS
        
 Class Name: IntersectsRangeTest
	Test Case Names: 
    - public void intersectInvalidLowerBound()
        - Sends a lower bound that is greater than the upper bound 
        - Assumption: An assumption is made that this data will intersect because if the bounds were switched it would return true
        - FAIL
    - public void intersectInvalidUpperBound()
        - Sends a upper bound that is greater than the lower bound 
        - An assumption is made that this data will intersect because if the bounds were switched it would return true
        - FAIL
    - public void intersectWithinRange()
        - When given bound that is within the mock range the test passes
        - PASS
    - public void intersectIsRange()
        - When given bound that is the mock range 
        - PASS
    - public void intersectOverlappingLowerBound()
        - Lower bound given is within the range but the upper bound is not
        - FAIL
    - public void intersectOverlappingUpperBound()
        - Upper bound given is within the range but the lower bound is not
        - PASS
    - public void intersectNoOverlappingBoundLHS()
        - Neither the upper or lower bound should overlap with the given range on the left hand side of range
        - FAIL
    - public void intersectNoOverlappingBoundRHS()
        - Neither the upper or lower bound should overlap with the given range on the right hand side range
        - PASS

Class Name: CreateNumberArrayTest
	Test Case Names: 
  - public void createNumberArrayValidInput()
    - Tests that passing in valid double array containing both positive and negative numbers creates expected Double array
  - FAIL
public void createNumberArrayValidInputLength()
Tests that passing in both positive and negative numbers in an array creates expected length array
PASS
public void createNumberArrayLargeInput()
Tests that passing in largest positive number that can be held in a double creates expected output 
PASS
public void createNumberArraySmallInput()
Tests that passing in largest negative number that can be held in a double creates expected output 
PASS
public void createNumberArrayEmptyInput()
Tests that passing in an empty double[] creates empty Double[]
PASS
public void createNumberArrayThrowsInvalidParameterException() 
Tests that passing in null data argument throws InvalidParameterException 
FAIL 
public void createNumberArray2DValidInput()
Tests that passing in a valid double[][] with both positive and negative numbers creates expected Double[][]
FAIL
public void createNumberArray2DCorrectRowsLength()
Tests that passing in valid double[][] creates Double[][] with correct number of rows
PASS
public void createNumberArray2DCorrectColumnsLength()
Tests that passing in a double[][] creates Double[][] with the correct number of columns
PASS 
public void createNumberArray2DEmptyInput()
Tests that passing in an empty double[][] creates empty Double[][] 
PASS
public void createNumberArray2DLargeInput()
Tests that passing in a double[][] containing largest positive value that can be held in a double creates the expected Double[][] 
PASS
public void createNumberArray2DSmallInput()
Tests that passing in a double[][] containing largest negative value that can be held in a double creates the expected Double[][] 
PASS
public void createNumberArray2DThrowsInvalidParameterException() 
Tests that passing in null data argument throws invalid parameter exception
FAIL

Class Name: CalculateTotalTest
	Test Case Names
public void calculateColumnWithLowerBound() 
Tests that passing in the lower bound returns the correct sum of columns with that index. 
Pass.
public void calculateColumnWithAboveLowerBound()
Tests that passing in an in-between value returns the correct sum of columns with that index
PASS
public void calculateColumnWithUpperBound()
Tests that passing in the upper bound returns the correct sum of columns with that index
PASS
public void calculateColumnWithNegativeValues()
Tests that negative values get added up correctly
PASS
public void calculateColumnWithNullData()
Tests that passing in null throws correct exception
FAIL
public void calculateRowWithLowerBound()
Tests that passing in the lower bound returns the correct sum of columns with that index
FAIL
public void calculateRowWithAboveLowerBound()
Tests that passing in an in-between value returns the correct sum of columns with that index
FAIL
public void calculateRowWithUpperBound()
Tests that passing in the upper bound returns the correct sum of columns with that index
FAIL
public void calculateRowWithNullData()
Tests that passing in null throws correct exception
FAIL
public void calculateRowWithNegativeValues()
Tests that negative values get added up correctly
FAIL
Class Name: RangeTest
	Test Case Names
setUp()
public void lowerBoundRange() 
testing method getLowerBound() for case where upper bound != lower bound
PASS
public void lowerBoundEqualRange()
testing method getLowerBound() for case where upper bound == lower bound
PASS
public void upperBoundRange() 
testing method getUpperBound() for case where upper bound != lower bound
FAIL
public void upperBoundEqualRange()
testing method getUpperBound() for case where upper bound == lower bound
PASS
public void lengthRange() 
testing method getLength() for range with length greater than 0
PASS
public void lengthEqualRange()
testing method getLength() for range with length equal to 0
PASS
public void rangeContainsValueInRange()
testing method contains() for valid value between boundary
PASS
public void rangeContainsLowerBound()
testing method contains() for valid value on lower boundary
PASS
public void rangeContainsUpperBound()
testing method contains() for valid value on upper boundary
PASS
public void rangeContainsPastLowerBound() 
testing method contains() for invalid value outside lower boundary
PASS
public void rangeContainsPastUpperBound()
testing method contains() for invalid value outside upper boundary
PASS


# 4 How the team work/effort was divided and managed

The team worked together as a group of 4 to create a thorough test plan, taking each method and writing an outline for every test to be conducted. Each member then took a few methods each and wrote the tests for those methods, writing cases for Boundary Values and Equivalence Classes. Christina worked on calculateRowTotal and calculateColumnTotal. Sobia worked on createNumberArray and createNumberArray2D, Maitry worked on getCumulativePercentage and intersects (in the range class), and Jamie worked on getLength, getLowerBound, getUpperBound, and contains in the range class. The data utilities classes were divided into 3 different test class files: 1 for column and row total, 1 for number array and 2D number array, and one for cumulative percentage. The range class contains 2 test class files: 1 for the getter and contains tests, and one for the intersects tests. 

The lessons on teamwork we learned from this lab were that while dividing up work makes it easier to complete, it also causes difficulties in understanding what other group members have done for their test cases. It also makes it more difficult to help out other group members when they run into bugs and errors.  

# 5 Difficulties encountered, challenges overcome, and lessons learned

As the team was writing tests, we became confused about how certain tests worked. The group had to determine whether errors occurred because of a bug in the program or an error in the way the test case was written. Sometimes JUnit would cause certain errors to occur with the test cases that were not reproducible. As we got more comfortable with writing tests we realized that there were bugs in the code and our tests were written correctly.

The team also struggled with learning mockery and how mocks and stubs can be incorporated in the tests written. After spending time in this lab the team learned more about mockery and grew comfortable with using it. 
Knowing how many tests to create per method was a difficulty faced. Certain tests that didn’t seem to have a purpose, but were written just as a precaution ended up providing valuable information that was not otherwise considered.


# 6 Comments/feedback on the lab itself

The instructions in the JUnit set up were clear and thorough, however some references to libraries in the explanation did not match what we were given. The JavaDoc does not clearly explain when exceptions are thrown. For example, an invalid parameter exception gets called when an incorrect data object is thrown, but a Junit program does not even compile when using invalid data objects. 
