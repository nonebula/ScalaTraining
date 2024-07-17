val pizza: String = "Spicy"

pizza match {
  case "Spicy" => "American Hot"
  case "Veggie" => "Vegetable Extravaganza"
  case "Fishy" => "Sardine Splendor"
  case "Meaty" => "Meaty Madness"
  case _ => "Invalid selection"
}

val pizzaSize: Int = 7

pizzaSize match {
  case 7 => "Personal"
  case 9 => "Small"
  case 11 => "Medium"
  case 14 => "Large"
  case _ => "Invalid size selection"
}

case class PizzaOrder(price: Double, crust: Int)

object Personal extends PizzaOrder(5.99, 7)
object Small extends PizzaOrder(7.99, 9)
object Medium extends PizzaOrder(10.99, 11)
object Large extends PizzaOrder(14.99, 14)

PizzaOrder match {
  case Personal(price, crust) => pizzaSize + price + crust
  case Small => "Small, £10.99: Classic"
  case Medium => "Medium, £12.99: Classic"
  case Large => "Large, £14.99: Classic"

  //Return to this at a later point
