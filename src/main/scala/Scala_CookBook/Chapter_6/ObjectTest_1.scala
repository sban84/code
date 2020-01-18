package main.scala.Scala_CookBook.Chapter_6

object ObjectTest_1 {

  private val a:Int = 0
  protected val b : Int =10



  def main(args : Array[String]) ={

    val a = "hello"
    println("get class from String Object using getClass  " + a.getClass)

    println("get class from String Object using classOf " + classOf[String])


  }


  private def function_private(a:Int) : Unit ={
    println("inside function_private " + a)
  }

  protected def function_protected(a:Int) : Unit ={
    println("inside function_protected " + a)
  }

  private[this] def function_object_private(a:Int) ={
    println("inside function_object_private " + a)
  }

}
