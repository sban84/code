package main.scala.Scala_lab_test

/**
  * Created by suman.banerjee on 4/10/2017.
  */
object FibonacciTest {



  def main( args: Array[String] ): Unit = {
    //println("result is " + fib(1,2))

    for (i<-0 until 5)
    print(s" ${fiboRecursive(i)}" )

    println("Fibbo using stream ")
    fibs.take(5).foreach(e=>print(e))
  }

  //working
  def fib(prevPrev: Int, prev: Int) {
    val next = prevPrev + prev
    println(next)
    if (next > 1000000) System.exit(0)
    fib(prev, next)
  }

  def fiboRecursive(n: Int): Int = {
    if (n == 0) 0
    else if (n == 1) 1
    else {
      println("Inside else")
      fiboRecursive(n - 2) + fiboRecursive(n - 1)
    }
  }

  lazy val fibs: Stream[BigInt] =
    BigInt(0) #::
      BigInt(1) #::
      fibs.zip(fibs.tail).map(n => {
        //println("Evaluating: %s -> %s".format(n._1, n._2))
        n._1 + n._2
      })

}
