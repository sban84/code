package main.scala.Functional_Prog_In_Scala.Chapter_4

object Option_Program_1 {

  def main(args: Array[String]): Unit = {

    val mean_result = mean(List(2.0,1) , None)
    println("mean_result " + mean_result.getOrElse())
  }

  // idea is to show how we can make use of option in scala
  def mean(list: List[Double] , option: Option[Double]) : Option[Double] ={

    var result = None : Option[Double]
    if (list.isEmpty) result
    else {
      result = Some(list.sum / list.size)
    }
    result
  }


}
