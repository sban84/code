package main.scala.Scala_CookBook.Chapter_3

object LoopOperation_1 {

  def main(args:Array[String] ):Unit = {

    val array = Array(1,2,0,10,12,11)

    printColUsingForLoop(array)

    print(testYield())

  }

  def printColUsingForLoop(array: Array[Int])={
    println("Array Elements ")
    for (i <- array)
      println(i)
  }

  def printColUsingForLoopStringInterpolarion(array: Array[Int])={
    println("Array Elements ")
    for(i <- 0 until array.length )
      print( "index " + s"$i " + " and element " + s"${array(i)}")

  }


  def printCollAndReturnNewArray(array: Array[Int])={
    for (i <- array) yield {
      val result  = i * 10
      result
    }
  }


  // Example to see how for loop can return value
  def testYield(): Unit ={
    val a = Array("apple", "banana", "orange")
    val new_array = for (i <- a) yield {
      val result = i.toUpperCase
      result
    }
    for (e <- new_array){
      println(e)
    }
  }

}
