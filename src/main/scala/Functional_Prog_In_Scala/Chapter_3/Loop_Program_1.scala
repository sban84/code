package main.scala.Functional_Prog_In_Scala.Chapter_3

object Loop_Program_1 {

  def main(args:Array[String] ) :Unit = {

    var i =0
    whileLoop(i<3 ,{print(i) ; i = i+1} )



  }

  def whileLoop(cond : Boolean , func :  => Unit) : Unit={

    if (cond)
      {
        func
        whileLoop(cond,func)
      }

  }
}
