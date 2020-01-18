package main.scala.Scala_CookBook.Chapter_4

object PassByValueOrReference {

  def main(args: Array[String]): Unit = {

    println("Calling PassByValue ***** \n")

    //In this case the addOne(1) is pre-computed , and then goes inside PassByValue,
    // println("Inside printMessage ") called only one time .
    PassByValue(addOne(1))



    println("\n Calling PassByVReference ***** \n")

    //In this case addOne(1) is not pre-computed , it will be computed at the time of calling and it will be same number of as how many
    // times its called , like e.g. here its called / accessed 3 times inside passByReference
    // Inside printMessage is called 3 times So that means computation happened those many times as the no of times its get accessed.
    passByReference(addOne(1))

  }

  def PassByValue(a:Int)={

    println("Inside PassByValue " + a)
    println("Inside PassByValue " + a)

    val result = a + 10
    println("Inside PassByValue result " + result)

  }

  def passByReference(a : => Int): Unit = {
    println("Inside passByReference " + a)
    println("Inside passByReference " + a)
    val result = a + 10
    println("Inside passByReference result " + result)
  }

  def addOne(a:Int): Int ={
    println("Inside printMessage ")
    a + 1

  }
}


