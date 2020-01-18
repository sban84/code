package main.scala.Scala_CookBook.Chapter_5

/**
  * Created by suman.banerjee on 4/24/2017.
  */
object MethodTest extends App{

  val s1 = new Stock("stock1")
  s1.increasePrice()
  println("After increase " + s1.price)

  s1.increasePrice(3)
  println("After increase " + s1.price)
  println("Stock Name  " + s1.getName)

  // Test 2 # same as varagrs in Java

  printAll("foo", "bar")
  printAll("foo", "bar", "baz")
  def printAll(strings: String*) {
    strings.foreach(println)
    /*for (s<-strings){  // another way of looping in String
      println(s)
    }*/
  }

  //Test 3 #
  // a sequence of strings
  val fruits = List("apple", "banana", "cherry")
  // pass the sequence to the varargs field
  printAll(fruits: _*)

  // Test 4 # fluent - style methods.
  val p = new Pizza
  p.setCrustSize(14)
  .setCrustType("thin")
  .addTopping("cheese")
  .addTopping("green olives")
  .print()

  // Test 5 # to check the class at run time
  def printClass(c: Any) :Any = { println(c.getClass) ; return c.getClass }
  printClass(s1)


}

class Stock(val name:String)
{
  var price : Double =0.0
  def increasePrice(incr : Double = 1.0) : Double ={  // default increament
    this.price += incr
    price
  }

  def getName = name  // parentheses less getter method  , normally no need to write as Scala does that for us for var and val params and we can access that by s1.name only
  override def toString: String = s"name $name and price $price"

}


//fluent - style methods :-

final class Pizza {
  import scala.collection.mutable.ArrayBuffer
  private val toppings = ArrayBuffer[String]()
  private var crustSize = 0
  private var crustType = ""
  def addTopping(topping: String) = {
    toppings += topping
    this
  }
  def setCrustSize(crustSize: Int) = {
    this.crustSize = crustSize
    this
  }
  def setCrustType(crustType: String) = {
    this.crustType = crustType
    this
  }
  def print() {
    println(s"crust size: $crustSize")
    println(s"crust type: $crustType")
    println(s"toppings: $toppings")
  }
}