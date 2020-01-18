package main.scala.Functional_Prog_In_Scala.HackerRank_Test

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import scala.collection.mutable.ListBuffer

object Booking_Request_App {

  def display_all_request(bookings: ListBuffer[Booking_case]): Unit = {
    bookings.foreach(e=> println(e))

    /*for (i <- 0 until bookings.size)
      {
        println(bookings(i))
      }*/
  }

  def getValidBookingReq(bookings: ListBuffer[Booking_case]): ListBuffer[Booking_case] = {

    val valid_bookings = ListBuffer[Booking_case]()
    for (i <- 0 until bookings.size -1){
      for (j <- i+1 until bookings.size){
        var o1 = bookings(i)
        var o2 = bookings(j)

        println(s"o1.start_time ${o1.start_time} ")
        println(s"o1.end_time ${o1.end_time} ")
        println(s"o2.start_time ${o2.start_time} ")
        println(s"o2.end_time ${o2.end_time} ")



        if ((o1.start_time.isBefore(o2.start_time) ) && (o1.end_time.isBefore(o2.start_time))){
          println("inside first loop")
          valid_bookings.append(o1)

        }
        else if ((o1.start_time.isAfter(o2.end_time)) && (o1.end_time.isAfter(o2.end_time))){
          println("inside second loop")
          valid_bookings.append(o1)
        }
      }

    }
    valid_bookings
  }

  def main(args: Array[String]): Unit = {

    val bookings = load_data()
    //display_all_request(bookings)

    val valid_booking = getValidBookingReq(bookings)
    //display_all_request(valid_booking)

    convertDateStringToDateTest
  }

  def load_data() : ListBuffer[Booking_case]= {

    //println("Enter the file name with path ")
    // val file = scala.io.StdIn.readLine()
    val file = "/Users/sumanbanerjee/CODE_Reference/ScalaTest_2017/src/main/scala/Functional_Prog_In_Scala/HackerRank_Test/bookings.txt"

    val booking_request = ListBuffer[Booking_case]()

    val bufferedSource = scala.io.Source.fromFile(file)

    for (line <- bufferedSource.getLines()) {

      //println("line " + line)
      val lineArr = line.split(",")

      val id = lineArr(0)
      val start_time = lineArr(1)
      val end_time = lineArr(2)

      /*println("start_time " + start_time)
      println("end_time " + end_time)
*/
      val start_time_dt = convertDateStringToDate(start_time)
      val end_time_dt = convertDateStringToDate(end_time)

      //val booking_obj = Booking(id.toInt, start_time, end_time)
      val booking_obj = Booking_case(id.toInt,start_time_dt,end_time_dt)

      booking_request.append(booking_obj)

    }
    booking_request
  }


  def convertDateStringToDate(input: String)={
    val date_1 = LocalDateTime.parse(input,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
    date_1
  }

  def convertDateStringToDateTest()={
    println(convertDateStringToDate("2018-01-01 10:00"))
  }

/*  case class Booking(id: Int, start_time: String, end_time: String) {
    override def toString: String = s"ID $id, and start_time $start_time and end_time $end_time"
  }*/

  case class Booking_case(id: Int, start_time: LocalDateTime, end_time: LocalDateTime) {
    override def toString: String = s"ID $id, and start_time $start_time and end_time $end_time"
  }


/*  def checkOverlapingTime(list: List[Booking_case])={

    for (i<-0 until(list.size -1 )){
      for (j <- 0 until(list.size)){
        var o1 = list(i)
        var o2 = list(j)

        if ((o1.start_time.isBefore(o2.start_time) ) && (o1.end_time.isBefore(o2.start_time))){
          println("inside first loop")


        }
        else if ((o1.start_time.isAfter(o2.end_time)) && (o1.end_time.isAfter(o2.end_time))){
          println("inside second loop")

        }
      }
    }

  }*/



}




