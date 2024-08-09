/** Higher Order Functions */

//HOFs are functions that will take in a different function as an input parameter OR returns a function as a result
//This can happen because in Scala, functions are first class citizens
  //The have the same status as other values. They can be assigned as variables, passed into parameters, return as results, stored in data structures, etc


  //1. assign functions to vals
  val addition: (Int, Int) => Int = (x,y) => x + y
  addition(2,3)

val subtract: (Int, Int) => Int = (x,y) => x - y
subtract(2,3)

  //2. store in collections (lists, maps etc)
  val functionList = List(
    (a: Int, b: Int) => a + b,
    (a: Int, b: Int) => a * b,
    (a: Int, b: Int) => a - b,
  )//not named, could be problematic, can only access as below

  functionList.head(1,2) //access first
  functionList(1)(1,2) //access second
  functionList(2)(1,2) //access third etc ...


//3. Pass functions into arguments/params - nicer, quicker
def manipulateNumbers (x:Int, y:Int, function:(Int, Int)=>Int): Int = {
  function(x,y)
}

manipulateNumbers(1,2, addition)

manipulateNumbers(1,2, subtract)

//4. return functions from other functions - purpose only to make the function, scales well
def createAdditionFunction (x: Int): Int => Int = {
//  println(s"$x")
  (y: Int) => x + y
}
createAdditionFunction(1)
//creating another method off this to make sure this does more than a function
//make val:
val addOne: Int => Int = createAdditionFunction(1)
//then call val as method/function
addOne(2)

//Pattern matching to call functions (e.g. calculator)
//Not used in isolation, usually used for a bigger reason
//Allows the writing of our code to be modular and reuseable
//Reduces the amount of redundant code. This is often done by extracting repeated code into a HOF
//The most common HOF is a map (also filter, reduce, fold(left & right)

/** Functions as Params */
def firstHOF(x: Int, function: Int => Int): Int = {
  function(x)
}

def addTwo(n:Int): Int = n + 2
firstHOF(3, addTwo)

def square(n: Int): Int = n * n
firstHOF(3, square)

//using strings

val newList: List[String] = List("apple", "orange", "pear", "mango")

def processTheList(list1: List[String], function: String => String): List[String] = {
  list1.map(function)
}

def addS(word: String): String = word + "s" //function defined to be used in above
def upperCase(word: String): String = word.toUpperCase

processTheList(newList, addS) //no other params given as params are defined in earlier methods etc
processTheList(newList, upperCase)

//map - really common HOF
val numbers = Seq(1,2,3,4,5)
val doubledNumbers = numbers.map(num => num * 2)

/** Fold Left / Fold Right */
//Used to reduce a collection into a single value (not used that frequently but can be handy

// def foldLeft[B](z: B)(op: (B, A) => B): B //op = function, B = type; B acts as accumulator while A changes value as we iterate
// def foldRight[B](z: B)(op: (A, B) => B): B //op = function, B = type; A acts as accumulator while B changes value as we iterate

val foldLeftExample = numbers.foldLeft(0)(_ + _) //0 = index position
//val foldRightExample = numbers.foldRight(0)(_ + _) // (_ + _ ) is the accumulator + current value

val stringList = List("we", "love", "learning", "scala")
val concatenatedString1 = stringList.foldLeft("")(_ + _)
val concatenatedString2 = stringList.foldLeft("")(_ + " " + _).trim

//val concatenatedString3 = stringList.foldRight("")(_ + _)
//val concatenatedString3 = stringList.foldRight("")(_ + " " + _).trim


//More complex example
case class Male (male: Boolean)
case class Animal (name: String, male: Male)
val animalList = List(Animal("Fred the Fox", Male(true)), Animal("Sally the Seahorse", Male(false)), Animal("Rex the Rat", Male(true)))

val foldAnimalsLeft = animalList.foldLeft(List[String]()) { (acc, animal) =>
    val sirOrMadam = animal.male match {
      case Male(true) => "Sir"
      case Male(false) => "Madam"
    }
  //doing recursion within higher order functions
  acc :+ s"$sirOrMadam ${animal.name}"
}
println(foldAnimalsLeft)


val foldAnimalsRight = animalList.foldRight(List[String]()) { (animal, acc) => //switch the animal and accumulator
  val sirOrMadam = animal.male match {
    case Male(true) => "Sir"
    case Male(false) => "Madam"
  }
  //doing recursion within higher order functions
  acc :+ s"$sirOrMadam ${animal.name}"
}
println(foldAnimalsRight)


//Task
//fold to find product of the list
numbers.foldLeft(1)(_ * _)

//filter to return only the true Ints from the list
numbers.filter(num => num % 2 == 0)

//use fold function to count the number of characters in a string
stringList.foldLeft(0)((acc, str) => acc + str.length)

//use map to iterate through and transform the first letter to a capital and concatenate into a sentence
val capitalsList = stringList.map(str => str.capitalize)
capitalsList.foldLeft("")(_ + " " + _).trim


/** Returning Functions */
//Usually seen with pattern matching for readability

def smallRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.1
}

def mediumRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.2
}

def largeRise(salary: Double): (Int, Double) => Double = {
  (lengthOfEmployment: Int, salary: Double) => salary * 1.5
}

case class Employee(name: String, salary: Double, lengthOfEmployment: Int)

//Could then tuck the rest above away somewhere and build off it


def getPayRise(employee: Employee): (Int, Double) => Double = {
  employee.lengthOfEmployment match {
    case year if year <= 3 => smallRise(employee.salary)
    case year if year <= 5 => mediumRise(employee.salary)
    case year if year > 5 => largeRise(employee.salary)
  } // could error handle if needed
}

val Steve = Employee("Steve", 30000.00, 3)
val choosePayRise = getPayRise(Steve)
//Only returning the function at this point

//To apply and get need to make another method
val getNewSalary = choosePayRise(Steve.lengthOfEmployment, Steve.salary)

//Doing everything this way means only the source method needs to be changed, rather than having to change in many places in the future.
//If being used in more than one place better off writing a method and reusing it as much as you need.


//Task

// Define discount functions for different price ranges
def lowDiscount(price: Double): Double => Double = {
  (price: Double) => price * 0.80
}

def mediumDiscount(price: Double): Double => Double = {
  (price: Double) => price * 0.60
}

def highDiscount(price: Double): Double => Double = {
  (price: Double) => price * 0.50
}

def getDiscount(price: Double): Double => Double = {
  price match {
    case price if price < 20 => lowDiscount(price)
    case price if price >= 20 && price <= 50 => mediumDiscount(price)
    case price if price > 50 => highDiscount(price)
  }
}

case class Item(name: String, price: Double)

val item1 = Item("Book", 15.00)
val item2 = Item("Shoes", 35.00)
val item3 = Item("Jacket", 75.00)

val discountForItem1 = getDiscount(item1.price)
val discountForItem2 = getDiscount(item2.price)
val discountForItem3 = getDiscount(item3.price)

val newPrice1 = discountForItem1(item1.price)
val newPrice2 = discountForItem2(item2.price)
val newPrice3 = discountForItem3(item3.price)

println(s"The new price for ${item1.name} is £$newPrice1")
println(s"The new price for ${item2.name} is £$newPrice2")
println(s"The new price for ${item3.name} is £$newPrice3")