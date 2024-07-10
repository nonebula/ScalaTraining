/** With Parentheses () */

//With no defined parameters
class Park1
//Make object
new Park1
//Not alot you can do with this but it exists and is happy.

//Construct with defined parameter
//No default values given
//We do not need to put val/var (but is best practice to include)
//This is a BLUEPRINT, cannot add methods or call it etc
class Park2(val rollerCoaster: Boolean, val largestLoop: Double)
//Make an object
//This is for utilising the data. Using the blueprint to call and use methods etc
new Park2(true, 4.5) //params MUST be included
new Park2(rollerCoaster = true, largestLoop = 4.5) //better practice to include like this

object Disney extends Park2(rollerCoaster = true, largestLoop = 4.5)

//Abstract - if we are not giving default values but are giving define parameters
//By making it abstract = safety net. More built in compiler error handling. Forces user to input values sooner.
//Behave similarly to traits
abstract class Park3(val rollerCoaster: Boolean, val largestLoop: Double)
//Make object? NOPE!
new Park3 //CAN'T DO THIS
//Must be extended in order to use them

//Constructing with default parameters
//IF unlikely to change, default parameters work well.
class Park4(val rollerCoaster: Boolean = true, val largestLoop: Double = 4.7)
//Make an object
new Park4 //Would use default values
//This object now happy, no need to add code in as they are predefined in the class; default values used.
new Park4(rollerCoaster = false) //using default params for loop but overriding rollerCoaster.
// Keyword override not needed. Can override none, 1, multiple. Don't include if not overriding.

/** With Curly Braces {} */
//No defined parameters
class Park5{}
//Make object
new Park5

//Constructed with defined parameters (but not default) | No inline with curlies
class Park6 {
  val rollerCoaster: Boolean
  val largestLoop: Double
}
//With curlies, we CANNOT make a class without defined parameters. We CAN make it abstract or give defaults
//If made abstract:
abstract class Park6 {
  val rollerCoaster: Boolean
  val largestLoop: Double
}
//If given defaults:
class Park7 {
  val rollerCoaster: Boolean = true
  val largestLoop: Double = 4.5
}
//Make object
new Park7 //making use of the default parameters defined in class
//Can override if wanted
new Park7{
  override val rollerCoaster: Boolean = false //MUST use override in this situation
}
//Assigned to a val, can access data like so:
val y = new Park7{
  override val rollerCoaster: Boolean = false //MUST use override in this situation
}
y.rollerCoaster
y.largestLoop

//We can extend
object LegoLand extends Park7
LegoLand.largestLoop
//Override
object LegoLand2 extends Park7 {
  override val largestLoop: Double = 5.4
}

/** Abstract Classes */
//Becomes more stringent
//MUST use val / var
abstract class Park8 {
  val rollerCoaster: Boolean
  val largestLoop: Double
}

//make object, wait for popup and click, will auto take to overriding
new Park8 {
  val rollerCoaster: Boolean = true
  val largestLoop: Double = 9.8
}
//When extending - must give a value to every parameter even if it already has a default
object HydePark extends Park8 // doesn't work as MUST give values
object HydePark2 extends Park8 {
  override val rollerCoaster: Boolean = false
  override val largestLoop: Double = 2.2
} //if one new value not given, there will be an error

/** () */
abstract class Park9(val rollerCoaster: Boolean, val largestLoop: Double)
//make object
new Park9(rollerCoaster = false, largestLoop = 3.2) //cannot make an object just using abstract class with round brackets
//Extend the class to make an object
object AnotherNewPark extends Park9(rollerCoaster = true, largestLoop = 5.6) // Don't have to include these params
//Some abstract class may be written a year before it needs to be used. Abstract gives us that safety net
//What is accessible?
AnotherNewPark.largestLoop //if val removed in params of class, access cannot be given and problems can arise
AnotherNewPark.rollerCoaster //will lose access to params if you remove val/var from abstract class with ()

/** () and {} */
class Park10 (val rollerCoaster: Boolean ) { //could give value here. If not, need to give it in new object
  val largestLoop: Double = 7.6
}
//make object
new Park10 (rollerCoaster = true) //or can give value here

//As soon as you make it abstract, you have to write everything out again

//abstract class Park10 (val rollerCoaster: Boolean) {
//  val largestLoop: Double = 7.6
//}
//new Park10 (rollerCoaster = true) {
//  override val largestLoop: Double = 6.7
//}

//Much better off using one or the other rather than a mixture of both

/** Traits */
//Traits are no good on there own, they're used to be implemented elsewhere. To be extended/withed etc.

//without defaults
trait CandyFloss {
  val hasCandyFloss: Boolean
}
//pass to object
object AnotherNewPark2 extends CandyFloss {
  override val hasCandyFloss: Boolean = false
} //need to provide the value as isn't provided in the default

trait CandyFloss2 {
  val hasCandyFloss: Boolean = true
}
//pass to object
object AnotherNewPark3 extends CandyFloss2 //no need to override but can still override if need be

/** Sealed Keyword */
//Scope dramatically reduced, only access in the same file
//e.g. new dog case class, doesn't need to be used outside this file, contain within same file using 'sealed'
sealed abstract class AbstractClassThatIsSealed
sealed trait SealedTrait
//Allows for exhaustive matching (to be continued...)

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

/** Case Object */
//Like an object but far more powerful than typical objects.

case object Hulk
Hulk.getClass
case object Superman
//Could be used for example for PAYE and VAT customers.
//Used when we want to be specific on different routes. Never gonna have a massive list of case objects.
//NOTHING ELSE TO BE DONE ATM. To be continued...