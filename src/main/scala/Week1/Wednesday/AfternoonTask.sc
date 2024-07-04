//MVP

//1
val watermelons: Int = 2

//2 && 3
if (watermelons > 5) {
  println(s"You can't carry this many watermelons, even with a bag! Total watermelons: $watermelons")
} else if (watermelons > 3) {
  println(s"You need a bag to carry this many watermelons, John! Total watermelons: $watermelons")
} else if (watermelons < 3) {
  println(s"You can carry these on your own John, no need for a bag! Total watermelons: $watermelons")
} else if (watermelons <= 0) {
  println("error: not enough watermelons for John.")
} else {
  println("Invalid entry. Please enter a number greater than 0.")
}

//4
val hasBag: Boolean = true

//5
if (watermelons > 3 && watermelons <5 && hasBag) {
  println(s"You can't carry this many watermelons, even with a bag! Total watermelons: $watermelons")
} else {
  println("John either doesn't have a bag or the number entered is invalid.")
}

//6
val storePrice: Double = 1.397

println(f"John's purchase of watermelons has cost him £$storePrice%.2f!")

//The 'Double' type is most appropriate here as you're dealing with decimals.

//Extension
//1
//The order of logical operators in IF statements in descending order is: NOT (!), AND (&&), OR(||).

//2
//(true || false && false) would result in false && false being evaluated first, because the order of precedence demands it. This would resolve to simplify the expression to true || false.

//3
//((true || false) && false) would result in the true || false part being evaluated first. This would evaluate to true because at least one of these would be true.

//4
// (1 < 4 && 7!= 10*| 9 + 10 == 21) would result in true.


//Research
val valueOne: Int = 3
val valueTwo: Int = 8
var stringStore: String = ""

if (valueOne > valueTwo) {
  stringStore = ("yes")
  println(stringStore)
} else if (valueTwo > valueOne) {
  stringStore = ("no")
  println(stringStore)
}