package Week3

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import Week3.Thursday.ForComp._
//cmd click on test words and full docs & keywords available
class ForCompSpec extends AnyWordSpec with Matchers { //
  //because object, have to import it. If class not necessary

  "retrieveNumbers" should {

    val expected = Seq(1,2,3,4,5,6,7,8,9,10)

    "generate a seq of numbers from 1 to 10" in { //keyword 'in' = we know it's a test
      retrieveNumbers shouldBe expected
    }

    "contain 10 elements" in {
      retrieveNumbers should have length 10
    }

    "start with 1 and end with 10" in {
      retrieveNumbers.head shouldBe 1
      retrieveNumbers.last shouldBe 10
    }
  }
}
//doing this way allows you to collapse everything and tidy things up for readability