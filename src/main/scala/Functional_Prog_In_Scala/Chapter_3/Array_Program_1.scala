package main.scala.Functional_Prog_In_Scala.Chapter_3

object Array_Program_1 {

  def main(args: Array[String]): Unit = {

    val array = Array(3, 8, 9, 7, 6)
    println("rotateNTimes(2,array.toList) " + rotateNTimes(3,array.toList))

    println("Solution(2,array.toList) " + solution(array, 3).foreach(e=>println(e)))

  }

/*  def findLargestPalindrom(array: Array[Int]):Int={

    array.aggregate(Integer.MIN_VALUE)(
      (largest,n) =>
        if (n>largest && n.toString.equals(n.toString.reverse)) n else largest ,
      Integer.MAX_VALUE

   )

  }*/


  // NOTE :- Good algo , try to remember as its hard to implement
  // Array(3, 8, 9, 7, 6) n =3 -> 9 7 6 3 8
  /*
  3, 8, 9, 7, 6
  6 3 8 9 7
  7 6 3 8 9
  9 7 6 3 8

   */

  def rotateNTimes[T](i: Int, list: List[T]): List[T] = i match {

      // shift to left
    case i if i < 0 => list match {
      case head :: xs => rotateNTimes(i + 1, xs ::: List(head))
      case Nil => rotateNTimes(i + 1, Nil)
    }
      // shift to right
    case i if i > 0 => list.reverse match {
      case head :: xs => {
        println(s"head $head and xs $xs")
        rotateNTimes(i - 1, head :: xs.reverse)
      }
      case Nil => {
        println("reached Nill case ")
        rotateNTimes(i - 1, Nil)
      }
    }
    case _ => list
  }


  def solution(a: Array[Int], k: Int): Array[Int] = {
    // write your code in Scala 2.12
    val list = a.toList
    val result = rotateNTimes(k,list)
    result.toArray
  }

  def oddOccurrences(list: List[Int])={

    val oddOccurencesItem = list.groupBy(e=>e).filter((t) => t._2.size%2 !=0) // array also has same API groupBy
    println("oddOccurencesItem " + oddOccurencesItem.keys.toList(0)  )


    // another way of ding this , use if the previous sol is not working .
    /*val linkedHashMap =scala.collection.mutable.LinkedHashMap[Int,Int]()
    list.map(e => {
      if (linkedHashMap.contains(e)){
        linkedHashMap.put(e,linkedHashMap.get(e).get + 1)
      }
      else{
        linkedHashMap.put(e,1)
      }
    })
    linkedHashMap.filter(t=>t._2%2 !=0)*/

  }

  // if we wanted o/p like 3 3 8 9 7
  def repeatFirstItemNTimes(array: Array[Int], n:Int) : Unit ={

    for (j <- 0 until n ){
      for (i <- array.length-1 until 0 by -1  ){
        array(i) = array(i -1 )
      }
    }

    println("array " + array.mkString)
  }

  def removeItemByIndexArray[T](array: Array[T] , index : T):Array[Int] ={

    array.zipWithIndex.filter(_._1 != index).map(_._2)

    //data.zipWithIndex.filter(e=> e._2 !=1).map(e=> e._1) //Array(1, 3, 4, 5)
  }
}
