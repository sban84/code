package main.scala.Scala_CookBook.Chapter_3

/**
  * Created by suman.banerjee on 4/22/2017.
  */
object SwitchCaseTest {

  def main ( args: Array[ String ] ): Unit = {

    //swtchTest(10)
    //swtchTest(22)
    //swtchTest(9)

    switchTest_1(10)
    switchTest_1(100)

  }

  def swtchTest(x:Int) : Unit = {
    val result = x match {
      case x if(x == 10) => print("X is equal to 10")
      case x if(x>20) => println("X is greater than 20")
      case default => println("X is less than than 10")
    }
  }

  // without if in case , and also returing value
  def switchTest_1(x:Int) : Unit = x match {
    case 10 => {
      println("x is 10")

    }
    case 20 => {
      println(s"x is 20")

    }
    case _ => {
      println(s"x is unknown ")

    }

  }
}
