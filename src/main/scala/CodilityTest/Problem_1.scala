package main.scala.CodilityTest

import scala.collection.mutable.ListBuffer

// Refer Array_Program_1.scala also
//=================================

object Problem_1 {

  def main(args: Array[String]): Unit = {

    val array = Array(3,1,2,4,3)
    //solution(array)
    //solution_1(3)

    //finsOddOccurences(Array(2,2,3,4))

    //findFirstUniqItem(Array(2,3,2,4))

    //findNumberOfJumps(10 , 85 , 20)

    findMissingItem(Array(1,3,2,5))

    findMissingItem_1(Array(-1,-3))

    findDistinctItemsArray(Array(2,1,1,2,3,1))

    findMaximumProduct(Array(-3,1,2,-2,5,6))

    println(s"findTriangleInArray(Array(10,2,5,1,8,20)) >> ${findTriangleInArray(Array(10,2,5,1,8,20))}" )
    println(s"findTriangleInArray(Array(10,50,5,1)) >> ${findTriangleInArray(Array(10,50,5,1))}" )


    findUniqueItemsInStr("abcdab")
  }



  /*
  An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.

Write a function:

object Solution { def solution(a: Array[Int]): Int }

that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:
   */
  def findTriangleInArray(array: Array[Int]) : Int ={

    val A = array.sorted
    var found = 0
    for (i <- 0 until(A.length -2 ) )
    {
      if ((A(i).asInstanceOf[Long] + A(i + 1).asInstanceOf[Long] > A(i + 2)) && (A(i + 1).asInstanceOf[Long] + A(i + 2).asInstanceOf[Long] > A(i)) && (A(i).asInstanceOf[Long] + A(i + 2).asInstanceOf[Long] > A(i + 1))) {
        found = 1
      }
    }

    found
  }

  def findMaximumProduct(array: Array[Int]):Int={
    val sorted_array = array.sorted
    val len = sorted_array.length
    val max_product = sorted_array(len-3) * sorted_array(len-2) * sorted_array(len-1)

    println(s"max_product $max_product")
    max_product
  }


  def findDistinctItemsArray(array: Array[Int]):Int={

    val distinct_array = array.distinct
    println("distinct item count  >> " + distinct_array.length)
    distinct_array.size
  }


  /*
  count the number between a and b which can be divided by k
   */
  def countDiv(a: Int , b : Int , k : Int):Int ={

    var counter = 0
    for(i <- a to b ) {
      if (i % k ==0){
        counter +=1
      }

    }
    counter
  }

  /*/
  Find min avg in the array pairing 2 item

  https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
   */

  /*def findMinAvg(array: Array[Int]) : Int ={

    var start_index = 0
    var end_index =0
    var  min_avg =0
    var temp =0
    for (i<- 0 until(array.length -1 )){
      for (j <- i +1 until(array.length)){

      }

    }
  }*/
  /*
  In this case we can handle -ve numbers .
   */
  def findMissingItem_1(array: Array[Int]):Int ={

    val set = scala.collection.mutable.HashSet[Int]()
    array.map(e=>{
      set.add(e)
    })

    println("set >> " + set)
    var missing_item = 0
    var found_first_missing_flag = false
    for (i <- 1 until(array.length + 1)) {
      println(i)
      if (!set.contains(i) && found_first_missing_flag == false){
        missing_item =  i
        found_first_missing_flag = true
      }
    }
    println(s"missing_item >> $missing_item")
    missing_item
  }


  // Find the missing elemtnt in the array
  def findMissingItem(array: Array[Int]):Unit ={
    val sorted_array =array.sortWith((a,b) => a < b)
    //sorted_array.foreach(e=>print(e + ","))

    val first_item = array(0)
    val last_item = array(array.length -1)

    val range_list = Array.range(first_item , last_item+1)
    //range_list.foreach(e=>print(e + ","))

    val diff = range_list.diff(array)
    if (diff.size > 0){
      diff.foreach(e=>println(e))
    }

  }


  /*
  Write a function:
object Solution { def solution(x: Int, y: Int, d: Int): Int }
that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
For example, given:
  X = 10
  Y = 85
  D = 30
the function should return 3
   */

  def findNumberOfJumps(x:Int , y:Int , d:Int):Int ={

    var curr_pos = x
    var jump_count =0
    while(curr_pos < y){
      curr_pos= curr_pos + d
      jump_count +=1
    }
    println("curr_pos >> "+ curr_pos)
    println(s"jump_count >> $jump_count " )
    jump_count
  }



  /*
  Find Odd Occurences
  https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/

   */

  def finsOddOccurences(array: Array[Int]) : Unit ={

    val array_map = array.groupBy(e=>e)

    /*
    val oddOccurenceNum = array_map.values.map(e=>(e,e.size)).filter(e=>e._2%2 != 0).map(e=>e._1).map(e=>e(0)) // return Iterable[Int ] = List(5,4)
     oddOccurenceNum.foreach(e=>{
      print(e + ",")
    })
     */

    val oddOccurenceNum = array_map.values.map(e=>(e,e.size)).filter(e=>e._2%2 != 0).map(e=>e._1).map(e=>e(0)).toList(0) // VERY GOOD TO REMEMBER , how we are converting Iterable to List and getting individual irems .


  }

  /*
  In last finsOddOccurences , the order is not guranteed and we will not get the first occurence.
  But if we wanted to get the first occurence of the duplicate / uniquie in Array /List
   */

  def findFirstUniqItem(array: Array[Int]) : Unit ={
    val linkedHaskMap = scala.collection.mutable.LinkedHashMap[Int,Int]()

    array.map(e=>{
      if (linkedHaskMap.contains(e)){
        linkedHaskMap.put(e,linkedHaskMap.get(e).get +1 )
      }
      else{
        linkedHaskMap.put(e,1)
      }
    })

    linkedHaskMap.keys.foreach(e=>{
      println(s" key is $e and value is ${linkedHaskMap.get(e).get}")
    })

    val firstUniqueItem = linkedHaskMap.filter(t=>t._2%2 != 0).take(1).map(e=>e._1)


    firstUniqueItem.foreach(e=>println(e))
    //println(s"firstUniqueItem $firstUniqueItem")

    println(s"firstUniqueItem.toList(0) ${firstUniqueItem.toList(0)}") // REMEBER TO GET VALUES FROM COLLECTIONS . just use toList
  }


  /*
  Find the number of max 0 in between 1 of a number . Max Binary Gap
  Can be done using normal loop but this is good and efficient
   */
  def solution_1(N: Int): Unit ={
    println(Solution_2(N >>> Integer.numberOfTrailingZeros(N), 0, 0))
  }

  def Solution_2(n:Int, max : Int, current : Int):Int= {
    if (n == 0) return max
    else if ((n & 1) == 0) return Solution_2(n >>> 1, max, current + 1)
    else return Solution_2(n >>> 1, Math.max(max, current), 0)

  }

  // this is to find the min of the list when divided into splits
//https://app.codility.com/demo/results/trainingDJMURT-X7F/

  def solution(a: Array[Int]): Unit = {
    // write your code in Scala 2.12

    var min_diff = Integer.MAX_VALUE

    for (i <- 1 until(a.length)){
      val split_array = a.splitAt(i)
      val part_1 = split_array._1
      val part_2 = split_array._2

      val diff = Math.abs(part_1.sum - part_2.sum)
      if (diff < min_diff){
        min_diff = diff
      }
    }
    println("min_diff " + min_diff)


  }


  def findUniqueItemsInStr(str:String) : Unit ={
    val unique_list_key = ListBuffer[Char]()
    val unique_list_value = ListBuffer[Int]()
    val uniqueMap = str.groupBy(e=>e).map(e=>(e._1,e._2.size)).filter(e=>e._2%2 != 0)

    uniqueMap.keys.foreach(e=>{
      unique_list_key.append(e)
      unique_list_value.append(uniqueMap.get(e).get)


    })

    println("unique_list_key >> " + unique_list_key )
    println("unique_list_value >> " + unique_list_value )


  }


}
