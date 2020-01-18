package main.scala.Scala_CookBook.Chapter_4

/**
  * Created by suman.banerjee on 4/24/2017.
  *
  * Shows number of ways instance can be created
  * Very useful >> Here apply acting as "Factory Method" where client can call this by passing arg and based on that
  * instance will be returned.
  */
object CompanionObjectTest extends App{

  // Test1 # by using new
  val obj = new PersonCompanion()

  //println("PersonCompanion " + PersonCompanion)
  //Test 2 # by companion object , where it should have a apply def
  val obj2 = PersonCompanion("test")
  println("obj2.getName() " + obj2.getName())
  println("PersonCompanion.getName() " + PersonCompanion.getName())

  //println("PersonCompanion " + PersonCompanion)  // this wil be always same as only one instance created for class when it is defined as "object" in scala i.e. Singleton

  //Test 2 # by companion object , where it should have a apply def
  val obj22 = PersonCompanion()
  println("obj22.getName() " + obj22.getName())


  //println("PersonCompanion " + PersonCompanion)

  //Test 3 # by using case class , case class also behind the scene will have apply . but for this we dont have create apply , scala does it internally.
  val obj3 = PersonCase("test")

}

class PersonCompanion {
  var name: String = _
  println("Inside PersonCompanion class ")

  def getName():String ={
    println("Inside Class getName >>> ")
    return name
  }
}

object PersonCompanion {
  println("Inside PersonCompanion object ")

  var name = None : Option[String]
  def apply(): PersonCompanion = {
    println("Inside PersonCompanion objects apply() def ")
    var p = new PersonCompanion
    p
  }

  def apply(name: String): PersonCompanion = {
    println("Inside PersonCompanion objects apply(name) def ")
    var p = new PersonCompanion
    p.name = name
    p
  }

  def getName():Option[String]={
    println("Inside Companion Object getName ")
    name
  }
}

case class PersonCase(name: String)
