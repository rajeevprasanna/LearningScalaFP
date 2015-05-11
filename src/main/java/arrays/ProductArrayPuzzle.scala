package arrays

/**
 * Created by rajeevprasanna on 01/04/15.
 *
 * http://www.geeksforgeeks.org/a-product-array-puzzle/
 *
 * http://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
 */

//Given an array arr[] of n integers, construct a Product Array prod[] (of same size)
// such that prod[i] is equal to the product of all the elements of arr[] except arr[i].
// Solve it without division operator and in O(n).
object ProductArrayPuzzle extends App {

  val list: List[Int] = List(10, 3, 5, 6, 2)

  val leftProduct =  List(1,1):::list.zipWithIndex.map { x => (list.take(x._2 + 1).reduce((l, c) => l * c))}
  val rightProduct = list.zipWithIndex.map { x => list.drop(x._2).reduce((l, c) => l * c) } ::: List(1,1)

  val x = leftProduct.zip(rightProduct).map( x => x._1 * x._2).drop(1).dropRight(1)
  println(x)

  //Segregate even and odd numbers : http://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
  //Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers first, and then odd numbers.
  val list1 = List(12, 34, 45, 9, 8, 90, 3)
  def evenFilter = (x:Int) => x%2 == 0
  def oddFilter = (x:Int) => x%2 == 1
  println("segregated list => " + (list1.filter(_%2==0) ::: list1.filter(_%2 == 1)))
  println("segregated list => " + (list1.filter(evenFilter):::list1.filter(oddFilter)))


}
