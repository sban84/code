package main.scala.Scala_lab_test

/**
  * Created by suman.banerjee on 3/28/2017.
  * For using command line arguments , do this
  * Run -> Edit Configuration -> Application (Select Application which need to be run)
  * -> program arguments
  */
object ScalaProgLoopTest {
  def main( args: Array[String] ): Unit = {
    whileTest(args)

    println("\n Extra code of using for loop  ====== >")
    forTest(args)

    //val greetStrings = new Array[String](3)
    // greetStrings = new Array[String](3) Not allowed as its of type val i.e. final in java
    //val greetStrings: Array[String] = new Array[String](3)  // way 2
    // val numNames = Array("zero", "one", "two")  // way 3

    //greetStrings(0)="Hello Scala"
    //print(greetStrings(0))
  }

  def whileTest( args: Array[String] ): Unit = {
    var i = 0

    println("Using while loop ====== >" + args + ":" + args.length)
    var str : String = args(0)
    while (i < str.length) {
      print(str.charAt(i) + ",")
      i = i + 1 // i++ will not work for var / val

    }

    println("\n Using for loop ====== >")
    for (arg <- str) {
      print(arg + ",")
    }

    println("\n Using foreach loop to Iterate the String array [ not elements ]====== >")
    args.foreach(( arg: String ) => print(arg + ","))
  }

  // This will extract the array and get the first element string and then iterate char by char
  // look at by 1 , we can use any increament
  def forTest(args : Array[String]) : Unit =
  {
    var str : String = args(0)
    //println("str is " + str)
    for(i <- 0 to str.length()-1 by 1)
    {
      print(str.charAt(i) + ",")
    }

  }
}
