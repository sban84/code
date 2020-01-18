package main.scala.Codility_Test

object Test1 {

  def main(args: Array[String]): Unit = {

    val res = Solution_1(328)
    println(res)
  }

  def Solution_1(n: Int): Int = {
    val list = "(?<=1)0+(?=1)".r.findAllIn(n.toBinaryString).toList
    if (list.isEmpty) 0
    else list.maxBy(_.length).length
  }



}


