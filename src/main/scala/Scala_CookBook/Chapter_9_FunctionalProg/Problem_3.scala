package main.scala.Scala_CookBook.Chapter_9_FunctionalProg

/**
  * Created by suman.banerjee on 4/26/2017.
  *
  * Partial functions and functions returning function as return types
  *

}

  */
object Problem_3 extends App{

  val sum = (a: Int, b: Int, c: Int) => a + b + c
  val partialSum = sum(1,2,_:Int)
  println("sum >> " + sum(1,2,6))
  println("partialSum  >> " + partialSum(6))  // pass only the missing arg which is not present in original function partialSum

  def saySomething(prefix: String) : String =  {
    "hello " + prefix
  }

  def isEven(i: Int) = if (i % 2 == 0) true else false  // here return type is implicit
  /*def isEvenEasy(i:Int) : Boolean = {
    if(i%2==0) true
    else false
  }*/

}



/*
* Partial use case could be
  * def wrap(prefix: String, html: String, suffix: String) = {
prefix + html + suffix
  val wrapWithDiv = wrap("<div>", _: String, "</div>")
Now you can call the new wrapWithDiv function, just passing it the HTML you want to
wrap:
scala> wrapWithDiv("<p>Hello, world</p>")
res0: String = <div><p>Hello, world</p></div>
 */


