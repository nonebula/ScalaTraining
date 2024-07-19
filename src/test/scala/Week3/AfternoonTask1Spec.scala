package Week3

import Week3.Thursday.AfternoonTask1._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class AfternoonTask1Spec extends AnyWordSpec with Matchers { //

    "QualifiedNewBuyer" should {
      "return a Right" when {
        val mortgageAmount = 262000
        "the annual earnings * 4 meets or exceeds the mortgage requirement" in {
          validateMortgage(65000, 28000) shouldBe Right(65000)
        }
      }
      "return a Left" when {
        "the annual earnings * 4 fail to meet the mortgage requirement" in {
          val mortgageAmount = 262000
          validateMortgage(30000, 28000) shouldBe Left("Insufficient earnings to qualify for a covering mortgage")
        }
      }
    }
//up to here!
//  "validatePassword" should {
//    "return a Right" when {
//          "the password contains both upper and lower case letters" in {
//          validatePassword("PassWord12345") shouldBe Right("PassWord12345")
//        }
//      }
//      "return a Left" when {
//        "the password is all uppercase" in {
//          validatePassword("PASSWORDLOOP") shouldBe Left("Password must be a mixture of upper and lower case")
//        }
//        "the password is all lowercase" in {
//          validatePassword("passwordloop") shouldBe Left("Password must be a mixture of upper and lower case")
//        }
//      }
//
//    }
//
//    "validateAge" should {
//      "return a Right" when {
//        "the user is 18 years or older" in {
//          validateAge(LocalDate.of(2000, 1, 1)) shouldBe Right(LocalDate.of(2000, 1, 1))
//        }
//      }
//      "return a Left" when {
//        "the user is younger than 18 years old" in {
//          validateAge(LocalDate.now.minusYears(17)) shouldBe Left("User must be 18 or over")
//        }
//      }
//    }
//
//    "validateUser" should {
//      "return a Right" when {
//        "all validations pass" in {
//          val user = User("atLeast12chars", "PassWord12345", LocalDate.of(2000, 1, 1))
//          validateUser(user) shouldBe Right(ValidatedUser("atLeast12chars", "PassWord12345", LocalDate.of(2000, 1, 1)))
//        }
//      }
//      "return a Left" when {
//        "the username is invalid" in {
//          val user = User("shortName", "PassWord12345", LocalDate.of(2000, 1, 1))
//          validateUser(user) shouldBe Left("Username too short. Must be at least 12 characters")
//        }
//        "if the password is invalid" in {
//          val user = User("longerThan12chars", "password", LocalDate.of(2000, 1, 1))
//          validateUser(user) shouldBe Left("Password too short. Must be at least 12 characters")
//        }
//        "if the age is invalid" in {
//          val user = User("longerThan12chars", "PassWord12345", LocalDate.now.minusYears(17))
//          validateUser(user) shouldBe Left("User must be 18 or over")
//        }
//      }
//    }

  }
//
