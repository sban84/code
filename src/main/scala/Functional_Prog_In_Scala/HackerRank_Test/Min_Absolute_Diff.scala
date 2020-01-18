package main.scala.Functional_Prog_In_Scala.HackerRank_Test

import scala.collection.mutable.ListBuffer

object Min_Absolute_Diff {

  def main(args: Array[String]): Unit = {

    val array_test_1 = Array(1, -3 ,71 ,68, 17)

    println("calculateMinDiffInArray(Array(1, -3 ,71 ,68, 17)) " + calculateMinDiffInArray(array_test_1))

    println("Integer2int(2)" + Integer2int(new Integer(2)).getClass)

    val result = 2< 3.0
    println("Int can check with double " + result)


    varArgesTest("a","b","c")

  }

  def calculateMinDiffInArray(array: Array[Int]) : Int={

    //var tempDiff = Integer.MIN_VALUE
    val listBuffer = ListBuffer[Int]()

    for (i <-0 until array.length -1){
      for (j <-i+1 until array.length){
        //println(s"array elements ${array(i)} and ${array(j)}")
        var diff_abs = Math.abs(array(i) - array(j))
        listBuffer.append(diff_abs)
      }
    }

    println("listBuffer + " + listBuffer)
    listBuffer.min

  }

  def varArgesTest(str : String*) ={ // varargs parameter should appear in the last.
    str.map(e=>print(e + "  "))

    //println("str " + str)
  }
}
