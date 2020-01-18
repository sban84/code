package main.scala.HackerRank_2019

import scala.collection.mutable.ArrayBuffer

//import import scala.collection.Searching._
object FindNumberInArray {

  def main(args: Array[String]): Unit = {

    /*val stdin = scala.io.StdIn
    val arCount = stdin.readLine.trim.toInt

    val array = new Array[Int](arCount)
    println("Enter the elements ")
    for (i <- 0 until(arCount)){
      array(i) = stdin.readLine.trim.toInt

    }

    println("Enter the item to search ")
    val number = stdin.readLine().trim.toInt*/


    val result = oddNumbers(3,9)
    println("result  " + result)

    for(i <- 0 until(result.length)){
      print(result(i) + " ")
    }
  }


  def oddNumbers(l: Int, r: Int): Array[Int] = {

    val a = 100000
    println(a)
    var arrayBuffer = ArrayBuffer[Int]()
    for (i <- l to(r)){
      if ( i%2 != 0)
        arrayBuffer.append(i)
    }
    println("odd " + arrayBuffer.toArray)
    return arrayBuffer.toArray
  }

  def findNumber(arr: Array[Int], k: Int): String = {

    var break = false
    val sorted_array = arr.sorted
    //sorted_array.search(k)
    for (i <- 0 until sorted_array.length if (break != true)){
      if (k < sorted_array(0) || k > sorted_array(sorted_array.length - 1))
        {
          break = true
          return "NO"
        }
      else if (k == arr(i)) {
        break = true
        return "YES"
      }

    }
          return "NO"
  }

}
