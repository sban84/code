package main.scala.HackerRankTest

import scala.collection.mutable.ArrayBuffer

object HackerRankTestSolutions_1 {

  def main(args: Array[String]): Unit = {

    /*val user_input_firstline = scala.io.StdIn.readLine()
    val array_len = user_input_firstline.split(" ")(0)
    val num_swaps = user_input_firstline.split(" ")(1).toInt

    val user_input_secLine = scala.io.StdIn.readLine()
    val array = user_input_secLine.split(" ").map(e => e.toInt)*/

    largestPermutation(2 , Array(4 ,2 ,3 ,5 ,1))

  }

  def largestPermutation(k:Int , array: Array[Int]  ) :Unit={

    val array_buffer = new ArrayBuffer[Int]()
    //array.foreach(e=> println(e))
    //println(s"k ${k}" )

    var max_permuted = Integer.MIN_VALUE
    var splitted_array = array
    var j =1

    for (i <- 0 until(splitted_array.length) ; if (j <= k)){

      splitted_array.foreach(e=>print(e + " "))

      var max_number_array = splitted_array.max

      //var min_number_array = array.min

      var max_number_index = splitted_array.indexOf(max_number_array)
      var temp = splitted_array(0)
      //var min_number_index = array.indexOf(min_number_array)

      array_buffer.append(max_number_array)
      /*array(i) =  max_number_array
      array(max_number_index) = temp*/



      splitted_array(0) =  max_number_array
      splitted_array(max_number_index) = temp


      // THis is important it will devide the array into 2 parts and we are taking the second part for further processing
      splitted_array = splitted_array.splitAt(1)._2
      j += 1

      println("result after i  " + i)
      splitted_array.foreach(e=>print(e + " "))


    }

    println("array_buffer >>>>>>>> " + array_buffer)
    println("splitted_array " + splitted_array.length)
    if (array_buffer.length < array.length)
    splitted_array.map(e=>{
      array_buffer.append(e)
    })



    println("array_buffer >> " + array_buffer)

  }

}
