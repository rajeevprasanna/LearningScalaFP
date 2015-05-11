package arrays

/**
 * Created by rajeevprasanna on 31/03/15.
 */
object ArrayRotation extends  App{
  val a = Array(1, 2, 3, 4, 5, 6, 7)
  val d:Int = 2
  //[3, 4, 5, 6, 7, 1, 2]

  //assuming d < a.size
  val rotatedArray =  a.drop(d) ++ a.take(d)
  println(rotatedArray.toList)
}
