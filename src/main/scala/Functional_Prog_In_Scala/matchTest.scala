package main.scala.Functional_Prog_In_Scala

object matchTest {

  def main(args: Array[String]): Unit = {
    testMatch(true)
  }

  def testMatch(a:Boolean) = a match {
    case true => {println("inside first true") ; println("inside sec true") }

    case false => println("inside first false")
    case _ => println("inside first _")
  }

}
