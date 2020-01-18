package main.scala.Functional_Prog_In_Scala.Chapter_2

object PolymorphicFunctions {

  def main(args: Array[String]): Unit = {

    println("Insidee Main")
    //println("checking polymorphic function isSorted " + isSorted(Array(1,2,30) , (a:Int,b:Int)=> a < b ))
    println("checking polymorphic function isSorted " + isSorted(Array(1,2,3) , (a:Int,b:Int)=> {if (a < b) return true else false} )) // passing anonymous func

    println("checking polymorphic function isSorted " + isSorted(Array(1,1,3) , function ))
  }


  val function = (a:Int , b:Int ) => if (a<b) true else false

  def isSorted[A](array: Array[A], ordered: (A,A) => Boolean): Boolean={

    @annotation.tailrec
    def go(n:Int):Boolean ={

      println(n)
      println(array.length)

      if(n >= array.length -1 ) return true // i.e array is sorted
      else if (ordered(array(n) , array(n+1))) {

        println(s" ${array(n)} and ${array(n+1)}")
        return true     // // ordered is any comparision funtion , if that return true tht implies array is not following that rule i.e sortedin thios case
      }
      else
        go(n+1)
    }
    go(0)
  }

 /* def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = {
    @annotation.tailrec
    def go(n: Int): Boolean =
      if (n >= as.length-1) true
      else if (gt(as(n), as(n+1))) false
      else go(n+1)

    go(0)
  }*/

  /* def gt(a: Int,b:Int):Boolean ={
     if(a > b) return true
     else false
   }*/


}
