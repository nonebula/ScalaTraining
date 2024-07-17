//Two different ways to write. Easier to access values in enums, slightly more difficult in case objects.

object Household extends Enumeration {
  val Mum = Value("Trish")
  val Dad = Value ("Jim")
  val Sister = Value ("Mel")
  val Brother = Value ("Liam")
  val Me = Value ("Tom")
  val Dog = Value ("Rex")
  val Cat = Value ("Peggie")
}

Household.values
Household.values.toString()

sealed trait Household
case object Mum extends Household
case object Dad extends Household
case object Sister extends Household
case object Brother extends Household
case object Me extends Household
case object Dog extends Household
case object Cat extends Household

def caseObjectMatch (household: Household): String = {
  household match {
    case Mum => "Trish"
    case Dad => "Jim"
    case Sister => "Mel"
    case Brother => "Liam"
    case Me => "Tom"
    case Dog => "Rex"
    case Cat => "Peggie"
  }
}

//Just a fancy way to represent a set of data