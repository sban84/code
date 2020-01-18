package main.scala.Scala_CookBook.Chapter_3

import scala.util.control.Breaks
import scala.util.control.Breaks._

/**
  * Created by suman.banerjee on 4/22/2017.
  */
object BreakAndContinueTest {

  def main ( args: Array[ String ] ): Unit = {

    //Test1 , see how break and continue works

    breakable {
                for ( i <- 0 to 10 ) {
                  println ( "Value of i " + i )
                  if ( i == 5 ) break ()
                }
              }

    //Test 2 , Nested loops and labeled break.
    println("Test on Nested loops and labeled break ")
    val Inner = new Breaks
    val Outer = new Breaks

    Outer.breakable {
                      for ( i <- 1 to 5 ) {
                        Inner.breakable {
                                          for ( j <- 'a' to 'e' ) {
                                            if ( i == 1 && j == 'c' ) Inner.break else println ( s"i: $i, j: $j" )
                                            if ( i == 2 && j == 'b' ) Outer.break
                                          }
                                        }
                      }
                    }


  }

}
