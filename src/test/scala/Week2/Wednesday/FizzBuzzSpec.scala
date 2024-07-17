package Week2.Wednesday

import org.scalatest.FlatSpec

class FizzBuzzSpec extends FlatSpec {

  "playGame" should "return FizzBuzz for numbers divisible by both 3 and 5" in {
    val n = new FizzBuzz
    assert(n.playGame(15) == "FizzBuzz")
    assert(n.playGame(30) == "FizzBuzz")
    assert(n.playGame(45) == "FizzBuzz")
  }

  it should "return Fizz for numbers divisible by 3" in {
    val n = new FizzBuzz
    assert(n.playGame(3) == "Fizz")
    assert(n.playGame(6) == "Fizz")
    assert(n.playGame(9) == "Fizz")
  }

  it should "return Buzz for numbers divisible by 5" in {
    val n = new FizzBuzz
    assert(n.playGame(5) == "Buzz")
    assert(n.playGame(10) == "Buzz")
    assert(n.playGame(20) == "Buzz")
  }

  it should "return the number as a string for numbers not divisible by 3 or 5" in {
    val n = new FizzBuzz
    assert(n.playGame(1) == "1")
    assert(n.playGame(2) == "2")
    assert(n.playGame(4) == "4")
  }
}
