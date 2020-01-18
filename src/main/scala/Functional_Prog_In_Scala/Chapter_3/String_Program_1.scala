package main.scala.Functional_Prog_In_Scala.Chapter_3

object String_Program_1 {

  def main(args: Array[String]): Unit = {

    println("longestCommonSubstring(\"hello world\" , \"world\") " +  longestCommonSubstring("hello world" , "world"))

    subSctringPresense("abc" , "abdfabcwabc")
  }

 /* def getAllSubstrings(str: String): Set[String] = {
    println("str "+  str.init)
    str.inits.flatMap(e=>{
      println("e" + e)
      println("e.tail " + e.tail)
      e.tails
    }).toSet
  }
  def longestCommonSubstring(str1: String, str2: String): String = {
    val str1Substrings = getAllSubstrings(str1)
    val str2Substrings = getAllSubstrings(str2)

    str1Substrings.intersect(str2Substrings).maxBy(_.length)
  }*/


  def getSubstrings(s:String) =
    for {
      start <- 0 until s.size
      end <- start to s.size

    } yield s.substring(start, end)

  def longestCommonSubstring(one: String, two: String): Seq[String] ={

    getSubstrings(one).intersect(getSubstrings(two))
      .groupBy(e=>e.length).maxBy(e=>e._1)._2
  }


  def test(s:String) ={
    for {
      start <- 0 until s.length
      end <- 0 to s.length
    }yield(start,end)
  }



  def subSctringPresense(find:String , str:String) : Unit ={

    var s , count =0

    for (i <- 0 until str.length by 1 ){
      if(s!=find.length() && str.charAt(i)==find.charAt(s))
        s = s + 1
        else if (s > 0)
          s = 0
      if (s == find.length) {
        count += 1
        s = 0
      }



      }

  println("count " + count)
  }

}
