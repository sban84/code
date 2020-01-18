package main.scala.Scala_CookBook.Chapter_9_FunctionalProg

object Problem_4 {

  //def func3(str: String): Any = ???

  def main(args: Array[String]): Unit = {




    //Exmaple higher order function , taking another func as i/p and calling it

    //println(func1(addOne(2)))

    //println(func3((str : String,i : Int) => str+i))

   /*val sum = (x:Int,y:Int) => { x + y}
    executeAndPrint(sum, 2, 9)

    def sum_1(x:Int,y:Int) : Unit = {
      x+y
    }
*/


    println(concat_higher(concat_lower,"a",1,2))
    //println(concat_higer_2(concat_lower_2("a",1)))


    //println(concat_higher_new(concat_lower,1))

  }

  def concat_higher(f:(String,Int) => String , a:String , b:Int , c:Int) : String = {
    println("Inside concat_higher ")
    f(a,b) + c
  }

  def concat_lower(x:String,a:Int) : String = {
    println("Inside concat_lower ")
    x+a
  }

/*  def concat_higher_new(f:(String,Int) => String ,c:Int) : String = {
    println("Inside concat_higher ")

    val a = c + "a"
    val b = c + 1
    f(a,b) + c
  }





  def concat_higer_2(f:() => String) : String ={
    println("Inside concat_higher_2 ")
    f()
  }

  def concat_lower_2(x:String,a:Int) = () => {
    println("Inside concat_lower_2 ")
    x+a
  }*/


  def add(a : Int )( b : Int )( c: Int) = a+b+c

  val ParamOnlyFirstAdd = add(5)_

  val ParamOnlySecondAdd = ParamOnlyFirstAdd(6)  //-- It will not work because partial applied function cannot be applied
//  multiple times.
//  since "" in partial applied function followed by method, but in above scenarion we are expecting PAF to return another
//  function by applying on function that contradict the defination of applying on method .
//
//    But this can be achieved by curring which is always ,applied over function.

  val PramTwoThreeAdd = ParamOnlyFirstAdd(5)(6) //-- It will Work , since passing parameter of leftout parameter in a methhod.

}
