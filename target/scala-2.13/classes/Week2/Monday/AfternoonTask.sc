//MVP - Fibonacci Sequence

val start:Seq[Int] = Seq(3,4)

def pureFibs(n:Int, seq:Seq[Int]): Seq[Int] = {
  val n1:Int = seq.reverse.head
  val n2:Int = seq.reverse.tail.head
  if (n <= 0) seq else pureFibs(n-1, seq:+n1+n2)
}

//3. If using an impure function in this case, it could be effective as it would print the next calculation following on each call. The impure element could be useful in this case.
// Impure fibonacci function
var sequence:Seq[Int] = Seq(3,4)
def impureFibs(n:Int):Seq[Int] = {
  val n1:Int = sequence.reverse.head
  val n2:Int = sequence.reverse.tail.head
  if (n <= 0) sequence else{
    sequence = sequence:+n1+n2
    impureFibs(n-1)
  }
}

//4.
pureFibs(4, start)
impureFibs(5)

//Extension
//1. infix notation is a way of calling methods using an operator-like syntax. Often used for methods that take a single argument.
val seq = Seq(1, 2, 3, 4)
val str = seq mkString ","
println(str)

//2. have to use Scala's 'readLine' operation

//import scala.io.StdIn.readLine
//
//object HelloInteractive extends App {
//  print("Enter a greeting:")
//  val input = readLine()
//  if (input == "Hello") {
//    println(s"Hello $name")
//  } else {
//    println("Unrecognised Greeting")
//  }
//}



//3. Chessboard positions

//def printChessboardCombinations(): Unit = {
//  val files = 'a' to 'h'
//  val ranks = 1to 8
//
//  for {
//    file <- files
//    rank <- ranks
//  } {
//    println(s"$file$rank")
//  }
//}
//
//printChessboardCombinations()


//Research - Computational Efficiency of Methods, Functions, and Vals
//  In Scala, the efficiency of methods, functions, and vals can vary based on their usage and context:
  //  Methods:
    //Evaluated every time they are called.
    //Can have side effects.
    //Computational efficiency depends on the operations performed within the method.
    //Repeated calls can be less efficient if the method is complex.

//Functions:
    //They can be passed around as values.
    //Efficient for higher-order programming and functional constructs.

//  Vals:
    //Evaluated once when defined and then considered immutable.
    //More efficient for storing results that do not change, as they avoid recomputation.
    //Useful for constants and results of expensive operations.

//Efficiency notes:
    //Lazy Vals: These are evaluated only once, on the first access, making them efficient for expensive computations that might not always be needed. They combine the benefits of val (immutability) and deferred computation.
    //Infix Notation: Infix notation does not inherently change computational efficiency but can make code more readable.
    //For immutable, repeatedly accessed data, vals are the most efficient.
    //For computations that need to be deferred and possibly skipped, lazy vals are a good choice.
    //For reusable blocks of logic, methods and functions are appropriate, but consider caching results if the method or function is expensive and called often.