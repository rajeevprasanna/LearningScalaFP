package arrays

/**
 * Created by rajeevprasanna on 01/04/15.
 *
 * http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
 */

// Given an unsorted array arr[0..n-1] of size n,
// find the minimum length sub array arr[s..e] such that sorting
// this sub array makes the whole array sorted.
object MinUnsortedArray extends App {

    val array = Array(10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60)
    val (start,end) = getIndexPositionsOfMinUnsortedArray(array)
    println("startIndex => "+ start + "  endIndex => "+ end)

  val array2 = Array(10, 12, 20, 30, 40, 50, 60)
  val (start2, end2) = getIndexPositionsOfMinUnsortedArray(array2)
  println("startIndex2 => " + start2 + "  endIndex2 => " + end2)

  val (start3, end3) = getIndexPositionsOfMinUnsortedArray(array2.reverse)
  println("startIndex3 => " + start3 + "  endIndex3 => " + end3)


  def getIndexPositionsOfMinUnsortedArray(array: Array[Int]) = {
    val startIndex = array.sliding(2, 1).toList.zipWithIndex.collectFirst { case (a, index) if (a(0) > a(1)) => index }.getOrElse(-1)
    val endIndex = array.sliding(2, 1).toList.zipWithIndex.reverse.collectFirst { case (a, index) if (a(0) > a(1)) => index }.getOrElse(-1)

    if (startIndex == -1 || endIndex == -1) {
      (0, 0)
    } else {
//      println("startIndex => " + startIndex + "  startElement => " + array(startIndex) + "  endIndex => " + endIndex + " endElement => " + array(endIndex))
      val minElementInUnsortedWindow = array.drop(startIndex + 1).min
      val maxElementInUnsortedWindow = array.drop(startIndex + 1).reverse.drop(array.length - endIndex - 1).max

//      println("minElementInUnsortedWindow => " + minElementInUnsortedWindow)
//      println("maxElementInUnsortedWindow => " + maxElementInUnsortedWindow)
//
      val sortStartIndex = array.zipWithIndex.collectFirst { case (x, index) if x > minElementInUnsortedWindow => index }.get
      val sortEndIndex = array.zipWithIndex.reverse.collectFirst { case (x, index) if x < maxElementInUnsortedWindow => index }.get
//      println("sortStartIndex => " + sortStartIndex)
//      println("sortEndIndex => " + sortEndIndex)
      (sortStartIndex, sortEndIndex)
    }
  }
}
