/** Scope */
//The term used for what information is available to a class, object, trait, function etc.
//Hierarchical; any scope can contain many other scopes within it. Can also be nested.
//If the compiler can't find the information it is looking for it in the current scope, it will look in its parent scope for that information.
//The compiler will always take information from the closest scope it can find.

/** Functions & Methods */
//Words get interchanged quite frequently, distinction can be subtle.
//Key differences:
  //Both, when names, allow you to define the specific steps once and then reuse them in multiple places, which eliminates duplicated code, leading to cleaner code.
  //Logic can be identical, however it's what we assign that logic to that decides if it is a function or a method
    //Function:
      //No different to any other type
      //It can be declared or assigned to a val or even passed into another function or returned by a function
      //Doesn't need to be named but cannot be reused without being assigned a name
      //Methods are a type of function
    //Method
      //Must use keyword 'def'
      //Belongs to a class.
      //Can be overridden with a different implementation.
      //We cannot have an anonymous methods; it must have a name.

//Anonymous Function
(number: Int) => number + 1

//Named Function
val addition = (number: Int) => number + 1

//Method
def addition: Int => Int = (number: Int) => number + 1

//Override Method
def addition: Int => Int = (number: Int) => number + 10

//Example Method
def makeACupOfTea(numOfSugars: Int): String = {
  s"You have made a tea with $numOfSugars spoons of sugar. Enjoy!"
}
makeACupOfTea(9)

//We never see the last expression being a println() because the println always returns a unit type. Return a string through interpolation.

val vat: Double = 1.4
def priceWithVat(price: Double): Double = {
  price * vat
}
priceWithVat(5)
//Easy to change above and update.

//Methods Within A Class:
class Number(num: Int) {
  def addition(aDifferentNum: Int): Int = {
    num + aDifferentNum
  }
}

val newNumberClass = new Number (10)
val classAddition = newNumberClass.addition(2)


//Task
//1.
def getBigVal(input1: Int, input2: Int): String = {
  if(input1 > input2){
    "first"
  } else if(input1 < input2){
    "second"
  } else if (input1 == input2) {
    "same"
  }
  else {
    "something's gone wrong"
  }
}
getBigVal(5,5)

//2.
def nameLength(firstName: String, secondName: String): Int = {
 if (firstName.length > secondName.length) {
   firstName.length
 } else if (firstName.length < secondName.length) {
   secondName.length
 } else if (firstName.length == secondName.length) {
   0
 } else {
   404
 }
 }
nameLength("Maximillian", "Kilman")

/** Referential Transparency */
//A function's return value is based solely on the inputs. Avoid if you can.
  //For example, given an addition method that has 1 and 1, the addition function will always return a result of 2.
//Might as well just hard code it and not waste time with a method.
//TLDR: DON'T WRITE METHODS YOU DON'T NEED. WRITE SMARTER.

/** Pure and Impure Functions
Pure: Given the same inputs, the output will always be the same.
Impure: Given the same inputs, the output will be different if passed in multiple times.*/

//Pure
val sentence: String = "Whoah! It's a"
def append(sentence: String, word: String): String = {
  sentence + " " + word.trim
}
val a = append(sentence, "Helicopter")
val b = append(sentence, "Ornithopter")



//Impure
var sentence: String = "Whoah! It's a"
def append(word: String): String = {
  sentence = sentence + " " + word
  sentence.trim
}

val a = append("Helicopter")
val b = append("Ornithopter")

//ALWAYS AIM FOR PURE METHODS. SCALA WANTS IMMUTABILITY



