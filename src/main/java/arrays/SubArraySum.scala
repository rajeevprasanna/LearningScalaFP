package arrays

/**
 * Created by rajeevprasanna on 04/04/15.
 *
 * http://www.geeksforgeeks.org/find-subarray-with-given-sum/
 *
 * //Look at this link for answer :http://stackoverflow.com/questions/29454886/find-subarray-with-given-sum
 */

//Given an unsorted array of non negative integers, find a continuous sub array which adds to a given number.
object SubArraySum extends App {

  val list:List[Int] = List(1, 4, 20, 3, 10, 5)
  val target = 33


  //Refer solution here : http://stackoverflow.com/questions/29454886/find-subarray-with-given-sum/29455981
  //Solution 3 :
  val sums = list.scanLeft(0)(_+_).zipWithIndex
  val subArray = sums.drop(1).foldLeft((sums, List[(Int, Int)]())){
    case ((leftTotal, rs), total) =>
      val newL = leftTotal.dropWhile(total._1 - _._1 > target)
      if(total._1 - newL.head._1 == target)
        (newL, (newL.head._2, total._2 - 1) :: rs)
      else (newL, rs)
  }._2
  println(subArray)


//
//  //Solution 1 :
//  val sumList = list.foldLeft(List(0), 0)((l, r) => (l._1 :+ (l._2+r), l._2 + r))._1.drop(1)
//  //Brute force approach
//  sumList.zipWithIndex.combinations(2).toList.collectFirst({
//    case i if i(1)._1 - i(0)._1 == sum => i
//  }) match {
//    case Some(List(x, y)) => println("elements which form the given sum are => "+ list.drop(x._2+1).take(y._2-x._2))
//    case _ => println("couldn't find elements which satisfy the given condition")
//  }
//
//
//  //solution 2 : start array sum with first element. keep on adding next elements. When sum becomes greater than the required
//  //sum then remove the tail element. otherwise keep adding next element till we reach end
//  val (totalSum, start, end, isSumFound) = list.zipWithIndex.drop(1).foldLeft(list.head, 0, 1, false)((l, r) =>
//    if(!l._4) {
//      val tempSum = l._1 + r._1
//      if (tempSum == sum){
//        (sum, l._2, r._2, true)
//      } else if(tempSum > sum){
//          var (curSum, curIndex) = (tempSum, l._2)
//          while(curSum > sum && curIndex < list.length-1){
//            curSum = curSum - list(curIndex)
//            curIndex = l._2 +1
//          }
//        (curSum, curIndex, r._2, curSum == sum)
//      } else {
//        (tempSum, l._2, r._2, false)
//      }
//    }else
//      l
//  )
//
//  if(isSumFound || totalSum == sum){
//    println("elements which form the given sum are => "+ list.drop(start+1).take(end-start))
//  }else{
//    println("couldn't find elements which satisfy the given condition")
//  }

}
