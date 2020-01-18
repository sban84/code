package main.scala.Functional_Prog_In_Scala.HackerRank_Test

import scala.collection.mutable

object Max_Sum_In_Array {

  def main(args: Array[String]): Unit = {

  /*  val array = Array(2,1,3,5,-2,-2,1) // 9
    val array_test_2 = Array(3, -1, -1, -1, -1, -1, 2, 0, 0, 0)
    val array_test_3 = Array(-1, 3, -5, 4, 6, -1, 2, -7, 13, -3)
    calculateMaxSumInArray(array_test_3)

    find_second_max_item(array)

    findDuplicatedItemAndItsCount(array)*/

    //
    // findFirstDuplicate(Array(1, 2, 1, 2, 3, 2, 2, 2, 10))
    findFirstDuplicate_1(Array(100, 10, 1, 2, 3, 2, 2, 2, 10))
  }

  def calculateMaxSumInArray(array: Array[Int]) ={

    var max_till_now = 0 // temp
    var max_sum = Integer.MIN_VALUE // final result
    var start_index = 0
    var end_index = 0

    array.map(e=>{

      max_till_now = max_till_now + e //keeping sum for each item internally.

      println("item " + e)
      if (e > max_till_now){

        start_index =  array.indexOf(e)
        max_till_now = e
        //println(s"inside e > max_sum $max_sum and $start_index")
      }
      if (max_till_now > max_sum){
        max_sum = max_till_now
        end_index = array.indexOf(e)
        //println(s"inside max_till_now > max_sum $max_sum and $end_index")
      }
    })

   println(s"maximum sum in the array $max_sum and index from $start_index to $end_index")
  }

  def find_second_max_item(array: Array[Int])={

    val sorted_array = array.sortWith((x,y) => x > y) // descending order
    sorted_array.foreach(e=>print(e + " "))
    val second_max = sorted_array(1)
    println("\n second_max " + second_max)
  }

  def findDuplicatedItemAndItsCount(array: Array[Int]) ={

    val item_count_map = array.groupBy(e=>e)

    val map_mutable = mutable.HashMap[Int,Int]()
    array.map(e=>{
      if (map_mutable.contains(e)){
        map_mutable.put(e,(map_mutable.get(e).get + 1))
      }
      else{
        map_mutable.put(e,1)
      }

    })

    println(s"mutable_map $map_mutable")
    /*map_mutable.keys.foreach(e=>{
      print(s"Item $e and its count is ${map_mutable.get(e).get}")
    })*/

    val map_with_filter = map_mutable.filter((t) => t._2 >=2)  // here  t is tuple type , and we can make use of that t._1 and t._2 , _2  is for value
    val map_with_filter_1 = map_mutable.filter((t) => t._1 >= 3 && t._1 <=5) // just to understand how this tuple is working , _1  is for key
    // on filtering map key and values

    println(s"map_with_filter $map_with_filter")
    println(s"map_with_filter_1 $map_with_filter_1")



    // if we wanted to count just duplicate item and dont want each eletemts count then we dont have to use HashMap extra.
    // Basically its same in map solution to filter value >= 2
    println("Total Duplicate item_count in a Array  ")
    val sorted_array = array.sorted
    //sorted_array.foreach(e=>print(e))

    var duplicate_item_count = 0
    for (i <- 0 until sorted_array.length -1 ){
      if (sorted_array(i).equals(sorted_array(i+1))){
        duplicate_item_count += 1
      }
    }

    println("Total duplicate_item_count  " + duplicate_item_count)

  }

  // Version 1 : here we can not sort , because after sort the index will change
  def findFirstDuplicate(array : Array[Int])={

    var runFlag= true
    for (i<- 0 until(array.length -1) if (runFlag == true)){

      for (j <- i+1 until(array.length) if (runFlag==true)){

        if (array(i) == array(j)){
          print(s"first duplicate ${array(i)} and index = $i")
          runFlag=false
        }

      }
    }
  }

  def findFirstDuplicate_1(array:Array[Int]) ={

    val linked_map = scala.collection.mutable.LinkedHashMap[Int,Int]()
    array.map(e=>{

      if (!linked_map.contains(e)){
        linked_map.put(e,1)
      }
      else{
        linked_map.put(e,linked_map.get(e).get +1 )
      }
    })

    var runFlag=true
   for (i <- 0 until(linked_map.size) if runFlag== true){

     linked_map.keys.foreach(e=>{
       if (linked_map.get(e).get > 1 ){
         println(s"first Duplicate found item $e and count is ${linked_map.get(e).get}")
         runFlag = false // break the loop as we wanted to stop after wee founf first duplicate , else no need
       }
     })
   }
  }
}

/*
 for (i<- 0 until array.length){

        println("item " + array(i))
        max_till_now = max_till_now + array(i)
        if (array(i) > max_sum){
          println("ins")
          max_sum= array(i)
          start_index = i
        }
        if (max_till_now > max_sum){
          max_sum = max_till_now
          end_index = i
        }
      }
 */
