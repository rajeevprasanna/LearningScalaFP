package arrays

/**
 * Created by rajeevprasanna on 03/04/15.
 *
 * http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
 */
object NumberOfOccurrences extends App {
  val list = List(1, 1, 2, 2, 2, 2, 3)
  val n = 1

  //Count the number of occurrences of element
  val count =  list.groupBy(x => x).mapValues(_.size).get(n).getOrElse(0)
  println(count)

  //Get an element which occurred maximum number of times
  val max = list.groupBy(x => x).mapValues(_.size).maxBy(_._2)
  println(max._1)
}
