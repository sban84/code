package main.scala.collection

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
  * THIS EXAMPLE VERY IMPORTANT for LIST in Scala
  * =============================================
  *
  * Created by suman.banerjee on 4/11/2017.
  * This is more than ListTest.scala what we have seen before.
  *
  * Here we will see now 2 list can be concatenated and also how inheritance works for adding elements into list
  * So we can see that we can add same level of instances (apple , orange) and also supertype Fruits
  * in the List .
  * As in scala :: class has
  * def ::[U >: T](x: U): List[U] = new scala.::(x, this)        [ upper bound impl ]
  *
  * This has some good example of List.
  *
  * // println(" 1ST element in the list " + list(1)) // not efficient as List is Linked List based and it need to
  * // iterate though the list , better user Vector( immutable ) or ListBuffer (mutable)
  *
  * Read about tail recursion >> https://oldfashionedsoftware.com/2008/09/27/tail-recursion-basics-in-scala/
  *
  *
  */
object ListTest {

  def main( args: Array[ String ] ): Unit = {

    val apples = List(new Apples() , new Apples())  // 2 apple objects in the list
    var addedList = new Orange :: apples
    //println(" after adding orange in the list " + addedList)

    addedList = new Fruits :: addedList
    //println(" after adding Fruits in the list " + addedList)

    val cars = List(new Suzuki)
    //addedList = cars ::: apples   // Not possible as Compilation error as they are of different type

    // Fold Test
    foldTestOnList()

    //print(" after  incAllInList >>> " + incAllInList(List(1,2,3,4)))

    //println("After reversing using ExternalStorage " + reverseListUsingExternalStorage(List(1,2,3,4)))
    println("After reversing without recursion " + recusrionTest(List(1,2,3,4)))
    println("After reversing using recursion " + reverseListUsingRecursion(List(1,2,3,4)))

    val v  = Vector(1,2,3,4)
    //println("vector element in 2nd position " + v(2))


   // println("Usage of Cons operator , it makes List >> " )
    val consReturn = 2 :: Nil
    //println("consReturn >> " + consReturn)  // returns a List(2)  , which is useful in recursion

  }

 /* def reverse[A](l: List[A]): List[A] = l match {
    case h :: tail => reverse(tail) ::: List(h)
    case Nil => Nil
  }*/

  // this is not a tail recursive
  def recusrionTest(list: List[Int]): List[Int] = list match {
    case List() => {print("End of Recursion") ; Nil }
    case x :: list => {recusrionTest(list) ::: List(x) } // x each element in the list , tail is any variable name as x :: tail returns a list of x . each time it will ne appended in the head of the list. so finally tail will have all elements in reverse of i/p original list
  }

  // this is not a tail recursive
  def incAllInList(list : List[Int]) : List[Int] = list match{
    case List() => List()
    case x :: list => x + 1 :: incAllInList(list)
  }

  // this is a tail recursive [ read more about tail recursive]  first calculate / process and then call recursion at the last , so don't need local variables and stack frames anymore it will be in teh same stack only
  def reverseListUsingRecursion( list : List[Int]) : List[Int] =  {

    @tailrec
    def doRecursion(result : List[Int] , list : List[Int]) : List[Int] = list match {
      case Nil => result
      case x :: list => { print("value of result " + result) ; print("value of list " + list) ;
        doRecursion(x :: result , list) }
      //case x :: list => { print("value of result " + result) ; print("value of list " + list) ; doRecursion(x :: result , list) }  // in each iteration x :: list  will remove head element x from the original list and  x will be appended in result at the front  with cons :: operator
    }
    //this will return the result finally
    doRecursion( Nil, list )
  }

  def reverseListUsingExternalStorage(list : List[Int]) : List[Int] =  {
    val listBuff : ListBuffer[Int] = new ListBuffer[Int]  // here ListBuffer[Int] in data type is optional
    for(i <- list.size -1 to 0 by -1 )
    {
      listBuff +=list(i)
    }
    return listBuff.toList
  }

  def foldTestOnList( ): Unit = {

    val list = List(1,2,3,4)

    //It takes 2 argument , first one is initialize and second is function litral
    val foldResult = list.fold(0){(a,b) => a+b}
    println("foldResult >> " + foldResult)   // since we are doing + so it will same either direction we go left / right in the list

    val foldLeftResult = list.foldLeft(0){(a,b) => a+b}
    println("foldLeftResult >> " + foldLeftResult)

    val foldRightResult = list.foldRight(0){(a,b) => a+b}
    println("foldRightResult >> " + foldRightResult)

    // println(" 1ST element in the list " + list(1)) // not efficient as List is Linked List based and it need to iterate though the list , better user Vector( immutable ) or ListBuffer (mutable)
  }
}

class Fruits
{
  //val name : String = "Fruits"
}

class Apples extends Fruits
{
  val name: String = "Apples"
}

class Orange extends Fruits
{
  val name : String = "Orange"
}

class NotFruits
{
  val name : String = "NotFruits"
}

class Car {

}

class Suzuki extends Car{

}