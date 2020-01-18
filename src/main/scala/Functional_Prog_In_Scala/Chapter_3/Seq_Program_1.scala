package main.scala.Functional_Prog_In_Scala.Chapter_3

import scala.collection.immutable.{HashMap, Queue, Stack}
import scala.collection.mutable

object Seq_Program_1 {

  def main(args:Array[String]) : Unit ={

    val result = addOneToAll(List(1,2,3))
    println(" list " + result)

    seqCollectionTest



  }

  def addOneToAll(s: List[Int]):List[Int] = {

    var result =List[Int]()

    def accum(result:List[Int] , s : List[Int]) : List[Int] = s match {
      case List() => result
      case x :: tail => accum( result :+ (x+1)  , tail) // here the diff between :+ and +: ( :: same as +: ) is important . as :+ add in the last where as others add in front.
        // so since we just want to inceament so no change in the order , but operation like operation reverse order is important and we need :: or +:

    }

    accum(result,s)
  }


 /* def addOneToAll[A](s : Seq[A]) : Seq[A] =  {

    var result = Seq[A]()
      def addOneToAllAccum[A]( result: Seq[A] , s:Seq[A]) : Seq[A]= s match{

        case Seq() => Seq()
        case x :: xs => addOneToAllAccum( Seq(x + 1),xs )
  }*/


  def seqCollectionTest() ={

    println("*****  Array immutable ****** \n ")

    // Array test , immutable
    val array = Array[Int](5) // size is must here . else runtime ArrayIndexOutOfBoundsException exception , val array = new Array[Int](5) means array of size 5 all initialized to 0 first.
    // But val arr = Array[Int](5) is an array with one item in it. Any add will create new Array , update with valid index is allowed.
    val new_array = array :+ 1 // append
    val new_array_1 = 2 +: new_array // prepend
    array(0) = 100 //update in Vector is not possible , in Array its possible as Array is seq collection.
    array.foreach(e=>print("array " + e + "\n"))

    println("new_array_1 >> ")
    new_array_1.foreach(e=>print(s" $e"))



    // >> VECTOR  no mutable version of vector
    println("  \n Vector immutable  ****** \n ")
    val vector = scala.collection.immutable.Vector(1,2,3)

    //vector(1) = 10 // NOTE*** update is Not possible as immutable Compile error , only append or prepend

    var new_vector = 10 +: vector // NOTE but this returns new vector same as List or all other seq collection immutable
    new_vector = new_vector :+ 100 // :+ will append and +: will prepend .
    // REMEMBER NUMBER AT FIRST THEN USE +: THAT MEANS NUMBER ADDED AT THE HEAD OF THE COLLECTION
    // COLLECTION AT FIRST :+ MEANS NUMBER WILL BE AT LAST
    println("vector " + vector)
    println("new_vector " + new_vector)
    val sortedVector = new_vector.sortWith((a,b) => a < b) // ascending
    println("sortedVector " + sortedVector)
    // this is split based on the index number
    println(s"new_vector.splitAt(3)._1 ${new_vector.splitAt(3)._1} and new_vector.splitAt(3)._2 ${new_vector.splitAt(3)._2}")
    val  indexAt = new_vector(2) // this will return the item at index 2 ,starts from 0
    println(s"new_vector.splitAt(indexAt)._1 ${new_vector.splitAt(indexAt)._1} and new_vector.splitAt(indexAt)._2 ${new_vector.splitAt(indexAt)._2}")

    val index_of_a_item = new_vector.indexOf(3)
    val sliced_vector = new_vector.slice(index_of_a_item,new_vector.length)
    println("sliced_vector " + sliced_vector)
    // LIST
    println("*****  List ****** \n ")

    val list = List(1,2,3,4)
    //list(1) = 10 //update is Not possible as immutable Compile error
    println("list  " + list)
    val  indexAt_list = list(2) // this will return the item at index 2 ,starts from 0
    println(s"new_vector.splitAt(indexAt_list)._1 ${list.splitAt(indexAt_list)._1} and new_vector.splitAt(indexAt_list)._2 ${list.splitAt(indexAt_list)._2}")


    // mutable LIST
    val list_mutable = scala.collection.mutable.ListBuffer[Int](1,2,3)
    list_mutable(1) = 22


    list_mutable += 100 // append
    list_mutable.append(1000)

    list_mutable.prepend(10) // prepend
    println("list_mutable  " + list_mutable)

    println("***** STACK ****** \n ")
    // Push and Pop are for adding in the Stack ( along with :+ and +: as other Linear Seq like List ) prefer to use Push and pop for Stack
    // Push will add the head and pop will return from the head
    // STACK immutable , modification will return new Stack ( same as List , Vector , Map , other imutable collection)
    val stack = Stack()

    val stack_new = stack :+ 2 // append
    val stack_new_1 = 10 +: stack_new //prepend
    val stack_new_2 = stack_new_1.push(100) // append
    //println("stack_new_1(0) " + stack_new_1(0))
    println("stack_new_2 " + stack_new_2)
    println("stack_new_2 top  " + stack_new_2.top) // just return the top item
    println("stack_new_2 pop " + stack_new_2.pop) // removes the top and return the rest Stack
    println("stack_new_2 after pop -> " + stack_new_2)

    // STACK mutable // modification can be done on the same Stack
    val stack_mutable = scala.collection.mutable.Stack[Int]()
    stack_mutable.push(2)
    stack_mutable.push(200)
    println("stack_mutable  " + stack_mutable)
    println("stack_mutable popped  " + stack_mutable.pop())


    println("***** Queue ****** \n ")
    // // enqueue and dequeue are for adding in the Queue ( along with :+ and +: as other Linear Seq like List )
    // Queue immutable
    val queue = Queue()
    val new_queue = queue :+ 2
    val new_queue_1 = 10 +: queue
    val new_queue_2 = new_queue_1.enqueue(100)
    println("new_queue_2" + new_queue_2)

    println("new_queue_2 dequeue " + new_queue_2.dequeue._1) // take the first item from the queue // FIFO Order and return new queue removing the item
    println("new_queue_2 after dequeue " + new_queue_2)  // new_queue_2.dequeue returns new queue so older queue has not change as its immutable.


    println("***** Map ****** \n ")
    //MAP immutable // no put only get , for putting use + only
    var map = HashMap[String,Int]("a" -> 1)
    map +=  ("b" -> 2)  // NOTE there is no put only remember + for adding any item but that return another map which is assigned in var if we use val then we might have to use anoter val/var to store the modified Map.
    // get is available in both mutable and immutable .
    map -= ("b")
    map = map + ("c" -> 3)
    map.contains("a")

    if (map.contains("a")){
      var curr = map.get("a").get + 1
      map += ("a" ->  curr)
    }


    println("map " +map)

    println("***** Mutable Map  ****** \n")
    // MAP mutable // put and get available REMEMBETR TO USE PUT AND GET for mutable Map
    val map_mutable = mutable.HashMap[String,Int]()
    map_mutable.put("a" , 1)
    map_mutable.put("b" , 2)
    map_mutable += ("c" -> 3) // same as put for immutable Map
    println("map_mutable  " +map_mutable)
    map_mutable.remove("b")
    println("map_mutable get  " +map_mutable.get("a").getOrElse("default"))
    map_mutable.contains("a")

  }

}
