package Week3

import java.util.concurrent.TimeUnit
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.util.{Failure, Success}
//lazy vals not executed until they are called.

//will only see this sometimes. Not as essential.
//Allow for operations to be performed in parallel meaning that tasks tend to be performed quicker and aynschronously
//Future acts as a placeholder object for a value that does not yet exist
//flatMap, foreach, filter etc can be used in conjunction with futures to allow callbacks to be made
//resolve around Execution Contexts - these are responsible for executing computations
//dependence on .

object Futures extends App {
  //as a placeholder:
  def addition(x: Int, y: Int): Int = {
    Thread.sleep(1000) //long computation - comparable to timeout in JS
    x + y
  }

  def additionInTheFuture: Future[Int] = Future {
    addition(1, 2)
  }

  val waitTime: FiniteDuration = Duration(5, TimeUnit.SECONDS)
  println(Await.result(additionInTheFuture, waitTime))


  /** Team Task */
  class NewError(val errorCode: Int, val errorMessage: String) extends Exception

  case object IsOddError extends NewError(errorCode = 400, errorMessage = "Bad Request in isOdd Method")


  def isOdd(x: Int): Either[NewError, String] = {
    if (x % 2 != 0) Right(s"$x is odd") else Left(IsOddError)
  }


  def fetchIsOddError(x: Int): Future[Either[NewError, String]] = Future {
    isOdd(x)
  }

  val number: Int = 7

  val isOddVal: Future[Either[NewError, String]] = fetchIsOddError(number)

  isOddVal.onComplete {
    case Success(either) =>
      either match {
        case Left(error) =>
          println(s"Error occurred: ${error.errorCode} : ${error.errorMessage}")
        case Right(result) =>
          println(s"Result: $result")
      }
    case Failure(exception) =>
      println(s"Future failed with exception: ${exception.getMessage}")

  }

}
