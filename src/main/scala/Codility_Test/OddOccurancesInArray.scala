package main.scala.Codility_Test

object OddOccurancesInArray {

  def main(args: Array[String] ) : Unit ={
    //val odd = Solution_1(Array(3,2,3,4,2))
    //println("Number with Odd Pair " + odd)

    solution_2(Array(2,3,4,2,3))

    /*var list = List(3,2,4,3,6)
    val in = list.indexOf(list.head, 0)
    val in1 = list.tail
    in1.foreach(e=>print(e))*/
  }
  def Solution_1(array: Array[Int]) : Int = {

    var map:Map[Int,Int] = Map[Int, Int]()
    var oddNumber = None:Option[Int]

    for(e <- array)
      {
        print( e + " ")
        if(map.contains(e)){
          map += (e -> (map(e)+1))

        }
        else
          map += (e -> 1)
      }
    map.foreach {keyVal => if(keyVal._2==1) oddNumber = Some(keyVal._1) }
    val odd = oddNumber.get
    odd

  }

  def solution_2(A: Array[Int]): Int = {
    def getUnpaired(list: List[Int]): Int = {
      val in = list.indexOf(list.head, 1)
      println("in value " + in)
      if (in == -1) list.head
      else getUnpaired((list.take(in) ::: list.takeRight(list.size - in - 1)).tail)
    }
    getUnpaired(A.toList)
  }

}
