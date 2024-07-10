package Week2.Wednesday

import org.scalatest.FlatSpec

class TwoNumbersSpec extends FlatSpec {

  "add" should "add numbers" in {
    val nums = new TwoNumbers(1,2) //new instance of class created. MUST declare new params everytime within test (better practice), unless vals always staying the same, then can be defined at top of document.
    assert(nums.add == 3)
  }

  "subtract" should "subtract numbers" in {
    val nums = new TwoNumbers(3,2)
    assert(nums.subtract == 1)
  }
}

//sbt test will run all tests