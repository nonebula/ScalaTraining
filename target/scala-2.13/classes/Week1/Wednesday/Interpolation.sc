// S Interpolation

val name: String = "Randy"
println(s"My name is $name")

println(s"3 x 3 = ${3*3}")
//Used a lot for decoding error messaging etc

val number: Int = 7
println(s"$number x $number = ${number * number}")

//No curly brackets for vals, but can just input straight in using curly brackets.


// F Interpolation
// %f - floating point number
// %d - decimal
// %i - integer

val pi: Double = 3.1415926535897
//Limiting decimal places
println(f"Pi to 2dp is $pi%.2f")
println(f"Pi to 4dp is $pi%.4f")
println(f"Pi to 6dp is $pi%.6f")
println(f"Pi to 8dp is $pi%.8f")
println(f"Pi to 10dp is $pi%.10f")

//Adding space before
println(f"Pi to 2dp but with 16 width is $pi%16.2f")
println(f"Pi to 4dp but with 32 width is $pi%32.4f")
println(f"Pi to 8dp but with 64 width is $pi%64.8f")
//Used for things like tax. Less widely-used but decimal rounding and placing common.

//Bumping down a line
println("hello \nworld")

printf("'%s", "Hello")
printf("'%s'", name)
printf("'%16s'", name)
printf("'%-16s'", name)

// Raw Interpolation
// Very similar to S but has many extra expressions and print them directly. Useful with regex cases.
println("hello \nworld")
// Using raw publishes everything in raw form.
println(raw"hello \nworld")
