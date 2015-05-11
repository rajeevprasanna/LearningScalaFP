package sorting

/**
 * Created by rajeevprasanna on 07/04/15.
 *
 * http://eddmann.com/posts/merge-sort-in-scala-using-tail-recursion-and-streams/
 */
object mergeSort extends App {

  implicit def lessThan1(a:Int, b:Int) = a<b
  def mergeSort1[T](xs:List[T])(implicit pred:(T,T) => Boolean):List[T] = {
    val m = xs.length/2
    if(m==0) xs
    else{
      @scala.annotation.tailrec
      def merge(ls:List[T], rs:List[T], acc:List[T] = List()):List[T] = (ls, rs) match {
        case (Nil, _) => acc ++ rs
        case (_, Nil) => acc ++ ls
        case (l::ls1, r::rs1) => if(pred(l,r)) merge(ls1, rs, acc:+l) else merge(ls, rs1, acc:+r)
      }
      val (l, r) = xs splitAt(m)
      merge(mergeSort1(l), mergeSort1(r))
    }
  }
  println(mergeSort1(List(5,4,3,2,1)))
  println(mergeSort1(List(1,3,4,2,5)))


  //Merge sort with streams
  def mergeSort[T](pred:(T,T) => Boolean)(xs:Stream[T]):Stream[T] = {
    val m = xs.length/2
    if(m==0) xs
    else{
      def merge(ls:Stream[T], rs:Stream[T]):Stream[T] = (ls, rs) match {
        case (Stream.Empty, _) => rs
        case (_, Stream.Empty) => ls
        case (l #:: ls1, r#::rs1) => if(pred(l, r)) l#::merge(ls1, rs) else  r#::merge(ls, rs1)
      }
      val (l, r) = xs splitAt(m)
      merge(mergeSort(pred)(l), mergeSort(pred)(r))
    }
  }
  def numbers(remain: Int): Stream[Int] =  if (remain == 0) Stream.Empty else Stream.cons(util.Random.nextInt(100), numbers(remain - 1))
  println(mergeSort((x: Int, y: Int) => x < y)(numbers(4)).toList)

}
