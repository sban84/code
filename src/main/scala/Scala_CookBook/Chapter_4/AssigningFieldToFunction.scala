package main.scala.Scala_CookBook.Chapter_4

import scala.io.Source

/**
  * Created by suman.banerjee on 4/24/2017.
  */
object AssigningFieldToFunction extends App{

 val ins = new FileReadingTest()
  val textLines = ins.readLines()
  println(textLines)
}

class FileReadingTest
{
  val file = "C:\\Users\\suman.banerjee\\IdeaProjects\\ScalaTest_2017\\input.txt"
  def readLines() : String = {
    val bfs = Source.fromFile(file)
    val lines = bfs.getLines().mkString
    lines
    /*// way 1 ,
    for(line <- lines){
      println(line)
    }*/


    /*//another way of iterating lines
    println("bfs will be empty , so we need to create another one " + bfs.getLines())

    val bfsAgain = Source.fromFile(file)
    val linesAgain = bfsAgain.getLines()
    while(linesAgain.hasNext)
    {
      println(linesAgain.next())
    }*/

  }

}
