package main.scala.Functional_Prog_In_Scala.Chapter_2

object FactorialNumber {



  def main(args: Array[String]): Unit = {

// Test 1 # simple

    //println("Enter a number to calculate factorial")
      //val n = scala.io.StdIn.readInt()
    //val result = factorial(n)
    //println(s"Factorial of $n is $result")

    // Test2 # get user ip and call factorial till use willing to exit.
    getChoiceAndCalFactorial()


  }

  def factorial(n:Int) :Int= {

    var result :Int =0


    def factAccum(result :Int, n:Int): Int ={
      if (n ==0 || n== 1)
        return result
      else
      {
        factAccum((result * n) , n - 1)
      }
    }

    factAccum(1,n)

  }


  // REMEMBER this when we wanted to get user i/p till willing to  exit , This is scala way of doing , no need to use do while loop.
  def getChoiceAndCalFactorial(): Unit = {

    println("Enter a number to calculate factorial ( Enter -1 to exit )" )
    //val line = scala.io.StdIn.readLine()
    val line = scala.io.StdIn.readDouble()
    //val input = findDataType(line) // this is to identify the type if required

    line match {
      case -1 => println("Exiting the program ") ;System.exit(0)
      //case "2" => println("Not implemented"); line
      case _ => println("Received " + line); {
        val n = line.toInt
        val result = factorial(n)
        println(s"Factorial of $n is $result")
        //done with factorial for this number , prompt again
        getChoiceAndCalFactorial()
      }
    }
  }


  // More additional check if we wanted to check data type of user input

  def findDataType(x: Any) : Int= x match {
       case x : String => {println("String identified"); x.split("\\.")(0).toInt}
       case x : Int => println("Integer identified"); x
       case x : Float => println("Float identified"); x.toInt
       case x : Double => println("Double identified"); x.toInt
       case _ => println("DataType not identified"); -1;
     }



}

// All variables in Scala has to be defined ,
// x:Int
// x =1 is not possible
/*class test
{
  val x : Int =0
}*/
