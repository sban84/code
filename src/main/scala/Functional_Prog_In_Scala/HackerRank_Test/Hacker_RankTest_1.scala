package main.scala.Functional_Prog_In_Scala.HackerRank_Test

object Hacker_RankTest_1 {

  def main(args: Array[String]): Unit = {

    specialPallindromUserInput()
  }

  def findNumber(arr: Array[Int], k: Int): String = {

    if (arr.length <1)
      "NO"
    else if(arr.contains(k))
      "Yes"
    else
      "NO"

  }


  def specialPallindromUserInput():Int={
    /*println("Enter the length of the String to be tested ")
    val n = scala.io.StdIn.readInt()

    println("Enter the String ")
    val s = scala.io.StdIn.readLine()*/
    val result = specialPallindrom(4,"aaaa")
    println(s"result $result")
    result

  }
  def specialPallindrom(n:Int , s:String):Int={
    var counter =0


    val stringBuilder = new scala.collection.mutable.StringBuilder()




    s.map(e=>{
      println(e + " and " + e.toString.reverse)
      stringBuilder.append(e)

      println(stringBuilder.toString())
      if (stringBuilder.toString().equals(stringBuilder.toString.reverse)){
        println("pallindrom")
        counter +=1
      }

    })
    counter + s.length
  }


  def strPermitation(str:String) = {

  }
}
