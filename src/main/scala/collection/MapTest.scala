package main.scala.collection

import scala.collection.mutable

/**
  * Created by suman.banerjee on 4/11/2017.
  */
object MapTest {

  def main( args: Array[String] ): Unit = {

    val result : mutable.Map[String,Int] = wordCountUsingMap("hello,scala,hello,spark,program,scala")
    println("result Map >>> " + result)

  }

  def wordCountUsingMap(line : String) : mutable.Map[String , Int] = {
    var counterMap : mutable.Map[String, Int] = mutable.HashMap.empty[String,Int]
    val words : Array[String] = line.split(",")
    for(word <- words)
      {

        //check in map already present , if so increament the count
        if(counterMap.contains(word))
          {
            var oldCount : Int = counterMap(word)
            oldCount += 1  // oldCount = oldCount + 1
            counterMap += word -> oldCount
          }
        else
          {
            counterMap += (word -> 1)
            //counterMap(word) = 1  same as above inserting into Map
          }
      }
    return  counterMap
  }



}
