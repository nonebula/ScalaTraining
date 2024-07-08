//Arithmetic
// + (a+b), - (a-b), / (a/b), * (a*b), % (a%b)
// % = modulus. Modulus finds remainder

val a: Int = 10
val b: Int = 5
val c: Int = 3

val add = a+b
val subtract = a-b
val divide = a/b
val multiply = a*b
val modulus = a%b

//Relational (compare 2 values and return a boolean)
// == equality
// != inequality
// < less than
// <= less than or equal to
// > greater than
// >= greater than or equal to

val equality = a == b
val inequality = a != b
val lessThan = a < b
val lessThanOrEqualTo = a <= b
val greaterThan = a > b
val greaterThanOrEqualTo = a >= b

//Logical

// && and
val and = true && true // both need to be true

// ||
val or = true || false // only 1 needs to be true

// !
val not = !true // NOT true == false


//a) 4 plus 3, times 55 is less than 300
val problemA = 4+3*55 < 300

//b) 96 divided by 12 is greater than eight or exactly 8
val problemB = 96/12 >= 8

//c) hamster is less than hippo
val problemC = "hamster" < "hippo"
//comparing a and i (as h are both equal)

//d) 8 is even
val problemD = 8%8 == 0

//e) 156 divided by 8 is less than 20 and 54 is less than 20 and 54 divided by 4 is less than 14
val problemE = 156/8 < 20 && 54 < 20 && 54/4<14