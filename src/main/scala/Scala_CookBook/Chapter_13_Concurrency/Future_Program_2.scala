package main.scala.Scala_CookBook.Chapter_13_Concurrency

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

import scala.collection.immutable.{List => MYLIST}

// REFER THIS ONLY FOR FUTURE example


object Future_Program_2 {

  def main(args: Array[String]): Unit = {
    //futureTest()

    futureTest_1


    // Continue with other computations
    Thread.sleep(500)
    println("Done with Logic 1 ")

    Thread.sleep(500)
    println("Done with Logic 2 ")
  }

  def futureTest() ={


    // this will be executed on other Thread
    val f = Future{
      Thread.sleep(1000)
      println("Inside Future ")
      1 +1

    }


    f.onSuccess {
      case value => println(" onSuccess " + value)
    }
    f.onFailure {
      case e => println("onFailure " + e.printStackTrace())
    }

    // another way of handling result from Future .
    f.onComplete {
      case Success(result) => println("onComplete Success case  " + result )
      case Failure(e) => println("onComplete Failure case  " + e )
    }



  }

  def futureTest_1 ={

    def longRunningComputation(i: Int): Future[Int] = Future {
      Thread.sleep(1000)
      i + 1
    }

    longRunningComputation(11).onComplete {
      case Success(result) => println(s"onComplete onSuccess $result" )
      case Failure(e) => println(s"onComplete Failure $e" )
    }

  }
}
