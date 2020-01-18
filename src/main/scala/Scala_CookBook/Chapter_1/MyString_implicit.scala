package main.scala.Scala_CookBook.Chapter_1

/*
To access implicit functions from outside this package , we need define implicit classes inside
Object and then create implicit classes in it.

And while accessing the functions we need to import implicit class package like as done in MyString_implicit and ImplicitTest
Refer MyString_implicit.scala / StringOperation and ImplicitTest.scala
 */

object MyString_implicit {

  def main(args: Array[String]): Unit = {

    val result = "Hello Scala".splitAndReverse()
    println("result " + result)
  }

  implicit class String_imp(s:String) {

    def splitAndReverse() : String ={
      val splitted = s.split(" ")
      val firstStr = splitted(0)
      val secondStr = splitted(1)
      println("first " + firstStr + "sec " + secondStr)

      return secondStr + " " + firstStr ;

    }
  }



}
