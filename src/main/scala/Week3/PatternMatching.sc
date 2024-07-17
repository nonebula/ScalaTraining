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
trait Temperature
object Cold extends Temperature
object Hot extends Temperature

val weather: Temperature = Cold

//match exhaustive option now available. Will generate.
weather match {
  case Cold => "Take a coat"
  case Hot => "Wear sun cream"
  case _ => "Not valid"
}