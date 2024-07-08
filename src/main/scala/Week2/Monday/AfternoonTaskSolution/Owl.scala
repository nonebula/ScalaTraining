package Week2.Monday.AfternoonTaskSolution

class Owl(
  val name: String,
  val speciesName: String,
  val age: Float,
  val beakLength: Float,
  val featherColour: String,
  val wingspan: Float
) extends Bird with Species with Flyable {

  val dietType: DietType = Omnivore
  val hootsPerNight: Int = 12
  val conservationStatus: String = "Least Concern"
  val averageLifespanRange: (Double, Double) = (7, 11)
  val numberOfYoungRange: (Int, Int) = (4, 6)
}
