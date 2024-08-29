package Week9.Thursday

// Variance makes things more type safe
// A concept used to explain inheritance correlation of Types that have parameters or arguments within them
//  Collection types can be constructed more securely when using variance
//  When using this you sometimes see - and + symbols being using in types.
//
//  Three types of varying factors that require two things, change and:
//  Co - together
//Contra - against
//In - unrelated/non

object Variance extends App {

  /** Covariance [+T] */

  abstract class Coffee {
    def name: String
  }

  //Sub classes of Coffee
  case class Standard(name: String) extends Coffee

  case class Fancy(name: String) extends Coffee

  def coffeeMenu(coffees: List[Coffee]): String = { //if cmd + click, will see is covariant by default (+A)
    coffees.foreach {
      coffee => println(coffee.name)
    }.toString //good practice to ensure you are not returning a unit, converting the println to string
  }

  val standardCoffeeMenu: List[Standard] = List(Standard("Latte"), Standard("Americano"), Standard("Cappuccino"))
  val fancyCoffeeMenu: List[Fancy] = List(Fancy("Aeropress"), Fancy("Drip"), Fancy("Artisanal"))

  //compiler knows what we are trying to do, can figure it out for us.

  println("Standard Coffee Menu:") + coffeeMenu(standardCoffeeMenu)
  println("Fancy Coffee Menu:") + coffeeMenu(fancyCoffeeMenu)


  /** Contravariance [-T] */

  //More likely to see here or there, quite faffy

  abstract class SummerActivity[-T] { //must be declared as contravariant
    def printValue(value: T): String //using type T means it will match the other one, e.g. here would be String
  }

  //above = extra step of contravariance
  abstract class Festival {
    def name: String
  }

  //sub-classes of festival
  case class MusicFestival(name: String) extends Festival

  //now make sub-class of SummerActivity
  class Glastonbury extends SummerActivity[Festival] {
    override def printValue(festival: Festival): String = festival.name
  }
  //above given superclass
  //This class can handle any type of festival

  class Reading extends SummerActivity[MusicFestival] {
    override def printValue(musicFestival: MusicFestival): String = musicFestival.name
  }
  //above given subclass
  //contravariance will cause an issue as not as flexible as what we're used to. Far more specific than previous example
  //can only handle MusicFestivals, not other festivals
  //Festival is out of reach for Reading example despite the extension

  val newMusicFestival: MusicFestival = MusicFestival("New Music Festival")

  def printNewMusicFestival(summerActivity: SummerActivity[MusicFestival]): String = {
    summerActivity.printValue(newMusicFestival)
  }

  val festival1: SummerActivity[Festival] = new Glastonbury //Valid. Same type.
  val festival2: SummerActivity[MusicFestival] = new Glastonbury //Valid. Glastonbury has type SummerActivity[Festival] and due to contravariance it's compatible with the sub-type SummerActivity[MusicFestival].

  val festival3: SummerActivity[Festival] = new Reading //Invalid, Reading has type SummerActivity[MusicFestival] and this is a sub-type of SummerActivity[Festival]. I cannot pass a sub-type in where as super-type is expected
  val festival4: SummerActivity[MusicFestival] = new Reading //Valid, is fine because a sub-type is passing into its own sub-type. Type match.

  println(printNewMusicFestival(festival1))
  println(printNewMusicFestival(festival2))
  //  println(printNewMusicFestival(festival3)) // will not run
  println(printNewMusicFestival(festival4))

  /** Invariance */
  class Box[T](var contentOfBox: T) // a generic class that holds a value of type 'T' in its contentOfBox parameter, tells compiler this is invariant

  abstract class Fruit {
    def variety: String
  }

  case class Apple(variety: String) extends Fruit

  case class Orange(variety: String) extends Fruit
  //Apple and Orange are sub-types of Fruit

  val appleBox: Box[Apple] = new Box[Apple](Apple("Gala"))
  //  val fruitBox: Box[Fruit] = new appleBox // will not work because while applebox is a box of fruits, invariance has broken the relation with the type defined on the line above
  //Used when we want to make something REALLY type-specific

}
