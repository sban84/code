package main.scala.Functional_Prog_In_Scala.Chapter_3

import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit.{DAYS, MONTHS, YEARS}
import java.time.{LocalDate, LocalDateTime}
import java.util.Calendar

//import Functional_Prog_In_Scala.HackerRank_Test.{Player_Score_Case, User_Input_Test}

import scala.collection.mutable.ListBuffer
import scala.util.Sorting


object Date_Program_1 {

  def dateCompare(str1: String, str2: String): Unit = {
    val date_1 = LocalDate.parse(str1,DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val date_2 = LocalDate.parse(str2,DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    println(s"dateCompare between $date_1 and $date_2 is >> ${date_1.compareTo(date_2)}")
  }

  def main(args:Array[String]) : Unit ={
    //date_test()

    //checkYearIsLeap()

    //date_test_1()

    //println("result " + getNumberOfMonths("2017-01-13" , "2018-01-12"))

    //getNumberOfWeekends("2018-12-12" , "2018-12-22")


    /*println("minusMonthsFromDate() " + minusMonthsFromDate("2018-12-14" , 12))
    println("getNumberOfMonths " + getNumberOfMonths("2019-02-02" , "2018-12-02"))

    println(s"dateDiff ${dateDiff("2018-12-13" , "2019-12-15")}" )  // dateDiff(START DATE , END DATE)

    dateCompare("2018-12-14" , "2017-12-14")

    checkADateIsInBetweenListOfDates("2018-12-02")*/

    val dates = List("2019-02-01 14:00:00", "2019-02-01 01:00:00" , "2019-01-01")
    sortDates(dates)

    val datesFallingResult = checkTimeFallingBetweenGivenDates(dates , "2019-02-01 10:00:00")
    println(s"datesFallingResult $datesFallingResult")


    val end_date = "2020-07-09"
    val start_date = "2019-09-29"
    println(s" dateDiff Test end_date=$end_date and start_date=$start_date = "+ {dateDiff(end_date , start_date)})
  }





  def getNumberOfMonths(str1:String, str2:String)={

    val start_date = LocalDate.parse(str1 , DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val end_date = LocalDate.parse(str2 , DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    //Both dates inclusive, hence adding 1
    val noOfMonths = MONTHS.between(end_date, start_date)   // these API accepts only Date , So we need to convert the String to Date first using LocaleDate.parse
    val noneofYears = YEARS.between(end_date,start_date)
    val noneofDays = DAYS.between(end_date,start_date)

    println("Month difference  " + noOfMonths)
    println("Year difference " + noneofYears)
    println("Days difference  " + noneofDays)

    // to return year-month-day
    noneofYears + ":" + noOfMonths + ":" + noneofDays


    // how to convert date into String
   /* val date_1= java.time.LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss")
    val curr_date_formatted = formatter.format(date_1)
    println("current date "+ curr_date_formatted)*/

  }

  def getNumberOfWeekends(str1:String , str2:String) ={

    var date1=  LocalDate.parse(str1,DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val date2 = LocalDate.parse(str2,DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    //date1.compareTo(date2) for comparring dates
    println(date1.isBefore(date2))
    var num_weekends = 0

    while(date1.isBefore(date2)){
      println("date1 " + date1)
      if ((date1.getDayOfWeek().getValue == Calendar.SUNDAY) || (date1.getDayOfWeek().getValue == Calendar.SATURDAY)){
        num_weekends =  num_weekends +1
      }
      date1 = date1.plusDays(1)
    }

    println("num_weekends " + num_weekends)

  }


  def minusMonthsFromDate(str:String , n:Int) : String={

    val input_date = LocalDate.parse(str , DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val date_after_minus_month = input_date.minusMonths(n)
    date_after_minus_month.toString
  }

  import java.time.Period

  def dateDiff(str1:String,str2:String) : Int={
    val start_date = LocalDate.parse(str1 , DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val end_date = LocalDate.parse(str2 , DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    var diff = 0

    val noOfYearDiff = Period.between(start_date, end_date).getYears
    val noOfMonthsDiff = Period.between(start_date,end_date).getMonths
    val noOfDaysDiff = Period.between(start_date,end_date).getDays


    println("Date Comparision >> " + Period.between(start_date,end_date).getMonths)

    Period.between(end_date,start_date).getMonths






    /*if (end_date.isAfter(start_date)){

      diff = end_date.compareTo(start_date) // return positive if end_date > start_date
    }
    else{
      diff = start_date.compareTo(end_date)
    }*/

  }


  def getLastPartition(year : String):String={
    //val curr_date = LocalDate.now().toString
    var curr_date_formatted =  LocalDate.parse(year,DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val lastYear = curr_date_formatted.minusYears(1).getYear.toString
    lastYear + "_" + curr_date_formatted.getYear
  }

  def checkADateIsInBetweenListOfDates(input : String): Unit ={

    val list_str = List("2018-01-01" , "2018-06-06" , "2019-01-01")
    val list_dates_buffer = ListBuffer[LocalDate]()

    val input_date = LocalDate.parse(input , DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    val list_dates = list_str.map(e=>{
      list_dates_buffer.append(LocalDate.parse(e,DateTimeFormatter.ofPattern("yyyy-MM-dd")))
    })

    println("list_dates_buffer " + list_dates_buffer)
    var inBetween = false

    for (i <- 0 until(list_dates_buffer.length -1 )){
      if (list_dates_buffer(i).isBefore(input_date) && list_dates_buffer(i+1).isAfter(input_date)){
        inBetween = true
      }
    }
    println("inBetween >> "+ inBetween)
    inBetween
  }


  def sortDates(dates : List[String]):Array[LocalDateTime] = {
    val listBuffer = new ListBuffer[LocalDateTime]()
    var e_concat = ""
    val dates_list = dates.map(e=>{

      if (e.length < 19){
        e_concat = e.concat(" 00:00:00")
      }
      else{
        e_concat = e
      }
      val d:LocalDateTime = LocalDateTime.parse(e_concat, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
      listBuffer.append(d)
    })
    val listBufferArr = listBuffer.toArray
    Sorting.quickSort(listBufferArr)(Date_Comparator)
    listBufferArr.foreach(e=> println(e))
    listBufferArr
  }

  def checkTimeFallingBetweenGivenDates(dates : List[String] , inputDateStr : String) : Boolean ={

    val inputDate = LocalDateTime.parse(inputDateStr , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    val dates_sorted = sortDates(dates)
    var run = true
    var found = false
    println("inputDate" + inputDate)
    for (i <-0 until(dates_sorted.size) if(run == true)){
      if ( ( inputDate.isAfter(dates_sorted(i)) || (inputDate.isEqual(dates_sorted(i))) ) && ( inputDate.isBefore(dates_sorted(dates_sorted.size -1)) || inputDate.isEqual(dates_sorted(dates_sorted.size -1 )) )  ){
        run = false
        println("inside if ")
        found = true
      }

      /*val first_date =  dates_sorted(0)
      val last_date = dates_sorted(dates_sorted.length -1)
      if (inputDate.compareTo(first_date) >= 0 || inputDate.compareTo(last_date) <=0){
        found = true
      }*/

    }
    found

  }
}


object Date_Comparator extends Ordering[LocalDateTime] {
  override def compare(x: LocalDateTime, y: LocalDateTime): Int = {
    x.compareTo(y)
  }
}


