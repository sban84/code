package main.scala.Functional_Prog_In_Scala.Chapter_3

import scala.collection.immutable.HashMap
import scala.collection.mutable.ArrayBuffer

object ArrayBuffer_Program_1 {

  def main(args: Array[String]): Unit = {
    arrayBufferTest()
  }

  def arrayBufferTest()={

    val arrBuf = ArrayBuffer(1,2)
    arrBuf += 3 //appends
    //arrBuf +: 4 // NA adding in the head not possible in buffer collection only append , same as ArrayList in Java // adding in
    // the head only allowed in immutable collection.
    arrBuf.append(4) // *** REMEMBER THIS as its more easy to add at last , any buffer mutable Seq has append and muable Map has put ,
    // So easy to remember like Java


    var map = HashMap[Int,String]()

    for (i<- 0 to arrBuf.size-1)
    {
      //print( s" arrBuffer contains  ${arrBuf(i)} and now will insert that into HashMap")
      map += ( i -> "Some Item")  // NOTE / REMEMBER :- since HashMap is immutable so to add use + like map + (i -> "first Item") but that will return another map instance ,
      // so we used var in this case. Same as map = map + (i -> "Some Item")
      // But this is not good to create more instances and assign , rather in this type of usecase use mutable Map ( collection )
      // where we needed to modify the collection.
      map = map + (2->"q") // same as map += (1 -> "a")

    }

    //now print arrayBuffer and Map both
    arrBuf.foreach(e=> print(e))

    map.foreach(e=> print(s"\n key ${e._1} and value ${e._2}"))

    // NOTE : refer HackerRankTest.scala / AnagramTest.scala

    println(" \n Anoter way to iterate Map ")
    map.keys.foreach(e=>{
      print(s" key is $e and value is ${map.get(e)}")
    })

  }

}
