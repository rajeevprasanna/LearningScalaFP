package arrays

/**
 * Created by rajeevprasanna on 05/04/15.
 *
 * http://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/
 */

//Given an unsorted array that contains even number of occurrences for all numbers except two numbers.
// Find the two numbers which have odd occurrences in O(n) time complexity and O(1) extra space.
object TwoOddOccurrenceNumbers extends App {

  val list = List(12, 23, 34, 12, 12, 23, 12, 45)
  val xor = list.reduce(_^_)
  val setBitNumber = xor & ~(xor-1)

  val (x, y , _) = list.foldLeft(0,0, setBitNumber)((l, r) =>
    if((r & l._3) == 1){
      (l._1^r, l._2, l._3)
    }else{
      (l._1, l._2^r, l._3)
    }
  )

  println("Two numbers occurred odd number of times =>  x => "+ x + " y => "+ y)
}
