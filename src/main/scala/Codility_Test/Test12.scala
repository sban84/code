package main.scala.Codility_Test

import java.util
import java.util.Collections
import scala.util.control.Breaks._
object Test12 {

  def main(args: Array[String]): Unit = {
    println( addBigNumbers("2","9") )
    println( solution("2,9") ) // 1,1,2,3,4,6
    //println( solution(Array(1, 2,3)))  // 1,1,2,3,4,6
   // println(add ("122","100"))
  }
var carry =0

def addBigNumbers (firstNum:String, secondNum:String): String ={

  val res = new util.ArrayList[String]
  val res1 = new StringBuilder
  var i = firstNum.length - 1
  var j = secondNum.length - 1

    breakable {
      while ( true ) {
        val i1 = Character.toString(firstNum.charAt(i)).toInt
        val i2 = Character.toString(secondNum.charAt(j)).toInt
        println(i1 + "   " + i2)
        var i3 = i1 + i2 + carry
        if (i3 > 9) {
          carry = 1
          i3 = i3 - 10
        }
        else carry = 0
        res.add(i3.toString)
        res1.append(i3.toString)
        i -= 1
        j -= 1
        if (i < 0 || j<0) {
          res.add(carry.toString)
          res1.append(carry.toString)
          break()

        }
      }
    }
  //println(">>>>>> "+res1)
  println("&&&& " + res1.reverse.deleteCharAt(0).toString())
  res1.reverse.toString()
}

  def solution(x: String) :String =
  {
    //x.head
    val list  = x.split(",").map(_.trim).toList
    var sumOfBigInts = new StringBuilder()
    var sum = "0"
    var sum1 = "0"
   println("<<<<<"+list.size)
    for ( i <- 0 to list.size-1){
      var first = list(i)
      //var second = list(i+1)
      println(">>>>>>lis "+list(i)+"<>"+sum)
      sum1 = (addBigNumbers(first,sum))
      sum = sum1


    }

    println("Result >>>>>>>>>>>>>>>>> "+sum1)
    sum1
/*    //println("###" + list)
    //list.foreach(e=>print(e) + " ")
    var sum=list(0).toLong
    //println("###" + sum)
    for(i <- 1 until list.length)
      {

        sum +=list(i).toLong
        //println("###" + sum)
      }

    sum.toString*/



  }

}
