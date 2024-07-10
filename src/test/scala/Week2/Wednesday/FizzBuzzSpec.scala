package Week2.Wednesday

import org.scalatest.FlatSpec


//Create a function called fizzBuzz that takes an Int and returns the same value as a String.
//
//• If the input is divisible by 3 (with no remainder) return the word "Fizz"
//
//• If the input is divisible by 5 (with no remainder) return the *
//  word "Buzz".
//
//• If the input is divisible by 3 and 5 (with no remainder) return the word "FizzBuzz"

class FizzBuzzSpec extends FlatSpec {

  "fizzBuzz" should "return Fizz for numbers divisible by 3" in {
    assert(FizzBuzz.fizzBuzz(3) == "Fizz")
  }

  it should "return Buzz for numbers divisible by 5" in {
    assert(FizzBuzz.fizzBuzz(5) == "Buzz")
  }

  it should "return FizzBuzz for numbers divisible by both 3 and 5" {
    assert(FizzBuzz.fizzBuzz(15) == "FizzBuzz")
  }

  it should "return the number as a string for numbers not divisible" {
    assert(FizzBuzz.fizzBuzz(1) == "1")
  }

}
