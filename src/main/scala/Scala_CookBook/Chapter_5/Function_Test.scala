package main.scala.Scala_CookBook.Chapter_5

object Function_Test {

  def main(args: Array[String]) : Unit ={
    functionWithVarArgs(1,"a","b","c")
  }

  def functionWithVarArgs(a:Int,str : String* ): Unit =
  {
    val res1 = a + 10
    /*val res2 = ""
    str.map{ e=> res2 + e}*/

    var res2=""
    for (i<- 0 to str.length -1 ){
      res2 = res2 + str(i)
    }
    println("res2 " +  res2)


  }
}
