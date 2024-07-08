/**Classes*/
//Where OOP really starts. Building blocks for everything in Scala.
//Use keyword 'class' to define a class.
//Capital letter for the class Name.
//Once adding behaviours, all inside { }, known as members of the class.

//Best practice isn't using worksheets. Best practice done through creating new Scala Class for each set of classes.

//2 ways to create a class:
//1: unimplemented members - no default value set. Each new class built off this must have these two params. ( ) used.
class ThemeParkEmptyParams (val hasRollerCoasters: Boolean, val diameterOfLargestLoop: Double) {
  //can add things within here that are always going to be the case.
}

//If adding things within, see below. Combination of both methods.
class ThemeParkBoth (val diameterOfLargestLoop: Double) {
  val hasRollerCoasters: Boolean = true
}

//2: implemented members - default values are set as parameters. { } used.
class ThemeParkDefaultParams {
  val hasRollerCoasters: Boolean = true
  val diameterOfLargestLoop: Double = 29.34
}
//Everything inside { } belongs to that class. These are Members of the class.

//Use classes to make objects. When we declare an object we are instantiating a class. We need to say what they need to be.
//Made up of three things: state, behaviour and identity.
//State = attributes of properties of the object.
//Behaviour = Methods that will give a response when called.
//Identity = The name given to allow interaction between different objects.

/**Objects */
//Using keyword 'new'
//1: empty params. Working with a large codebase, this is not particularly useful and can be tricky.
val mercatorPark: ThemeParkEmptyParams = new ThemeParkEmptyParams(hasRollerCoasters = true, diameterOfLargestLoop = 7.28)
mercatorPark.getClass
mercatorPark.hasRollerCoasters
mercatorPark.diameterOfLargestLoop
//dot notation to navigate

//2: default params. Assuming default values are this classes values.
val disneyPark: ThemeParkDefaultParams = new ThemeParkDefaultParams()
disneyPark.hasRollerCoasters
disneyPark.diameterOfLargestLoop

/** Parameters */
//Meaningful name, raw values passed in OR existing vals.

class Hamster (age: Int, val color: String)
val orange: String = "Orange"
//make the object:
val BooTheHamster: Hamster = new Hamster(1, orange)
BooTheHamster.color

/** Objects Without Classes */
//Sometimes we only need one copy of something. If this is the case, we just make an object on its own. If there is a need for reuse, classes must be used.
//Objects have no parameters. Values have to be given within the object.
//Are available globally. No use of keyword 'new'.

object DavidsDogs {
  val Loki: String = "Loki"
  val Rex: String = "Rex"
  val Rover: String = "Rover"
  val Pebbles: String = "Pebbles"
  val Scooby: String = "Scooby"
}
DavidsDogs.Loki
DavidsDogs.Pebbles
DavidsDogs.Rex
//If wanting to assign multiple params, we'd need to make a class and then new instances of dogs to assign various characteristics.

/** Inheritance */
//Use the 'extends' keyword
//Declare the class we want to extend from
//Class we extend from is called the 'parent' or 'superclass'
//Can only extend 1 class. See 'traits' for more than 1 class.

//Method 1:
class Legoland extends ThemeParkEmptyParams (hasRollerCoasters = false, diameterOfLargestLoop = 0) {
  //because no default params assigned, they MUST be assigned in here.
  val oldestThemePark: Boolean = false
}

//Method 2:
class Bakken extends ThemeParkDefaultParams {
  //happy with RollerCoasters param, overriding largestLoop. Anything you're happy with doesn't need to change.
  override val diameterOfLargestLoop: Double = 20.15
  val oldestThemePark: Boolean = true
}


/** Traits */
//Similar to using inheritance classes however we use keyword 'with' instead of 'extends'.
//Cannot create an instance of a trait, must be extended or implemented from something else.
//We can have unimplemented members and keep pulling in. Extend multiple traits.
//Must be used in combination with something else.

trait Mascot {
  val nameOfMainCharacter: String
}

trait OversizedFood {
  val hugeTurkeyLeg: Boolean
}

class DisneyWorld extends ThemeParkDefaultParams with Mascot with OversizedFood {
  override val nameOfMainCharacter: String = "Mickey Mouse"
  //leave defaults or override them here
  override val hasRollerCoasters: Boolean = false
  override val hugeTurkeyLeg: Boolean = true
}

//MUST MAKE SOMETHING FROM A CLASS TO BE ABLE TO USE IT. E.G. AN OBJECT. CANNOT PRINT A CLASS ALONE.