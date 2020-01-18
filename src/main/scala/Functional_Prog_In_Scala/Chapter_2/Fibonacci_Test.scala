package main.scala.Functional_Prog_In_Scala.Chapter_2

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

/*
Refer this only
 */
object Fibonacci_Test {

  def main(args: Array[String]): Unit = {

      //Task_1 : Print the Series upto N
    val result_series = ArrayBuffer[Int]()
    val n = 4
    derive_fibonacci_series(4 , result_series )
    println(s"\n Series upto $n is ${result_series.take(n)}")

    // Task2# : Print the Nth number of the series
    println(s"\n $n th number of the series  is ${result_series(n -1 )}")

    // Task3# : Print the next number of the series

    println(s"\n $n th number of the series  is ${result_series(n  )}")

  }

  /*
Write a recursive function to get the nth Fibonacci number (http://mng.bz/C29s). The first two Fibonacci numbers are 0 and 1. The nth number is always the sum of the previous two—the sequence begins 0, 1, 1, 2, 3, 5. Your definition should use a local tail-recursive function.
 */
  // 0 1 1 2 3 5 8 13 21
  def derive_fibonacci_series(n : Int , result_series: ArrayBuffer[Int]) : Int ={
    var sum =0
     // This is required if first number of the series printing is needed , in that case we need to print prev

    var firstNumOfSeriesPrinted = false

    def fib_accum(prev:Int,cur:Int,n:Int):Int ={


      if (firstNumOfSeriesPrinted == false){
        print(s"$prev ")
        result_series.append(prev)
        print(s"$cur")
        result_series.append(cur)
        firstNumOfSeriesPrinted = true
      }

      // actual logic started.
      if (n==0 ) {
        return sum
      }
      //if (n==1)  return 1
      else
      {
        sum = prev+cur
        print(s" $sum ")
        result_series.append(sum)
        fib_accum(cur,sum,n-1)
      }

    }
    fib_accum(0,1,n) // control whether to print 0 as starting number or not.
  }


  // using tail-recursion

  def fiboUsingTailRecursion(n:Int) : Int = {
    @tailrec
    def fib_tail(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => fib_tail(n-1 , b , a+b)
    }
    return fib_tail(n, 0 , 1)
  }

}

