package main.scala.Scala_lab_test


import java.text.DateFormat._
import java.util.{Date, Locale}

/**
  * Created by suman.banerjee on 3/27/2017.
  */



object DisplayDateFormatByCountry {

  def main(args: Array[String]): Unit =
  {
    val now = new Date()
    //val df = getInstance(DateFormat.LONG , Locale.FRANCE)


    val df = getDateInstance(LONG, Locale.ENGLISH)
    println("Date format " + df.format(now))


  }

}
