package main.scala.Scala_CookBook.Chapter_3

/**
  * Created by suman.banerjee on 4/21/2017.
  */
object LoopOperation {

  def main(args : Array[String]) :Unit = {

    val array : Array[String] = Array("apple" , "banana" , "orange")

    //Test 1 # loop through the Array and do upper case
    for(e <- array){
      println("Elements in UpperCase " + e.toUpperCase())
    }

    // Test2 # loop through and upper case and finally return as new Array
    val fruitsInUpperCase = for(e <- array) yield{
      e.toUpperCase()
    }
    println("For Loop Returning values " )
    fruitsInUpperCase.foreach(x=>println(x))

    //Test3 , loop through foreach
    array.foreach(x=>print(x + ","))

    //Test4# Accessing elements in loop using index // like in Java
    println("\nAccessing elements/Processing in loop using Normal Index ")
    for(i <- 0 until array.length)   // same as for(i <- 0 to array.length -1)
    {
      print("\nIndex = " + i + " Elements= " + array(i).toUpperCase() +",")
    }

/*    array.foreach(e => e.toUpperCase())   NOTE : foreach on any collection does not return any new collection it helps to modify items present in called collection
    array.foreach(e => println("array after uppercase" + e))*/

    //Test5 # Accessing elements/Processing in loop using zipWithIndex
    println("\nAccessing elements/Processing in loop using zipWithIndex")
    val arrayWithZipIndex = array.zipWithIndex  // will form List((apple,0), (banana,1),(orange,2))
    //arrayWithZipIndex.foreach(x=>println(x))
    for((e,count) <- arrayWithZipIndex) {
      println("Index = " + s"$count" + " Elements= " + s"$e".toUpperCase() +",")

    //Test6 # create Range and safe guard check in  for loop , very useful to pit check before / while executing the loop
      for(i<-0 to 10 if(i%2==0)){
        print("Even Numbers in the Range " + i + ",")
      }

      //Test7# looping though Map collection
      val names = Map("fname" -> "Robert","lname" -> "Goren")
      for ((k,v) <- names) println(s"key: $k, value: $v")
    }
  }
}
