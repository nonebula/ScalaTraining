class Rational(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  //auxiliary constructor
  def this(n: Int) = this(n, 1) //allows future programmers to input only 1 int rather than the two if the denominator is 1.

  def +(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def +(i: Int): Rational =
    new Rational(
      numer + i * denom, denom
    )

  def -(that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def -(i: Int): Rational =
    new Rational(
      numer - i * denom, denom
    )

  def *(that: Rational): Rational =
    new Rational(
      numer * that.numer, denom * that.denom
    )

  def *(i: Int): Rational =
    new Rational(
      numer * i, denom
    )

  def /(that: Rational): Rational =
    new Rational(
      numer * that.denom, denom * that.numer
    )

  def /(i: Int): Rational =
    new Rational(
      numer, denom * i
    )

  override def toString = s"$numer/$denom"

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
    //will find highest common divisor
  }
}

val x = new Rational(1, 3)
val y = new Rational(5, 7)

x + y
x * y

val r = new Rational(1, 2)
r.numer
r.denom

/** def lessThan(that: Rational) =
 * this.numer * that.denom < that.numer * this.denom */
//this.numer would refer to the numerator of the object on which lessThan was invoked.
//same effect would be achieved without 'this'. Equivalent notations.

/** def max(that: Rational) =
 * if (this.lessThan(that)) that else this */
//'this' is essential here, as the second this represents the result of the method in the case where the test returns false. There would be nothing to return if it was omitted.

val y = new Rational(3)

implicit def intToRational(x: Int) = new Rational(x)
var r = new Rational(2, 3)
2 * r