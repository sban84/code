package main.scala.Scala_lab_test



/**
  * Created by suman.banerjee on 4/12/2017.
  */
object AbstractTest {

  def main( args: Array[ String ] ): Unit = {
    val concreteObject = new Concrete()
    var result  =  concreteObject.method(2)
    println(" result is >> " + result)
  }

}


trait Abstract {
  type T
  def method(x : T) : T
  val initial : T
  var current : T
}

/*
One reason to use a type member is to define a short, descriptive alias for a type whose real name is more verbose, or less obvious in meaning, than
the alias. Such type members can help clarify the code of a class or trait. The other main use of type members is to declare abstract types that must be defined in subclasses
Normally val can be overridden by def in subclass but "Abstract val" can not be overriden by def in subclass.
for details refer to :- page no 499 in "Programming in scala"
 */
class Concrete extends Abstract
{
  type T = Int  // this means anywhere T appears in this class , it will be Int only , So "type" keyword identifies alias ,

  def method(x: Int) : T = return (x + x)

  val initial: Int = 12
  var current: Int = initial
}