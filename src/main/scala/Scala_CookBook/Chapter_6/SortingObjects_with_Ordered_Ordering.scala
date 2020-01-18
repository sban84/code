package main.scala.Scala_CookBook.Chapter_6

import scala.collection.mutable.ListBuffer
import scala.util.Sorting

/*

THis is very useful code to understand how we can sort objects in Scala .
there are 2 ways of doing thing like Java
1) Ordered :- a object self can compare with other object

2) Ordering :- 2  objects can be compared , normally use this .


// 2 ways of comparing objects / primitives
------------------------------------------
either do list.sorted / list.sortWith ( applicatble to array , arrayBuffer , listBuffer )
use this we want natural sorting e.g. primitives
OR
Sorting.quickSort(array)(orderingByNames_Comparator)
use this for objects and custom ordering
 */

object SortingObjects_with_Ordered_Ordering {



  def main(args: Array[String]): Unit = {

    // Test 1 #

    var list_ordered = List[Person]()
    val p1 = new Person("Suman", "Banerjee")
    val p2 = new Person("Stman", "Tendilkar")
    val p3 = new Person("Vinod", "AAAAA")
    val p4 = new Person("Suman", "Tendilkar")

    /*    val p1 = new Person("Suman" )
    val p2 = new Person("Sachin" )
    val p3 = new Person("Vinod" )*/

    list_ordered = p1 +: list_ordered  // adding in the head
    list_ordered = p2 +: list_ordered
    list_ordered = p3 +: list_ordered
    list_ordered = p4 +: list_ordered // adding in the head

    println("Testing normal Person class which extends Ordered[Person] ----- >")
    println("list before sorting " + list_ordered)

    val sorted_list_person = list_ordered.sorted

    println("list after sorting sorted_list_person " + sorted_list_person)

    val listSortBy = list_ordered.sortBy(e=> e.first)

    println("list listSortBy sorting by first name " + listSortBy)

    // NOTE *** :: important to understand here even though we define f.first but the comparision will work
    // based on the compare() implementation defined in class extends Ordered
    val list_sorted_using_sortwith = list_ordered.sortWith((x,y) => x.first > y.first)


    println("Testing  Person_Case class ----- >")

    val listBuffer_case = ListBuffer[Person_Case]()
    val pc1 = Person_Case("Suman", "Banerjee")
    val pc2 = Person_Case("Stman", "ATendilkar")
    val pc3 = Person_Case("Vinod", "Kambli")
    val pc4 = Person_Case("Suman", "ATendilkar")

    listBuffer_case.append(pc1)
    listBuffer_case.append(pc2)
    listBuffer_case += pc3
    listBuffer_case.append(pc4)

    println("List Buffer before sorting " + listBuffer_case)  // ListBuffer(Suman Banerjee, Stman Tendilkar, Vinod Kambli, Suman Tendilkar)

    // val listBuffer_sorted = listBuffer.sorted  // sorted on any class will not work until we extend Ordered and implement compare()
    val listBuffer_sorted_by_firstName = listBuffer_case.sortWith((x,y) => x.first < y.first) // descending order by first name

    println("listBuffer_sorted_by_firstName after  sorting " + listBuffer_sorted_by_firstName)

    val listBuffer_sorted_using_sortyBy_func = listBuffer_case.sortBy(e=>e.first) // same as sortWith but sortWith takes function so we can do ascending / descending
    // nut here by default is ascending

    println("listBuffer_sorted_using_sortyBy_func after  sorting " + listBuffer_sorted_using_sortyBy_func )


    println("Testing  Person_Ordering class which extednds Ordering[Person_Ordering]----- >")

    val person_Ordering1 = new Person_Case("Suman", "Banerjee")
    val person_Ordering2 = new Person_Case("Stman", "Tendilkar")
    val person_Ordering3 = new Person_Case("Vinod", "Kambli")
    val person_Ordering4 = new Person_Case("Suman", "Tendilkar")

    val listBuffer_ordering = ListBuffer[Person_Case]()

    listBuffer_ordering.append(person_Ordering1)
    listBuffer_ordering.append(person_Ordering2)
    listBuffer_ordering.append(person_Ordering3)
    listBuffer_ordering.append(person_Ordering4)

    println("listBuffer_ordering before sorting " + listBuffer_ordering)

    val listBuffer_ordering_sorted_by_name = sort_person_Using_Ordering(listBuffer_ordering)

    println("listBuffer_ordering_sorted_by_name after  sorting " + listBuffer_ordering_sorted_by_name)

  }


  def sort_person_Using_Ordering(listBuffer_ordering: ListBuffer[Person_Case]) : ListBuffer[Person_Case]= {
    println("Inside sort_person_Using_Ordering ")
    val array = listBuffer_ordering.toArray
    val listBuffer = ListBuffer[Person_Case]()

    Sorting.quickSort(array)(orderingByNames_Comparator)

    array.foreach(
      e=> {
        listBuffer += e
      }
    )
    array.foreach(e=>println(e))
    listBuffer
  }

  object orderingByNames_Comparator extends Ordering[Person_Case] {
    override def compare(x: Person_Case, y: Person_Case): Int = {
      if (x.first.equals(y.first)){
        x.last.compareTo(y.last)
      }
      else
        x.first.compareTo(y.first)
    }
  }

  class Person(var first: String, var last: String) extends Ordered[Person] {
    override def toString: String = first + " " + last

    override def compare(that: Person): Int = {
      if (this.last.equals(that.last)) {
        return this.first.compare(that.last)
      }
      else
        return this.last.compare(that.last)
    }
  }

  case class Person_Case(var first: String, var last: String) {
    override def toString: String = first + " " + last

  }

/*  class Person_Ordering(var first: String, var last: String) extends Ordering[Person_Ordering]{

  }*/



}


