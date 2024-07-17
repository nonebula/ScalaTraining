/** Options */
//Often used to replace exceptions that can be thrown when we have parameters that might be present, might not.
//Stops us having to throw exceptions all the time
//Allows optionality
//Can also pattern match on these too

case class ChocolateBar (chocType: String, filling: Option[String]) //Two options, Some or None. Have to specify.

trait ChocolateBar{
  val chocType: String
  val filling: Option[String]
}

object TwixWhite extends ChocolateBar {
  val chocType: String = "white"
  val filling: Option[String] = Some("caramel")
}

object Snickers extends ChocolateBar {
  val chocType: String = "milk"
  val filling: Option[String] = Some("caramel, nuts")
}

object DairyMilk extends ChocolateBar {
  val chocType: String = "milk"
  val filling: Option[String] = None
}

val chocolateBarOrder: ChocolateBar = new ChocolateBar() {
  val chocType: String = "milk"
  val filling: Option[String] = Some("caramel, nuts")
}

def whatChoc(chocolateBar: ChocolateBar): String = {
  chocolateBar.filling match {
    case Some("caramel") => "caramel"
    case Some("caramel, nuts") => "caramel, nuts"
    case Some("nuts") => "nuts"
    case Some("fudge") => "fudge"
    case Some("cream") => "cream"
    case Some(x) => s"$x is not a valid filling"
    case None => "No filling in this chocolate bar."
  }
}
//NOTE casing issue

whatChoc(chocolateBarOrder)
