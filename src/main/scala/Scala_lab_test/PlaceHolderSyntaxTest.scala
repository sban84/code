package main.scala.Scala_lab_test

/**
  * Created by suman.banerjee on 4/4/2017.
  * Here we will see how a place holder is used in scala
  *
  *
  * Because filesMatching takes a function that requires two String arguments,
however, you need not specify the types of the arguments. Thus you could also write (fileName, query) => fileName.endsWith(query).
Since the parameters are each used only once in the body of the function, and since the first parameter, fileName, is used first in the body, and the second
parameter, query, is used second, you can use the placeholder syntax: _.endsWith(_). The first underscore is a placeholder for the first parameter,
the file name, and the second underscore a placeholder for the second parameter, the query string.
  *
  */
object PlaceHolderSyntaxTest {

  private def filesHere = (new java.io.File(".")).listFiles

  def main( args: Array[String] ): Unit = {
    withPlaceHolder("endsWith" , "txt")
    withPlaceHolder("contains" , "input")
    withPlaceHolder("matches" , "_2")

    println("Now without place holder ")
    withoutPlaceHolder("endsWith" , "txt")
  }

  def fileMatching( query: String , matcher: (String , String) => Boolean)  = {
    for (file <- filesHere;
         if matcher(file.getName, query))  // This can be written in single line also without using ;
      yield {
        println( "query is " + query + " and file name " + file )
      }
  }

  def withPlaceHolder( oprName : String , query : String ) : Unit = oprName match {
    //case "salt"   => param + " A"
    case "endsWith" => fileMatching(query , _.endsWith(_))
    case "contains" => fileMatching(query , _.contains(_))
    case "matches" => fileMatching(query , _.matches(_))
  }

  def withoutPlaceHolder(oprName : String , query : String) : Unit = oprName match {
    case "endsWith" => fileMatching(query , (fileName : String , query : String) => fileName.endsWith(query))
    case "contains" => fileMatching(query , (fileName : String , query : String) => fileName.contains(query))
    case "matches" => fileMatching(query , (fileName : String , query : String) => fileName.matches(query))
  }

}
