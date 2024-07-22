package Week4.Monday

import org.w3c.dom.html.HTMLAppletElement

object EnumerationAndCaseObjects extends App {

  /** Enumeration & Case Objects */
  //Both are very handy when using recursion to work our way through a list, especially if that list contains a finite number of values.
  //Use enums when:
  //Simple cases
  //Easier to iterate over
  //Built in structure

  //Use case objects when
  //More complex cases
  //More built-in boilerplate code
  //Each object is a singleton instance of the associated class

  //Unless you use the keyword 'sealed' your pattern matches within your recursive methods might not be exhaustive. You may see a warning for this

  /** Using Enumeration */
  object DayOfWeek extends Enumeration {
    type DayOfWeek = Value //allows DayOfWeek to be used as a type. Similar to using case objects to extend the same trait
    val Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday = Value
  }

  //Using tailrec WITH helper method
  //converting an enum list to a string

  def enumListToString(dayOfWeekEnums: List[DayOfWeek.Value]): String = {
    def enumListHelper(dayEnums: List[DayOfWeek.Value], acc: String): String = { //acc always same return type and return from main method
      dayEnums match {
        case Nil => acc
        case ::(head, tail) =>
          val makeNiceToRead = if (acc.isEmpty) "" else ", "
          enumListHelper(tail, acc + makeNiceToRead + head.toString)
      }
    }

    enumListHelper(dayOfWeekEnums, "")
  }

  println(enumListToString(List(DayOfWeek.Monday, DayOfWeek.Tuesday, DayOfWeek.Wednesday, DayOfWeek.Thursday, DayOfWeek.Friday, DayOfWeek.Saturday, DayOfWeek.Sunday)))
  println(enumListToString(DayOfWeek.values.toList))

  /** Using Case Objects */
  sealed trait DayOfWeek

  case object Monday extends DayOfWeek

  case object Tuesday extends DayOfWeek

  case object Wednesday extends DayOfWeek

  case object Thursday extends DayOfWeek

  case object Friday extends DayOfWeek

  case object Saturday extends DayOfWeek

  case object Sunday extends DayOfWeek

  def objectsToString(listDays: List[DayOfWeek]): String = {
    def helperMethod(remainingListDays: List[DayOfWeek], acc: String): String = {
      remainingListDays match {
        case Nil => acc
        case ::(head, tail) =>
          val makeNiceToRead = if (acc.isEmpty) "" else ", "
          helperMethod(tail, acc + makeNiceToRead + head.toString)
      }
    }

    helperMethod(listDays, "")
  }

  println(objectsToString(List(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)))



  //Independent Practice

  object FruitEnumeration extends App {
    object fruit extends Enumeration {
      type Fruit = Value
      val apple, orange, banana, mango, grape = Value

      def countFruit(fruits: List[Fruit], targetFruit: Fruit): Int = {
        def helperFruit(remainingFruitList: List[Fruit], acc: Int): Int = {
          remainingFruitList match {
            case Nil => acc
            case head :: tail =>
              val updatingAcc = if (head == targetFruit) acc + 1 else acc // add to count only if present
              helperFruit(tail, updatingAcc)
          }
        }

        helperFruit(fruits, 0)
      }

      val fruitList = List(apple, orange, banana, apple, mango, apple, grape, banana)
      val targetFruit = apple
      println(countFruit(fruitList, targetFruit))
    }
  }


}
