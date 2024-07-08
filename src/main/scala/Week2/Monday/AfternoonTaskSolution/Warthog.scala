package Week2.Monday.AfternoonTaskSolution

class Warthog(
  val name: String,
  val speciesName: String,
  val age: Float,
  val furColour: String,
  val hasTail: Boolean
) extends Mammal with Species {

  val dietType: DietType = Herbivore
  val hasTusks: Boolean = true
  val conservationStatus: String = "Least Concern"
  val averageLifespanRange: (Double, Double) = (7.0, 11.0)
  val numberOfYoungRange: (Int, Int) = (3, 4)
}
