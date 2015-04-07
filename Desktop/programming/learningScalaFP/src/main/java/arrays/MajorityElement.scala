package arrays

/**
 * Created by rajeevprasanna on 30/03/15.
 *
 * http://www.geeksforgeeks.org/find-the-number-occurring-odd-number-of-times/
 */
object MajorityElement extends App {
  val list = List(3,3,4,2,4,4,2,4,4,5)
  val majorElement = list.groupBy(x => x).mapValues(_.size).maxBy(_._2)._1
  println("major element is => "+ majorElement)
}
