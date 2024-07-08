package Week2.Monday.AfternoonTaskSolution

object Sanctuary extends App {

  def feedAnimal(animal: Animal) = println(s"You fed ${animal.name} some ${animal.dietType.eats}!")

  val hedwigTheSnowyOwl = new Owl("Hedwig", "Snowy Owl", 8, 2, "White", 150)
  val pumbaTheWarthog  = new Warthog("Pumbaa", "Common Warthog", 4, "Brown", true)
  val jeffTheDragonfly  = new Dragonfly("Jeff", "Blue Eyed Darner", 1, 12, 10, 1)

  feedAnimal(hedwigTheSnowyOwl)

}

