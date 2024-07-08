package Week1.Friday.AfternoonTaskSolution

class Dragonfly(
  val name: String,
  val speciesName: String,
  val age: Float,
  val wingspan: Float,
  val numberOfLimbs: Int,
  val antennaeLength: Float
) extends Insect with Species with Flyable {

  val dietType: DietType = Carnivore
  val conservationStatus: String = "Least Concern"
  val averageLifespanRange: (Double, Double) = (0.125, 0.167)
  val numberOfYoungRange: (Int, Int) = (24, 200)
}
