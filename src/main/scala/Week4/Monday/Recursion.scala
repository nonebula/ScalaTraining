package Week4.Monday

import scala.annotation.tailrec

//Used instead of any 'while' loops in scala
//While loops are risky and do not give you the same control
//Used to break a problem into smaller chunks
//Within the method, it calls itself to repeat the process
//Recursion runs on a call stack. Memory is limited and so can result in a stack overflow within classic recursion.

object Recursion extends App {

  //Standard recursion - final call needs to be method itself so it loops back round
  def factorial(n: Int): Int = { //loop at side tells us this is now recursive
    if (n <= 1) {
      1
    } else {
      n * factorial(n - 1) //this is the recursive call, each time you go round it adds to the call stack, remembering all previous results.
      //In production code DO NOT assign method to val and call. Only done here for demo.
    }
  }

  println("\nFactorial method (4) - standard recursion:")
  println(factorial(4))


  //Tail recursion
  //The last action in the method is the call on itself
  //Prevents stack overflow error
  //Call stack is reused, rather than having to store all the data that has previously been executed, rather than taking up all that memory again and again
  //@tailrec can be used to check if something is tail recursive. If we do this and haven't written tail recursion, it'll return an error to tell us this.
  //call the method INSIDE the helper method

  def smartFactorial(n: Int): Int = {
    @tailrec //this is a helper annotation
    def factorialHelper(x: Int, acc: Int): Int = { //everytime we write a helper method we are giving it everything it needs to make the call inside
      //accumulator above star of show, gives us the tail recursion + any additional parameters that may be needed during the recursion but not in the original method
      if (x <= 1) acc
      //the return of the accumulator is the 'get out' instead of returning (e.g.) 1 as above
      else {
        factorialHelper(x - 1, x * acc) //acc - holds the running total - storing that intermediate
      } //all method goes in second curly braces apart from the call
    }

    factorialHelper(n, 1)
  }

  println("\nFactorial tail (4) - tail recursion:")
  println(smartFactorial(4))
  //println(smartFactorial(4000)) Won't work, will return 0. This is because it is a LONG not an INT. Would need to give type LONG.

  //1st call: factorialHelper(4 - 1, 4 * 1) = (3, 4)
  //2nd call: factorialHelper(3 - 1, 3 * 4) = (2, 12)
  //3rd call: factorialHelper(2 - 1, 2 * 12) = (1, 24)
  //4th call: factorialHelper(1 - 1, 1 * 24) = (1, 24) // x == 1 => hitting the 'if' returning the accumulator(acc) which is currently stored as 24


  // Tail rec -> concatenate a string n times
  // Without helper method - to see difference
  @tailrec
  def concatenateWords(word: String, n: Int, acc: String): String = {
    if (n <= 0) acc
    else {
      concatenateWords(word, n - 1, word + acc)
    }
  }

  println("\n tail rec concatenate words: ")
  println(concatenateWords("hello ", 3, "")) //need to put three params as no helper method. Empty string at start for accumulator


  //Write a method that will find out how many elements are in a list of strings. Use both methods

  //standard recursive
  def countStrings(list: List[String]): Int = {
    if (list.isEmpty) 0
    else 1 + countStrings(list.tail)
  }

  println(countStrings(List("apple", "banana", "cherry")))

  //tail recursive
  def countTailStrings(list: List[String]): Int = {
    @tailrec
    def countTailStringsHelper(remainingList: List[String], acc: Int): Int = {
      if (remainingList.isEmpty) acc
      else {
        countTailStringsHelper(remainingList.tail, acc + 1)
      }
    }

    countTailStringsHelper(list, 0)
  }

  println(countTailStrings(List("apple", "banana", "cherry")))

  //With cases
  def countCaseTailStrings(list: List[String]): Int = {
    @annotation.tailrec
    def countCaseTailStringsHelper(remainingList: List[String], accumulator: Int): Int = {
      remainingList match {
        case Nil => 0
        case _ :: tail => countCaseTailStringsHelper(tail, accumulator + 1) // :: = concatenate
      }
    }

    countCaseTailStringsHelper(list, 0)
  }

  println(countCaseTailStrings(List("apple", "banana", "cherry")))


}
