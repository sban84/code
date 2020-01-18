package main.scala.Scala_lab_test

import scala.collection.immutable.HashSet
import scala.collection.mutable
import scala.collection.mutable.Map

/**
  * Created by suman.banerjee on 3/28/2017.
  *
  * As illustrated previously, the Scala compiler
transforms a binary operation expression like 1 > "Go to island." into (1).>("Go to island."). Thus, when you say 1 > "Go to island.", you are actually calling a method named >
on an integer with the value 1, passing in a string with the value "Go to island." This >method, which
you can invoke on any object in a Scala program, returns a two-element tuple containing the key and value.8 You then pass this tuple to the += method of
the map object to which treasureMap refers. Finally, the last line prints the value that corresponds to the key 2 in the treasureMap. If you run this code,
it will print: Find big X on ground.
  */
object ScalaProgCollectionTest {

  def main( args: Array[String] ): Unit = {
    setTest()
    mapTest()
  }

  def setTest(): Unit =
  {
    var mutableSet = mutable.HashSet("a", "a", "b")
    mutableSet = mutableSet + "c"
    println(mutableSet)

    var immutableSet = HashSet("hello" , "set")
    immutableSet += "test"
    println(immutableSet)
  }

  def mapTest(): Unit =
  {
    val treasureMap = Map[Int, String]()

    treasureMap += (2 -> "Find big X on ground.")
    treasureMap += (3 ->  "Dig.")
    println(treasureMap(2))
  }
}
