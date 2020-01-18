package main.scala.Scala_lab_test

import java.io.{File, FileNotFoundException, FileReader, IOException}

/**
  * Created by suman.banerjee on 4/3/2017.
  */
object ExceptionHandling {

  def exceptionTest( ): Unit = {
    try {
      val f = new FileReader("input123.txt")
      println(f)
      // Use and close file
    } catch {
      case ex: FileNotFoundException => println("File not found" + ex)
      case ex: IOException => println("IOException " + ex)
    }
    finally{
      println("Inside exceptionTest , Finally is called ")
    }
  }

  /*
  finally get called irrespective of try , catch executed
  So the value returned from finally block will override the value in try like here x.
  o/p = 2
  Same behavior in Java
   */
  def testOne( ): Int = {
    var x =0
    try
    {
      x = 1
      return x
    }
    finally{
      x = 2
      println("Inside testOne finally ")
      return x
    }
  }

  /*
  There is not throws clause like in Java. We need to use the @throws annotation.
  It’s important to note that Scala’s philosophy regarding checked exceptions is different than Java’s. Scala doesn’t require that methods declare that exceptions can be thrown, and it also doesn’t require calling methods to catch them
  Although Scala doesn’t require that exceptions are checked, if you fail to test for them, they’ll blow up your code just like they do in Java at runtime
   */
  @throws(classOf[FileNotFoundException])
  def testTwo(): Unit = {

    try{
      var file = new FileReader(new File("input123.txt"))
    }
    /*catch{
      case ex : FileNotFoundException => println("File not found " + ex)
        println("Caught and re throwing")
        throw ex
    }*/
  }

  def main( args: Array[String] ): Unit = {
    //val f = new FileReader("input123.txt")
    //exceptionTest()
    //var x = testOne()
   // println("value of x = " + x)

    try{
      testTwo()
    }
    catch{
      case ex : FileNotFoundException => println("Hello")
    }

  }

}


