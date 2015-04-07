package arrays

/**
 * Created by rajeevprasanna on 03/04/15.
 *
 * http://www.geeksforgeeks.org/next-greater-element/
 */

//Given an array, print the Next Greater Element (NGE) for every element.
// The Next greater Element for an element x is the first greater element on the right side of x in array.
// Elements for which no greater element exist, consider next greater element as -1.
object NextGreaterElement extends App {

 // val array = Array(4, 5, 2, 25)
   val array = Array(13, 7, 6, 12)

  import scala.collection.mutable.Stack
  val stack = new Stack[Int]
  stack.push(array(array.length-1))


  val greaterElementList = array.reverse.map{x:Int =>
    stack.push(x);
    stack.collectFirst({case i:Int  if(i>x) => i}) match
    {
      case Some(t) => t
      case None => -1
    }
  }.toList

  println(array.toList.zip(greaterElementList.reverse))
}
