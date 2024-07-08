package Week2.Monday.AfternoonTaskSolution

trait Species {
  val speciesName: String
  val conservationStatus: String
  val averageLifespanRange: (Double, Double)
  val numberOfYoungRange: (Int, Int)
  val dietType: DietType
}
