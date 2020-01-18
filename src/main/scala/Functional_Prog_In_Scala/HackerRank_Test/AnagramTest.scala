package main.scala.Functional_Prog_In_Scala.HackerRank_Test

import scala.collection.mutable.ArrayBuffer

object AnagramTest {

  /*
  This is generic test problem to check how Map[String, List[Instances]] works .
  Here we are just storing key String with sorted and its counts got from, the i/p
   */
  def testMapWithListOfInstances(input: String): Unit = {

    val inputArr = input.split(" ")
    val map = scala.collection.mutable.HashMap[String,List[Item_Count]]()

    //inputArr.foreach(e => print(e + " "))
    inputArr.map(e=> {
      val sortedKey = e.sorted

      if (map.contains(sortedKey)){
        var currCount = map.get(sortedKey).get(0).count // get the first item_count object from list and we will consider that count as reference , even though
        // other list will be having initial value but that we dont want to consider that here in this test .

        var tempRecord = Item_Count(e,currCount + 1)
        println("already present " + sortedKey)
        val getCurrList  : List[Item_Count]= map.get(sortedKey).get
        //val newList = getCurrList :+ tempRecord
        val new_list_1 = tempRecord +: getCurrList // both are same purpose we want to add that into list

        map.put(sortedKey,new_list_1) // map.get(e) returns Option[VALUE_TYPE] here we must do get on that

      }
      else{
        var tempRecord = Item_Count(e, 1)
        println("Not present " + sortedKey)
        val list = List[Item_Count](tempRecord)
        map.put(sortedKey,list)
      }
    })

    //println("map " + map)

    // REMEMBER this 2 ways of iterating MAP
   /* map.foreach(e=>{
      print(s"key is ${e._1}  and value is ${e._2}");
    })*/

    map.keys.foreach(e=>{
      //print(s"keys $e and value = ${map.get(e)}")
      map.get(e).map(rec => {
        rec.map(item_count_instance => print(s" item_count_instance.count.item ${item_count_instance.item} and  item_count_instance.count ${item_count_instance.count} "))
      })
    })

  }


  // to find given a set of String and find which are of them anagaram each other
  // and retun them in ascending order as o/p.

  def anagramTest_2(input : String)={

    val inputArr = input.split(" ")
    val arrayBuffer = ArrayBuffer[String]()
    for (i <- 0 until inputArr.length -1){
      var item_1 = inputArr(i)
      var item_2 = inputArr(i + 1)
      println("item_1 " + item_1)
      println("item_2 " + item_1)
      if (item_1.sorted.equals(item_2.sorted)){
        println(s" $item_1 and $item_2 are anagram ")
        arrayBuffer.append(item_1)
        arrayBuffer.append(item_2)
      }
    }
    println("arrayBuffer  " + arrayBuffer)

    // now sort the arrayBuffer to have items in sorted order , 2 ways to sort any seq collection
    // sorted and sortWith but both returns new collection i.e. arrayBuffer here

    val arrayBuffer_sorted = arrayBuffer.sorted
    println("arrayBuffer.sorted  " + arrayBuffer_sorted)

    val arrayBuffer_sorted_1 = arrayBuffer.sortWith((x,y) => x < y)
    println("arrayBuffer_sorted_1 " + arrayBuffer_sorted_1)
  }

  def main(args: Array[String]): Unit = {

    //println("Enter the number of String for Anagram Test ")
    //val n = scala.io.StdIn.readInt()

    println("enter the Strings space separated ")
    val input = scala.io.StdIn.readLine()

    // This is to understand how we can use Map in more advanced way
    testMapWithListOfInstances(input)

    // Anagram test
    anagramTest_2(input)



  }

  case class Item_Count (var item:String,var count:Int)

}


