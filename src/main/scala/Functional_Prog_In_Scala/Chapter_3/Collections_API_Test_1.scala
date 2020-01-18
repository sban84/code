package main.scala.Functional_Prog_In_Scala.Chapter_3

/**
  *
  */

object Collections_API_Test_1 {



  def main(args: Array[String]): Unit = {

    listAPITest()
    listAPITest_1()
    ListAPITest_2
    //dropAndSliceTest()

    //mapTestSameAs2Loop
    //foldTest
    //findMaxInListByFold

    //arrayAPITest
    //findMaxInListByFold


  }

  def listAPITest() : Unit={
    val list = List(2,1,4,5)

    // :+ will add in last )
    // +: will add in the head ( in List :: also can do the same)

    // Add element in list different ways **********
    val add_test_at_end = list :+ 100
    println("adding one element in the list at end " + add_test_at_end)

    val add_test_at_head = 100 +: list
    println("adding one element in the list head " + add_test_at_head)


    val add_test_using_:: = 100 :: list  // :: can only be applied when we wanted to add an element at the head of the list
    println("adding one element in the list head add_test_using_:: " + add_test_using_::)

    val vector = Vector(1,2,3,4)
    val addedInLast = vector :+ 100
    val addedAtHead = 200 +: vector

    println(s"addedInLast $addedInLast")
    println(s"addedAtHead $addedAtHead")

    println("list.sum " + list.sum)
    println(" list.fold(10)((a,b)=>a+b) " + list.fold(10)((a,b)=>a+b)) //fold uses seed which will be used to sum the first element.
    println(" list.foldLeft(10)((a,b) => a+b) " + list.foldLeft(10)((a,b) => a+b))

    println("list.slice(0,3) " + list.slice(0,50)) // result List(2, 1, 3) like substring in String , no index bound exception here !!


    val newList = 11 :: 2 :: 10 :: 2 :: Nil

    println("distinct of new_list " + newList.distinct)

    val diff_list = list.diff(newList)
    println("diff_list " + diff_list)

    val insersect_list = list.intersect(newList)
    println("intersect_list " + insersect_list)

    val mergedList = diff_list ::: insersect_list
    println("merged list " + mergedList) // This will be same list .


  }

  // very good example of function returing function
  // function taking another function as argument
  // andThen aplication
  def listAPITest_1(): Unit =
  {
    val list = List(2,1,4,5)
    val aggList = list.aggregate(0)((sum,ch) => sum+ch.toInt , (p1,p2) => p1+p2)
    println(s"aggList resullt $aggList")


    //https://stackoverflow.com/questions/40659149/andthen-in-list-scala
    // refer this ...
    val h = ((x:Int) => x+2).andThen((x:Int) => x-1)  // composing 2 functions using the andThen combinator
    list.map(h)
    println("list after andTHen " + list)


    def add(x:Int) = ( a:Int) => {
      x +1
    }
    def minus(x : Int) = (a:Int)=> {
      x -10
    }

   /*
    No need to refer this is just test .
   val combinedFunc = add(2).andThen(minus)
    list.map(e=>combinedFunc(e))*/

  }

  // function without parenthesis means it does not take any argument
  def ListAPITest_2 ={
    val l1 = List(1,2,3,4).splitAt(2) // List( List(1,2),List(3,4))
    println(l1._1(0))

    println("takeWhile test " + List(1,2,3,4).takeWhile(e=>e!=2))

    List(1,2,3,4).zipWithIndex.foreach(e=>{print(e);print(s" Item is ${e._1} and its index ${e._2}")})
  }

  /*
  Some of the List API and its description / same as Array and returned collection will be of same type as the source.

  1- slice - this will return extracted / sliced elements from the original List , e.g. List(1,2,3,4,5).slice(2,4) will
  return item from index 2 till 3rd ( starting from index 0) so o/p is List(3,4)

  2-sliding - this will return Itarable collection , which will contain a collection of items defined by first parameter
  in API and with the gap of sec parameter

  e.g
  val list = List(1,2,3,4,5,6,7)
  list.sliding(3,1).toList
  res11: List[List[Int]] = List(List(1, 2, 3), List(2, 3, 4), List(3, 4, 5), List(4, 5, 6), List(5, 6, 7))
  and
  list.sliding(3,4).toList
  res12: List[List[Int]] = List(List(1, 2, 3), List(5, 6, 7))

  3- take - this will return an collection with first specified number of of items
  list.take(3)
  res13: List[Int] = List(1, 2, 3)

  4- drop -  return new list with dropping the first specified number of itms
  list.drop(3)
  List[Int] = List(4, 5, 6, 7)

  5- dropWhile -   it stops dropping as long as the condition is no longer met / same as takeWhile just opposite.
   list.dropWhile(e=>(e > 0 && e < 3))
   res21: List[Int] = List(3, 4, 5, 6, 7)
  6-



   */
  def dropAndSliceTest(): Unit = {
    val list = List(1,2,3,4)


    println("Before Slice Test " + list)
    val sliced = list.slice(1,3) //
    println("List.take(2) " + list.take(2)) //
    println("sliced " + sliced ) // easy to remember if a list has List(1,2,3,4)
    // list.slice(1,3) will return List[Int] = List(2, 3)
    // and list.take(2) will return List(1,2)  , ( same as substring works end-1)

    println(" list.drop(2) " + list.drop(2)) // from Left drop 0th and 1st , so returns List(3, 4)
    println("original list " + list)
  }

  def arrayAPITest()={
    val arr = Array(2,1,4,5)
    //val arr_1=arr.filter(e=>e !=4)
    arr.filter(e=>e !=4)
    arr.foreach(e => println(e))

    // One operations like map / filter new array will be returned same as List .
    val numbers = Array(1, 2, 3, 4)
    val arr_multiplied =  numbers.map(_ * 2)
    arr_multiplied.foreach(println)

  }
  def mapTestSameAs2Loop()={
    val mapres = (1 to 5).map(i => (1 to 2).map(j=>(i, j)))
    println(" mapres " + mapres.flatMap(e=>e))

    // same as

    for(i <- 1 until 6){
      for (j <- 1 to 2)
        {
          println(i + ", " + j)
        }
    }

  }

  // NOTE : reduce and fold :-
  //The order in which operations are performed on elements is unspecified and may be nondeterministic in fold
  // where as order in foldLeft and foldRight maintains order from left and right respectively.
  // refer :- https://alvinalexander.com/scala/how-to-walk-scala-collections-reduceleft-foldright-cookbook
  // its very useful fold and reduce will allow each element to get processed with next element applying passed functions.

  def foldTest()= {
    val numbers = List(5, 4, 8, 6, 2)
    println("list " + numbers)
    val a =  numbers.fold(0) { (z, i) =>
    {
      println("fold val1 " + z +" val2 " + i)
      z + i

    }
    }
    println(a)
    val b =  numbers.foldLeft(0) { (z, i) =>
      println("foldleft val1 " + z +" val2 " + i)
      z + i

    }
    println(b)
    val c =  numbers.foldRight(0) { (z, i) =>
      println("fold right val1 " + z +" val2 " + i)
      z + i

    }
    println(c)
  }

  def findMaxInListByFold()={
    val list = List(2,1,3,4)
    val max = list.max
    println("max = " + max)

    // NOTE :: we can use custom user functions like findMaxBetween2Num in foldLeft and reduceleft etc in all such functions.
    val maxUsingFoldLeft = list.foldLeft(Integer.MIN_VALUE)((a,b) => a.max(b))
    println("maxUsingReduceLeft >> " + maxUsingFoldLeft)
    val maxUsingReduceLeft = list.reduceLeft((a,b) => if(a>b) a else b)
    println("maxUsingReduceLeft >> " + maxUsingReduceLeft)


/*    val list_1 = List(1,2,3)
    val foldLeft = list.foldLeft(5)
    println(s"foldLeft result " + foldLeft)*/



  }

  def findMaxBetween2Num(x:Int,y:Int):Int ={
    x.max(y)

  }

  def slidingTest()={

    val list = List(1,2,3,4,5,6,7)
    val maxSumInGroupOfThree = list.sliding(3,1).toList.map(e=>e.sum).max
    // list.sliding(3,1).toList o/p is List[List[Int]] = List(List(1, 2, 3), List(2, 3, 4), List(3, 4, 5), List(4, 5, 6), List(5, 6, 7))


    println("maxSumInGroupOfThree " + maxSumInGroupOfThree )

  }

}
