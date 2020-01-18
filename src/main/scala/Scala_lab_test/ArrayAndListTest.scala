package main.scala.Scala_lab_test

/**
  * Created by suman.banerjee on 4/10/2017.
  *
  * THIS EXAMPLE VERY IMPORTANT for ARRAY in Scala
  * =============================================
  * var arraySizeTest = new Array[Int](5)  // by defalt it will create Array of size 5 initialized to 0 .
  * It can take upto 5 elements
  * But the moment we define arraySizeTest = Array(1,2,3) its size will become =3 . and further inserting into array will cause ArrayIndexOutOfBoundsException
  *
  * One more important point is we can create create Array  in Scala like this
  * ===================
  * val array = Array(1,2,3) // here the size is 3 and items are also initilized
  * but array = new Array[Int][5] -- while defining like this WE NEED new KEYWORD  here the size is 5 and all are initilazed with 0
  * WE can not create List with initial size as its not meant for that.
  *
  *
  * In Java ( this is not possible as in java either we can declare size OR we can initialize with elements) :-
  *
  * int[] arraySizeTest = new int[5];
		int[] arraySizeTest1 = new int[]{1,2,3,4,5};

    WE CAN NOT DO IN JAVA
  * int[] arraySizeTest = new int[5]; and then arraySizeTest = {1,2,3}; So size will be always 5
  *
  */
object ArrayTest {

  def main( args: Array[String] ): Unit = {
    //val array = new Array[Int](5)   // dec only
    val array = Array( 10, 1, 2, 13, 4 ) // dec and assignment both
    /* for(i<- 0 until array.length)
       {
         array(i) = i
       }*/
    printArray( array )

    toAndUntilDifference()
    sortArrayWithoutAPI( array )

    sortArrayWithAPI(Array( 10, 1, 2, 13, 4 ))
    //var z = Array("Zara", "Nuha", "Ayan")

    arrayZipTest(Array( 10, 1, 2, 13, 4 ))


    // START :: Test to check Array are of fixed size in scala like in Java or not
    var arraySizeTest = new Array[Int](5)  // by default it will create Array of size 5 initialized to 0 . For List :- val list = List[Int] or list = List(1,2,3)
    //arraySizeTest = Array(1,2,3)  // this is IMP to remember , This is like re defining the array with new size.
    //arraySizeTest.foreach(e=>println(e))
    println("arraySizeTest.length = " + arraySizeTest.length + " arraySizeTest.size= " + arraySizeTest.size)
    for(i <- 0 until arraySizeTest.length){
      arraySizeTest(i) = i
    }
    //arraySizeTest(5) = 5  // ArrayIndexOutOfBoundsException as array size is fixed
    for(i <- 0 until arraySizeTest.length)
      {
        println("element >> " + arraySizeTest(i))
      }


    // END :: Test to check Array are of fixed size in scala like in Java or not

  }

  def printArray( array: Array[Int] ): Unit = {
    println( "Array Size " + array.length + " and Elements are >> " )
    // loop will run from 0 to array.length -1 , difference between to and untill is , in case of untill loop will iterate one less than the parameter . But in to iteration will go upto the parameter value.
    // So e.g. in array if we wanted to iterate till last element , we need to mention 0 untill array.length  OR 0 to array.length -1
    for (i <- 0 until array.length)
      print( array( i ) + "," )
  }

  def toAndUntilDifference( ): Unit = {
    println( "\n Demo to check difference between to and until " )
    println( "looping using to" )
    for (i <- 0 to 3)
      print( i + "," )

    println( "looping using until With until, the final number is not included." )
    for (i <- 0 until 3)
      print( i + "," )
  }


  // not a good sorting algo , this is just a test , O(n^2)
  def sortArrayWithoutAPI( array: Array[Int] ): Unit = {
    for (i <- 0 until array.length - 1) {
      for (j <- (i + 1) until (array.length)) {
        if (array( i ) > array( j )) {
          var temp = array( i )
          array( i ) = array( j )
          array( j ) = temp
        }
      }
    }
    println( "\nSorted array => " )
    for (i <- 0 until (array.length))
      print( array( i ) + "," )
  }

  def sortArrayWithAPI( array: Array[Int] ): Unit = {
    println("\nSorted array using API => " )
    array.sorted
    for(i <- 0 until(array.length))
      {
        print(array(i) + ",")
      }
  }

  def arrayZipTest(array : Array[Int]) : Unit ={
    for((e , index) <- array.zipWithIndex)
      {
        println(s"element $e and index $index")
      }

  }

}
