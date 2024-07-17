/** Enumeration */
//Representing finite sets of data
//Many ways to write, from enums to sealed objects etc.

/** Native - ENUMS */
//SHORTHAND METHOD
// Declaring what we want.
object Weekday extends Enumeration {
  val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value //each a val, all a value
}

Weekday.Monday.toString //Can call methods on these, dot notation
Weekday.Tuesday


//LONGER WAY - Most often used. Useful for assigning acronyms/long names etc
object BetterWeekday extends Enumeration {
  val Monday = Value("Mon")
  val Tuesday = Value("Tue")
  val Wednesday = Value("Wed")
  val Thursday = Value("Thu")
  val Friday = Value("Fri")
  val Saturday = Value("Sat")
  val Sunday = Value("Sun")
}
BetterWeekday.values
BetterWeekday.Monday.toString
BetterWeekday.Saturday
//Inherently ordered. e.g.:
Weekday.Monday < Weekday.Tuesday //according to place on list. Ordered by index position

object ReOrderWeekday extends Enumeration {
  val Monday = Value(1)
  val Tuesday = Value(5)
  val Wednesday = Value(0)
  val Thursday = Value(2)
  val Friday = Value(6)
  val Saturday = Value(3)
  val Sunday = Value(4)
}
//With index numbers assigned ^^
ReOrderWeekday.values

object ReOrderWeekdayString extends Enumeration {
  val Monday = Value(1, "Mon")
  val Tuesday = Value(5, "Tue")
  val Wednesday = Value(0, "Wed")
  val Thursday = Value(2, "Thu")
  val Friday = Value(6, "Fri")
  val Saturday = Value(3, "Sat")
  val Sunday = Value(4, "Sun")
}
//With index numbers assigned ^^
ReOrderWeekday.values

//Tend to use Enums for EXHAUSTIVE matching

def exhaustiveMatch(weekday: BetterWeekday.Value): Unit = {
  weekday match {
    case BetterWeekday.Monday => "Mon"
    case BetterWeekday.Tuesday => "Tue"
    case BetterWeekday.Wednesday => "Wed"
    case BetterWeekday.Thursday => "Thu"
    case BetterWeekday.Friday => "Fri"
    case BetterWeekday.Saturday => "Sat"
    case BetterWeekday.Sunday => "Sun"
    case _ => "Invalid Weekday"
  }
}

def nonExhaustiveMatch(weekday: BetterWeekday.Value): Unit = {
  weekday match {
    case BetterWeekday.Monday => "Mon"
    case BetterWeekday.Tuesday => "Tue"
    case BetterWeekday.Sunday => "Sun"
  }
} //WILL NOT THROW ANY ERRORS. OFTEN FOR THIS REASON IT IS BETTER TO ENSURE WILDCARD IS INCLUDED



/** Sealed Case Objects */
//Probably seen more often. Built-in methods and boilerplate code, makes sense to use them.
sealed trait Weekday //having a trait so I can link all my case objects together using the trait
case object Monday extends Weekday
case object Tuesday extends Weekday
case object Wednesday extends Weekday
case object Thursday extends Weekday
case object Friday extends Weekday
case object Saturday extends Weekday
case object Sunday extends Weekday
//Difference compared to native enums - Exhaustive match REQUIRED

def caseObjectMatch (weekday1: Weekday): String = {//all above recognised here
  weekday1 match {
    case Monday => "Nooo it's Monday!"
    case Tuesday => "Yay it's Tuesday!"
    case Wednesday => "Splendid it's Wednesday!"
    case Thursday => "OMG it's Thursday!"
    case Friday => "Thankfully it's Friday!"
    case Saturday => "Wow it's Saturday!"
    case Sunday => "Boo it's Sunday!"
    //extra warnings if not exhaustive for next dev etc
  }
}
//Potential drawbacks:
  //No easy way to access all values (no . values etc)
  //Would need to map through to retrieve
  //No default ordering
  //and MORE!

//Also use case objects for custom errors
abstract class Error(name: String, errorCode: Int)
case object WeekdayNotFound extends Error("Weekday Not Found!", 404)
//Coming back to these on Thursday