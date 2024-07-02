//MVP
//1a)
val taskA: Boolean = (3+4)*57 < 300
//1b)
val taskB: Boolean = 144 / 12 >= 12
//1c)
val taskC: Boolean = "Cat" < "Dog"
//1d)
val taskD: Boolean = "Rabbit" < "Hamster"
//1e)
val taskE: Boolean = 17 % 2 == 1
//1f)
val taskF: Boolean = 75/9 < 30 && 89 / 6 < 20

//2)
//The difference between a string (e.g. "I love scala already") and a print line (e.g. printin ("I love scala already")) is that the string is either being declared or passed as a value (assigned to val or var) whereas a println is a command that includes a string and prints the line to the program. The latter includes a string, but is more than a string alone.

//3)
println(s"The answer to Task 1a is ${taskA} but the answer to Task B is ${taskB}. Meanwhile, the answers to tasks c, d and e are: ${taskC}, ${taskD} and ${taskE}. Last, but not least, the answer to task F is ${taskF}.")
//I find it quirky that the 's' above in println prints and look forward to learning more about these kinds of nuances of the language. I tripped up earlier when using the boolean declarations because I capitalised the T of true and took a moment to realise.

//Extension
//1 - This is false because the letters are all assigned numerical values. Capitalised letters are assigned different values to lower case letters and therefore the numerical values are totally different.
//2 - If the string was "1", it would be easy to use the toInt method attached to strings to convert it. However, as this isn't the case, it is a more complex route:

//3

//4

//5

//6

//Research
//Some words that I found cannot be used are: case, class, extends, abstract, finally, super, null, object, if, else, val, var, type, true, false.