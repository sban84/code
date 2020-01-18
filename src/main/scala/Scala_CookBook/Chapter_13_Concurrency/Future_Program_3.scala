package main.scala.Scala_CookBook.Chapter_13_Concurrency

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}



/*
Exmaple of how to handle multiple webservice calls and then combine their result some point of time once all API returns .

 */
object Future_Program_3 {

  def main(args: Array[String]): Unit = {
    println("Main application started ")

    val obj = new CloudApplication()

    println("Time Before Future call  " + System.currentTimeMillis())

    // calling asyncronously
    println("Starting the Futures  ")
    val result_1 = obj.runAlgorithm(10)
    val result_2 = obj.runAlgorithm(20)
    val result_3 = obj.runAlgorithm(30)
    val result_4 = obj.runAlgorithm(40)



    // combine all the response from Future calls

    //Here sum_response will not be computed until all the Futures completes which is total minimum 700 ms.

    val sum_response = for {
       r1 <- result_1
       r2 <- result_2
       r3 <- result_3
       r4 <- result_4
    } yield ( r1+r2+r3+r4 )


    println("sum_respnse " + sum_response.isCompleted)
    sum_response.onComplete {
      case Success(result) => {
        println("Time After All Future call  " + System.currentTimeMillis())
        println(s"sum_response.onComplete success result $result " ) }
      case Failure(e) => println(s"sum_response.onComplete failure error $e " )
    }

    // keep the JVM alive

    Thread.sleep(3000)
    println("Main Exits now ... ")

  }

  /*def sum(w:Future[Int] ,x:Future[Int] ,y:Future[Int] , z:Future[Int]) : Future[Int] = {
    w.
  }*/

}

class CloudApplication {

  def runAlgorithm(i:Int) : Future[Int] = {

  println("Running remote cloud application ")
  //Thread.sleep(Random.nextInt(100)) // waiting for random time instead of finxed time interval.

    if (i ==10 || i == 20)
      Thread.sleep(100)
    if (i ==30 )
      Thread.sleep(200)
    if (i ==40 )
      Thread.sleep(300)

  //i + 10
   val f = Future {
     i + 10
   }
   return f
}
}

