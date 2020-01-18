package main.scala.Functional_Prog_In_Scala.Chapter_4

object LazyTest {

  def main(args: Array[String]): Unit = {

    val x = maybeTwice(true, { println("hi"); 1+41 })

    println("Now Lazy way of calling ... ")
    val y = maybeTwice_lazy(true, { println("hi"); 1+41 })

    println("Stream Test ")
    val streamdata = streamTest(1,1).take(7).toList
    println("streamdata >> " + streamdata )

    println("createStream(1,2).take(10).toList " + createStream(1,2).take(10).toList)

  }

  def maybeTwice(b: Boolean, i: => Int) = {
    if (b) i+i+i // argument of maybeTwice function will be evaluated 3 times as its been referred 3 times .
    else 0
  }

  /*
  Adding the lazy keyword to a val declaration will cause Scala to delay evaluation of the right-hand side of that lazy val declaration
  until it’s first referenced. It will also cache the result
  so that subsequent references to it don’t trigger repeated evaluation.
   */
  def maybeTwice_lazy(b: Boolean, i: => Int) = {
    lazy val j = i
    if (b) j+j // argument of maybeTwice function will be evaluated 1 times as its been referred by lazy .
    else 0
  }

  // Stream test
  /*
  A Stream is like a list except that its elements are computed lazily. Because of this, a stream can be infinitely long. Only those elements requested are computed. Otherwise, streams have the same performance characteristics as lists.

  Whereas lists are constructed with the :: operator, streams are constructed with the similar-looking #::. Here is a simple example of a stream containing the integers 1, 2, and 3:
   */
  def streamTest(a:Int,b:Int) : Stream[Int] ={
    a #:: streamTest(b,a+b)
    }

  // Simple test to generate stream of data
  def createStream(a:Int,b:Int) : Stream[Int]={
    a #:: createStream(b,b+1)
  }
}
