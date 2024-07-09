/** MVP */
//1. What are three main differences between a class and a case class?

//2. Which of the following lines of code is runnable and which will produce an error?
//a) case class Person (name: String, age: Int, nationality: String, isStudent:
//Boolean)

//b) val firstPerson = new Person("Carlos", 23, "Spanish", true)

//c) val secondPerson = Person("Carlos", 23, "Spanish", true)

//d) val thirdPerson = Person("Chloe", 25, "British", false)

//e) class Animal (name: String, colour: String, pet: Boolean)

//f) val cat = Animal("cat", "black", true)

//g) val dog = new Animal ("dog", "white", true)

//3. After reviewing all combinations, which ones are true when compared using the "==" operator?
/** case class Muffin (flavour: String, price: Double, storeBoughtFrom: String)
val chocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val blueberryMuffin = Muffin ("blueberry", 3.50, "Mercator Bakery")
val vanillaMuffin = Muffin("vanilla", 3.50, "Mercator Bakery")
val anotherChocolateMuffin = Muffin("chocolate", 3.50, "Mercator Bakery")
val oneMoreChocolateMuffin = Muffin ("Chocolate", 3.50, "Mercator Bakery")
val finalChocolateMuffin = Muffin("choocolate", 2.50, "MercatorBakery") */


/** Extension */
//1.Construct a case class that takes in a minimum of 3 parameters, each of a different type, and a case object.

//2. Create 3 instances of the case class.

//3. Use the ".copy" method to create a further 3 instances, each time modifying a different class parameter.

//4. Use the "toString" method to print all parameters of the instance you have already created for exercise 3.

//5. Use the "equals" method to compare case class instances you have already created as part of the exercises so far.


  /** Research */
//1. We discussed about ".copy", ".toString" and "equals" methods but there are a lot more available, such as "getClass", "canEqual" etc. Find as many as you can, what do they do? Try to apply them the case classes you've created.

//2. Is there difference between "equals" and "==" methods and why?