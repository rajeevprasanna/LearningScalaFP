package arrays

/**
 * Created by rajeevprasanna on 31/03/15.
 *
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 */
object MaxSumWithNoAdjElement extends App {

  def maxNonContiguouseSum(list: List[Int]): Int = {
    //find maximum sum with no two adjacent elements
    list.drop(2).zipWithIndex.foldLeft(list(0), list(1), math.max(list(0), list(1)))((r, c) =>
      if (r._1 + c._1 > r._2)
        (r._2, r._1 + c._1, math.max(r._1 + c._1, r._3))
      else
        (r._2, r._1, r._3)
    )._3
  }

  val l = List(5, 5, 10, 40, 50, 35)
  println(maxNonContiguouseSum(l))

  val l1 = List(5, 5, 10, 100, 10, 5)
  println(maxNonContiguouseSum(l1))
}
