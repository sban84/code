package main.scala.Scala_CookBook.Chapter_12_FileHandling

object Program_2_Book_Meeting {

  def main(args:Array[String]) ={

    println("Enter input file name ")
    val fileName = scala.io.StdIn.readLine()

    readFile(fileName)


  }


  def readFile(fileName : String ) ={

    val buffedSource = scala.io.Source.fromFile(fileName)

    for (line <- buffedSource.getLines()){
      println("line " + line )

    }
  }

}
