package main.scala.Scala_CookBook

import main.scala.Scala_CookBook.Chapter_1.StringOperation.StringImprovements
import main.scala.Scala_CookBook.Chapter_1.MyString_implicit._ //._ is required as its in other package Chapter_1

/*
To access implicit functions from outside this package , we need define implicit classes inside
Object and then create implicit classes in it.

And while accessing the functions we need to import implicit class package like as done in MyString_implicit and ImplicitTest
Refer MyString_implicit.scala / StringOperation and ImplicitTest.scala
 */

object ImplicitTest {
  def main(args: Array[String]): Unit = {

    val str  = "hello".toUpperCaseFirstCharOnly()

    println("After Converting fiorst char to upperCase " + str)

    // From Another implicit class

    val result = "Hello Scala".splitAndReverse()
    println("result " + result)
  }

}
