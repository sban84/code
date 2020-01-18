package main.scala.Functional_Prog_In_Scala.HackerRank_Test

import scala.collection.mutable.ListBuffer

class User_Input_Test {

  def getUserInput() : Unit ={

    println("Enter No. of Items ")
    val n = scala.io.StdIn.readInt()

    // we can use List but sice List is immutable so will create new List every time we add new item .
    val list_buffer = ListBuffer[Int]()

    for (i <- 0 until(n)){
      println("Enter the items in One line seperated by space ")
      val line = scala.io.StdIn.readLine()
      println(s"line entered $line" )

      val line_array = line.split(" ")
      line_array.map(e => {
        list_buffer.append(e.toInt)
      })

    }

    println(s"list_buffer >> ${list_buffer.toList}")
  }
}


object MainApplication  {

  def main(args:Array[String]) : Unit ={

    val instance = new User_Input_Test()
    instance.getUserInput()
  }
}
