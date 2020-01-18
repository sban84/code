package main.scala.HackerRankTest

object Problem_1 {

  def main(args: Array[String]): Unit = {
    loopTest()
  }

  // i/p Array(2,5,3,4,6,7,9,8)
  //o/p (2,0),(3,2),(6,4),(9,6)

  def removeOddOndexedItems(array: Array[Int])={

    val array_with_index = array.zipWithIndex
    val array_with_oddIndexedItemremoved = array_with_index.filter(e=> e._2%2 ==0)

    array_with_oddIndexedItemremoved.foreach(e=> print(e._1 + ","))
  }
  def loopTest() = {
    val array = Array(1,2,3,4)

   /* for (i <- Range(0 , array.length)){  // this is same as our  for (i <- 0 until(array.length)){ better remember / use  for (i <- 0 until(array.length)){
      println(array(i))
    }

    // use this
    for (i <- 0 until(array.length)){
      println(array(i))
    }*/


    for (i<- 0 until(array.length)  ; j <- array.length -1  to(0) by -1 ){
      println("inside for loop >>>")
      println("i >> " + i)
      println("j >> " + j)
      //
    }

    var j = array.length -1
    for (i <- 0 until(array.length)){

      println(i)
      println(j)
      j -=1

    }
  }

}
