package Week2.Wednesday

import org.scalatest.FlatSpec

class TwoNumbersSpec extends FlatSpec {

  "add" should "add numbers" in {
    val nums1 = new TwoNumbers(1,2) //new instance of class created. MUST declare new params everytime within test (better practice), unless vals always staying the same, then can be defined at top of document.
    assert(nums1.add == 3)
  }

  "subtractYFromX" should "subtract numbers" in {
    val nums2 = new TwoNumbers(1,2)
    assert(nums2.subtractYFromX == -1) //must consider edge cases in situations like this
  }

  "subtractXFromY" should "subtract numbers" in {
    val nums3 = new TwoNumbers(1,2)
    assert(nums3.subtractXFromY == 1) //must consider edge cases in situations like this
  }

  "multiply" should "multiply numbers" in {
    val nums4 = new TwoNumbers(3,4)
    assert(nums4.multiply == 12)
  }

  "divide" should "divide numbers" in {
    val nums5 = new TwoNumbers(6,2)
    assert(nums5.divide == 3)
  }

  "isAMultiple" should "return true when x is a multiple of y" in {
    val nums6 = new TwoNumbers(10, 2)
    assert(nums6.isAMultiple())
  }

  "isAMultiple" should "return false when x is not a multiple of y" in {
    val nums7 = new TwoNumbers(10, 3)
    assert(!nums7.isAMultiple())
  }

  "isAMultiple" should "throw IllegalArgumentException when y is 0" in {
    val nums8 = new TwoNumbers(10, 0)
    assertThrows[IllegalArgumentException] {
      nums8.isAMultiple()
    }
  }
}

//sbt test will run all tests