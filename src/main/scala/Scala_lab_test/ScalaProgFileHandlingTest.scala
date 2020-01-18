package main.scala.Scala_lab_test

import scala.io.{BufferedSource, Source}

/**
  * Created by suman.banerjee on 4/3/2017.
  * This program will help to understand how to read file and read lines
  * And also simple processing on those lines like calculate the size and the print only those lines whose size > input_width
  NOTE : always use val / var while assignment unlike Java where we define exact type while assignment
  */
object ScalaProgFileHandlingTest {
  def main( args: Array[String] ): Unit = {
    val fileName = """C:\Users\suman.banerjee\IdeaProjects\ScalaTest_2017\input.txt"""
    processLines(fileName , 20)
  }

  def readFileName(file : String) : BufferedSource = {
    val source = Source.fromFile(file)
    return source
  }

  def processLines(file : String , width : Int) : Unit = {
    val bfs = readFileName(file)
    val lines =  bfs.getLines()

    for(line <- lines if line.length > width)
      println(file + ":" + line.trim)

  }
}
