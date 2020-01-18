package main.scala.Scala_CookBook.Chapter_10_Collection

/**
  * Created by suman.banerjee on 4/26/2017.
  *
  * THis is basic example before going into details of collections:-
  *
  * What a predicate is :- A predicate is simply a method, function, or anonymous function that takes one or more parameters and returns a Boolean value.
  • What an anonymous function is :
  • Implied loops
  */
object Problem_1 extends App{

  // Predicate function
  def isEven (i: Int) = if (i % 2 == 0) true else false

  // anonymous function  :- (i: Int) => i % 2 == 0
  val list = List.range(1, 10)
  println("accessing list at index " + list.size + " and element " + list(8))

  val evens = list.filter(e=>(if(e%2==0) true else false))  // here e =>(if(e%2==0) true else false) is anonymous function
  println("evens >> " + evens)

  //implied loops. As you can see from that example,   the filter method contains a loop that applies your function to every element in the collection and returns a new collection. You could live without the filter method and     write equivalent code like this:
  // But Filter approach is both more concise and easier to   read.
  for {
    e <- list
    if e % 2 == 0
  } yield e


}
