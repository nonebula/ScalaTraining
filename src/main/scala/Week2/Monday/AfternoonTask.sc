//MVP - Fibonacci Sequence

val start:Seq[Int] = Seq(3,4)

def pureFibs(n:Int, seq:Seq[Int]): Seq[Int] = {
  val n1:Int = seq.reverse.head
  val n2:Int = seq.reverse.tail.head
  if (n <= 0) seq else pureFibs(n-1, seq:+n1+n2)
}

//3. If using an impure function in this case, it could be effective as it would print the next calculation following on each call. The impure element could be useful in this case.

//4.
pureFibs(4, start)