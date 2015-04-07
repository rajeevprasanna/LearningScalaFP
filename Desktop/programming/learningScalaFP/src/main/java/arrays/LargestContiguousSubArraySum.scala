package arrays

/**
 * Created by rajeevprasanna on 30/03/15.
 */
object LargestContiguousSubArraySum extends App {
  val list: List[Int] = List(-2, -3, 4, -1, -2, 1, 5, -3)

  //apply kadanes algorithm
  def maxContiguousSubArraySum(list: List[Int], maxSoFar: Int, maxEndingHere: Int): Int = list match {
    case Nil => maxSoFar
    case x :: tail if tail == Nil => math.max(maxSoFar, x + maxEndingHere)
    case x :: tail => val tempMax = maxEndingHere + x
      if (tempMax < 0) {
        maxContiguousSubArraySum(tail, maxSoFar, 0)
      } else if (tempMax > maxEndingHere) {
        maxContiguousSubArraySum(tail, math.max(maxSoFar, tempMax), tempMax)
      } else {
        maxContiguousSubArraySum(tail, maxSoFar, tempMax)
      }
  }

  val maxContiguousSum = maxContiguousSubArraySum(list, list(0), list(0))
  println("max contiguous subarray sun => " + maxContiguousSum)
}
