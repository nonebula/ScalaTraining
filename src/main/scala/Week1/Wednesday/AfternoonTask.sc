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




//Research
