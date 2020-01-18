package main.scala.Scala_CookBook.Chapter_3

import scala.annotation.tailrec

/**
  * Created by suman.banerjee on 4/22/2017.
  */
object TailRecursionTest {

  val list: List[Int] = List(1,2,3,4,5)
  def main ( args: Array[ String ] ): Unit = {
    /*println("sum using sumUsingRecusrtion >> " + sumUsingRecusrtion(list))
    println("sum using sumUsingTailRecursion >> " + sumUsingTailRecusrion(list))
    println("sum using sumUsingLooping >> " + sumUsingLooping(list))
    println("sum using sumUsingMap >> " + sumUsingMap(list))
    println("sum using sumUsingForeach >> " + sumUsingForeach(list))*/

    println("factorial using factorialUsingLoop " + factorialUsingLoop(6))
    println("factorial using factorialUsingRecirsion " + factorialUsingTailRecirsion(6))

    println("Fibo series Sun using Recursion " + fibo(4))
    println("Fibo series ")
    for (i <- 1 to 6)
      {
        print(fiboUsingTailRecursion(i) + " ")
      }


  }
  def sumUsingRecusrtion(list : List[Int]) : Int = {
    list match {
      case Nil => 0  // if there are no elements, then the sum is 0
      //case x :: tail => {print(x) ; print(" tail"  +tail); x + sumUsingRecusrtion(tail)} // for debugging
      case x :: tail => { x + sumUsingRecusrtion(tail)} //// if there is an element, add it to the sum of the tail
    }

  }

  /*def sumUsingRecusrtion(list : List[Int]) : Int = list match{
    case Nil => 0  // if there are no elements, then the sum is 0
    case x :: tail => {print(x) ; x + sumUsingRecusrtion(tail)} //// if there is an element, add it to the sum of the tail

  }*/

  def sumUsingTailRecusrion(list : List[Int]) : Int = {
    @tailrec
    def sumAccumulator(sum : Int , list : List[Int]) : Int = list match {
      case Nil => sum
      case x :: rest => sumAccumulator(x+sum , rest)
  }
    val result = sumAccumulator(0,list)
    return result
  }

  def sumUsingLooping(list:List[Int]) : Int ={
    var sum =0
    for(e <- list)
      {
        sum += e
      }
    sum
  }

  def sumUsingMap(list : List[Int]) : Int ={
    var sum=0
    val result = list.map(e => (sum+=e))
    sum // same as return sum
  }

  def sumUsingForeach(list : List[Int]) : Int ={
    var sum=0
    list.foreach(e=>(sum+=e))
    return sum
  }

  def factorialUsingLoop(n: Int) : Int = {
    var result =1
      for(i <- n to 1 by -1) {
        result = result * i
      }
      return result
  }


  def factorialUsingTailRecirsion(n:Int) : Long ={

      @tailrec
      def factorialAcc(result :Long, n:Int) : Long = n  match{
        case 1 => result
        case _ => factorialAcc(result * n , n-1)

      }
    factorialAcc(1 , n)
  }

  // another way of doing the same instead of using match / case
 /* def factorial(number: Int) : Int = {
    def factorialWithAccumulator(accumulator: Int, number: Int) : Int = {
      if (number == 1)
        return accumulator
      else
        factorialWithAccumulator(accumulator * number, number - 1)
    }
    factorialWithAccumulator(1, number)
  }*/

  /** Fibonacci series **/

  // Remember this , using recursion we can not get the series in the function , we need to call from externally , as shown here
  def fibo( n : Int) : Int = n match {
    case 0 | 1 => n  //  we can use if here
    case _ => fibo( n-1 ) + fibo( n-2 )
  }

  def fiboUsingTailRecursion(n:Int) : Int = {
    @tailrec
    def fib_tail(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => fib_tail(n-1 , b , a+b)
    }
    return fib_tail(n, 0 , 1)
  }
  // to generate the series in the function , we need to print inside the function , but this iterative algo.
  /*def fiboUsingLoop(n : Int) : Int ={

    var first = 0
    var second = 1
    var count = 0
    var sum =0

    while(count < n){
      sum = first + second
      //print(sum + " ")
      first = second
      second = sum
      count = count + 1
    }

    return sum // this  is just to return the last sum*/





}


