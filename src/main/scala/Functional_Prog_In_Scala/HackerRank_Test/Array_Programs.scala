package main.scala.Functional_Prog_In_Scala.HackerRank_Test

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
object Array_Programs {

  def main(args: Array[String]): Unit = {

    val array = Array(2,3,1,4,3,3)
    println(" findFirstDuplicateInArray(array) " + findFirstDuplicateInArray(array).get)

    println("findFirstDuplicateInArray_usingRecursion(array) " +  findFirstDuplicateInArray_usingRecursion(array).get)


    /*findFirstDuplicateInArray_usingAPI(array)

    val array_String = Array[String]("bca" , "cab" , "aaa" , "aab")
    sortStringItemsInArray(array_String)*/

    //findSumNonCensequitiveIndex(array)

    //val array_1 = Array(1,3,0,4,5,7)
    //findPairForAGivenNum(array_1,7)

    /*val array_2 = Array[Int](10, 22, 9, 33, 21, 50, 41, 60, 80)
    longestIncSeriesInArray(array_2)*/

    println("findDominator(Array(1,2,1,1,3)) >> " + findDominator(Array(2,2,1,1,3)))

    findDuplicateWithIndex(Array(10,9,1,2,1,3,2))
    findDuplicate(Array("a","b","c","d","c"))
  }

  def findFirstDuplicateInArray(array: Array[Int]) : Option[Int] = {

    val sorted_array = array.sorted // dont do sorting if index also need to print but that will take O(n^2)
    var first_duplicate = None : Option[Int]

    var stop = false // better not to use break in scala
    try{

      for (i <- 0 until sorted_array.length -1 if(stop == false) ){ // we can use & stop == false
        if (sorted_array(i).equals(sorted_array(i+1))){
          first_duplicate = Some(sorted_array(i))
          stop = true
        }

      }
      first_duplicate
    }
    catch {
      case e :Exception => {
        println("breaking here " + e.getMessage)
        first_duplicate
      }
    }
  }

  // This is very useful to undertsand how recursion powerful for doing any calculation on List . this is without sorting
  // and O(N) one iteration

  def findFirstDuplicateInArray_usingRecursion(array: Array[Int]) : Option[Int] ={

    val currElement = None : Option[Int]
    val prevElement = None : Option[Int]

    val list = array.toList

    @tailrec
    def findAccum(prevElement : Option[Int]  , list: List[Int]) : Option[Int] = list match {

      case List() => prevElement
      case xs :: tail => {
        //println("xs " + xs )
        //println("prevElement " + prevElement )
        if (prevElement != None && xs.equals(prevElement.get)){
          //println(s"found duplicates  $prevElement and $xs" )
          return prevElement
        }
        else{
          findAccum(Some(xs),tail)
        }
      }
    }
    findAccum(None,list)
  }


  def findFirstDuplicateInArray_usingAPI(array: Array[Int])={
    val distinct = array.distinct
    val diff = array.diff(distinct)

    println("duplicated items " )
    diff.foreach(e=>print(e + " "))
  }

  // Duplicate with index , so can not sort , we need for as map will not give the next item , its only for each item to process one at a time
  def findDuplicateWithIndex(array : Array[Int])={
    var runFlag= true
    for (i <- 0 until(array.length -1 ) if runFlag == true){
      for (j <- i+1 until(array.length ) if runFlag == true ){
        if (array(i) == array(j))
          {
            runFlag = false
            println(s"first duplicate ${array(i)} and index $i")
          }
      }
    }
  }

  // Duplicate only , Sort , performance will be fast

  def findDuplicate(array: Array[String])={
    val sorted_arr = array.sorted
    println(s"${sorted_arr.toList}")
    var runFlag = true
    for(i <- 0 until(sorted_arr.length -1 ) if (runFlag == true)){
      if (sorted_arr(i) == sorted_arr(i+1)){
        runFlag= false
        println(s"first duplicate ${sorted_arr(i)}" )
      }
    }
  }


  def sortStringItemsInArray(array: Array[String])= {

    // items will sorted among themselves
    val sorted_array = array.sortWith((x,y) => x < y) // o/p aaa aab bca cab
    println("Array with Sorted String ")
    sorted_array.foreach(e=>print(e + " "))

    // now sort the individual items also .
    println("With individual Sorted String ")
    val listBuffer = ListBuffer[String]() // we can use ArrayBuffer also here , we just need mutable collection
    sorted_array.map(e=>{
      listBuffer.append(e.sorted)

    })

    println(" listBuffer with items are also sorted " + listBuffer)
  }

  def findSumNonCensequitiveIndex(array: Array[Int]) = {

    var sum_of_non_consequitive_index = 0

    for ( i <- 0 until array.length by 2){
      println(s"index $i and item ${array(i)}" )
      sum_of_non_consequitive_index += array(i)

    }

    println(" sum_of_non_consequitive_index " + sum_of_non_consequitive_index)
  }

  def findPairForAGivenNum(array: Array[Int] , num : Int) ={

    val sorted_array = array.sorted
    var i=0
    var j = sorted_array.length - 1
    val listBuffer = ListBuffer[(Int,Int)]()

    while(i < j) {

      println(s"sorted_array(i) ${sorted_array(i)} and sorted_array(j) ${sorted_array(j)}")

      if (sorted_array(i) + sorted_array(j) == num){
        println("Found one pair ")
        listBuffer.append((sorted_array(i),sorted_array(j)))
        j -= 1
        i += 1

      }
      else if (sorted_array(i) + sorted_array(j) > num){
        println("Found greater ")
        j -= 1
      }

      else if (sorted_array(i) + sorted_array(j) < num){
        println("Found lesser ")
        i += 1
      }
    }
    println("listBuffer " + listBuffer)

    //just to test something
  /*  val takeFirst =  listBuffer.take(1)
    takeFirst.map(e => print(e._1 + " and " + e._2))*/
  }

  /*def longestIncSeriesInArray(array: Array[Int]) ={
    var last_num = Integer.MIN_VALUE
    var listBuffer = ListBuffer[Int]()

    array.map(e=>{
      println("e " + e)
      //last_num = e
      listBuffer.append(e)
      if (e < listBuffer(listBuffer.length -1 )){
        println("found item less than last elememt in list buffer ")
        listBuffer.clear()
        listBuffer.append(e)
      }
      if (e > listBuffer(listBuffer.length -1 ) ){
        println("found item greater than last elememt in list buffer ")
        listBuffer.append(e)
      }

    })

    println("listBuffer " + listBuffer)

  }*/


  // Find the item which appears more than half of the number of items in the array

  def findDominator(array: Array[Int]):Int = {

    val array_grouped = array.groupBy(e=>e).map(e=>(e._1,e._2.size))


    val  item_with_max_appearance = array_grouped.filter(t => t._2 > array.length / 2) // Map(1 -> 3)

    if (item_with_max_appearance.size > 0){

      val item_with_Count = item_with_max_appearance.map(e=>e._1).toList(0) //
      //println("AAAA")

        array.indexOf(item_with_Count)
    }

    else
      -1
  }


  def findNumAppearedMaxTime(array : Array[Int]):Unit={

    val array_grped = array.groupBy(e=>e)
    val map_with_count = array_grped.mapValues(e=> e.size)
    val sort_by_values_desc= map_with_count.toSeq.sortWith( (x,y) => x._2 > y._2)
    val first_item = sort_by_values_desc.take(1) // some thing like ArrayBuffer((2,5))
    println(s"item ${first_item(0)._1} and its count is ${first_item(0)._2}")

  }

}
