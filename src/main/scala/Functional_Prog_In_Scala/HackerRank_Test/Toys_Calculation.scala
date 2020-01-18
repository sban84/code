package main.scala.Functional_Prog_In_Scala.HackerRank_Test

import scala.util.control.Breaks._
/*
Function Description

Complete the function maximumToys in the editor below. It should return an integer representing the maximum number of toys Mark can purchase.

maximumToys has the following parameter(s):

prices: an array of integers representing toy prices
k: an integer, Mark's budget
 */

object Toys_Calculation {


  def main(args: Array[String]): Unit = {

//    val array = Array(1, 12 5 111 200 1000 10)

    val result = maximumToys(Array(1 ,12, 5 ,111, 200, 1000, 10), 50)
    println(" result " +  result)

    println("result using takeWhile " + maximumToys_1(Array(1 ,12, 5 ,111, 200, 1000, 10), 50))
  }

  def maximumToys_1(array: Array[Int] , k:Int)={

    val sorted_array = array.sorted
    var sum_so_far =0
    var num_of_toys = -1 // because takeWhile returns boolean , so we need to reduce count by 1

    sorted_array.takeWhile(e => {
      sum_so_far += e
      num_of_toys += 1
      sum_so_far <=k
    })

    num_of_toys
  }


  def maximumToys(prices: Array[Int], k: Int) : Int= {
    val sorted_array = prices.sorted
    var sum_till_now =0
    var num_of_toys =0

    sorted_array.map(e=> {

      sum_till_now += e

      println("sum_till_now " + sum_till_now)
      if (sum_till_now <= k) {
        num_of_toys += 1
      }
      if (sum_till_now > k){
        return num_of_toys
      }

    })
    println("out of loop")
    num_of_toys


  }






}
