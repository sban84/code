package main.scala.Functional_Prog_In_Scala.Chapter_3

import scala.util.control.Breaks

object Array_Multidimension {


  def main(args:Array[String]) : Unit ={
    //createMultiDimension()

    //arrayTest()

    //createSingleDimArray_1()
    //createSingleDimArray_2()

    /*val stack = new Stack[Int]()
    println(stack.push(4))
    println(stack.pop())
*/

    val genericClass = new GenericClass[Int]()
    println(genericClass.addItem(2))
    //println(s"adding to Array generic exmaple ${genericClass.addItemToArray(33)}")


    //println(addItem(31))
  }

  def createMultiDimension():Unit={

/*    val singleDimArray = new Array[Int](5)
    println("Size " + singleDimArray.length)
    singleDimArray(0) = 1
    singleDimArray(1) = 2
    singleDimArray(2) = 0

    singleDimArray.foreach(e=>print(e))*/

    val multiDimArray = Array.ofDim[Int](2,3)
    for (i <- 0 until multiDimArray.length){
      for (j<- 0 until multiDimArray(i).length){
        multiDimArray(i)(j) = i*j
      }
    }
    for(i <- 0 until multiDimArray.length)
    {
      for (j<- 0 until multiDimArray(i).length){
        print(s" ${multiDimArray(i)(j)} ")
      }

      println()
    }

  }

  def arrayTest(): Unit ={

    println(" Enter array size ")
    val num = scala.io.StdIn.readInt()

    println(" Enter array items space separated ")
    val items = scala.io.StdIn.readLine()

    //val array = Array[String]()

    val elements = items.split(" ")

    print(s"entered elements ")
    for (i <- 0 until elements.length)
      {
        print(s" ${elements(i)} ")
      }
    val sorted_elements = elements.sorted
    printArray(sorted_elements)

    var count =0
    val loop = new Breaks;

    for (i <- 0 until sorted_elements.length-1){
      //print(sorted_elements(i)  + "  " + sorted_elements(i +1 ) )
      if (sorted_elements(i) == sorted_elements(i + 1)){
        print("found first duplicated item " + sorted_elements(i))
        loop.break()
      }
    }

    /*val elements_Int = new Array[Int](elements.size)
    for(i<-0 until(elements.length)){
      elements_Int(i) = elements(i).toInt
    }

    elements_Int.foreach(e=>println(e))*/
  }

  def printArray[A](arr :Array[A]): Unit ={
    print(s"array elements")
   /* for (i <- 0 until arr.length)
      {
        print(s" ${arr(i)} ")
      }*/

    arr.map(e=> print(s" $e "))

  }


  def createSingleDimArray_1() ={


    println("Enter the array size for Single Dimension ")
    val num = scala.io.StdIn.readInt
    val array = new Array[Int](num) // new is must when we wanted to define the array size with declaration .

    // actualy this is not add , this is update the existing array with new values , initially it will be all 0
    for (i <- 0 until num) {
      array(i) = i
    }

    println("array contains ")
    array.foreach(e=> print(s" $e " ))
  }


  // better approach to use array in scala
  def createSingleDimArray_2() ={
    println("Enter the array size for Single Dimension ")
    val num = scala.io.StdIn.readInt

    // NOTE : REMEMBER *** / TRY TO USE THIS WAY OF CREATING ARRAY MOST OF THE TIME.
    // Array is mutable in the sense that we can update any index rec with new value
    //But adding and dropping will return new Array

    val array = Array[Int]()  // array size is 0 in this case
    println("arra size " + array.length)

    // NOTE >> array is mutable in the sense that it provide update item with its index but in this case we can not update any item in that like we did before as its empty array
    // . So we need to add by :+ OR +: but that will return new array
    //

    /*for (i <- 0 until num) {
      array(i) = i // since array is mutable each time the array is getting updated . So array will have .
    } */

    val new_array_1 = array :+ 1       // adding in the last
    val new_array_2 = 0 +: new_array_1 // adding in the head
    val new_array_3 = new_array_2 :+ 3
    val new_array_4 = new_array_3 :+ 4

    val new_array_after_drop = new_array_4.drop(2) // will drop 0th and 1st index element. easy to remember like substring

    println("new_array_4 contains ")
    new_array_4.foreach(e=> print(s" $e " )) // 0 ,1 ,3 ,4

    println("new_array_after_drop contains ")
    new_array_after_drop.foreach(e=> print(s" $e " )) // 3 ,4



    println("Zip test ") // same as List
    val arr1 = Array("suman" , "Anannya")
    val arr2 = Array("B" , "M")

    val zipped = arr1.zip(arr2)
    zipped.foreach(e=>println(e))
  }


  def removeItemByIndexArray[T](array: Array[T] , index : T):Array[Int] ={

    array.zipWithIndex.filter(_._1 != index).map(_._2)
  }


  def addItem[T]( x: T) : List[T] ={
    var elements: List[T] = Nil
    elements = x :: elements
    elements
  }

}


// good example of Generic class and usage of it.

class GenericClass[T]{

  var elements: List[T] = Nil
  //var array : Array[T] = new Array[T](10) // Need to check for Array, Currently List is okay.

  def addItem( x: T) : List[T] ={
    x :: elements
  }

/*  def addItemToArray[T: ClassTag](x:T) : Array[Any] ={
    x +: array
  }*/
}


class Stack[A] {
  private var elements: List[A] = Nil
  def push(x: A) { elements = x :: elements }
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
}


