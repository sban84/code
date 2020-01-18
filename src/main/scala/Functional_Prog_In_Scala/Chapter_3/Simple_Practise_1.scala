package main.scala.Functional_Prog_In_Scala.Chapter_3

object Simple_Practise_1 {

  def main(args: Array[String]): Unit = {
    val result  = findMax(3,2)
    println("result of Max " + result)

  }

  def findMax(a : Int , b : Int) : Int ={
    if (a>b)
      a
    else
      b
  }
}
