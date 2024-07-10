package Week2.Wednesday

class TwoNumbers (x: Int, y: Int) {

  def add(): Int = {
    x + y
  } //no params as class gives the numbers

  def subtractYFromX(): Int = {
    x - y
  } //before going to test, navigate to build file and add dependencies

  def subtractXFromY(): Int = {
    y - x
  }

  def multiply(): Int = {
    x * y
  }

  def divide(): Int = {
    x / y
  }

  def isAMultiple(): Boolean = {
    if (y == 0) throw new IllegalArgumentException
    x % y == 0
  }
}

//AVOID DEPENDENCY TICKETS AT ALL COSTS