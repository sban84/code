package main.scala.Scala_lab_test


/**
  * Created by suman.banerjee on 4/10/2017.
  */
object ListTest {


  def main( args: Array[String] ): Unit = {
    // way 1# declare and initialize same time
    val listTestOne: List[Int] = List( 2, 5, 8, 1 )
    //println("######" + listTestOne.head)  // will not remove the head , tail remove the head and returns rest of the list
    //println("######" + listTestOne)
    //way2# , create a empty list and then add one by one
    var listTestTwo: List[String] = List()
    for (i <- 0 until 4) {
    // newList +=  (i).toString // only possible in case mutable List  , import scala.collection.mutable.MutableList
      listTestTwo = (i).toString :: listTestTwo  //will append at the head of the list
  }
    //way 3#  , declare and initialize same time
    val listTestThree = "a" :: "b" :: Nil

    printList(listTestOne)
    printList(listTestTwo)
    printList(listTestThree)


    val listRange = List range(1 ,5)
    println(listRange)

    // flatMap will first apply the function and create individual List[T] result and then apply concatenation on result from all the List.
    val flatMapTest = List.range(1, 5) flatMap (
      i => List.range(1, i) map (j => (i, j))
      )
    print(flatMapTest)

    wordCountTest()
  }

  def wordCountTest( ): Unit ={
    // i/p is already in List , no need of flatMap , just apply groupBy
    val wordCountOnList = List("hello" , "scala" , "spark" , "hello" , "scala")
                       .groupBy(eachWord =>(eachWord)).mapValues(values => values.size)
    println(wordCountOnList)

    // ip is raw lines , So need of flatMap ,
    val str : Array[String] =  Array("hello,scala,spark,hello,scala")
    val wordCountOnStr = str.flatMap(lines=>(lines.split(","))).toList.groupBy(eachword => eachword).mapValues(values=> values.size)
    println("\nwordcount using flatMap >> " +wordCountOnStr)

  }
  def printList(list : List[Any]) : List[Any] = {
    print("List Items => ")
    for(item <- list)
      {
        print(item + ",")
      }
    return list
  }

  def rev[T](xs: List[T]): List[T] = xs match {
    case List() => xs
    case x :: xs1 => rev(xs1) ::: List(x)
  }
}
