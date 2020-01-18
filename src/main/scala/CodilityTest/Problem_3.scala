package main.scala.CodilityTest

object Problem_3 {

  def main(args: Array[String]): Unit = {

/*    val   s =
      """my.song.mp3 11b
greatSong.flac 1000b
not3.txt 5b
video.mp4 200b
game.exe 100b
mov!e.mkv 10000b"""*/

    val s =
      """my.song.mp3 11b
        |greatSong.flac 1000b
        |not3.txt 5b
        |video.mp4 200b
        |game.exe 100b
        |movie.mkv 10000b""".stripMargin

    println(solution_3(s))

    //println(solution(123456))


    //loopTest

    //loopTest_1()
  }


  def solution_3(s: String) :List[(String, Int)]= {


    val arr = s.split("\n")

    val testsmalarr = arr.map(x=> x.split(" "))

    val testsmalarr1 = testsmalarr.map(x=>((x(0).split("\\.").last),x(1)))

    val testsmalarr2 = testsmalarr1.map( x=> (
      x._1 match {
        case "mp4" => "movies"
        case "avi" => "movies"
        case "mkv" => "movies"
        case "bmp" => "images"
        case "gif" => "images"
        case "mp3" => "music"
        case "acc" => "music"
        case "flac" => "music"
        case "jpg" => "images"
        case _ => "other"
      } , x._2.replace("b","")
    ))

    testsmalarr2.groupBy(e=>e._1).map(e=>(e._1,e._2.map(t=>t._2))) // scala.collection.immutable.Map[String,Array[String]] = Map(movies -> Array(200, 10000), others -> Array(5, 100), music -> Array(11, 1000))
    val fileType_valueSize_Map = testsmalarr2.groupBy(e=>e._1).map(e=>(e._1,e._2.map(t=>t._2.toInt))).mapValues(e=> e.sum) //Map(movies -> 10200, others -> 105, music -> 1011)

    val expected_Map_Structure = scala.collection.mutable.HashMap("music" -> 0,"images" -> 0,"movies"-> 0,"other" ->0)

    fileType_valueSize_Map.keys.foreach(e=>{
      expected_Map_Structure.put(e,fileType_valueSize_Map.getOrElse(e,0))
    })




    // ****** if we need to return in String *******
    val string_buffer = new StringBuffer("")
    expected_Map_Structure.toList.foreach(e=>{
      string_buffer.append(e)
    })

      println(string_buffer.toString.replace('(','\n').replace(')','b'))

    expected_Map_Structure.toList // List((movies,10200), (images,0), (music,1011), (other,105))
}


  def solution(a: Int): Int = {
    // write your code in Scala 2.12

    val input_number = a.toString
    val StringBuffer = new StringBuilder()

    var length = 0

    length = input_number.length -1
    var count =0

    if (input_number.length % 2 == 0){
      count = length /2
    }

    else
    {
      count = length /2
    }
    for (i<- 0 to(count  ) ) {

      println(i)

      var j = length  - i

      var firstDigit = input_number(i)
      var secondDigit = input_number(j)

      StringBuffer.append(firstDigit.toString)


      if (StringBuffer.length <= input_number.length -1 ){
        StringBuffer.append(secondDigit.toString)

      }
    }
    //print(StringBuffer.toString())

    Integer.parseInt(StringBuffer.toString())

  }



  /*def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12

    //val sorted_array = a.sorted

    val set = scala.collection.mutable.HashSet[Int]()
    a.map(e=>{
      set.add(e)
    })

    var missing_item = 0
    var found_first_missing_flag = false
    for (i <- 1 until(Integer.MAX_VALUE) if (found_first_missing_flag == false)) {
      //println(i)
      if (!set.contains(i) && found_first_missing_flag == false){
        missing_item =  i
        found_first_missing_flag = true
      }
    }
    //println(s"missing_item >> $missing_item")
    missing_item

  }*/


  // Another short way for solution
  def loopTest(): Unit ={
    println("inside loopTest ")
    val num = 123456.toString

    var j = num.length - 1
    //var count = 0

    val string_buffer = new StringBuffer("")
    for (i <- 0 until num.length)
      {

        if ( j > i){
          string_buffer.append(num(i))
          string_buffer.append(num(j))
          println(i,j)
          j -= 1
        }
        else if (num.length % 2 !=0 && j == i){
          string_buffer.append(num(i))
        }
      }
    println("string_buffer  >> " + string_buffer)

  }

  //for loop with if condition in it .
  def loopTest_1() ={
    val num = 123456.toString
    for (i <- 0 until(num.length) ; if (i % 2 ==0)){
      println(i)

    }
  }
}
