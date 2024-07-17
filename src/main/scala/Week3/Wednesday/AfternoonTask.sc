/** MVP */
//1. Use pattern matching to return the capital city of a country when the country is entered.
  //Consider how to deal with countries not included _? what happens with casing of input .tolowercase? what about whitespace .trim?
val input: String = "     Norway  "
val country: String = input

country.trim.toLowerCase() match {
  case "england" => println(s"The capital city of ${country.trim} is London.")
  case "france" => println(s"The capital city of ${country.trim} is Paris.")
  case "germany" => println(s"The capital city of ${country.trim} is Berlin.")
  case "italy" => println(s"The capital city of ${country.trim} is Rome.")
  case "spain" => println(s"The capital city of ${country.trim} is Madrid.")
  case "portugal" => println(s"The capital city of ${country.trim} is Lisbon.")
  case "netherlands" => println(s"The capital city of ${country.trim} is Amsterdam.")
  case "belgium" => println(s"The capital city of ${country.trim} is Brussels.")
  case "austria" => println(s"The capital city of ${country.trim} is Vienna.")
  case "switzerland" => println(s"The capital city of ${country.trim} is Bern.")
  case "sweden" => println(s"The capital city of ${country.trim} is Stockholm.")
  case "norway" => println(s"The capital city of ${country.trim} is Oslo.")
  case "denmark" => println(s"The capital city of ${country.trim} is Copenhagen.")
  case "finland" => println(s"The capital city of ${country.trim} is Helsinki.")
  case "poland" => println(s"The capital city of ${country.trim} is Warsaw.")
  case "czech republic" => println(s"The capital city of ${country.trim} is Prague.")
  case "hungary" => println(s"The capital city of ${country.trim} is Budapest.")
  case "greece" => println(s"The capital city of ${country.trim} is Athens.")
  case "turkey" => println(s"The capital city of ${country.trim} is Ankara.")
  case "russia" => println(s"The capital city of ${country.trim} is Moscow.")
  case "china" => println(s"The capital city of ${country.trim} is Beijing.")
  case "japan" => println(s"The capital city of ${country.trim} is Tokyo.")
  case "south korea" => println(s"The capital city of ${country.trim} is Seoul.")
  case "india" => println(s"The capital city of ${country.trim} is New Delhi.")
  case "australia" => println(s"The capital city of ${country.trim} is Canberra.")
  case "new zealand" => println(s"The capital city of ${country.trim} is Wellington.")
  case "canada" => println(s"The capital city of ${country.trim} is Ottawa.")
  case "united states" => println(s"The capital city of ${country.trim} is Washington, D.C.")
  case "mexico" => println(s"The capital city of ${country.trim} is Mexico City.")
  case "brazil" => println(s"The capital city of ${country.trim} is Brasília.")
  case "argentina" => println(s"The capital city of ${country.trim} is Buenos Aires.")
  case "chile" => println(s"The capital city of ${country.trim} is Santiago.")
  case "south africa" => println(s"The capital city of ${country.trim} is Pretoria.")
  case "egypt" => println(s"The capital city of ${country.trim} is Cairo.")
  case "nigeria" => println(s"The capital city of ${country.trim} is Abuja.")
  case "kenya" => println(s"The capital city of ${country.trim} is Nairobi.")
  case "saudi arabia" => println(s"The capital city of ${country.trim} is Riyadh.")
  case "united arab emirates" => println(s"The capital city of ${country.trim} is Abu Dhabi.")
  case "iran" => println(s"The capital city of ${country.trim} is Tehran.")
  case "iraq" => println(s"The capital city of ${country.trim} is Baghdad.")
  case "israel" => println(s"The capital city of ${country.trim} is Jerusalem.")
  case "pakistan" => println(s"The capital city of ${country.trim} is Islamabad.")
  case "indonesia" => println(s"The capital city of ${country.trim} is Jakarta.")
  case "thailand" => println(s"The capital city of ${country.trim} is Bangkok.")
  case "malaysia" => println(s"The capital city of ${country.trim} is Kuala Lumpur.")
  case "singapore" => println(s"The capital city of ${country.trim} is Singapore.")
  case "vietnam" => println(s"The capital city of ${country.trim} is Hanoi.")
  case "philippines" => println(s"The capital city of ${country.trim} is Manila.")
  case "bangladesh" => println(s"The capital city of ${country.trim} is Dhaka.")
  case _ => println("404 Invalid country entered.")
}

//2. Given the data, create the method to instantiate the person case class

//Necessary imports to enable interaction with time (libraries)
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

//Person case class definition
case class Person(
                   fullName: String,
                   dateOfBirth: LocalDate,
                   lastCountryOfLiving: String,
                   age: Int,
                   starSign: String,
                   dateOfDeath: Option[LocalDate] = None,
                   ageAtDeath: Option[Int] = None
                 )

//Age calculation (for later age at death)
def calculateAge(dateOfBirth: LocalDate, date: LocalDate = LocalDate.now()): Int = {
  ChronoUnit.YEARS.between(dateOfBirth, date).toInt
}

//enumeration to work out what the star sign would be based on date of birth
def getStarSign(dateOfBirth: LocalDate): String = {
  val month = dateOfBirth.getMonthValue
  val day = dateOfBirth.getDayOfMonth

  //using if guards to ensure that each month catches the correct date ranges for star signs
  month match {
    case 1 if day <= 19 => "Capricorn"
    case 1 => "Aquarius"
    case 2 if day <= 18 => "Aquarius"
    case 2 => "Pisces"
    case 3 if day <= 20 => "Pisces"
    case 3 => "Aries"
    case 4 if day <= 19 => "Aries"
    case 4 => "Taurus"
    case 5 if day <= 20 => "Taurus"
    case 5 => "Gemini"
    case 6 if day <= 20 => "Gemini"
    case 6 => "Cancer"
    case 7 if day <= 22 => "Cancer"
    case 7 => "Leo"
    case 8 if day <= 22 => "Leo"
    case 8 => "Virgo"
    case 9 if day <= 22 => "Virgo"
    case 9 => "Libra"
    case 10 if day <= 22 => "Libra"
    case 10 => "Scorpio"
    case 11 if day <= 21 => "Scorpio"
    case 11 => "Sagittarius"
    case 12 if day <= 21 => "Sagittarius"
    case 12 => "Capricorn"
  }
}

//method that uses the provided data to instantiate the person
def createPerson(
                  fullName: String,
                  dob: String,
                  lastCountryOfLiving: String,
                  dod: Option[String] = None
                ): Person = {
  val dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.ISO_DATE)
  val age = calculateAge(dateOfBirth)
  val starSign = getStarSign(dateOfBirth)

  //pattern matching to identify those who are dead and alive
  dod match {
    case Some(dateOfDeathStr) =>
      val dateOfDeath = LocalDate.parse(dateOfDeathStr, DateTimeFormatter.ISO_DATE)
      val ageAtDeath = calculateAge(dateOfBirth, dateOfDeath)
      Person(fullName, dateOfBirth, lastCountryOfLiving, ageAtDeath, starSign, Some(dateOfDeath), Some(ageAtDeath))
    case None =>
      Person(fullName, dateOfBirth, lastCountryOfLiving, age, starSign)
  }
}

//usage
val person = createPerson(
  fullName = "John Doe",
  dob = "1980-04-15",
  lastCountryOfLiving = "USA",
  dod = Some("2020-06-01")
)

println(person)

//3. Create method called horoscope that accepts a localdate and returns a tuple of their star sign and their horoscope

def getStarSignAndHoroscope(date: LocalDate): (String, String) = {
  val month = date.getMonthValue
  val day = date.getDayOfMonth

  val (starSign, horoscope) = (month, day) match {
    case (1, day) if day <= 19 => ("Capricorn", "You will find stability in your work.")
    case (1, _) => ("Aquarius", "Adventure is on the horizon.")
    case (2, day) if day <= 18 => ("Aquarius", "Adventure is on the horizon.")
    case (2, _) => ("Pisces", "Creativity will flow through you.")
    case (3, day) if day <= 20 => ("Pisces", "Creativity will flow through you.")
    case (3, _) => ("Aries", "Bold moves will pay off.")
    case (4, day) if day <= 19 => ("Aries", "Bold moves will pay off.")
    case (4, _) => ("Taurus", "Steady progress will bring success.")
    case (5, day) if day <= 20 => ("Taurus", "Steady progress will bring success.")
    case (5, _) => ("Gemini", "Communication will be key.")
    case (6, day) if day <= 20 => ("Gemini", "Communication will be key.")
    case (6, _) => ("Cancer", "Nurturing relationships will be rewarding.")
    case (7, day) if day <= 22 => ("Cancer", "Nurturing relationships will be rewarding.")
    case (7, _) => ("Leo", "Your confidence will lead you to new heights.")
    case (8, day) if day <= 22 => ("Leo", "Your confidence will lead you to new heights.")
    case (8, _) => ("Virgo", "Attention to detail will be crucial.")
    case (9, day) if day <= 22 => ("Virgo", "Attention to detail will be crucial.")
    case (9, _) => ("Libra", "Balance will be your strength.")
    case (10, day) if day <= 22 => ("Libra", "Balance will be your strength.")
    case (10, _) => ("Scorpio", "Intense focus will bring transformation.")
    case (11, day) if day <= 21 => ("Scorpio", "Intense focus will bring transformation.")
    case (11, _) => ("Sagittarius", "Your optimism will attract opportunities.")
    case (12, day) if day <= 21 => ("Sagittarius", "Your optimism will attract opportunities.")
    case (12, _) => ("Capricorn", "You will find stability in your work.")
  }

  (starSign, horoscope)
}

// Example usage
val date = LocalDate.of(1990, 5, 15)
val (starSign, horoscope) = getStarSignAndHoroscope(date)
println(s"Star Sign: $starSign, Horoscope: $horoscope")


//4. animal to be extended, different types and pattern matching returning facts
sealed trait Animal
case object Pig extends Animal
case object Dog extends Animal
case object Cat extends Animal
case object Bird extends Animal
case object Wolf extends Animal
case object Human extends Animal
case object Shark extends Animal
case object Fish extends Animal
case object Cockroach extends Animal
case object Wasp extends Animal

def animalObjectMatch(animal: Animal): String = {
  animal match {
    case Pig => "Can fly"
    case Dog => "Man's best friend"
    case Cat => "The true boss of the household"
    case Bird => "Remember faces"
    case Wolf => "Excellent hunters"
    case Human => "Has bipedal thumbs"
    case Shark => "Ancient sea creatures"
    case Fish => "Can swim"
    case Cockroach => "Could survive a nuclear apocalypse"
    case Wasp => "Can sting"
  }
}

val animal = Cat
println(animalObjectMatch(animal))

//Extension

//Research
/**
 def checkListType[T](list: List[T]) = list match {
  case _: List[Double] => "List of Doubles"
  case _: List[String] => "List of Strings"
  case _: List[Int] => "List of Ints"
  case _ => "Unknown"
}

val numList: List[Int] = List(1,2,3)
val doubleList: List[Double] = List(1.0, 2.0, 3.0)
val stringList: List[String] = List("1", "2", "3")

checkListType(numList)
checkListType(doubleList)
checkListType(stringList)
*/

//It doesn't work because it will pick out List[Double] or any other list in addition to List[String].
// There are a variety of ways of fixing the problem, including wrapping any parameterized types in a
// non-parameterized case class:
//case class StringList(value: List[String])
//and then you can just:
//mySequence.collect{ case StringList(xs) => xs }
//to pull out the lists of strings (with the correct type, and type-safely also).