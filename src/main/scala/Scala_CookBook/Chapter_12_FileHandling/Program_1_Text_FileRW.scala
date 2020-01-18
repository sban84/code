package main.scala.Scala_CookBook.Chapter_12_FileHandling

import java.io.{FileWriter, PrintWriter}

import scala.collection.immutable.HashMap
import scala.io.Source


object Program_1_Text_FileRW {

  def main(args: Array[String]): Unit = {

    println("Enter File Name with full path ")
    //val fileName = scala.io.StdIn.readLine()
    val fileName = "/Users/sumanbanerjee/CODE_Reference/ScalaTest_2017/src/main/scala/Scala_CookBook/Chapter_12_FileHandling/inputFile.txt"
    readFile(fileName)

    //readFile_completeFile(fileName)

  }

  // This is better
  def readFile(fileName: String) = {

    val bufferedSource = scala.io.Source.fromFile(fileName)
    //var wordCountMap = HashMap[String,Int]()

    // Better to use when we needed to modify the existing Map , as for mutable after each add / remove it returns another Map
    // Which has to be re-initialized
    val wordCountMap_mutable = scala.collection.mutable.HashMap[String,Int]()

    for (lines <- bufferedSource.getLines()){ // this way it will process line by line

      //println("lines " + lines)

      val line_split = lines.split(" ")  // Array[String]

      // wordCount locally line by line
      val wordCount_in_each_line = line_split.map(e=>(e,1)).groupBy(e=>e._1).mapValues(e=> e.size)
      println("wordCount " + wordCount_in_each_line )

      // wordCount globally
      line_split.map(e=>{
        if (wordCountMap_mutable.contains(e)){
          println("exisitng key " + e)
          var incCurrentCount = wordCountMap_mutable.get(e).get + 1
          wordCountMap_mutable.put(e,incCurrentCount )
        }
        else{
          wordCountMap_mutable.put(e,1 )
        }
      })

      println("wordCountMap_mutable " + wordCountMap_mutable )

    }

    val printWriter = new PrintWriter(new FileWriter("/Users/sumanbanerjee/CODE_Reference/ScalaTest_2017/src/main/scala/Scala_CookBook/Chapter_12_FileHandling/outputFileWC.txt"))
    wordCountMap_mutable.keys.foreach(e=>{
      printWriter.write(s"word : $e and its Count : ${wordCountMap_mutable.get(e).get} \n")

    })
    printWriter.close() //close is must to force the flushing of printWriter
  }

  // This will load the entire file contents as one String , usefule sme one wants to process the complete files in
  // one go.
  def readFile_completeFile(file:String)={

    val line = Source.fromFile(file).getLines()  // retirns iTarable[String]
    //println("lines " + line.mkString )
    val lineStringArray = line.mkString.split(" ")
    val wordCountMap = lineStringArray.map(e=> (e,1)).groupBy(e=>e._1).mapValues(e=> e.size)
    println("Inside readFile_completeFile wordCountMap " + wordCountMap)

  }
}
