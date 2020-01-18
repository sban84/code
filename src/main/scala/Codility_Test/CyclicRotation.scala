package main.scala.Codility_Test

object CyclicRotation {

  def main(args: Array[String]): Unit = {
    val result : Array[Int] = solution(Array(3, 8, 9, 7, 6), 3)
    println("Resulted Array after Rotation  " )
    result.foreach(e=>print(e + " ") )
  }

  def solution(A: Array[Int], K: Int): Array[Int] = {
    def rotateKStep(l: List[Int], K: Int): List[Int] = {
      def rotateOneStep(l: List[Int]) = {
        l.take(l.size - 1).+:(l.last)
      }

      if (K == 0) l
      else rotateKStep(rotateOneStep(l), K - 1)
    }
    if (A.isEmpty) A
    else rotateKStep(A.toList, K).toArray
  }

}
