package arrays

/**
 * Created by rajeevprasanna on 31/03/15.
 */
object MaximumSizeSquareSubMatrix extends App {

  val matrix =
    List(
      List(0, 1, 1, 0, 1),
      List(1, 1, 0, 1, 0),
      List(0, 1, 1, 1, 0),
      List(1, 1, 1, 1, 0),
      List(1, 1, 1, 1, 1),
      List(0, 0, 0, 0, 0)
    )

  val res = for {
    row: List[Int] <- matrix
    column: Int <- row
  } yield column

  println(res)
}
