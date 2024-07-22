package Week4.Monday

import scala.annotation.tailrec

object AfternoonTask extends App {


  //1
  object EurosTeams extends Enumeration {
    type EurosTeams = Value
    val Albania, Croatia, Czechia, Hungary, Poland, Scotland, Serbia, Ukraine, Austria, Belgium, Denmark, Georgia, Italy, Romania, Slovakia, Slovenia, Germany, Portugal, Switzerland, Turkey, France, Netherlands, England, Spain = Value
  }

  def printTeams(teams: List[EurosTeams.Value]): String = {
    @tailrec
    def printHelper(remainingTeams: List[EurosTeams.Value], acc: String): String = {
      remainingTeams match {
        case Nil => acc
        case head :: tail =>
          val updatingAcc = if (acc.isEmpty) "" else ", "
          printHelper(tail, acc + updatingAcc + head.toString)
      }
    }

    printHelper(teams, "")
  }

  println(printTeams(EurosTeams.values.toList))

  //2
  sealed class Team(val name: String)

  object Team {
    case object Albania extends Team("Albania")

    case object Croatia extends Team("Croatia")

    case object Czechia extends Team("Czechia")

    case object Hungary extends Team("Hungary")

    case object Poland extends Team("Poland")

    case object Scotland extends Team("Scotland")

    case object Serbia extends Team("Serbia")

    case object Ukraine extends Team("Ukraine")

    case object Austria extends Team("Austria")

    case object Belgium extends Team("Belgium")

    case object Denmark extends Team("Denmark")

    case object Georgia extends Team("Georgia")

    case object Italy extends Team("Italy")

    case object Romania extends Team("Romania")

    case object Slovakia extends Team("Slovakia")

    case object Slovenia extends Team("Slovenia")

    case object Germany extends Team("Germany")

    case object Portugal extends Team("Portugal")

    case object Switzerland extends Team("Switzerland")

    case object Turkey extends Team("Turkey")

    case object France extends Team("France")

    case object Netherlands extends Team("Netherlands")

    case object England extends Team("England")

    case object Spain extends Team("Spain")

    def printTeamsObj(teams: List[Team]): String = {
      @tailrec
      def printHelper(remainingTeams: List[Team], acc: String): String = {
        remainingTeams match {
          case Nil => acc
          case head :: tail =>
            val updatingAcc = if (acc.isEmpty) "" else ", "
            printHelper(tail, acc + updatingAcc + head.toString)
        }
      }

      printHelper(teams, "")
    }

    val allTeams: List[Team] = List(
      Albania, Croatia, Czechia, Hungary, Poland, Scotland, Serbia, Ukraine, Austria, Belgium, Denmark,
      Georgia, Italy, Romania, Slovakia, Slovenia, Germany, Portugal, Switzerland, Turkey, France,
      Netherlands, England, Spain
    )

    println(printTeamsObj(allTeams))

  }

  //3
  object EvenChecker {
    val numbers: List[Int] = (1 to 20).toList

    def isEven(index: Int): Either[String, Boolean] = {
      @tailrec
      def helper(remainingList: List[Int], currentIndex: Int): Either[String, Boolean] = {
        remainingList match {
          case Nil => Left("Index out of bounds")
          case head :: tail =>
            if (currentIndex == 0) Right(head % 2 == 0)
            else helper(tail, currentIndex - 1)
        }
      }

      if (index < 0 || index >= numbers.length) Left("Index out of bounds")
      else helper(numbers, index)
    }

    println(isEven(4))
    println(isEven(14))
    println(isEven(7))
    println(isEven(19))
    println(isEven(24))
  }

  //4
  object SumCalculator {
    def sumUpTo(n: Int): Int = {
      require(n >= 0, "Input must be a positive number")

      @tailrec
      def helper(current: Int, acc: Int): Int = {
        if (current == 0) acc
        else helper(current - 1, acc + current)
      }

      helper(n, 0)
    }

    println(sumUpTo(9))


  }
}
