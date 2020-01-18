package main.scala.Scala_lab_test

import java.lang.Thread.sleep

/**
  * Created by suman.banerjee on 3/27/2017.
  */
object PassingFuctionIntoAnother {

  def main(args: Array[String]): Unit =
  {
    println("Inside Main ")
    timerFunction(someWork)
  }

  def someWork(): Unit =
  {
    println("Doing my work")
  }

  def timerFunction(func: () => Unit): Unit =
  {
    while(true)
      {
        func()
        println("I will sleep for 1 sec")
        sleep(1000)
      }
  }
}
