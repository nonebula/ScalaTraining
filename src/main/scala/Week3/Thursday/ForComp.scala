package Week3.Thursday

/** for Comprehensions */
//Lightweight notation for expression of sequence comprehensions
//They fail fast, as soon as one error case is hit, the for comprehension exits out.
//Nice and easy to read
//Simplified way of writing a function and are supported by many data types

//extending app enables running of object (green play button) and unit testing
object ForComp extends App {
  // <- : calls the function

  /** Classic */ //We've been overusing vals. We can just call and do not need to make vals all the time
  //one line / inline method
  def retrieveNumbers: Seq[Int] = for (numbers <- 1 to 10) yield numbers
  retrieveNumbers //calls the method (without val)
  //curly method (same function)
  def retrieveNumbers1: Seq[Int] = {
    for (numbers <- 1 to 10) yield numbers
  }
  retrieveNumbers1
  //Can use println to print this in terminal but SHOULDN'T be doing this. Unit tests work better for this.

  def squareNumbers: Seq[Int] = for (numbers <- 1 to 10) yield numbers * numbers
  println(squareNumbers) //print lining for ease but should usually TEST!

  def ifGuardNumbers: Seq[Int] = for (numbers <- 1 to 10 if numbers % 2 == 0) yield numbers //all in same brackets for if guards
  println(ifGuardNumbers) //will NOT see print lining in production code.

  /** use with case classes */
  sealed trait Color //not able to be used outside of this file
  case object Blue extends Color
  case object Red extends Color
  case object Green extends Color
  case object Yellow extends Color
  case object Purple extends Color
  case object Orange extends Color

  //unlikely to see this use case in action
  case class Pencil(color: Color, sharpened: Boolean)
  def getPencils: List[Pencil] = for {
    color <- List(Blue, Green, Yellow, Red, Purple, Orange)
    sharpened <- List(true, false)
  } yield Pencil(color, sharpened)
  println(getPencils)

  //can eliminate. Doesn't need to be exhaustive
  def getTruePencils: List[Pencil] = for {
    color <- List(Blue, Green, Yellow, Red, Purple, Orange)
    sharpened <- List(true)
  } yield Pencil(color, sharpened)
  println(getTruePencils)

  //Exercise - write a simple for comprehension method
  def capitalizeNames(names: List[String]): List[String] = for (name <- names) yield name.toUpperCase
//OR
  //for {
  //   name <- nameInput.map(x => x.toUpperCase)
  // } yield name

//  capitalizeNames(List("alice", "bob", "clive", "dave", "ed", "frank")) PROPER CASE
  println(capitalizeNames(List("alice", "bob", "clive", "dave", "ed", "frank")))

  def capitalizeFirstLetter(names: List[String]): List[String] = for (name <- names) yield name.capitalize
  //  capitalizeFirstLetter(List("alice", "bob", "clive", "dave", "ed", "frank")) PROPER CASE
  println(capitalizeFirstLetter(List("alice", "bob", "clive", "dave", "ed", "frank")))

}
