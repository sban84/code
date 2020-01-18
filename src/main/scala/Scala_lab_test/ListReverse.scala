package main.scala.Scala_lab_test

/**
  * Created by suman.banerjee on 4/11/2017.
  *
  * A class for immutable linked lists representing ordered collections of elements of type A.
    This class comes with two implementing case classes scala. and scala.:: that implement the abstract members isEmpty, head and tail.
    This class is optimal for last-in-first-out (LIFO), stack-like access patterns. If you need another access pattern, for example, random access or FIFO, consider using a collection more suited to this than List.

  A ListBuffer is a mutable object (contained in package scala.collection.mutable), which can help you build lists more efficiently
  when you need to append. ListBuffer provides constant time append and prepend operations. You append elements with the += operator, and
  prepend them with the +=: operator. When you’re done building, you can obtain a List by invoking toList on the ListBuffer.
  import scala.collection.mutable.ListBuffer
  */
object ListReverse {

  def main( args: Array[String] ): Unit = {

    val orgList : List[Int] = List(1,2,3)

    var reversedList =  reverse(orgList)
    println("List ater reversal >> " + reversedList)

    println("original list " + orgList)

    reversedList = reverseInOtherWay(orgList)
    println("List ater reversal >> " + reversedList)

    var newList  = insert(orgList , 1 , 10)
    println("List after added new element >>> " +  newList)
    println("original list " + orgList)

  }

  def reverse[A](list :List[A]) : List[A] = {
    var result : List[A] = Nil
    var temp = list
    while(!temp.isEmpty){
      result = temp.head :: result  // appending head from source list to the head in target list
      temp = temp.tail   // getting the remaining list except head of the source
      println("temp >>> " + temp)
    }
    return result
  }

  // we can not do like java ( using loop to go to last position and decreament by 1 ) as in java we have add() which adds in last but here in Scala its added in head
  def reverseInOtherWay[A](list : List[A]) : List[A] = {
    var result : List[A] =  List()
    var j =0
    for(i <- 0 to list.size-1)
      {
        //println("i " + i + " and list(i) "  + list(i))
        result =  list(i) :: result
        j += 1
      }

    return result

  }

  /*
  There is no built-in function or a method of a List that would allow user to add a new element in a certain position of a List.
  So below API can serve the purpose
   */
  def insert[T](list: List[T], i: Int, value: T) : List[T] = {
    val (front, back) = list.splitAt(i)
    return front ++ List(value) ++ back
  }
}
