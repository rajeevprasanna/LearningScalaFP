package arrays

/**
 * Created by rajeevprasanna on 31/03/15.
 *
 * http://www.geeksforgeeks.org/leaders-in-an-array/
 */
object LeadersOfArray extends App {

  val list = List(16, 17, 4, 3, 5, 2)

  //Write a program to print all the LEADERS in the array.
  // An element is leader if it is greater than all the elements to its right side.
  // And the rightmost element is always a leader.
  // For example in the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
  val reverse = list.reverse
  val ladders = reverse.foldLeft(List(reverse.head), reverse.head)((l, r) => if(r > l._2) (l._1.::(r), r) else l)._1
  println(ladders)
}
