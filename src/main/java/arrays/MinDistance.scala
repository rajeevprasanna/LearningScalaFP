package arrays

/**
 * Created by rajeevprasanna on 03/04/15.
 *
 * http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 */

//Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[].
// The array might also contain duplicates. You may assume that both x and y are different and present in arr[].
object MinDistance extends App {

  val l1 = List(3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3)
  val x1 = 3
  val y1 = 6

//  val l1 = List(3, 4, 5)
//  val x1 = 3
//  val y1 = 5

//  val l1 = List(2, 5, 3, 5, 4, 4, 2, 3)
//  val x1 = 3
//  val y1 = 2

  println(getMinDifference(l1, x1, y1))

  //  Algorithm :
  // Traverse the array from left side and stop if either x or y are found. Store index of this first occurrence in a variable prev
  // Now traverse arr[] after the index prev. If the element at current index i matches with either x or y
  // then check if it is different from arr[prev]. If it is different then update the minimum distance if needed.
  // If it is same then update the prev.

  //Get the first matching element and its index
  def getMinDifference(list: List[Int], x: Int, y: Int):Int = {
    val firstElementTuple = list.zipWithIndex.collectFirst({ case i if (i._1 == x || i._1 == y) => i }).get
    list.zipWithIndex.filter(p => (p._1 == x || p._1 == y)).foldLeft(firstElementTuple._2, 1000)((l, r) =>
      if (list(l._1) == r._1) {
        (r._2, l._2)
      } else {
        if (r._2 - l._1 < l._2) {
          (r._2, r._2 - l._1)
        } else {
          (r._2, l._2)
        }
      }
    )._2
  }
}

