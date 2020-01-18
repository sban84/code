package main.scala.collection

import scala.collection.mutable.ArrayBuffer

/**
  * Created by suman.banerjee on 4/11/2017.
  */
object ArrayTest {

  def main( args: Array[ String ] ): Unit = {
    val arrBuff : ArrayBuffer[Int] = new ArrayBuffer[Int]()
    arrBuff += 2
    arrBuff += 3
    arrBuff += 4
    arrBuff ++= List(11,12,13)
    println("ArrayBuffer contains >> " + arrBuff)
  }



}
