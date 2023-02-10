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

Text…

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

# 4 How the team work/effort was divided and managed

Text…

# 5 Difficulties encountered, challenges overcome, and lessons learned

As the team was writing tests, we became confused about how certain tests worked. The group had to determine whether errors occurred because of a bug in the program or an error in the way the test case was written. Sometimes JUnit would cause certain errors to occur with the test cases that were not reproducible. As we got more comfortable with writing tests we realized that there were bugs in the code and our tests were written correctly.

The team also struggled with learning mockery and how mocks and stubs can be incorporated in the tests written. After spending time in this lab the team learned more about mockery and grew comfortable with using it. 
Knowing how many tests to create per method was a difficulty faced. Certain tests that didn’t seem to have a purpose, but were written just as a precaution ended up providing valuable information that was not otherwise considered.


# 6 Comments/feedback on the lab itself

The instructions in the JUnit set up were clear and thorough, however some references to libraries in the explanation did not match what we were given. The JavaDoc does not clearly explain when exceptions are thrown. For example, an invalid parameter exception gets called when an incorrect data object is thrown, but a Junit program does not even compile when using invalid data objects. 
