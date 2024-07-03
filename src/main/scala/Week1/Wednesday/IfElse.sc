//Conditional if/else
val weather: String = "cold"
val season: String = "winter"

if(weather == "cold" && season == "winter") {
  println(s"It is $weather" + "! Wear a coat.")
} else {
  println("Don't bother with a coat today!")
}

//elseif
if (weather == "cold") {
  println(s"It is $weather" + " weather today! Wear a coat.")
} else if (weather == "rain") {
  println(s"It is $weather" + " weather today! Use an umbrella.")
} else {
  println(s"It is $weather" + " weather today! Enjoy the day!")
}

//Exercises
//Task 1
val grade: Int = 50

if (grade >= 90) {
  println("Your grade is A.")
} else if (grade >= 80) {
  println("Your grade is B.")
} else if (grade >= 70) {
  println("Your grade is C.")
} else if (grade >= 60) {
  println("Your grade is D.")
} else if (grade >= 50) {
  println("Your grade is E.")
} else if (grade <= 49) {
  println("Your grade is F.")
} else {
  println("You must enter a number for the grade, please try again.")
}

//Task 2
val age: Int = 17

if (age >= 18) {
  println("You can watch any movie.")
} else if (age >= 15) {
  println("You can not watch 18 rated movies but can see all other movies.")
} else if (age >= 12) {
  println("You can watch all movies up to grade '12A' but not above.")
} else if (age >= 8) {
  println("You can only watch 'U' and 'PG' rated movies.")
} else {
  println("You can only watch 'U' certified movies.")
}
//Should include error handling and watch for edge cases
//s interpolation for error reporting.