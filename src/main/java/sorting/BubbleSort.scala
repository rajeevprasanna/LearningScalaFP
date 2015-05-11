package sorting

/**
 * Created by rajeevprasanna on 05/04/15.
 */
object BubbleSort extends App {

  def bubbleSort[A <% Ordered[A]](a: List[A]): List[A] = {

    def sort(as: List[A], bs: List[A]): List[A] = {
      if (as.isEmpty) bs
      else bubble(as, Nil, bs)
    }

    def bubble(as: List[A], zs: List[A], bs: List[A]): List[A] = as match {
      case h1 :: h2 :: tail => if (h1 > h2) bubble(h1 :: tail, h2 :: zs, bs) else bubble(h2 :: tail, h1 :: zs, bs)
      case h1 :: Nil => sort(zs, h1 :: bs)
    }

    sort(a, Nil)
  }

  println(bubbleSort(List(5, 4, 3, 2, 1)))
  println(bubbleSort(List(1, 2, 3, 4, 5)))
  println(bubbleSort(List(5.0, 4.0, 3.0, 2.0, 1.0)))

}
