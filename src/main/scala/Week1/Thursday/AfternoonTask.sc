//MVP
//1.
// a) Make a List of the numbers from 1-5, and a Seq of the primary colours.
val numbers: List[Int] = List(1,2,3,4,5)
val colors: Seq[String] = Seq("red", "yellow", "blue")

//b) Multiply all the values in your List by 3.
val multipliedNumbers: List[Int] = numbers.map {
  number => number * 3
}
println(multipliedNumbers)

//c) Remove "Blue" from your Seq.
val removedColor: Seq[String] = colors.filterNot(_ == "blue")
println(removedColor)

//d) Returns 'true' if your Seq contains "Orange"
val containsColor: Boolean = colors.contains("orange")
println(containsColor)

//2. Go through each value in your List of numbers and return true if they are odd and false if they are even.
def isOdd(number: Int): Boolean = number % 2 !=0
val oddNumbers: List[Boolean] = numbers.map(isOdd)
println(oddNumbers)

//3. David has a lot of pets. Decide what pets he has (must include at least 1 dog) and write these in a Map.
val davidsPets: Map[String, List[String]] = Map(
  "dog" -> List("rex", "buddy", "mike"),
  "cat" -> List("pebbles", "peggie"),
  "frog" -> List ("felix"),
  "tiger" -> List ("lucifer"),
  "goldfish" -> List ("goldie", "silver")
)

//4. Return a List of the names of David's dog(s).
val getDogNames: List[String] = davidsPets.getOrElse("dog", List())
println(getDogNames)



//Extension
//1. Starting with a Seq(1-9), come up with 2 filters that, when used together, will return Sea (1,2,5,7).

//2. The head function returns the first element of a list, and the tail function returns everything except the first element. Use head and tail only to get the 3rd element of a List.


//Research
//1. What makes a Set different from a Seq?

// What should Set(1,2) == Set(2,1,1,1) return?

//2. What do you think List(3,4) == Seq(3,4) will return? Why?

// What about List(5,6) == Set(5,6)?