package main.scala.Scala_lab_test

import java.io.File

import scala.io.Source

/**
  * Created by suman.banerjee on 3/30/2017.
  */
object ScalaProgFilterInFilesTest {

  //val fileList = List("C:\\Users\\suman.banerjee\\IdeaProjects\\ScalaTest_2017\\input.txt")
  val whereami = System.getProperty("user.dir")
  val fileList = (new java.io.File(".")).listFiles()
  def main( args: Array[String] ): Unit = {

    println("Current working dir >>> " + whereami)

    grep(".*scala.*")
  }

  /*def fileLines(file : File): List=
  {
    val fileLines = Source.fromFile(file).getLines().toList
    println("Inside fileLines >>> " + fileLines)
  }

  def grep(pattern : String): Unit =
  {
    for(
      file <- fileList
      if(file.getName.endsWith(".txt"));
        line <- fileLines(file)
      if line.matches(pattern)
    )println(file + ": " + line)
  }*/

  def fileLines(file: File) : List[String] ={
    Source.fromFile(file).getLines().toList
  }


  /*
  Power of "for" control statement in scala
  This will help us to iterate through the file list and filter with .txt extension
  and inner loop will iterate through lines in each file and second check will help to
  filter lines with ".scala"
  finally print.
   */
  def grep( pattern: String ) =
  {
    for (
      file <- fileList
      if file.getName.endsWith(".txt");
      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) {
      println(file + ": " + line.trim)
    }
  }
}
