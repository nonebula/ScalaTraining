package Week4.Monday

object AfternoonExt extends App {
  val start: Seq[Int] = Seq(3, 4)

  def fibsCalc(n: Int, acc: Seq[Int] = Seq(1, 1)): Either[String, Seq[Int]] = {
    n match {
      case x if x < 0 => Left(s"Error: input must be positive, $x < 0")
      case x if x == 0 => Right(Seq())
      case x if x == 1 => Right(Seq(1))
      case x if x == 2 => Right(acc)
      case x if x > 2 =>
        val lastX = acc.last
        val secondLastX = acc(acc.length - 2)
        fibsCalc(x - 1, acc ++ Seq(lastX + secondLastX))
      case _ => Left(s"Something went wrong")
    }
  }


}