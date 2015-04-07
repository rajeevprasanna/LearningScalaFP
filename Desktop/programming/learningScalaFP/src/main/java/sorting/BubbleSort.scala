package sorting

/**
 * Created by rajeevprasanna on 05/04/15.
 */
object BubbleSort extends App {

  def bubbleSort(a:List[Int]):List[Int] = {
    def sort(a:List[Int], sortedList:List[Int]):List[Int] = a match {
      case Nil => sortedList
      case x::Nil => sortedList :+ x
      case x::y::tail => if(x < y) {
        sort(tail:+y, sortedList:+x)
      } else {
        sort(tail:+x, sortedList:+y)
      }
    }
    sort(a, Nil)
  }

  println(bubbleSort(List(5,4,3,2,1)))
}
