/** Unit Testing */
//The process in which the smallest testable components of a program are individually tested for correctness.
//The tests only include checking characteristic of the particular piece of code, or the "unit" being tested.
//A unit test typically only tests public functions
//Consider edge cases, how stupid can people be? What could happen? Always looking for the worst possible cases too, not just making it work.

//FlatSpec used for testing in our setting.

import org.scalatest.FlatSpec

/**
                                          //naming convention: same as file with spec at the end
class TwoNumbersSpec extends FlatSpec{
  "add" should "add numbers" in {         //method name and expected functionality
    val nums = new TwoNumbers(1,2)
    assert(nums.add==3)                   //block of code that performs the test, assert is keyword (this and line above)
  }                                       //assert gives Boolean value, must evaluate 'true' for test to pass,
}                                         //however sometimes we want it to fail.
*/

//We write the tests first, then write code next. (start with the end method)

//Ensure tests are:
  //Written to specification
  //Code is developed to meet expectations
  //Not developed to work for your code (which allows bugs to set in)
//Scala offers dummy implementations to help with TDD, we'll get an error but it will compile (and that's the important part!).
//Start with empty implementation. Get test passing, then refactor.
