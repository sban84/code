package main.scala.HackerRankTest

import scala.annotation.tailrec
import scala.math._

object Problem_2 {

  def main(args: Array[String]): Unit = {

    //println(solution(6000,7000))

   // println(solution(1))
  }


  def solution(n:Int) : Int= {


    if (n < 10 )
       n
    else {
      var n_string = n.toString
      if (n_string.length == 1)
        {
          return 0
        }
      val first_char = n_string.charAt(0).toString
      var multipler = new StringBuffer("1")
      for(i<- 0 until(n_string.length-1))
        multipler.append("0")

      val result = Integer.parseInt(multipler.toString) * first_char.toInt


      result
    }

  }


  def solution ( a : Int , b : Int): Int = {

    def maxSqrt(n : Double) : Int = {
      @tailrec
      def tailSqrt(n : Double, iter : Int) :Int={

        // if( sqrt(n) % 2 != 0.0)  iter
        if( sqrt(n) - floor(sqrt(n)) != 0.0)  iter

        else  tailSqrt(sqrt(n),iter+1)

      }
      tailSqrt(n,0)

    }
    var cnt = 0

    for ( i <- a until b+1){

      var x = maxSqrt(i)
      // println(maxSqrt(i))

      if (x>cnt)
        cnt = x
    }
    cnt
  }


}
