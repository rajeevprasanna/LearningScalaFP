package arrays

/**
 * Created by rajeevprasanna on 03/04/15.
 *
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 */

//TODO : incomplete

//Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
object MaximumJMinusI extends App {

  val list = List(1, 2, 3, 4, 5)
  //  val list = List(5,4,3,2,1)
  //  val list =List(34, 8, 10, 3, 2, 80, 30, 33, 1)
  //  val list = List(9, 2, 3, 4, 5, 6, 7, 8, 18, 0)
  //  val list = List(1, 2, 3, 4, 5, 6)

  val result = list.map { x => list.map {
    y => (y, x)
  }
  }.flatten.filter(z => z._1 > z._2).map {
    p => list.indexOf(p._1) - list.indexOf(p._2)
  }.max

  println(result)


  // Get all the minimum elements on left side for each index
  //  val minElementWithLeftIndexes = list.zipWithIndex.foldLeft(List((list(0), 0)), (list(0), 0))((l,r) => if(l._2._1 >= r._1) (l._1 :+r, r) else (l._1:+l._2, l._2))._1.drop(1)
  //  val maxElementWithRightIndexes = list.zipWithIndex.foldRight(List((list.last, list.length-1)), (list.last, list.length-1))((r,l) => if(l._2._1 <= r._1) (l._1 :+ r, r) else (l._1:+l._2, l._2))._1.drop(1)


  //  println(minElementWithLeftIndexes)
  //  println(maxElementWithRightIndexes)

  //  val sortedList = minElementWithLeftIndexes.zip(maxElementWithRightIndexes).sortBy(x => x._1._2 - x._2._2)
  //  val leftIndex = sortedList(0)._1._2
  //  val rightIndex = sortedList(0)._2._2
  //  println("array indexes with maximum difference left index =>" + leftIndex + "  left element => "+ list(leftIndex)  + " right index => "+ rightIndex + " right element=> "+ list(rightIndex))

}