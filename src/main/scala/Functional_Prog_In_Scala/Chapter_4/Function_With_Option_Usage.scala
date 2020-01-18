package main.scala.Functional_Prog_In_Scala.Chapter_4

object Function_With_Option_Usage {

  def main(args: Array[String]): Unit = {
    val result = parseInsuranceRateQuote("1" ,"2") // parseInsuranceRateQuote will return None if some exception while converting String to Int
    // or Some(Double) if success
    //val result = parseInsuranceRateQuote("1" ,"Hello")
    println("result " + result)
  }

  def parseInsuranceRateQuote( age: String,numberOfSpeedingTickets: String): Option[Double] = {
    val optAge: Option[Int] = Try(age.toInt)
    val optTickets: Option[Int] = Try(numberOfSpeedingTickets.toInt)
    //insuranceRateQuote(optAge, optTickets)

    // Its not possible to modify the existing function to take Option instead of Primitives ,
    // So map2[A,B,C](a:A,b:B)(f:(A,B) = > C) : Option[C]  will be usful to Lift any existing function to work with Option without changing existing function.
    // Very useful , as Option is better to handke errors.
     map2(optAge, optTickets)(insuranceRateQuote)

  }

  // Both Try and map2 is required .
  // Try will convert primitives into Option and
  //map2 will help to Lift existing function .
  def Try[A](a: => A): Option[A] = {

    println("Inside Try ")
    try Some(a)
    catch { case e: Exception => None }
  }


  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
    a flatMap (aa =>
      b map (bb =>{ println("aa " + aa + " bb " + bb); f(aa, bb)}))


  def insuranceRateQuote(a:Int , b:Int) = {
    println("a = " + a)
    println("b = " + b)
    a + b
  }

  // if we have List[String] and we wanted to convert that into List[Int]

}


