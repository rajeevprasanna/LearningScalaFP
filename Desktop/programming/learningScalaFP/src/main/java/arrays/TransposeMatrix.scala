package arrays

/**
 * Created by rajeevprasanna on 31/03/15.
 */
object TransposeMatrix extends App {

  val matrix = List(
    List(0, 1, 1, 0, 1),
    List(1, 1, 0, 1, 0),
    List(0, 1, 1, 1, 0),
    List(1, 1, 1, 1, 0),
    List(1, 1, 1, 1, 1)
  )

  type Row = List[Int]
  type Matrix = List[Row]

  def dotProduct(v1:Row, v2:Row) = v1.zip(v2).map{ t:(Int, Int) => t._1 * t._2}.reduceLeft(_+_)

  def transpose(m:Matrix):Matrix = if(m.head.isEmpty) Nil else m.map(_.head)::transpose(m.map(_.tail))

  def matrixMultiplication(m1:Matrix, m2:Matrix) = for(m1Row <- m1) yield for (m2col <- transpose(m2)) yield dotProduct(m1Row, m2col)

  val test = List(
    List(1,2,3),
    List(4,5,6),
    List(7,8,9)
  )

  //However it would be nice to be able to use standard mathematical operators like A*B and AT when coding with matrices.
  case class RichMatrix(m:Matrix){
    def T = transpose(m)
    def *(that:RichMatrix) = matrixMultiplication(this.m, that.m)
    def apply(i:Int, j:Int) = m(i)(j)

    def rowCount = m.length
    def colCount = m.head.length

    def toStr = "\n"+m.map{
      _.map{"\t" + _}.reduceLeft(_+_)+"\n"
    }.reduceLeft(_+_)
  }
  implicit def pimp(m:Matrix) = new RichMatrix(m)

  println(test.toStr)
  println(test.T.toStr)
}
