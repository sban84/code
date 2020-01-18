package main.scala.Functional_Prog_In_Scala.Chapter_3

import scala.collection.immutable.HashSet

object Seq_Program_2 {

  def main(args: Array[String]): Unit = {

    setTest()
  }


  // set test
  def setTest(): Unit ={

    val set_immutable = HashSet[String]()

    val set_immutable_1 = set_immutable + "a"
    val set_immutable_2 = set_immutable_1 + "ab"

    val set_immutable_3 = set_immutable_2 + "dab"
    val set_immutable_4 = set_immutable_3 + "ab"

    println(" set_immutable_4 " + set_immutable_4)
    println(" set_immutable " + set_immutable)

    val set_filter_test1 = set_immutable_4.filter((t) => t.startsWith("d"))
    println(" set_filter_test1 " + set_filter_test1)

    val sorted_set_immutable_4 =set_immutable_4.toSeq.sortWith((k,v) => k > v) // descending order
    println(" sorted_set_immutable_4 " + sorted_set_immutable_4)
    sorted_set_immutable_4.toList // any collection normally can be converted to List most of the time , then we can access them easily.

    set_immutable_4.foreach(e=>println(e + " "))


    val set_mutable = scala.collection.mutable.HashSet[Int]()
    set_mutable.add(1)
    set_mutable += 2

  }

}
