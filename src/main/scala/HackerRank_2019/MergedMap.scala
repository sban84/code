package main.scala.HackerRank_2019

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object MergedMap {


  def main(args: Array[String]): Unit = {

    val map = mutable.HashMap[mutable.HashSet[Int] , Int]()

  /*  map.put(mutable.HashSet[Int](3,4),2)
    map.put(mutable.HashSet[Int](5,6),2)
    map.put(mutable.HashSet[Int](1,7),2)
    map.put(mutable.HashSet[Int](1,2,3),3)*/

   /* map.put(mutable.HashSet[Int](1,21),2)
    map.put(mutable.HashSet[Int](11,2,3),3)
    map.put(mutable.HashSet[Int](11,17),2)
    map.put(mutable.HashSet[Int](3,4),3)
    map.put(mutable.HashSet[Int](6,8),2)
    map.put(mutable.HashSet[Int](3,7),2)
    map.put(mutable.HashSet[Int](30,70),2)
    map.put(mutable.HashSet[Int](8,70),2)*/


   /* map.put(mutable.HashSet[Int](1,2),2)
    map.put(mutable.HashSet[Int](1,2,3),3)
    map.put(mutable.HashSet[Int](6,8),2)
    map.put(mutable.HashSet[Int](3,8),2)
    map.put(mutable.HashSet[Int](4,8),2)*/

   /* map.put(mutable.HashSet[Int](1),2)
    map.put(mutable.HashSet[Int](1,2,3),3)
    map.put(mutable.HashSet[Int](6,8),2)*/


    map.put(mutable.HashSet[Int](3,2,4),3)
    //map.put(mutable.HashSet[Int](4,3),2)





    println(s"map $map")
    val result = mergedCommonFriend(map)
    println(s"result $result")
  }

  def mergedCommonFriend(map : mutable.HashMap[mutable.HashSet[Int] , Int]): mutable.HashMap[mutable.HashSet[Int] , Int ] = {

    val mergedMap = mutable.HashMap[mutable.HashSet[Int] , Int ]()
    var setTemp = map.keys
    var keyList = setTemp.toList
    //print(keyList)

    val listBuffer = ListBuffer[mutable.HashSet[Int]]()
    for(i <-0 until(keyList.size -1 )){
      var mergedSet = mutable.HashSet[Int]()

      var temp = keyList(i)
      print(s"temp $temp")

      //println(s"keyList  $keyList ")
      for (j <- 1 until(keyList.size)){

        //println(s"temp $temp")
        //println(s"keyList(j) ${keyList(j)}")

        //println(s"temp.intersect(keyList(j)).size ${temp.intersect(keyList(j)).size}")

        println(s"keyList(j) ${keyList(j)}")
        println(s"listBuffer >> $listBuffer")
        if (temp.intersect(keyList(j)).size >= 1 ){
          mergedMap.remove(temp)
          mergedMap.remove(keyList(j))
          mergedSet = temp.union(keyList(j))

          //println(s"mergedSet $mergedSet")
          listBuffer.append(keyList(j))
          listBuffer.append(temp)
          temp= mergedSet

          keyList = keyList :+ mergedSet
          println(s"after adding mergedset $keyList")


        }
        else if (!listBuffer.contains(keyList(j))  ) {
          println(s"inside else $temp")
          println(s"inside else  keyList(j)>>> $keyList(j)")
          mergedSet = temp
          listBuffer.append(temp)
        }

      }
      if (mergedSet.size > 0 ){
        mergedMap.put(mergedSet,mergedSet.size)
      }

    }
    if (mergedMap.size == 0){
      map
    }
    else{
      mergedMap
    }

  }

}
