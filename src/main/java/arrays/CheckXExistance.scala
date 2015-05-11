package arrays

/**
 * Created by rajeevprasanna on 30/03/15.
 */

//Refer: http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
//Given an array A[] and a number x, check for pair in A[] with sum as x
//Write a C program that, given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x.
object CheckXExistance extends App {
  val a = List(1, 4, 45, 6, 10, 8)
  val sum = 16

  def findSumTuples(list: List[Int], sum: Int): List[(Int, Int)] = list match {
    case Nil => List()
    case x if x.size == 1 => List()
    case x :: tail =>
      if (x + tail.last == sum) {
        (x, tail.last) :: findSumTuples(tail.dropRight(1), sum)
      } else if (x + tail.last > sum) {
        findSumTuples(list.dropRight(1), sum)
      } else {
        findSumTuples(tail, sum)
      } case _ => List()
  }

  val checkSumTuples = findSumTuples(a.sorted, sum)
  println(checkSumTuples)

}
