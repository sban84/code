package main.scala.Scala_CookBook.Chapter_13_Concurrency

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

/*
refer https://www.credera.com/blog/credera-site/mastering-scala-futures/
 */

object Future_Program_5_FallbackTo {


  def main(args: Array[String]): Unit = {


    /*
    If we want to independently execute our futures in parallel and then collect their results,
    we must declare our Futures before the for loop and thereby start their execution prior to the for-yield
     */
    val sum1 = addNum(2,3)
    val sum2 = addNumThrowsError(1,20)
    val sum3 = addNum(1,2)




    // Now we can either run the Futures independently in parallel by for loop comprehension  or
    // we can run in sequentially by flatMap like shown:-

    val sum_final = for {
      r1 <- sum1
      r2 <- sum2
      r3 <- sum3
    } yield (r1 ,r2 , r3)  // sum_final will be of tuple

    sum_final.onComplete{
      case Success(result) =>{
        println("Success parallel execution " + sum_final )}
      case Failure(e) => println("Failed " + e)
      }

    // this is sequential flow
    val result = sum1.flatMap(s1=>{
      sum2.map(s2=> {
        sum3.map(s3 => {
          println(s"sum1,sum2,sum3 ($s1,$s2,$s3)")
          s1+s2+s3
        })
      })
    })

    result.onComplete{
      case Success(result) => println("seq result" + result)
      case Failure(e) => println("Failed " + e)
    }


    Thread.sleep(1000)
  }

  def addNum_default(): Future[Int] = {

    val f = Future{
      println("Inside addNum_default ")
      Thread.sleep(100)
      0
    }
    f
  }

  def addNum(a:Int , b:Int) : Future[Int] = {
    println("Inside addNum Future current thread " + Thread.currentThread())
    Thread.sleep(100)
    val f = Future {
      a + b
    }
    f
  }

  def addNumThrowsError(a: Int, b: Int) : Future[Int]  = {
    println("Inside addNumThrowsError Future current thread " + Thread.currentThread())
    Thread.sleep(100)
    if(a == -1)
      {
        throw new Exception("Failed to Execute this addition ")
      }
    else
      {
        val f = Future {
          a + b
        }
        f
      }


  }


}
