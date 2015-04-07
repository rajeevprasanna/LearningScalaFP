package arrays

/**
 * Created by rajeevprasanna on 02/04/15.
 *
 * http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 */

//P = 1 is an equilibrium index of this array, because:
//A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]
//P = 3 is an equilibrium index of this array, because:
//
//A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]
//P = 7 is also an equilibrium index, because:
//
//A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0
//and there are no elements with indices greater than 7.
//
//P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
object EquillibriumIndexOfArray extends App {

  def equalsTuples = (a:(Int,Int,Int)) => if(a._1==a._2) true else false
  def getEquillibriumIndexes(a:Array[Int]) = {
    val array = 0 +: a :+ 0
    array.zipWithIndex.map(x => (array.take(x._2+1).reduce(_+_), array.takeRight(array.length-x._2).reduce(_+_), x._2)).drop(1).dropRight(1).filter(equalsTuples).map(x => x._3-1).toList
  }
  println(getEquillibriumIndexes(Array(-1, 3, -4, 5, 1, -6, 2, 1)))
  println(getEquillibriumIndexes(Array(-7, 1, 5, 2, -4, 3, 0)))
}
