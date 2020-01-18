package main.scala.Functional_Prog_In_Scala.HackerRank_Test

object RegularExpressionTest {

  def main(args: Array[String]): Unit = {
    //println("check email " + check("abc_tesco@tesco.com"))

    //println("check email " + check("abc_tesco::tesco.com")) will pass if +@ replaced with +::
    println("check email " + check("abc_tesco@tesco.com"))

  }

  // ^ means start with , so email can start with a-zA-Z0-9!#$%&'*+/=
  // after that can have
  private val emailRegex = """^[a-zA-Z0-9\!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r


  private val emailRegex_small = """"""


  def check(e: String): Boolean = e match{
    case null                                           => false
    case e if e.trim.isEmpty                            => false
    case e if emailRegex.findFirstMatchIn(e).isDefined  => true
    case _                                              => false
  }
}
