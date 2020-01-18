package main.scala.Scala_lab_test

import scala.io.Source

/**
  * Created by suman.banerjee on 3/28/2017.
  * Code is just to show how file reading can be done in scala
  * it will add the line length along with complete line
  */
object ScalaProgFileInputTest {

  def main(args : Array[String]): Unit =
  {
    println("Please Enter File Name with Path")
    var fileName = Source.stdin.getLines().next()
    //var fileName = ""
    if(args.length > 0)
      {
        fileName = args(0)
        fileTest(fileName)
      }
    else
      {
        //println("Enter the File Name ")
        Console.err.println("Please enter filename")
      }
  }

  def fileTest(file : String): Unit =
  {
    for(line <- Source.fromFile(file).getLines())
      print(line.length + " " + line)

  }
}
