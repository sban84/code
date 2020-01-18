/*package Scala_CookBook.Chapter_13_Concurrency

import scala.collection.mutable.ListBuffer
import scala.concurrent.Future

object Future_Program_4 {

  def main(args: Array[String]): Unit = {
    val listOfFuturesOfInt : List[Future[Int]] = List(Future{
      Thread.sleep(100)
      1
    })


    val listOfFuturesOfList : List[Future[List[Int]]] = List.fill(5)(Future {
      List(1,2,3)
    }
    )
    // listOfFuturesOfList: List[scala.concurrent.Future[List[Int]]] = List(Future(Success(List(1, 2, 3))), Future(Success(List(1, 2, 3))), Future(Success(List(1, 2, 3))), Future(Success(List(1, 2, 3))), Future(Success(List(1, 2, 3))), Future(Success(List(1, 2, 3))), Future(Success(List(1, 2, 3))), Future(Success(List(1, 2, 3))), Future(Success(List(1, 2, 3))), Future(Success(List(1, 2, 3))))

    val listOfListOfString : List[List[String]] =  List.fill(3)(List("a","b"))

  }

  def returnListOfListofString(num: Int) ={


  }

}*/
