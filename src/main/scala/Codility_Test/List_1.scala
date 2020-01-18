package main.scala.Codility_Test

object List_1 {

  def main(args: Array[String]): Unit = {

    val listTestOne = List(2,1,3,2,6)

    val head = listTestOne.head
    println("Head of the List " + head)

    val tail = listTestOne.tail
    println("Taiil of the List " + tail)

    val indexOfItem = listTestOne.indexOf(12 ,1) //Finds index of first occurrence of some value in this list after or at some start index. if not found returns -1
    println("IndexOf " + indexOfItem)

    val listAfterPrepend = 10 :: listTestOne // :: add an element in the begining , ::: to add two list into one list (applicable to only list whereas ++ can be for any Traversable i.e. LinkedList)
    println("listAfterPrepend>> " + listAfterPrepend)

    val listAfterAppend = listTestOne :+ 20
    println("listAfterAppend >> " + listAfterAppend)

    val takeRightTwoElement = listTestOne.takeRight(2)
    println("takeRightTwoElement>> " + takeRightTwoElement)

    val listTake = listTestOne.take(2)  // will take first 2 and returns a list
    println("listTake>> " + listTake)

    val takeWhile = listTestOne.takeWhile(e=>e<6) // returns only the elements which are satifying the passed function
    println("takeWhile " + takeWhile)

  }

}
