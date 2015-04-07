package arrays

/**
 * Created by rajeevprasanna on 04/04/15.
 *
 * http://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/
 */

//Given an array of n distinct integers sorted in ascending order,
// write a function that returns a Fixed Point in the array, if there is any Fixed Point present in array, else returns -1.
// Fixed Point in an array is an index i such that arr[i] is equal to i. Note that integers in array can be negative
object FixedPoint extends App {

  val list = List(-10, -5, 0, 3, 7)
  val fixedPoints =  list.zipWithIndex.filter(x => x._1 == x._2)
  println(fixedPoints)

}
