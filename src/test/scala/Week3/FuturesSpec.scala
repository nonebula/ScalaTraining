package Week3

import Week3.Futures.{addition, additionInTheFuture, fetchIsOddError}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Seconds, Span}
import org.scalatest.wordspec.AnyWordSpec

class FuturesSpec extends AnyWordSpec with Matchers with ScalaFutures {
  //as a placeholder:

  implicit val defaultWaitTime: PatienceConfig = PatienceConfig(timeout = Span(3, Seconds), interval = Span(500, Millis))

  "addition method" should {
    "add two ints" in {
      addition(1, 2) shouldEqual 3
    }
  }

  "addition in the future" should {
    "eventually return the correct sum" in {
      whenReady(additionInTheFuture) { //When testing futures MUST use whenReady (kinda like await, uses patienceConfig)
        result => result shouldEqual 3
      }
    }
  }

  //  "def isOddError" should {
  //    "Succeed and return a Left" in {
  //      val x: Int = 6
  //      whenReady(fetchIsOddError(x)) {
  //        result => Right(s"$x is even")
  //      }
  //    }
  //    "Succeed and return a Right" in {
  //      val x: Int = 5
  //      whenReady(fetchIsOddError(x)) {
  //        result => Right(s"$x is odd")
  //      }
  //    }
  //    "Fail and throw error" in {
  //      val x: String = "ERRORITIS"
  //      whenReady(fetchIsOddError(x)) {
  //        result => (s"$x is odd")
  //      }
  //    }
  //  }


}
