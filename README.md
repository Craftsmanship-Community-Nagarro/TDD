![csharp build](../../actions/workflows/csharp_build.yml/badge.svg)
![java build](../../actions/workflows/java_build.yml/badge.svg)

# Test Driven Development

This is a template for different TDD exercises. There are Unit Tests to verify that the test frame setup correctly and that a mocking library is available. 

## Your tasks
Create a simple string-calculator with a method to add some number. The method returns the sum as an integer value.

The method can take up multiple numbers separated by commas, and will return their sum.
For example “” or “1” or “1,2” as inputs.

- Think about the design first
- Write down a list of examples
- Implement th code with TDD starting with the 1st feature.
- Solve things as simply as possible so that you force yourself to write tests you did not think about
- Refactor after each passing test


## Feature 1

Provide a second delimiter '\n' for separating the numbers so that both can be passed in the same input alternatively. 

## Feature 2

Support additional delimiters in the following format

   “//[delimiter]\n[numbers...]”

## Feature 3

Calling the calculator with a negative number will throw an exception with the message “negative number are not allowed”. The exception should contain the negative number that was passed. If there are multiple negative numbers, list all of them in the exception message

## Feature 4

Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2

## Feature 5

Delimiters can be of any length:
 “//$$\n1$$2$$3” should return 6

 ## Acknoledgement
 Thanks to Roy Osherrove who designed this kata originally ([find his version of the String Calculator here](https://osherove.com/tdd-kata-1)) and who is the author of “Art of Unit Testing”.
