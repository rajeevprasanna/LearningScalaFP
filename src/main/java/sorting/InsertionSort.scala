package sorting

/**
 * Created by rajeevprasanna on 07/04/15.
 */
object InsertionSort extends App {

  def sort(as:List[Int], bs:List[Int]):List[Int] = as match {
    case h :: t => sort(t, insertInList(bs, h))
    case Nil => bs
  }

  def insertInList(list:List[Int], x:Int):List[Int] =  list match {
    case h::t if h < x =>  h :: insertInList(t, x)
    case _ => x::list
  }

  println(sort(List(1,2,5,3,4), Nil))
//  println(sort(List(5,4,3,2,1)))
}
