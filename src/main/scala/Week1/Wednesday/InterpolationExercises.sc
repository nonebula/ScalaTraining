//1

val nameOne: String = "Bob"
val nameTwo: String = "Sue"

println(s"$nameOne is older than $nameTwo.")

//2
val ageOne: Int = 43
val ageTwo: Int = 36

println(s"$nameOne is ${ageOne-ageTwo} years older than $nameTwo")

//3
val ageOneDbl: Double = 43.32742
val ageTwoDbl: Double = 36.1541949

println(f"$nameOne is ${ageOneDbl-ageTwoDbl}%.0f years older than $nameTwo")

//4
println(raw"\n\n\n\n\n\nsameline\n")



//Different interpolation play
val height: Double = 1.8573

println(f"Can you believe it? $nameOne is $height%12.6fm tall!!")
println(f"Can you believe it? $nameOne is $height%-5.2fm tall!!")
println(f"Can you believe it? $nameOne is $height%.1fm tall!!")