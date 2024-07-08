// Suzie wants 5 melons. Melons cost 50p
// She wants 2 apples. Apples cost 10p
// She wants 6 drinks. Drinks cost £1.20

val priceOfMelon = 0.50
val numberOfMelon = 5
val totalMelonPrice = priceOfMelon * numberOfMelon

val melons = 5 * 50
val apples = 2 * 10
val drinks = 6 * (1.2*100)
val total = melons + apples + drinks

//Store a val
val dog = "Rex"
//Re-assign a val
//Commented out due to error
//dog = "Sam"

//Store a var
var dog = "Rex"
println(dog)
//Re-assign a var
dog = "Sam"
println(dog)

//John at the shop buys 5 lemons @ 30p
//2 bags of flour @ 90p
//6 ciders @ £2.50

val lemons = 5 * 30
val bagsOfFlour = 2 * 90
val ciders = (2.50*100)*6
val total = lemons + bagsOfFlour + ciders
println(s"John bought ${total}p worth of goods")