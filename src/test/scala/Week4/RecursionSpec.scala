package Week4

import Week4.Monday.Recursion
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class RecursionSpec extends AnyWordSpec with Matchers {

  "concatenateWords" should {
    "return the acc if n is negative" in { //write all cases of what should happen before the rest of the test content
      val methodCall = Recursion.concatenateWords("hello ", -1, "")
      val expectedResult = ""
      methodCall shouldEqual expectedResult
    }
    "return the acc is n is 0" in {
      val methodCall = Recursion.concatenateWords("hello ", 0, "")
      val expectedResult = ""
      methodCall shouldEqual expectedResult
      //IF nice and small, do it inline:
      /** Recursion.concatenateWords("hello ", 0, "") shouldBe "" */
    }

    "return a concatenated string of 'hello' 3 times if n is 3 " in {
      val methodCall = Recursion.concatenateWords("hello ", 5, "")
      val expectedResult = "hello hello hello hello hello "
      methodCall shouldEqual expectedResult
      //IF nice and small, do it inline:
      /** Recursion.concatenateWords("hello ", 5, "") shouldBe "hello hello hello hello hello " */
    }

    //Edge case
    "concatenate an empty string" in {
      val methodCall = Recursion.concatenateWords("", 2, "")
      val expectedResult = ""
      methodCall shouldEqual expectedResult
      //IF nice and small, do it inline:
      /** Recursion.concatenateWords("hello ", 2, "") shouldBe "" */
    }

  }

}