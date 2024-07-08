/** Family tree

  Family has a surname
  There are parents, they have a child
  The child grows up and gets a girlfriend
  then they get married
  there is then another family member with the same surname but different parents
  They have a child, etc etc

How would you represent this as simply as possible in code. */

//Would you need to use vars? Reassigning names when changing? You would if adding to a list e.g. parents, children

//Start with an object of family tree (name, surname required).

//Define a class for FamilyMember

//Lots of 'new FamilyMember' creations and adding members to family as you go.



//How would you use traits to cover and explore this?
//Setting up a train of traits that could be implemented with less time committed to classes later (frontloaded effort?)

//April's solution
class Person (firstName: String) {
  val surname: String = "Smith"
  //could insert other defaults here
}

class Dad extends Person ("Steve")

class Girlfriend extends Person ("Jess") {
  override val surname: String = "Jones"
  //override surname for external members
}



