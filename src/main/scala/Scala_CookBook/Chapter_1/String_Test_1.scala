package main.scala.Scala_CookBook.Chapter_1

object StringTest_1 {

  def main(args :Array[String]) ={

    val str = "Hello Scala"
    println("str " + str.getClass.getName)

    //StringEqualityCheck()

    //val objectType = objectMatch("a")
    //println("objectType " + objectType)

    //multilineString()
    val revStr = reverseString("hello")
    println("revStr " + revStr)

    /*revStrusingTail("abcd")*/
    println("upperStr " + mapTest("hello"))

    RegexTest("Hello Spark 123")



  }

  def getStrLength(s:String) = {
    s.length
  }

  def StringEqualityCheck() ={

    val str1 = "hello"
    val str2 = "Hello"
    println("String Equal check using == " + str1 == str2)
    println("String Equal check using equals " + str1.equals(str2))
    println("String Equal check using equals after lowercase " + str1.toLowerCase.equals(str2.toLowerCase))

    // difference between equals and == in Scala

    //null.equals("hello") // will throw NPE
    null == "hello" // no NPE ,

    "hello".eq("hello") // false as reference is not same


  }

  def objectMatch(obj : Any) : String = obj match {

      case obj : Boolean => return "Boolean"
      case obj : Integer => return "Integer"
      case obj : String => "String"
      case _ => "other"

  }

  def multilineString()={
    val str = " Hello " +
      "world , I am new to " +
      "Scala "
    println("str " + str.stripMargin)

  }

  def reverseString(s: String) : String = {
    if (s.isEmpty) ""

    else {
      print("s.tail > " + s.tail)
      print("s.head >" + s.head)
      reverseString(s.tail) + s.head
    }
  }


// we will do it once tail rec is clear
 /* def revStrusingTail(str:String) = {

    println("str" + str)
    @scala.annotation.tailrec
    def impl(str:String , r:String) : String={
      if(str == null ) null
      if(str.tail.isEmpty) str.head + r
      impl(str.tail , str.head+r)
    }
    val rev = impl(str,"")
    println("reversed string " + rev)

  }
*/


  def mapTest(s:String) : String ={
    val upperStr = s.map(e => e.toUpper)
    return upperStr
  }

  def RegexTest(s:String) = {
    val pattern = "[0-9]+".r

    /*
    The differnce between findFirstIn and findAllIn is that findFirstIn return Option whereas findAllin returns Iterator
    So accessing result is differnt as shown below , But  foreach is common in both while access records.
     */
    val matches = pattern.findAllIn(s) // return iterator so we need to use foreach , match can not be used

    matches.foreach(e => println(e))
    matches.toList.map(e => println(e))


    val result = pattern.findFirstIn(s)

    result.foreach(e => if(e.contains("123")) println("Found 123 "))

    result match  {
      case Some(e) => println(s"Found Matches  +$e ")
      case None => println(s"No Matches Found " )
    }

  }


}