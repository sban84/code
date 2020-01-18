package main.scala.Scala_CookBook.Chapter_5

/**
  * Created by suman.banerjee on 4/24/2017.
  */
object SuperClassMethodCallingTest extends App{

  val c = new Child
  println(s"c.printSuper = ${c.printSuper}")
  println(s"c.printMother = ${c.printMother}")
  println(s"c.printFather = ${c.printFather}")
  println(s"c.printHuman = ${c.printHuman}")
}


// Test 1 #
trait Human {
  def hello = "the Human trait"
}
trait Mother extends Human {
  override def hello = "Mother"
}
trait Father extends Human {
  override def hello = "Father"
}

class Child extends Human  with Father with Mother{
  def printSuper = super.hello  // this will call super trait , if multiple hello then call the latest trait (defined last in with clause)
  def printMother = super[Mother].hello
  def printFather = super[Father].hello
  def printHuman = super[Human].hello
}

//Test 2 #

trait Animal {
  def walk { println("Animal is walking") }
}
class FourLeggedAnimal extends Animal {
  override def walk { println("I'm walking on all fours") }
}
class Dog extends FourLeggedAnimal {
  def walkThenRun {
    super.walk // works
    super[FourLeggedAnimal].walk // works
    //super[Animal].walk // error: won't compile
  }
}