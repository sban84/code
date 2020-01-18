package main.scala.Scala_lab_test

import scala.io.Source

/**
  * Created by suman.banerjee on 4/3/2017.
  */
object ScalaProgWordCount {

  def main( args: Array[String] ): Unit = {
    var fileName = """C:\Users\suman.banerjee\IdeaProjects\ScalaTest_2017\input.txt"""
    //var fileName = Source.stdin.getLines().next()
    //wordCountWayOne(fileName)
    wordCountTest()

  }

  // groupBy will grp the keys and will make a List() of all such same elements .
  // then we can use mapValues , will just map the first item and with their values and to get the count in List() we need to do values.length
  def wordCountWayOne( file : String): Unit = {
    val lines = Source.fromFile(file).getLines()
    //val wc = lines.flatMap(line=>line.split(" ")).toList  // o/p is :-  word count program => List(hello, world, of, scala, is, really, mix, of, functional, and, object, oriented, programming, language., scala, is, good)
    //val wc = lines.flatMap(line=>line.split(" ")).toList.groupBy((word: String) => word)  // word count program => Map(is -> List(is, is), good -> List(good), world -> List(world), programming -> List(programming), oriented -> List(oriented), object -> List(object), mix -> List(mix), scala -> List(scala, scala), language. -> List(language.), hello -> List(hello), really -> List(really), functional -> List(functional), of -> List(of, of), and -> List(and))
    val wc = lines.flatMap(line=>line.split(" ")).toList.groupBy((word: String) => word).mapValues(values => values.length)

    println("word count program => " + wc)


    //val wcUsingMap = lines.flatMap(line=>(line.split(" "))).map(w=>(w,1)).collect()
    //println("word count program => " + wcUsingMap)
    //val wc = lines.flatMap(line=>line.split(" ")).toList.reduce((a,b) => a+b)  // will just append all the contents. there is no reduceByKey as Spark in scala it has only groupBy
  }

  //more example on words count...
  def wordCountTest( ): Unit ={
    // i/p is already in List , no need of flatMap , just apply groupBy
    val wordCountOnList = List("hello" , "scala" , "spark" , "hello" , "scala")
                          .groupBy(eachWord =>(eachWord)).mapValues(values => values.size)
    println("\nwordcount of String in List >>" + wordCountOnList)

    // i/p is lines in Array , So need of flatMap ,
    val str : Array[String] =  Array("hello,scala,spark,hello,scala")
    val wordCountOnStr = str.flatMap(lines=>(lines.split(","))).toList.groupBy(eachword => eachword).mapValues(values=> values.size)
    println("\nwordcount using flatMap for Array[String] >> " +wordCountOnStr)

    //  i/p is Raw lines , So need to convert to Array first using split then List and use groupBy.
    // OR we could have used flatMap on result of split i.e on Array

    val rawStr : String = "hello,scala,spark,hello,scala"
    val wordCountOnRawStr = rawStr.split(",").toList.groupBy(words => words).mapValues(value => value.size)
    println("\nwordcount of Raw Lines >> " +wordCountOnRawStr)

  }

}
