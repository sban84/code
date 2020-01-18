/*
package Scala_CookBook.Chapter_13_Concurrency

import scala.concurrent.Future
import scala.util.Random
import scala.concurrent.ExecutionContext.Implicits.global

object CloudApplication {

  def runAlgorithm(i:Int) : Future[Int] = Future {

    println("Running remote cloud application ")
    Thread.sleep(Random.nextInt(100)) // waiting for random time instead of finxed time interval.
    i + 10
   /* val f = Future {
      i + 10
    }
    return f*/
  }
}
*/
