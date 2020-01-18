package main.scala.CodilityTest

import scala.collection.mutable.ArrayBuffer

class Problem_2 {


  def findFactorsOfANum(N:Int):Int ={

    var factor_count =0
    for (i <- 1 to(N)){ // here to(N) is used as we need to run the loop till N .
      if (N % i == 0)
        factor_count += 1
    }
    factor_count
  }

  //https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/

  /*
  A(0) = 1    B(0) = 5
    A(1) = 3    B(1) = 6
    A(2) = 7    B(2) = 8
    A(3) = 9    B(3) = 9

   */
  def MaxOverlapping(a:Array[Int] , b:Array[Int]) : Int={
    if(a.length <1 ){
      return a.length
    }
    var result =1
    var prevEnd = b(0)
    for(i<- 1 until(a.length)){
      if(a(i) > b(i -1) || a(i) > prevEnd ){
        result +=1
        prevEnd = b(i)
      }
    }
    result
  }



  def countPeaksInArray(A : Array[Int]) : Int ={
    val N = A.length
    var counter =0
    for (i <- 1 until(N-1)){
      if (A(i) > A(i-1) && A(i) < A(i+1)){
        counter +=1
      }



    }
    counter
  }

  def findAllPrimeNum(N : Int) : Unit ={
    val array_buffer = ArrayBuffer[Int]()
    var i = 2
    while ( i < N){
      if ( i%2 != 0){
        array_buffer.append(i)
      }
      i += 1
    }
    println("prime numbers " + array_buffer)
  }




}

object MainApplication {
  def main(args:Array[String]) : Unit ={

    val instance = new Problem_2()
    val result = instance.findFactorsOfANum(24)
    println(s" result $result")

    val countPeaks = instance.countPeaksInArray(Array(1,5,3,4,3,4,1,2,3,4,6,2))
    println("countPeaks >>" + countPeaks)

    instance.findAllPrimeNum(24)
  }
}
