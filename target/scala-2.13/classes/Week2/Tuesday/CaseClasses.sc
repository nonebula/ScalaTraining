/** Case Classes */
//Helpful tool introduced by Scala, basically pimped up classes
//How do these differ? Classes are blueprints and so are case classes, but case classes model IMMUTABLE data.
//Unlike classes, we don't need to use the 'new' keyword when instantiating a new object
//Provides plenty of boilerplate code.

//Extra methods provided:
//an apply method
//an unapply method
//a hashcode and equals methods
//a copy method
//a toString method

case class SuperHero(realName: String, heroName: String, weakness: String)
//use of case above removes need for 'object' below
//methods available on . notation
val newSuperHero: SuperHero = SuperHero.apply("Clark Kent", "Superman", "Kryptonite") //used to make the objects
//can use unapply but not used as often as apply method
//OR write it out. Don't need to use 'new' for object.
val anotherNewSuperHero: SuperHero = SuperHero("Clark Kent", "Superman", "Kryptonite") //other method to make the objects

// ==
newSuperHero == anotherNewSuperHero //components are being compared, comparing what makes the object up (params)

//Copy Method
val updateName = anotherNewSuperHero.copy(realName = "Lois Lane")
val updateNameSuper = anotherNewSuperHero.copy(realName = "Lois Lane", heroName = "Superwoman")


//Exercise
//1.
case class Dog(name: String, breed: String, age: Int)
case class Cat(name: String, breed: String, age: Int)
case class Bird(name: String, breed: String, age: Int)


//2.
val dog1 = Dog.apply(name = "Rex", breed = "Rottweiler", age = 5)
val dog2 = Dog.apply(name = "Max", breed = "Labrador", age = 6)
val dog3 = Dog.apply(name = "Scrappy", breed = "Hound", age = 2)
val dog4 = Dog.apply(name = "Scooby", breed = "Hound", age = 9)

val cat1 = Cat.apply(name = "Peggy", breed = "Shitzu", age = 5)
val cat2 = Cat.apply(name = "Garfield", breed = "Gingerthing", age = 15)
val cat3 = Cat.apply(name = "Scratchy", breed = "Tiger", age = 9)
val cat4 = Cat.apply(name = "Margo", breed = "British Shorthair", age = 3)

val bird1 = Bird.apply(name = "Soary", breed = "Parrot", age = 13)
val bird2 = Bird.apply(name = "Flappy", breed = "Eagle", age = 3)
val bird3 = Bird.apply(name = "Milo", breed = "Hawk", age = 13)
val bird4 = Bird.apply(name = "Poncho", breed = "Bluejay", age = 13)

//3.
case class Kennel (name: String, Dogs: List[Dog])
//4.
val kennel1 = Kennel("Happy Tails", List(dog1, dog2, dog3, dog4))
//5.
val kennel2 = kennel1.copy(name = "happy paws")
//6.
case class ExpandedKennel(name: String, dogs: List[Dog], cats: List[Cat], birds: List[Bird])

val kennel3 = ExpandedKennel("joyful pets", List(dog1, dog2, dog3, dog4), List(cat1, cat2, cat3, cat4), List(bird1, bird2, bird3, bird4))

//7.
val newDog = Dog("Charlie", "Poodle", 1)
val newCat = Cat("Whiskers", "Siamese", 9)
val newBird = Bird("Tweety", "Canary", 2)

val kennel4 = ExpandedKennel("Joyful Pets", List(dog1, dog2, dog3, dog4), List(), List())

val finalExpandedKennel = kennel4.copy(
  dogs = kennel4.dogs :+ newDog,
  cats = kennel4.cats :+ newCat,
  birds = kennel4.birds :+ newBird
)

println(finalExpandedKennel)