package main.scala.Scala_CookBook.Chapter_8

/**
  * Created by suman.banerjee on 4/26/2017.
  * Check SuperClassMethodCallingTest.scala also
  *
  * Refer Chapter - 8 Scala cook book
  *
  */
object TraitTest extends  App{

  //Test 1 # Using trait as abstract class
  val dog = new Dog
  dog.run
  dog.speak
  dog.walk

  // Test 2 # Important feature of Trait , trait can be added on the fly and also instance level

   val f = new Cat with WaggingTail
   val hulk = new DavidBanner with Angry

  /*Test 3 # Imposing restriction in Trait

  // Limiting Which Classes Can Use a Trait by Inheritance
  trait StarfleetWarpCore extends StarfleetComponent

  // Marking Traits So They Can Only Be Used by Subclasses of a Certain Type
  trait MyTrait {
  this: BaseType =>

  // methods level
  trait WarpCore {
    this: { def ejectWarpCore(password: String): Boolean } =>
  }

  */



}


abstract class Animal {
  def speak
}
trait WaggingTail {
  println("Inside WaggingTail constructor body , trait does not have constructor parameter like class as Trait are not made to be Instantiated")
  def startTail { println("tail started") }
  def stopTail { println("tail stopped") }
}
trait FourLeggedAnimal {
  def walk
  def run
}
class Dog extends Animal with WaggingTail with FourLeggedAnimal {
  // implementation code here ...
  def speak { println("Dog says 'woof'") }
  def walk { println("Dog is walking") }
  def run { println("Dog is running") }
}

class Cat {
  override def toString: String = s"Inside Cat Class which does not extend any class and trait "
}


trait Pet {
  def speak { println("Yo") } // concrete implementation
  def comeToMaster // abstract method
}
class Dog1 extends Pet {
  // don't need to implement 'speak' if you don't need to
  def comeToMaster { ("I'm coming!") }
}
class Cat1 extends Pet {
  // override the speak method
  override def speak { ("meow") }
  def comeToMaster { ("That's not gonna happen.") }
}


// Test , Adding a Trait to an Object Instance

class DavidBanner
trait Angry {
  println("You won't like me ...")
}
