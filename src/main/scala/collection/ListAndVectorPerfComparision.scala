package main.scala.collection

/**
  * Created by suman.banerjee on 4/17/2017.
  */
object ListAndVectorPerfComparision {

  def main( args: Array[ String ] ): Unit = {
    val list : List[Int] = List.range(0 , 6000000)
    ListPeformance(list)
    val vector : Vector[Int] = Vector.range(0,6000000)
    VectorPerformance(vector)

  }

  def ListPeformance(list : List[Int]) : Unit = {
   var startTime : Long =  System.currentTimeMillis()
   var listCopy = list
    listCopy = 2 :: listCopy
    var endTime : Long = System.currentTimeMillis()
    println("Time taken to Insert a element " + (endTime - startTime) + " MS ")

    startTime =  System.currentTimeMillis()
    val value = listCopy(10000)
    listCopy.updated(10000,2)
    endTime = System.currentTimeMillis()
    println("Time taken to ( random access) query a element " + (endTime - startTime) + " MS and value is " + value)

  }

  def VectorPerformance(vector : Vector[Int]) : Unit = {
    var startTime = System.currentTimeMillis()
    var vectorCopy : Vector[Int] = vector
    vectorCopy = 2 +: vector
    var endTime : Long = System.currentTimeMillis()
    println("Time taken to Insert a element " + (endTime - startTime) + " MS ")

    startTime =  System.currentTimeMillis()
    val value = vectorCopy(10000)
    vectorCopy.updated(10000, 2)
    endTime = System.currentTimeMillis()
    println("Time taken to ( random access) query a element " + (endTime - startTime) + " MS and value is " + value) // This will be faster than List




  }
}
