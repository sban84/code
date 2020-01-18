package main.scala.Scala_CookBook.Chapter_4

/**
  * Created by suman.banerjee on 4/24/2017.
  */
object PrivateFieldTest extends App {

  val s1 = new Stock
  s1.setPrice(20)
  //println("accessing private using instance " + s1.price) // not allowed as Java
  val s2 = new Stock
  s2.setPrice(100)
  println(s2.isHigher(s1))


  val s3 = new Stock()
  // println("privatePrice " + s3.privatePrice) // not allowed to access outside from class

}

class Stock {
  // getter and setter methods are generated
  var delayedPrice: Double = _
  // keep this field hidden from other classes , // a private field can be seen by any Stock instance
  private var price: Double = _
  def setPrice(p: Double) { price = p }
  def isHigher(that: Stock): Boolean = this.price > that.price  // private will allow this

  // a private[this] var is object-private, and can only be seen by the current instance
  private[this] var privatePrice: Double = _
  //def isHigherThanPrivatePrice(that: Stock): Boolean = this.privatePrice > that.privatePrice // private[this] will not allow
}