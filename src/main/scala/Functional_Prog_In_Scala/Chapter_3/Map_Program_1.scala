package main.scala.Functional_Prog_In_Scala.Chapter_3

import scala.collection.immutable.HashMap
import scala.collection.mutable.ArrayBuffer


object Map_Program_1 {

  def main(args:Array[String]) = {

    //mapAPITest
    mapTest_1()

    val sum = varArgs_add(List(1,2,3) :_*) // refer :- https://stackoverflow.com/questions/7938585/what-does-param-mean-in-scala
    // tells the compiler to treat a single argument of a sequence type as a variable argument sequencev
    println("sum " + sum)

    varArgs_add(1,2,3)


    val map = new scala.collection.mutable.HashMap[Any,Any]()
    //map += (1 -> "a")
    map.put(1,300)
    print(s"getValueFromMap(map) ${getValueFromMap(map)}")


  }

  def mapAPITest(): Unit ={

    // Here HashMap is immutable , but initialized with var , i.e. when we add an elelmt it returns a hashmap which is assigned to the same var
    var map = new HashMap[String,Int]
    //val map1 = new scala.collection.mutable.HashMap[String,Int]

    map  = map + ("hello" -> 1)  // same as +=
    map  += ("Scala" -> 2)
    map  += ("Spy" -> 3)
    map  += ("h" -> 1)


    //map1 += ("hello" -> 1)


/*    //sort by values ascending order
    val r = map.toSeq.sortWith((x,y) => x._2 < y._2)
    println(s"r $r" )

    // descesnding order
    val sortedMapByValues =mutable.ListMap(map.toSeq.sortWith(_._2 > _._2):_*)
    println("sortedMapByValues " + sortedMapByValues)

    // Summing map values
    val sumUpMapValues = sortedMapByValues.foldLeft(0)((x,y) => x+y._2)
    println(s"sumUpMapValues " + sumUpMapValues)*/


    // Usage of immutable HashMap
    val map_1 = HashMap[String,Int]("a" -> 1)
    val map_2 = map_1 + ("b" -> 2) // adding elemts in existing HashMap which returns another HashMap

    println("map_1 " + map_1)
    println("map_2 " + map_2)
    //println("map2.mkString " +map_2.mkString )

    // some more features of Map (mutable ) ...

    val map_mutable = scala.collection.mutable.HashMap[Int,String]()
    map_mutable.put(1,"Suman1")
    map_mutable.put(2,"Suman2")
    map_mutable.put(3,"Suman3")
    map_mutable.put(4,"Suman4")
    map_mutable.put(5,"Suman5")
    map_mutable.put(6,"Suman6")

    //println(s" map_mutable " + map_mutable)

    val map_mutable_test1  = map_mutable.filter((t) => t._1 >1 && t._1 <5) // filter on mutable map returns new mutable map and source map will not be changed.
    println(s" map_mutable " + map_mutable)
    println(s" map_mutable_test1 " + map_mutable_test1)



    map_mutable.retain((k,v) => k > 3) // retain and transform does modify the same underlying Map , original map will get changed and \\
    // returns same map so we can save that to some other map as well.
    println(s" map_mutable " + map_mutable)

    val map_mutable_test3 = map_mutable.filter((t) => t._1.equals(5)).transform((k,v) => v.concat(" hello "))

    println(s" map_mutable_test3 " + map_mutable_test3)


    // some more features of Map (immutable ) ... retain is not available in immutable HashMap and transform returns new
    // Map as this is immutable map.

    val map_immutable = HashMap[Int,String]()
    val map_immutable_1 =  map_immutable + (1 -> "Suman1")

    val map_immutable_2 =  map_immutable_1 + (2 -> "Suman2")
    val map_immutable_3 =  map_immutable_2 + (3 -> "Suman3")
    val map_immutable_4 =  map_immutable_3 + (4 -> "Suman4")
    val map_immutable_5 =  map_immutable_4 + (5 -> "Suman5")
    val map_immutable_6 =  map_immutable_5 + (6 -> "Suman6")

    println(s" map_immutable_6 " + map_immutable_6)

    val map_immutable_test1 = map_immutable_6.filter((t) => t._1 > 1 && t._1 <5)

    println("map_immutable_test1 " + map_immutable_test1)

    val map_immutable_test2 = map_immutable_6.filter((t) => t._1==5).transform((k,v) => v.concat(" hello"))
    println("map_immutable_test2 " + map_immutable_test2 )

    val map_immutable_test3  = map_immutable_test2.transform((k,v) => v.toUpperCase())
    println("map_immutable_test3 " + map_immutable_test3 )

  }


  def mapTest_1():Unit ={

    var map = new HashMap[String,ArrayBuffer[Int]]()
    val buffer = ArrayBuffer[Int]()
    buffer.append(1)
    map = map + ("a" -> buffer)
    buffer.append(2)
    map += ("b" -> buffer)

    map.keys.foreach(e=>{
      println(s"key is $e and value is ${map.get(e).getOrElse("default")}")
    })

  }

  def varArgs_add(a : Int*) :Int ={

    var result = 0
    for (i <- a){
      result += i
    }
    result
  }


  def getValueFromMap(map : scala.collection.mutable.HashMap[Any,Any])={

    println("map >> " + map.get(1).getOrElse())
    val value = map.get(1)

    val result = value match  {
      case Some(x:Int) => println(s"inside Int ${x.toInt}")
      case Some(x:Char) => println(s"inside Char ${x.toChar}")
      case Some(x:String) => println(s"inside String ${x.toString}")
      case _ => println(s"inside Others ")
    }
    result
  }


  val map = scala.collection.mutable.HashMap[Int,List[Courses]]()
  map.put(2,List[Courses]( (Courses(1,"Maths")) , Courses(2,"Phygics")))
  map.put(1,List[Courses]( (Courses(1,"Java")) , Courses(2,"Scala")))

  def sortMap(map: scala.collection.mutable.HashMap[Int,List[Courses]] , sortFlag:Boolean) : Unit ={

    val result = sortFlag match {
      case true => {
        println("sorting is based on Strudent_id")
        val sorted_map = map.toSeq.sortWith((x,y) => x._1 < y._1)
      }
      case false =>{
        println("sorting is based on Course_Name")
        //val sorted_map = map.toSeq.sortWith( (x,y) => x._2.sorted < y._2.sorted )
      }
    }

  }

}

case class Courses(c_id:Int, c_name:String)

