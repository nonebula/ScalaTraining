/** MVP */
//1. What are three main differences between a class and a case class?
//Case classes model immutable data, no need for new or object keywords, provides boilerplate code to build off of.

//2. Which of the following lines of code is runnable and which will produce an error?
//a) - runs
case class Person (name: String, age: Int, nationality: String, isStudent: Boolean)

//b) - runs
val firstPerson = new Person("Carlos", 23, "Spanish", true)

//c) - runs
val secondPerson = Person("Carlos", 23, "Spanish", true)

//d) val - error - no use of val, not assigned.
//thirdPerson = Person("Chloe", 25, "British", false)

//e) - runs
class Animal (name: String, colour: String, pet: Boolean)

//f) - error, isn't case class so needs keyword 'new'
//val cat = Animal("cat", "black", true)

//g) - runs, new keyword is used and is needed initially as not a case class
val dog = new Animal ("dog", "white", true)

//3. After reviewing all combinations, which ones are true when compared using the "==" operator?
case class Muffin (flavour: String, price: Double, storeBoughtFrom: String)
val chocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val blueberryMuffin = Muffin ("blueberry", 3.50, "Mercator Bakery")
val vanillaMuffin = Muffin("vanilla", 3.50, "Mercator Bakery")
val anotherChocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val oneMoreChocolateMuffin = Muffin ("Chocolate", 3.50, "Mercator Bakery")
val finalChocolateMuffin = Muffin("choocolate", 2.50, "MercatorBakery")

// chocolateMuffin == anotherChocolateMuffin is the only combination that matches. Different cases, letter spacing etc.

/** Extension */
//1.Construct a case class that takes in a minimum of 3 parameters, each of a different type, and a case object.
case class VideoGame (genre: String, price: Int, childAppropriate: Boolean)
case object GameStore

//2. Create 3 instances of the case class.
  val marioKart = VideoGame("Arcade", 25, childAppropriate = true) //intellij requested me to name the boolean operators, reason for this?
  val maxPayne = VideoGame("Thriller", 19, childAppropriate = false)
  val nba2K = VideoGame("Sport", 45, childAppropriate = true)

  println(s"Game genre: ${marioKart.genre}, Price: ${marioKart.price}, Child Appropriate: ${marioKart.childAppropriate}")
  println(s"Game genre: ${maxPayne.genre}, Price: ${maxPayne.price}, Child Appropriate: ${maxPayne.childAppropriate}")
  println(s"Game genre: ${nba2K.genre}, Price: ${nba2K.price}, Child Appropriate: ${nba2K.childAppropriate}")

  println(GameStore)

//3. Use the ".copy" method to create a further 3 instances, each time modifying a different class parameter.
val damagedMario = marioKart.copy(price = 15)
val familyMaxPayne = maxPayne.copy(childAppropriate = true)
val cheapNba2K = nba2K.copy(price = 30)

println(damagedMario)
println(familyMaxPayne)
println(cheapNba2K)

//4. Use the "toString" method to print all parameters of the instance you have already created for exercise 3.
println(damagedMario.toString)
println(familyMaxPayne.toString)
println(cheapNba2K.toString)

//5. Use the "equals" method to compare case class instances you have already created as part of the exercises so far.
println(marioKart.equals(damagedMario))
println(maxPayne.equals(familyMaxPayne))
println(nba2K.equals(cheapNba2K))

  /** Research */
//1. We discussed about ".copy", ".toString" and "equals" methods but there are a lot more available, such as "getClass", "canEqual" etc. Find as many as you can, what do they do? Try to apply them the case classes you've created.
//.equals() - Checks if another instance is equal to this one
  val anotherMarioKart = VideoGame("Arcade", 25, childAppropriate = true)
println(marioKart.equals(anotherMarioKart)) // true

//.eq - Checks if two references are the same (reference equality)
val sameReference = marioKart
println(marioKart.eq(sameReference)) // true
println(marioKart.eq(anotherMarioKart)) // false

//.hashCode - returns a hash code value for the object
println(marioKart.hashCode)

//.toString - returns a string representation of the object
println(marioKart.toString)

//.canEqual - Checks if the object can be compared for equality
println(marioKart.canEqual(anotherMarioKart))
println(marioKart.canEqual("some string"))

//.productArity - Returns the number of elements in the product (case class)
println(marioKart.productArity) // 3

//.productElement - Returns the nth element of the product (case class)
println(marioKart.productElement(0))
println(marioKart.productElement(1))
println(marioKart.productElement(2))

//.productElementName - Returns the name of the nth element of the product (case class)
println(marioKart.productElementName(0))
println(marioKart.productElementName(1))
println(marioKart.productElementName(2))

//.productElementName - Returns the name of the nth element of the product (case class)
println(marioKart.productElementName(0))
println(marioKart.productElementName(1))
println(marioKart.productElementName(2))

//.productIterator - Returns an iterator over all the elements of the product (case class)
marioKart.productIterator.foreach(println)

//.productPrefix - Returns the prefix of the product (case class)
println(marioKart.productPrefix)

//.getClass - Returns the runtime class of the object
println(marioKart.getClass)

//.!= - Checks if two instances are not equal
val differentGame = VideoGame("Racing", 30, childAppropriate = true)
println(marioKart != differentGame)

//.## - Returns a hash code value for the object (synonym for hashCode)
println(marioKart.##)

//.== - Checks if two instances are equal (same as equals)
println(marioKart == anotherMarioKart) // true

//.asInstanceOf - Casts the object to a different type
val obj: Any = marioKart
val game: VideoGame = obj.asInstanceOf[VideoGame]
println(game)

//.isInstanceOf - Checks if the object is an instance of a specific type
println(marioKart.isInstanceOf[VideoGame]) // true
println(marioKart.isInstanceOf[String]) // false

//.ne - Checks if two references are not the same
println(marioKart.ne(differentGame)) // true
println(marioKart.ne(sameReference)) // false

//.synchronized - Synchronizes the block of code on the object
marioKart.synchronized {
  println("This is a synchronized block.")
}

//.-> - Creates a tuple SS
val tuple = marioKart -> "Best Game"
println(tuple)

//.ensuring - Ensures a condition holds for the object
val ensuredGame = marioKart.ensuring(_.price > 0, "Price must be positive")
println(ensuredGame)

//.+ - Concatenates the string representation of the object SS
val gameDescription = "Game: " + marioKart
println(gameDescription)

//.formatted - Formats the object's string representation
//println(marioKart.formatted("Price: %s", marioKart.price))
//DEPRECATED!

//.→ - Creates a tuple
val arrowTuple = marioKart → "Fun"
println(arrowTuple)

//2. Is there difference between "equals" and "==" methods and why?
// equals method defined in the 'ANY' class in root of scala's class hierarchy. Used to determined whether two objects are equal in terms of their content or state. Can be overridden by classes to provide custom equality logic.
// == is syntactic sugar for the equals method. However, adds a layer of safety by handling nulls 'gracefully'. Checks for null and ensures that it does not throw a NullPointerException. If the left-hand side is null, it will return false instead of throwing an exception.