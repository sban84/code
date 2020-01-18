package main.scala.Scala_CookBook.Chapter_9_FunctionalProg

/**
  * Created by suman.banerjee on 4/26/2017.
  *
  * You want to use an anonymous function—also known as a function literal—so you can
    pass it into a method that takes a function, or to assign it to a variable.
  */
object Problem_1 extends App{

  val list = List(1,2,3,4,5,6,7,8,9,10)
  val even = list.filter((e : Int) => e%2 ==0)  // Here (e : Int) => e%2 ==0 is Function literal / anonymous function
  val funcLit = (e:Int) => e%2 ==0 // Anonymous function is assigned to variable

  val evens = list.filter((e : Int) => if(e%2==0)true else false)

  val even_short = list.filter(_%2 ==0)

  val even_by_passing_fuctionliteral_as_variable = list.filter(funcLit)

  println("even =>> " + even )
  println("evens =>> " + evens )
  println("even_short =>> " + even_short )
  println("even_by_passing_fuctionliteral_as_variable =>> " + even_by_passing_fuctionliteral_as_variable )

  // using foreach we can do the same thing also.
  list.foreach(e=>if(e%2==0) print(e + ","))
}
