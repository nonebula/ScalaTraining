/** Pattern Matching */
//Pattern matching works in a similar way to if/else statements. Cleaner!
//We can pattern match off vals, traits, objects, enums etc
//Certain values you can match on and then depending on the value matched you execute a certain operation.
//Must account for wildcards

//Conditional if/else (From Week1 Weds)
val weather: String = "cold"

//Original If/Else statement
if (weather == "cold") {
  println(s"It is $weather" + " today! Wear a coat.")
} else if (weather == "rainy") {
  println(s"It is $weather" + " today! Use an umbrella.")
} else {
  println(s"It is $weather" + " today! Enjoy the day!")
}

//Converted to pattern matching:
//Matching off a VAL
weather.toLowerCase match {
  //think about all possible cases
  case "cold" => println(s"It is $weather" + " today! Wear a coat.")
  case "rainy" => println(s"It is $weather" + " today! Use an umbrella.")
  case _ => println(s"$weather is not valid")
}

//Converting past task on watermelons (Wk1 Weds)
//if (numOfWatermelons > 5) {
//  println(s"You can't carry this many watermelons, even with a bag! Total watermelons: $numOfWatermelons")
//} else if (numOfWatermelons > 3) {
//  println(s"You need a bag to carry this many watermelons, John! Total watermelons: $numOfWatermelons")
//} else if (numOfWatermelons < 3) {
//  println(s"You can carry these on your own John, no need for a bag! Total watermelons: $numOfWatermelons")
//} else if (numOfWatermelons <= 0) {
//  println("error: not enough watermelons for John.")
//} else {
//  println("Invalid entry. Please enter a number greater than 0.")
//}

//Matching off an INT
val numOfWatermelons: Int = 5
numOfWatermelons match {
  case x if x <=0 => println("Must be more than zero")
  case 1 | 2 | 3 => println("John can carry these without a bag")
  case 4 | 5 => println("John needs a bag to carry these")
  case _ => println(s"$numOfWatermelons is invalid")
}

// if guard
//e.g. case x if x <=0 => println("Must be more than zero")


//Matching off OBJECTS
sealed trait Temperature //Making this sealed, can only be extended within the same file that it's defined in. Compilation error will occur if no exhaustive match
object Cold extends Temperature
object Hot extends Temperature
object Mild extends Temperature //Added later, match below is no longer exhaustive

val weather: Temperature = Cold

//match exhaustive option now available. Will generate.
weather match {
  case Cold => "Take a coat"
  case Hot => "Wear sun cream"
  //Need to then add the added object. Otherwise compilation error
  case Mild => "Maybe take another layer"
  //case _ => "Not valid" - if wildcard included, will prevent any compilation errors
}

//Match using CLASSES
abstract class Notification //made abstract right away. Don't want to be able to make instances, just extending it.
//Abstract class cannot be instantiated, MUST be extended.
case class Email (sender: String, title: String, body: String) extends Notification
//making case classes because we like having the extra boilerplate code. No reason not to make a case class.
case class SMS(caller: String, message: String) extends Notification
case class VoiceRecording(contactName: String, link: String) extends Notification

val notification: Notification = SMS("Mum", "Are you home?")//class hit, case classes too

notification match {
  case Email(sender, title, body) => "Email from: " + sender + "Title: " + title //can reference the other side | don't need to use all, can do if you want to
  //if guard added ABOVE any case. Want to check it first
  case SMS(caller, message) if caller == "Mum" => "SMS from " + caller + ". Don't ignore!"
  case SMS(caller, message) => "SMS from " + caller
  case VoiceRecording(contactName, link) => "Recording from: " + contactName + "With link: " + link
  case _ => "Not valid"
}

