/** Options */
//Often used to replace exceptions that can be thrown when we have parameters that might be present, might not.
//Stops us having to throw exceptions all the time
//Allows optionality
//Can also pattern match on these too

case class Pizza (size: Int, crust: Option[String]) //Two options, Some or None. Have to specify.
//Some = Pizza(14, Some("stuffed"))
//None = Pizza(14, None)

trait Pizza{
  val size: Int
  val crust: Option[String]
}

//Best practice
object Personal extends Pizza {
  val size: Int = 7
  val crust: Option[String] = None //classic could be the default here
}

object smallClassic extends Pizza {
  val size: Int = 9
  val crust: Option[String] = Some("stuffed")
}

//Faster(autocomplete)
object smallItalian extends Pizza {
  override val size: Int = 11
  override val crust: Option[String] = Some("Hot Dog")
}

val pizzaOrder: Pizza = new Pizza {
  val size: Int = 9
  val crust: Option[String] = Some("Italian")
}

def whatCrust(pizza: Pizza): String = {
  //match casing HERE!!
  //when off options we will have more options
  pizza.crust match {
    //be careful here because there are multiple Some options, be careful with making this exhaustive
    case Some("stuffed") => "stuffed crust"
    case Some("hot dog") => "hot dog"
    case Some("italian") => "italian"
    //MUST have wildcard option for the Some BEFORE the None
    case Some(x) => s"$x is not a valid crust type"
    case None => "Default crust - classic"
  }
}
//NOTE casing issue

whatCrust(pizzaOrder)

// .get - doesn't allow for type safety
val getCrust: String = pizzaOrder.crust.get //This is BAD practice because if called on an empty we'll get issues
//If you see this being used, don't trust the developer.

// .getOrElse - allows for a default to be given. Typesafe.
val getOrElseCrust: String = pizzaOrder.crust.getOrElse("classic")