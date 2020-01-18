package main.scala.Scala_lab_test


/**
  * Created by suman.banerjee on 4/12/2017.
  */
object LazyTest {

  def main( args: Array[ String ] ): Unit = {

    val x = {println("foo") ; 12}  // here initialization happen instantly
    println("bar")
    println(x)


    lazy val x1 = {println("foo") ; 12}  // here initialization happen once its called i.e on demand
    println("bar")
    println(x1)

  }

}


/*
trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g
  override def toString = numer +"/"+ denom
  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}*/
