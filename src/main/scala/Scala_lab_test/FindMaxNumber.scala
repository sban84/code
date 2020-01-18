package main.scala.Scala_lab_test

/**
  * Created by suman.banerjee on 3/28/2017.
  */
object FindMaxNumber {

  val a =10
  def main(args: Array[String]): Unit =
  {
    println("Program to find out max number between 2 input number")
    /*Scanner scanner = new Scanner(System.in)
    val x = scanner.nextInt()
    val y = scanner.nextInt()*/

    //println("Entered input is " + x + " and " + y)
    val x = Integer.parseInt(args(0))
    val y = Integer.parseInt(args(1))
   val result = max(x,y)
    println(" MAx is " + result)


  }

  def max(x: Int , y:Int): Int =
  {

    //if(x>y)?x:y
    if(x>y)
      x
      //return x
    else
      y
      //return y
  }

}
