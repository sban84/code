package main.scala.Functional_Prog_In_Scala.HackerRank_Test

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

/*
Function Description

Declare a Checker class that implements the comparator method as described. It should sort first descending by score, then ascending by name.
The code stub reads the input, creates a list of Player objects, uses your method to sort the data, and prints it out properly.

5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150
Sample Output

aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
 */


object SortingObjectsUsingComparator {

  def main(args: Array[String]): Unit = {

    /*val p1 = new Player_Score("amy" , 100)
    val p2 =  new Player_Score("david" , 100)
    val p3 = new Player_Score("heraldo" , 50)
    val p4 =  new Player_Score("aakansha" , 75)
    val p5 = new Player_Score("aleksa" , 150)


    val arrayBufferOfPlayers = ArrayBuffer[Player_Score]()
    arrayBufferOfPlayers.append(p1)
    arrayBufferOfPlayers.append(p2)
    arrayBufferOfPlayers.append(p3)
    arrayBufferOfPlayers.append(p4)
    arrayBufferOfPlayers.append(p5)

    println(" arrayBufferOfPlayers before sorting " + arrayBufferOfPlayers)

    val arrayForCompare = arrayBufferOfPlayers.toArray

    Sorting.quickSort(arrayForCompare)(Player_Score_Comparator)

    arrayForCompare.foreach(e=> println(e))*/


    // Test with Case class to check same work in case class , The requirement is  the same for both i.e. extends Ordering[Class_Name]
    // Same , so we can use any one , case class make coding less


    val arrayBufferOfPlayers_case = ArrayBuffer[Player_Score_Case]()

    val p11 =  Player_Score_Case("amy" , 100)
    val p21 =  Player_Score_Case("david" , 100)
    val p31 = Player_Score_Case("heraldo" , 50)
    val p41 =  Player_Score_Case("aakansha" , 75)
    val p51 = Player_Score_Case("aleksa" , 150)
    val p61 =  Player_Score_Case("aaa" , 100)

    arrayBufferOfPlayers_case.append(p11)
    arrayBufferOfPlayers_case.append(p21)
    arrayBufferOfPlayers_case.append(p31)
    arrayBufferOfPlayers_case.append(p41)
    arrayBufferOfPlayers_case.append(p51)
    arrayBufferOfPlayers_case.append(p61)

    val arrayForComparatorCase = arrayBufferOfPlayers_case.toArray

    // if we need custom sorting / complex like based on multiple condition then use this aproach using Ordering
    Sorting.quickSort(arrayForComparatorCase)(Player_Score_Case_Comparator)

    arrayForComparatorCase.foreach(e=> println(e))


    // In Scala for simple sorting requirement , use Array.SortWith() as shown below ,
    // SortWith is avaiable in in any other Seq collection
    val sorted_by_score_using_sortWith = arrayBufferOfPlayers_case.sortWith((x,y) => x.score > y.score)

    println("sorted_by_score_using_sortWith just by score using sortWith" + sorted_by_score_using_sortWith)

  }

}

// using normal class
class Player_Score(var name:String , var score: Int) {

  override def toString: String = name + " and " + score

}

object Player_Score_Comparator extends Ordering[Player_Score]{
  override def compare(x: Player_Score, y: Player_Score): Int = {
    if (y.score.equals(x.score)){
      x.name.compare(y.name)
    }
    else
    {
      y.score.compare(x.score)
    }
  }
}




// using case class
case class Player_Score_Case(var name:String , var score: Int){

  override def toString: String = name + " and " + score
}

object Player_Score_Case_Comparator extends Ordering[Player_Score_Case] {
  override def compare(x: Player_Score_Case, y: Player_Score_Case): Int = {
    if (y.score.equals(x.score)) {
      x.name.compareTo(y.name)
    }
      else{
        y.score.compareTo(x.score)
      }

  }
}


