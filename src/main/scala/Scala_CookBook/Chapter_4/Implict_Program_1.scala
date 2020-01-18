package main.scala.Scala_CookBook.Chapter_4

object Implict_Program_1 {

  def main(args:Array[String]):Unit ={
    implicitParamTest()
  }

  def implicitParamTest()={

    implicit val num = 10

    fun

  }

  def fun(implicit a:Int): Int ={
    a +1
  }
}
