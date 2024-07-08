// What’s the difference between an abstract class and a trait? Why might you use one over the other?
//- A class can only inherit from one abstract class but can inherit from multiple traits
//- Abstract classes can have constructor parameters whereas traits can't
// If you need constructor parameters and want to define clear inheritance hierarchy, use abstract classes
// If you need reusable code and want to apply it to a range of different uses, use a trait
// If in doubt, use traits

// What are companion classes and objects and why might you use them?
//- A class and object declared in the same file with the same name
//- The class/object can access the private members of its companion
//- Companion objects can contain factory methods to generate new instances of a class
//- Companion objects can contain methods that are not specific to instances of the companion class