package strings

/**
 * Created by rajeevprasanna on 27/04/15.
 *
 * http://www.geeksforgeeks.org/category/c-strings/page/6/
 */
object Page6 extends App{

  //http://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/
  val str = "test"
  val maxChar = str.groupBy(x => x).mapValues(_.size).max._1
  println(maxChar)


  //Remove all duplicates from the input string
  //http://www.geeksforgeeks.org/remove-all-duplicates-from-the-input-string/
  val s = "geeksforgeeks"
  //distinct characters of the string
  println("unique characters => "+ s.distinct)
  //duplicate characters of the string
  s.groupBy(x => x).mapValues(_.size).filter(_._2 > 1).map(x => println(x._1))

  //Remove characters from the first string which are present in the second string
  //http://www.geeksforgeeks.org/remove-characters-from-the-first-string-which-are-present-in-the-second-string/
  val str1 = "test string"
  val str2 = "mask"

  println("Removing characters present in the second string")
  val str2Set = str2.toSet
  str1.filterNot(x => str2.contains(x)).foreach(println)

  //Check if strings are rotations of each other
  //http://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other-or-not/
  val s3 = "ABCD"
  val s4 = "CDAB"
  val isSubString = (s3++s4).contains(s3) && (s3++s4).contains(s4)
  println("s3 is rotations of each other s4 => ", isSubString)

  //Reverse of a string using tail recursion
  def reverseString(str: String): String = {

    @scala.annotation.tailrec
    def reverse(s: String, t: String): String = {
      if (s == null) return null
      if (s.tail.isEmpty) return s.head + t
      reverse(s.tail, s.head + t)
    }

    @scala.annotation.tailrec
    def rev(s: String, t: String): String = (s, t) match {
      case ("", x) => x
      case (x, y) => rev(x.tail, y + x.head)
    }

    val r1 = reverse(str, "")
    val r2 = rev(str, "")
    if (r1.equals(r2)) return r1
    else "error"
  }
  //http://www.geeksforgeeks.org/reverse-a-string-using-recursion/
  println(reverseString("Geeks for Geeks"))


  //Permutations of a give string
  //http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
  val perString = "ABC"
  val permutations = perString.permutations.toStream.toIterator.foreach(println)

  //Permutations of integer list
  def permutationsList(l:List[Int]):List[List[Int]] = l match {
    case List(ele) => List(List(ele))
    case list =>
      for{
        i <- List.range(0, list.length)
        p <- permutationsList(list.slice(0,i) ++ list.slice(i+1, list.length))
      } yield list(i)::p
  }
  val perms = permutationsList(List(1,2,3))
  println(perms)

  //Combinations of string
  def combinations[A](s:Set[A], k:Int):Set[Set[A]] = if(k>s.size) Set()
          else if (k==1) s.map(Set(_))
          else combinations(s.tail, k-1).map(_ + s.head) ++ combinations(s.tail, k)
  println(combinations(Set(1,2,3), 2))


  //Divide the string into N equal parts
  //http://www.geeksforgeeks.org/divide-a-string-in-n-equal-parts/
  val divString = "a_simple_divide_string_quest"
  val n = 4
  val equalSubStringParts = for {
    i <- n to divString.length by n if divString.length % n == 0
    j = i - n
  } yield divString.substring(j, i)
  println(equalSubStringParts)

  //Given a string, find its first non repeating character
  //http://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
  val repStr = "geeksforgeeks"
  val chars = new Array[Boolean](256)
  val firstNonRepeatingElement = repStr.groupBy(x => x).collectFirst({
    case x if x._2.length == 1 => x._1
  }).getOrElse("nothing is there")
  println("First non repeating element => ", firstNonRepeatingElement)


  //Print list items containing all characters of a given word
  //http://www.geeksforgeeks.org/print-list-items-containing-all-characters-of-a-given-word/
  val source = "sun"
  val listStr = List("sunday", "geeksforgeeks", "utensils", "just", "sss")
  val filteredWords = listStr.filter(x => source.toSet.subsetOf(x.toSet))
  println(" list items containing all characters of a given word : sun are => ", filteredWords)

}
