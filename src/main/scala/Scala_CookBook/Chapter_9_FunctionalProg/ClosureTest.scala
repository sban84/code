package main.scala.Scala_CookBook.Chapter_9_FunctionalProg

import scala.collection.mutable.ArrayBuffer

class ClosureTest {

  val fruits = ArrayBuffer[String]("apple_by_default")

  def addToBasket(item :String ) : ArrayBuffer[String] = {
//    fruits += item  // allowed but better remember one that ArrayBuffer has append ( like ArrayList.add in java )

    fruits.append(item)
    println("fruits " + fruits)
    fruits

  }

}
