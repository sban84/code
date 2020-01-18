package main.scala.Scala_CookBook.Chapter_9_FunctionalProg

import scala.collection.mutable.ArrayBuffer
object Program_5 {

  def main(args: Array[String]): Unit = {

    buyStuff(List("orange","mango"))
  }

  def buyStuff(itemList:List[String])={


    val closureTest = new ClosureTest()
    var arrayBuffer = ArrayBuffer[String]()
    //val arrayBuffer_1 = ArrayBuffer[ArrayBuffer[String]]
    //var list = List[String]

/*    for (i<- 0 until 3){
      arrayBuffer = closureTest.addToBasket("apple")
    }

    println("arrayBuffer "+  arrayBuffer.toList)*/
    itemList.map(e=>{
      println("e " + e)
      arrayBuffer = closureTest.addToBasket(e)

    })

    //println("finalList.size" + arrayBuffer.toList)
    arrayBuffer.foreach(e=> print(s"$e "))
  }
}
