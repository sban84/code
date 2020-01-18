package main.scala.Scala_CookBook.Chapter_3

object ApplyTest {

  def main(args: Array[String]): Unit = {

    applyTesting("Developer")
  }

}


object applyTesting{

  val message = "Hello"
  def apply(str: String):String ={
    message + str
  }
}
