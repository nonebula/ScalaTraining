//Imagine you're modelling an animal sanctuary in code. What type of Scala constructs would you use? Represent this in Scala.
//TO NOTE: This is the first slightly larger task of the course. Think about making your code clean and readable.

//Abstract classes ALMOST like traits but is still a class and gives a few other functionality bits
abstract class Animal {
  val age: Int
  val name: String
  val animalType: String
  val animalFamily: String

  println("My name is " + name + ". I am " + age + " years old.")
  println("I am a " + animalType + ".")
}
//Not sure why I ended up having to use trait here? Complexity of transferring across and extending.

class Bird(val age: Int, val name: String, val animalType: String) extends Animal {
  val animalFamily: String = "Bird"
  val hasWings: Boolean = true
  println("I am a " + animalFamily + ".")
}

class Insect(val age: Int, val name: String, val animalType: String) extends Animal {
  val animalFamily: String = "Insect"
  val HasExoskeleton: Boolean = true
  val NumberOfLegs: Int = 12
  println("I am an " + animalFamily + ".")
}

class Mammal(val age: Int, val name: String, val animalType: String) extends Animal {
  val animalFamily: String = "Mammal"
  val HasTail: Boolean = true
  println("I am a " + animalFamily + ".")
}

val lion = new Mammal (3, "Rex", "Lion")

trait CanFly {
  val CanFly: Boolean = true
  if (CanFly) {
    println("I can fly :) !")
  } else {
    println("I can't fly :( !")
  }
}

val eagle = new Bird(5, "Eddie", "Eagle") with CanFly
val cockroach = new Insect(56, "Vince", "Cockroach") with CanFly {
  override val CanFly: Boolean = false
}

val owl = new Bird(24, "Otto", "Owl") with CanFly
val warthog = new Mammal(7, "Pumba", "Warthog")
val dragonfly = new Insect(1, "Darko", "Dragonfly")


//Extension:
//Create a sealed trait to represent different diet types
//Create an object to represent the sanctuary and add some animals to it.
//Add some other animals/ animal groups to the model (e.g. domesticated).

//Research:
// What’s the difference between an abstract class and a trait? Why might you use one over the other?
//- A class can only inherit from one abstract class but can inherit from multiple traits
//- Abstract classes can have constructor parameters whereas traits can't
// If you need constructor parameters and want to define clear inheritance hierarchy, use abstract classes
// If you need reusable code and want to apply it to a range of different uses, use a trait
// If in doubt, use traits

// What are companion classes and objects and why might you use them?
//- A class and object declared in the same file with the same name
//- The class/object can access the private members of its companion
//- Companion objects can contain factory methods to generate new instances of a class
//- Companion objects can contain methods that are not specific to instances of the companion class