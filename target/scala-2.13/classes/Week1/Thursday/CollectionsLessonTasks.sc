//Task One
//1
val academyTeamMembers: Seq[String] = Seq("Tom", "Tayamul", "Spencer", "Arei", "Joe", "Antony", "April", "Bilal", "Jamie", "Roshan", "Muhammad")

//2
val colorMap: Map[Int, String] = Map(
  1 -> "red",
  2 -> "yellow",
  3 -> "blue",
  4 -> "green"
)

//Come back to the above and have a play with it, show this below.

colorMap(4)



//3
val addedColorMap: Map [Int, String] = colorMap.map {
  case (key, value) => (key + 1, value)
}

//4 - remove all even numbers from a collection
val filteredColorMap: Map[Int, String] = colorMap.filter { case (key, _) => key % 2 != 0 }

//5 - return true if a seq has a string that contains the letter "r"
val containsR: Boolean = academyTeamMembers.contains("r")

//Task Two
//1
//Sets are an unordered collection of unique (no duplicate) elements, whereas Sequences are a sequential collection of elements and may be indexed (like an array) or linear (like a linked list) and Maps contain a collection of key/value pairs, like a Java Map, Python dictionary, or Ruby Hash.

//2
//In Scala, flatMap() method is identical to the map() method, but the only difference is that in flatMap the inner grouping of an item is removed and a sequence is generated. It can be defined as a blend of map method and flatten method. The output obtained by running the map method followed by the flatten method is same as obtained by the flatMap(). So, we can say that flatMap first runs the map method and then the flatten method to generate the desired result.

val name = Seq("mercator", "group")
name.flatMap(_.toUpperCase)

// Output
//val res1: Seq[Char] = List(m, e, r, c, a, t, o, r, g, r, o, u, p)

//Flatmap very handy for maps within maps, flattens elements within nested data very well.
val findScalaGod: Seq[String] = academyTeamMembers.flatMap( s =>
  if(s.toLowerCase() == "april") Seq(s.toUpperCase() + " The Scala God")
  else Seq(s)
)

//.toSet to convert to a set, far more efficient that checking for containing and removing that way.