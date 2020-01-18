package main.scala.Scala_CookBook.Chapter_6

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

object Sorting_Ordering {

  def main(args: Array[String]): Unit = {

    val list = List(1,3,5,1,0,10)
    val list_sorted_1  = list.sorted // by default ascending
    val list_sorted_2 = list.sortWith((x,y)=> x > y) // descdending

    val array = list.toArray
    println("array before sorting " )
    array.foreach(print(_))
    val array_sorted_1 = array.sorted
    val array_sorted_2 = array.sortWith((x,y)=> x > y) // descdending

    Sorting.quickSort(array)
    println("\n array after sorting in ascending order " )
    array.foreach(e=> print(e + " "))

    println("\n Array after sorting descending order " )
    array_sorted_2.foreach(e=>print(e + " "))

    /*val o1 = Employee_Case("suman",30)
    val o2 = Employee_Case("suman",30)

    println("Double comparision " + o1.equals(o2))*/

    println("\n Test in object comparision **** ")

    val array_employee_buffer= ArrayBuffer[Employee_Case]()
    val o1 = Employee_Case("suman",40)
    val o2 = Employee_Case("suman",30)
    array_employee_buffer.append(o1)
    array_employee_buffer.append(o2)


    println("array_employee before sorting " + array_employee_buffer)
    val array_employee = array_employee_buffer.toArray

    Sorting.quickSort(array_employee)(Employee_Case_Comparator)
    println("array_employee after sorting " + array_employee.toList)


  }


}

case class Employee_Case(var name:String , var age:Int){
  override def toString: String = name + " " + age


}

object Employee_Case_Comparator extends Ordering[Employee_Case]{
  override def compare(x: Employee_Case, y: Employee_Case): Int = {
    if (x.name.equals(y.name)) {
      x.age.compareTo(y.age)
    }
      else{
        x.name.compareTo(y.name)
      }
    }

}






