package Week3.Thursday

import java.time.LocalDate

/** Eithers */
//Just like how we used an Option as a type, an either is also a type
//Takes two parameters (a left and right)
//   A[LEFT] usually error case, B[RIGHT] usually success case (can be anything)
//Assume makes an ASS out of U and Me

object Eithers extends App {

  def isEven(x:Int): Either[String, String] = {
    if (x % 2 == 0) Right(s"$x is even") else Left(s"$x is odd")
  }
  println(isEven(4))
  println(isEven(3))

  class NewError(val errorCode: Int, val errorMessage: String) extends Exception
  case object IsOddError extends NewError(400, "Bad request in the 'is odd' method") //Built in methods of exception and newerror

  def isOdd(x:Int): Either[NewError, String] = {
    if (x % 2 != 0) Right(s"$x is odd") else Left(IsOddError) //could return string and add IsOdd.message to return cleaner method
  }
  println(isOdd(4))
  println(isOdd(3))

  /** Different approaches that can be applied. Find one you like better and stick to it */
  /** Try/Catch */
  def plusOne(x:String): Either[String, Int] = {
    try {
      Right(x.toInt)
    } catch {
      case e: Exception => Left(s"Failed due to: $e")  // can add multiple cases here, hence the 'case' use.
    }
  }

  println(plusOne("1"))
  println(plusOne("one"))

  /** Pattern Matching */
  def plusTwo(): Unit = {
    plusOne("1") match {
      case Left(e) => println(s"Failed due to: $e")
      case Right(x) => println(s"Right: $x")
    }
  }

  println(plusTwo())

  /** for Comps with Eithers */
  //if you have multiple conditions depending on each other then this is the way to go
  //BECAUSE: fails fast, as soon as one condition is not met it exits

  case class User (username: String, password: String, dateOfBirth: LocalDate)

  case class ValidatedUser (username: String, password: String, dateOfBirth: LocalDate) //same as above but when they arrive here they've been validated

  //Validate Username
  def validateUsername(username: String): Either[String, String] = {
    if (username.length < 12) Left("Username too short. Must be at least 12 characters")
    else Right(username)
    //could add all custom errors here etc
  }

  //Validate Password
  def validatePassword(password: String): Either[String, String] = {
    if (password.length < 12) Left("Password too short. Must be at least 12 characters")
    else if (password.toUpperCase == password || password.toLowerCase == password) Left("Password must be a mixture of upper and lower case")
    else Right(password)
    //could add all custom errors here etc
  }

  //Validate Age
  def validateAge(dateOfBirth: LocalDate): Either[String, LocalDate] = {
    if (dateOfBirth.plusYears(18).isAfter(LocalDate.now)) Left("User must be 18 or over")
    else Right(dateOfBirth)
  }

  //Combine all 3 above and validate whole user
  //(user: User) passing in case class after a param that is of that type
 def validateUser(user: User): Either[String, ValidatedUser] =
   for {
     username <- validateUsername(user.username) //this method will move through line by line, so if one fails it'll exit out
     password <- validatePassword(user.password)
     dateOfBirth <- validateAge(user.dateOfBirth)
     createValidatedUser = ValidatedUser(username, password, dateOfBirth) //creation of case class
   } yield createValidatedUser //yielding case class, ONLY happens if all methods above hit the Right of the Either

  val usernameBad = User("jon", "OsPdsaiojiaword", LocalDate.of(1992,4,21))
  val passwordBad = User("jonathansifjhf", "passwordsapassyword", LocalDate.of(1992,4,21))
  val dobBad = User("jonathansifjhf", "OsPdsaiojiaword", LocalDate.of(2022,4,21))
  val userGood = User("jonathansifjhf", "OsPdsaiojiaword", LocalDate.of(1992,4,21))

  println(validateUser(usernameBad))
  println(validateUser(passwordBad))
  println(validateUser(dobBad))
  println(validateUser(userGood))

}
