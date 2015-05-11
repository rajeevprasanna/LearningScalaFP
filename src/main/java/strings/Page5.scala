package strings

/**
 * Created by rajeevprasanna on 28/04/15.
 *
 * http://www.geeksforgeeks.org/category/c-strings/page/5/
 */
object Page5 extends App{

  //Reverse the words in a given sentence
  //http://www.geeksforgeeks.org/reverse-words-in-a-given-string/
  val original = "i like this program very much"
  val reverse = original.split(" ").map(_.reverse).mkString(" ")
  require(original.length ==  reverse.length)
  println("After reversing each word in the given sentence => ", reverse)

  //Smallest window in a string containing all characters of another string
  //http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
  val bigstr = "this is a test string"
  val small = "tist"
  var smallMap = small.map(ch => (ch, -1)).toMap

  bigstr.toList.foldLeft(-1,-1, smallMap)((l, r) =>
    if(smallMap.contains(r)){
        l
    }else
    l
  )

  def leftCharOccurance:(Char, Int) = (charMap:Map[Char, Int]) => charMap.





}
