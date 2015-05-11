package arrays

/**
 * Created by rajeevprasanna on 05/04/15.
 *
 * http://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
 */
object SortedSubSequenceOfSize3 extends App {

//  val list =  List(12, 11, 10, 5, 6, 2, 30)
//  val list =  List(1, 2, 3, 4)
    val list =  List(4, 3, 2, 1)
  val minList =  -1 +: list.zipWithIndex.drop(1).map(x => if(list.take(x._2).min > x._1) -1 else list.take(x._2).min )
  val maxList = list.reverse.zipWithIndex.drop(1).map(x => if(list.reverse.take(x._2).max < x._1) -1 else list.reverse.take(x._2).max) :+ -1

  minList.zip(maxList).zipWithIndex.collectFirst({case i if i._1._1 != -1 && i._1._2 != -1 => i}) match {
    case Some(((startElement, lastElement), middleIndex)) => println("Elemenets which are in sorted order are startElement => "+ startElement + "  middleElement => "+ list(middleIndex) + "  lastElement => " + lastElement)
    case _ => println("No such triplet")
  }

}
