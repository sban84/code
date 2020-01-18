package main.scala.Scala_CookBook.Chapter_13_Concurrency

import scala.concurrent.Await._
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Future_Program_1 {

  def main(args: Array[String]) : Unit ={


    implicit val baseTime = System.currentTimeMillis

    val f = Future {
      Thread.sleep(500)
      1 + 1


    }

    val result = Await.result(f, 1 second)
    println("result " + result)
    Thread.sleep(1000)

  }

}
