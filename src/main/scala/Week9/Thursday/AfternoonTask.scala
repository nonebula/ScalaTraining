package Week9.Thursday

object AfternoonTask extends App {

  //1
  abstract class Animal {
    def name: String

    def diet: String
  }

  case class Dog(name: String, diet: String) extends Animal

  case class Cat(name: String, diet: String) extends Animal

  case class Dragon(name: String, diet: String) extends Animal

  case class Gorilla(name: String, diet: String) extends Animal

  case class Sheep(name: String, diet: String) extends Animal

  case class Bird(name: String, diet: String) extends Animal

  val myDog: Animal = new Dog("Buddy", "Beef")
  val myCat: Animal = new Cat("Gaia", "Everything")
  val myDragon: Animal = new Dragon("Vermithor", "Humanity")
  val myGorilla: Animal = new Gorilla("Thor", "Vegetables")
  val mySheep: Animal = new Sheep("Sally", "Grass")
  val myBird: Animal = new Bird("Sol", "Ice Cream")

  // This compiles because these are subtypes of Animal. In Scala, this is allowed as Animal can refer to any of its subclasses. The type system is working correctly with subtyping.


  //2
  class Solitary[+T <: Animal](val animal: T) {
    def isSolitary: Boolean = true
  }

  val solitaryCat: Solitary[Cat] = new Solitary[Cat](Cat("Gaia", "Everything"))

  // This line will not compile:
  // val solitaryAnimal: Solitary[Animal] = solitaryCat

  // Explanation: Solitary is covariant in its type parameter, but the assignment will fail because `Solitary[Cat]` is not a subtype of `Solitary[Animal]`. Variance only applies to the covariant type parameter of the class; it doesn't apply to class instances directly.
  //Invariance means Solitary[Cat] is not a subtype of Solitary[Animal], even though Cat is a subtype of Animal. The type Solitary[Cat] cannot be used where Solitary[Animal] is expected, due to invariance.

  //3
  class Pair[+T](val first: T, val second: T)

  class Swan(name: String, diet: String) extends Animal {
    override def name: String = "Bob"

    override def diet: String = "Fish"
  }

  val swanPair: Pair[Swan] = new Pair[Swan](new Swan("Tyler", "Cod"), new Swan("Sandra", "Fish"))

  // This will compile:
  val animalPair: Pair[Animal] = swanPair

  // Explanation: The Pair class is covariant in its type parameter `T`, which means that `Pair[Swan]` is a subtype of `Pair[Animal]` because `Swan` is a subtype of `Animal`. Covariance allows `Pair[Swan]` to be used wherever `Pair[Animal]` is expected.
  //Covariance means you can assign a Pair[Swan] to a Pair[Animal] because Swan is a subtype of Animal. This is allowed because Pair is covariant in its type parameter.


  //4
  abstract class Feeder[-T] {
    def feedAnimal(animal: T): Unit
  }

  class AnimalFeeder extends Feeder[Animal] {
    def feedAnimal(animal: Animal): Unit = println(s"Feeding ${animal.name}")
  }

  class DogFeeder extends Feeder[Dog] {
    def feedAnimal(animal: Dog): Unit = println(s"Feeding ${animal.name}")
  }

  // This line will not compile:
  // val dogFeeder: Feeder[Dog] = animalFeeder

  // Feeding with DogFeeder
  val dogFeeder: Feeder[Animal] = new AnimalFeeder // Correct usage
  dogFeeder.feedAnimal(Dog("Rover", "Beef")) // Expected to print: Feeding Rover

  // This line will not compile:
  // dogFeeder.feedAnimal(Cat("Gaia", "Everything"))

  // Explanation: A `DogFeeder` cannot be assigned to `Feeder[Animal]` because it is specialized to feed only `Dog` instances. The assignment would fail. However, `AnimalFeeder` can be assigned to `Feeder[Animal]` because it can handle any `Animal`.


  // Explanation: A `DogFeeder` is specialized to feed only `Dog` instances. Attempting to call `feedAnimal` with a `Cat` will fail because `Cat` is not a `Dog`, and contravariant types only work when the type `T` is a supertype of the expected type.


}

