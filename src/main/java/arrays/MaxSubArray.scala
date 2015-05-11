package arrays

/**
 * Created by rajeevprasanna on 03/04/15.
 *
 * http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
 *
 * http://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/
 */

//Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
object MaxSubArray extends App {
//  val list = List(1, 2, 3, 1, 4, 5, 2, 3, 6)
//  val k = 3

  val list = List(8, 5, 10, 7, 9, 4, 15, 12, 90, 13)
  val k = 4

   val maxList =  list.sliding(k).toList.map(_.max)
  println(maxList)


  //Given two arrays: arr1[0..m-1] and arr2[0..n-1].
  // Find whether arr2[] is a subset of arr1[] or not. Both the arrays are not in sorted order
//  val arr1 = Array(11, 1, 13, 21, 3, 7)
//  val arr2 = Array(11, 3, 7, 1)

  val arr1 = Array(10, 5, 2, 23, 19)
  val arr2 = Array(19, 5, 3)

  val isSubset = arr1.sorted.containsSlice(arr2.sorted)
  println("arra2 is subset of arr1 => "+ isSubset)
}
