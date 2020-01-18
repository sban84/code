package main.scala.Functional_Prog_In_Scala.HackerRank_Test

import scala.collection.mutable

object SortMapByKeyAndValues {

  def main(args: Array[String]): Unit = {

    val mutable_map = mutable.HashMap[String,Int]() // as we will add items
    mutable_map.put("aaa" , 1)
    mutable_map.put("aab" , 2)
    mutable_map.put("abc" , 0)
    mutable_map.put("bbb" , -1)

    sortingMapTest(mutable_map)
  }

  def sortingMapTest(mutable_map : mutable.HashMap[String , Int]):Unit ={

    val sortedMap_By_Key = mutable.LinkedHashMap(mutable_map.toSeq.sortWith((x, y)=> x._1 < y._1):_*)

    val sortedMap_By_Value = mutable.LinkedHashMap(mutable_map.toSeq.sortWith((a,b) => a._2 < b._2):_*)

    sortedMap_By_Key.keys.foreach(e=>{
      println(s"Sorted By Key >> key $e and value ${mutable_map.get(e).get}")
    })

    sortedMap_By_Value.keys.foreach(e=>{
      println(s"Sorted By Value >> key $e and value ${mutable_map.get(e).get}")
    })

  }

}
