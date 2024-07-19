package Week3.Thursday

object AfternoonTask1 extends App {

  //insert a method to consider property price on input
  //insert to consider the deposit on input too

  val propertyPrice: Int = 280000

  case class NewBuyer(annualEarnings: Int, deposit: Int, creditScore: Int)

  case class QualifiedNewBuyer(annualEarnings: Int, deposit: Int, creditScore: Int)

  def validateMortgage(annualEarnings: Int, deposit: Int): Either[String, Int] = {
    val mortgageAmount = propertyPrice - deposit
    if (mortgageAmount > annualEarnings * 4) Left("Insufficient earnings to qualify for a covering mortgage")
    else Right(annualEarnings)
  }

  def validateDeposit(deposit: Int): Either[String, Int] = {
    if (deposit < propertyPrice / 10) Left("Insufficient deposit to meet 10% requirement")
    else Right(deposit)
  }

  def validateCreditScore(creditScore: Int): Either[String, Int] = {
    if (creditScore < 550) Left("Credit score too low to qualify")
    else Right(creditScore)
  }

  def qualifyNewBuyer(newBuyer: NewBuyer): Either[String, QualifiedNewBuyer] =
    for {
      annualEarnings <- validateMortgage(newBuyer.annualEarnings, newBuyer.deposit)
      deposit <- validateDeposit(newBuyer.deposit)
      creditScore <- validateCreditScore(newBuyer.creditScore)
      createQualifiedNewBuyer = QualifiedNewBuyer(annualEarnings, deposit, creditScore)
    } yield createQualifiedNewBuyer

  val annualEarningsBad = NewBuyer(4500, 28000, 600)
  val depositBad = NewBuyer(80000, 2000, 600)
  val creditScoreBad = NewBuyer(80000, 30000, 200)
  val buyerGood = NewBuyer(85000, 30000, 600)

  val samantha = NewBuyer(45000, 20000, 577)

  println(qualifyNewBuyer(annualEarningsBad))
  println(qualifyNewBuyer(depositBad))
  println(qualifyNewBuyer(creditScoreBad))
  println(qualifyNewBuyer(buyerGood))

  println(qualifyNewBuyer(samantha))

}
