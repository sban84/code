package main.scala.Functional_Prog_In_Scala.Chapter_3

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

/*
Refer this , it has good code to know about recursion feature while working with  List
How to add items and retrive

Partial Function and Function Curry

 */
object List_Program_1 {

 // Test1 # to show how cons operator (:: and :+ ) works . how we can add items into List
  def addItemInList() : Unit ={

    println("\n  Test 1 #")
    val list_1 = List(11,21,31,41)
    // :: and +: is same effect on List as both are adding one element in the head . where as :+ add in the last , refer Collections_API_Test_1.scala OR Scala LIST API
    // :: is specially for list whereas :+ is for any Seq Indexed Collection.
    val list_1_added_in_haed = 100 +: list_1   // add in the head of the source list and returns a new list as List in immutable in Scala
    list_1_added_in_haed.foreach(e => print(e + " "))
    println()
    list_1.foreach(e => print(e + " "))

  }

  // Reverse Using  recusrion ,
  def reverseListUsnigRec(data: List[Int]): List[Int] = data match {

    case Nil => { println("Inside List empty case ") ; List() }
    case x :: tail => { println("x " + x + " and tail " + tail ) ; reverseListUsnigRec(tail) ::: List(x) }

  }

  // Reverse Using tail recusrion , same impl is also available in ListTest.Scala
  def reverseListUsingTailRec(data : List[Int]) : List[Int] ={

    val result = List[Int]()
    @tailrec
    def reverseListAccum(result:List[Int] , data : List[Int] ) : List[Int] = data match  {
      case List() => result
      case x :: tail => reverseListAccum( x +: result , tail )  // +: will add in head same as ::
    }
    reverseListAccum(result,data)
  }

  def sumUsingTailRecursion(list: List[Int]) = {

    var result = List()

    @tailrec
    def sumAccum(result:Int,list:List[Int]):Int = list match  {

      case List() => result
      case x :: tail => sumAccum( x + result , tail)
    }

    sumAccum(0,list )
  }

  def dropWhile[A](as: List[A])(f: A => Boolean): List[A] = as match {
    case h :: t if f(h) => dropWhile(t)(f)
    case _ => as
  }

  //test on function curry

  def addFunction(a:Int)( f :(Int,Int) => Int)(b:Int) ={
    a + b
  }

  def addFunction_1(a:Int)(b:Int)(c:Int) ={
    a + b + c
  }


  def squareAndAdd(x:Int)(y:Int)(f:(Int,Int) => Int):Int ={
    x + f(x,y)
  }

  def main(args: Array[String]): Unit = {

    //val data = List(1,2,3,4)
    //val data = List.range(1 , 11)
    val data = List(1 to 10).flatMap(e=>e)
    val res= data.foldLeft(5)(_+_)
    println("FOLD " + res)

    val revList = reverseListUsnigRec(data)
    revList.foreach(e => print(e))

    // **** Some test on List API available in Scala ****

    // Test 1# :: ( cons operator )
    addItemInList()


    // Test 2 # , Test recursion to calculate sum of a list
    println()
    println("Sum of a list " + sumUsingTailRecursion(List(2,1,3)))


    //Test 3 # dropping elements from list by specific condition. here we have used partially applied function first just to see how it works ,
    // and then passed the remaining argumets

    val fun_1 = dropWhile(List(1,2,4,3))_
    val final_result = fun_1((x => x < 4))
    println("final_result " + final_result)

    // Test 4# testing Function Curry
    // refer https://dzone.com/articles/difference-between-currying-amp-partially-applied
    // Function curry :- creating a chain of functions from a function which is taking multiple i/ps , used in library impl as we can create a function with the avaiable i/ps and passing to next layer to impl the rest.
    // Parirally aplied functions - useed to create different flavors of a function.
    //
    val res_1 = addFunction(2)((x:Int,y:Int) => x+y)_     // (x:Int,y:Int) => x+y is a annonymous function / function litral
    val final_add_result = res_1(6) // So the perfect example of Function Curry . res_1 will be partially applied with the provided argument and will compute once all the parameters passed.
    println("final_add_result after applying function curry " + final_add_result)

    val result_1 = addFunction_1(1)_
    val result_2 = result_1(2)
    val result_1_2_6 = result_2(6)
    println("result_1_2_6 = " + result_1_2_6)


    arrayBufferTest()


    // Test 5 # Can REMEMBER THIS only ( above 2 are for reference addFunction and addFunction_1)
    //*********************************
    println("Test 5 : FUNCTION CURRY TEST ")
    //val result = squareAndAdd(2)(3)((x:Int,y:Int) => x*y) // this normal way of calling passing eerything sa,e time .
    val result_first = squareAndAdd(2)_  // _ is must and this is called partially applied function
    val result_sec = result_first(3)  // once u get the result variable from partially applied function , we can just pass one more argument gradually and get function ( which is called function curry
    // and useful in Scala feature )

    val result_final = result_sec((x:Int,y:Int) => x*y)

    println("result_final " + result_final)

    val list_rev_tail_rec = reverseListUsingTailRec(List(1,2,3,4))
    println("list_rev_tail_rec ")
    list_rev_tail_rec.foreach(e=> print(e + " "))


  }



/*  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case x :: xs => f(x, foldRight(xs, z)(f)) }
  def sum2(ns: List[Int]) = foldRight(ns, 0)((x,y) => x + y)
  def product2(ns: List[Double]) = foldRight(ns, 1.0)(_ * _)*/

  def arrayBufferTest(): Unit ={
    val b = new ArrayBuffer[Int]()
    b += 2
    b += 1
    b += 20
    b += 11


    val vector =  Vector(1,2,3)
    b ++=vector // appends
    vector ++: b // prepends  vector in b

    for (e<-b)
      {
        println("contents of ArrayBuffer " + e)
      }


  }

  def binarySearchTestList(array: Array[Int]) :Unit ={
    val record = java.util.Arrays.binarySearch(array.sorted,0)

    //Array(1, 2, 3, 4, 5).search(3)
  }

}


