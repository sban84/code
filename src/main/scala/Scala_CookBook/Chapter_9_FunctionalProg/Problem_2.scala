package main.scala.Scala_CookBook.Chapter_9_FunctionalProg

/**
  * Created by suman.banerjee on 4/26/2017.
  *
  * You want to pass a function around like a variable, just like you pass String, Int, and
    other variables around in an object-oriented programming language.

    >> implicit and explicit way of defining functions in scala

  */
object Problem_2 extends App{

  // implicit approach  .. Prefer this
  val addImp = (x: Int, y: Int) => { x + y }
  // explicit approach
  val addExp: (Int, Int) => Int = (x,y) => { x + y }

  val addThenDoubleImp = (x :Int , y:Int) => {
    val a = x + y
    2 * a
  }
  val addThenDoubleExp: (Int, Int) => Int = (x,y) => {
    val a = x + y
    2 * a
  }

  println("addThenDoubleImp= " + addThenDoubleImp(2,3))
  println("addThenDoubleExp= " + addThenDoubleExp(2,3))


  //Test 1 # , method with no arg and no return Implicit way , Prefer this
  val sayHello = () => println("Hello")
  executeXTimes(sayHello , 3)

  def executeXTimes(callback:() => Unit, numTimes: Int) {
    for (i <- 1 to numTimes) callback()
  }

  // IMPORTANT >>>> Test 2 # , method with 2 arg and return Implicit way , Prefer this

  def executeAFunction(f:(Int,Int) => Int , x:Int , y : Int) : Int = {
    println("Inside executeAFunction ....x = " + x + " and y = " +y)
    val result = f(x,y)
    return result
  }

  val addFunc = (x:Int,y:Int) => {x + y}  // Implicit way of defining function
  val mulFunc = (x:Int,y:Int) => {x * y}  // Implicit way of defining function

  //val addFuncExp:(Int,Int) => Int = (x:Int,y:Int) => {x + y}  // Implicit way of defining function

  println("executeAFunction(addFunc,2,3) >>> " +executeAFunction(addFunc,2,3) )
  println("executeAFunction(mulFunc,2,3) >>> " +executeAFunction(mulFunc,2,3) )
  println("calling directly >>> " + addFunc(2,3))


}
