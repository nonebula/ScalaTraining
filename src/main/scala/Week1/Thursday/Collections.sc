//Maps and Sequences are the most common two types used.

//Sequences
val seq1: Seq[Int] = Seq(1, 2, 3)
//Very basic sequence in Scala. Define [what to expect] = (what is actual).

val list1: List[Int] = List(1, 2, 3)
// Very basic list in Scala. List is a linear sequence. Define [what to expect] = (what is actual).


//Maps
//Maps take in Key|Value pairs to return a value. Written as: key -> value
val map1: Map[String, Int] = Map (
  "one" -> 1,
  "two" -> 2,
  "three" -> 3
)

//Fetching from datasets

//Data from sequences
val getSeqData: Int = seq1(0)
//Head only gives first element.
val getSeqData2: Int = seq1.head
//Head gives first. Tail gives rest in Scala.
val getSeqData3 = seq1.tail

//Data from lists
val getListData: Int = list1(2)
val getListData2: Int = list1.head
val getListData3 = list1.tail

//Data from maps
val getMapData = map1("one")

//Many options and things to play around with. Explore and find out more, tinker and learn.

//Manipulating datasets

//.map
val tripledSeq: Seq[Int] = seq1.map {
  number => number * 3
}

val tripledList: List[Int] = list1.map {
  number => number * 3
}

val tripledMap: Map[String, Int] = map1.map {
  case (key, value) => (key, value * 3)
}

val changeKey: Map[String, Int] = map1.map {
  case (key, value) => (key + "s", value)
}

val changeKeyAndValue: Map[String, Int] = map1.map {
  case (key, value) => (key + "s", value * 3)
}

//.filter
val filteredSeq: Seq[Int] = seq1.filter {
  number => number > 1
}

val filteredList: List[Int] = list1.filter {
  number => number < 2
}

//Tuple in context
val filteredMap: Map[String, Int] = {
  map1.filter(number => number._2 > 2)
}
//selected from the Map has to be selected through _1/_2.


//filterNot (similar to !filter)
val filterNotList: List[Int] = {
  list1.filterNot(number => number >= 2)
}

//Exists
//returns a boolean value, returns first one that matches.
val listExists: Boolean = list1.exists {
  number => number > 1
}

val seqExists: Boolean = seq1.exists {
  number => number > 6
}

val mapExists: Boolean = map1.exists {
  number => number._2 > 2
}

//Contains
//used to check for just one parameter in particular.

val containsSeq: Boolean = seq1.contains(2)
val containsList: Boolean = list1.contains(0)

//can only check the key in map
val containsMap: Boolean = map1.contains("six")