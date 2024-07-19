package Week3

import Week3.Thursday.Eithers._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.time.LocalDate

class EithersSpec extends AnyWordSpec with Matchers { //

  "isOdd" should {
    "return a Right" when {
      "the number is odd" in {
        val result = isOdd(3)
        result shouldBe Right("3 is odd")
      }
      "the number is odd and large" in {
        val result = isOdd(10001)
        result shouldBe Right("10001 is odd")
      }
    }

    "return a Left" when { //keyword 'in' = we know it's a test
      "the number is even" in {
        val result = isOdd(4)
        result shouldBe Left(IsOddError)
        //also fine:
        //isOdd(4) shouldBe Left(IsOddError)
      }
    }
  }
  "validateUser" should {
    "return a Right" when {
      "the username is longer than 12 characters" in {
        validateUsername("atLeast12chars") shouldBe Right("atLeast12chars")
      }
    }
    "return a Left" when {
      "the username is 12 characters or shorter" in {
        validateUsername("shortName") shouldBe Left("Username too short. Must be at least 12 characters")
      }
    }
  }

  "validatePassword" should {
    "return a Right" when {
      "the password contains both upper and lower case letters" in {
        validatePassword("PassWord12345") shouldBe Right("PassWord12345")
      }
    }
    "return a Left" when {
      "the password is all uppercase" in {
        validatePassword("PASSWORDLOOP") shouldBe Left("Password must be a mixture of upper and lower case")
      }
      "the password is all lowercase" in {
        validatePassword("passwordloop") shouldBe Left("Password must be a mixture of upper and lower case")
      }
    }

  }

  "validateAge" should {
    "return a Right" when {
      "the user is 18 years or older" in {
        validateAge(LocalDate.of(2000, 1, 1)) shouldBe Right(LocalDate.of(2000, 1, 1))
      }
    }
    "return a Left" when {
      "the user is younger than 18 years old" in {
        validateAge(LocalDate.now.minusYears(17)) shouldBe Left("User must be 18 or over")
      }
    }
  }

  "validateUser" should {
    "return a Right" when {
      "all validations pass" in {
        val user = User("atLeast12chars", "PassWord12345", LocalDate.of(2000, 1, 1))
        validateUser(user) shouldBe Right(ValidatedUser("atLeast12chars", "PassWord12345", LocalDate.of(2000, 1, 1)))
      }
    }
    "return a Left" when {
      "the username is invalid" in {
        val user = User("shortName", "PassWord12345", LocalDate.of(2000, 1, 1))
        validateUser(user) shouldBe Left("Username too short. Must be at least 12 characters")
      }
      "if the password is invalid" in {
        val user = User("longerThan12chars", "password", LocalDate.of(2000, 1, 1))
        validateUser(user) shouldBe Left("Password too short. Must be at least 12 characters")
      }
      "if the age is invalid" in {
        val user = User("longerThan12chars", "PassWord12345", LocalDate.now.minusYears(17))
        validateUser(user) shouldBe Left("User must be 18 or over")
      }
    }
  }

}