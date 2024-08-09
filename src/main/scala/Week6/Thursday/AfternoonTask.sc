/** MVP */
//Task 1a - function that takes Int input and manipulates it to return an Int value
def addOne (input: Int): Int = {
  input + 1
}

//create a second function called 'applyTwice' that takes two arguments
  //one is an Int input
  //one is an Int to Int function (from step 1)
  //the function must apply the Int to Int function argument twice to the Int argument
def applyTwice (x: Int, function: Int => Int): Int = {
  function(function(x))
}

//Task 1b - create 4 functions (addition, multiplication, division, subtraction)
  //Each take two doubles as an input and return the result
val addition: (Double, Double) => Double = (x, y) => x + y

val subtraction: (Double, Double) => Double = (x, y) => x - y

val multiplication: (Double, Double) => Double = (x, y) => x * y

val division: (Double, Double) => Double = (x, y) => x / y

//create a function called 'mathFunc' that takes in two doubles, and a mathematical operation (as made above) as a function and returns the result as a double
def mathFunc (x: Double, y: Double, function: (Double, Double) => Double): Double = {
  function(x, y)
}

//Task 2a - Create a function called 'convertToUpperCase' that take any string input and returns that string as uppercase
def convertToUpperCase (input: String): String = {
  input.toUpperCase
}

//Create a function called 'convertToLowerCase' that take any string input, and returns that string as lowercase
def convertToLowerCase (input: String): String = {
  input.toLowerCase
}

////Create a third function called 'convertString' that takes a Boolean input with a parameter name 'makeStringUpperCase'. If the input is 'true' return the 1st uppercase method, if false return the 2nd lowercase method
//def convertString (makeStringUpperCase: Boolean, input: String): String = {
//  makeStringUpperCase match {
//    case true => convertToUpperCase(input)
//    case false => convertToLowerCase(input)
//  }
//}

//IF statement seems more efficient:
def convertString (makeStringUpperCase: Boolean, input: String): String = {
  if (makeStringUpperCase) {
    convertToUpperCase(input)
  } else {
    convertToLowerCase(input)
  }
}

//Copy: val testString = "cOnVeRtMe". Apply your convertString method to your testString and print the result when the input is 'true' and when it is 'false'
val testString = "cOnVeRtMe"
convertString(makeStringUpperCase = false, testString)
convertString(makeStringUpperCase = true, testString)

//Task 2b - Create a 'calculate' method that takes a string input and pattern matches it to return on previously written methods from question 1; 'add', 'subtract', 'multiply', 'divide'
def calculate(function: String): (Double, Double) => Double = {
  function match {
    case "add" => addition
    case "subtract" => subtraction
    case "multiply" => multiplication
    case "divide" => division
    case _ => throw new Error(s"Unknown operation $function")
  }
}

//Try applying different string inputs to the calculate method to return each of the arithmetic methods, saving the resulting method to a val. What happens if you enter an input that doesn't match any of the methods?



//Apply the val methods (from above), passing in two Int values. Print the result using s interpolation.





//When doing higher functions and returning, we do it in two steps, that makes sure we have everything we need to use