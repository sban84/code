package main.scala.Scala_CookBook.Chapter_6

/**
  * Created by suman.banerjee on 4/26/2017.
  *
  * we’ve seen that Scala code looks cleaner when you don’t always have to use the new
keyword to create a new instance of a class, like this:

val a = Array(Person("John"), Person("Paul"))
  * 1- Create a companion object for your class, and define an apply method in the companion
object with the desired constructor signature.
• 2- Define your class as a case class.
  */

object ObjectTest extends App{

  //Test 1 #
  val dogInstance = Animal("dog")
  val catInstance = Animal("cat")
  val cowInstance = Animal("cow")

  println("dogInstance " + dogInstance)
  println("catInstance " + catInstance)
  println("Instance check " + cowInstance.isInstanceOf[Cow])

  //Test 2 #
  val cat = Animal.getAnimal("cat") // returns a Cat
}

trait Animal {
  def speak
}

object Animal{
  class Dog extends Animal{
    override def speak = {println("Inside speak of Dog")}


  }
  private class Cat extends Animal {
    override def speak = {println("Inside speak of Cat")}
  }

  // the factory method
  def apply(animalType : String) : Animal ={
    if(animalType.equals("dog"))  new Dog  // return is optional in scala
    else if(animalType == "cat") {println("cat") ; new Cat }  // In scala equals() and == used in the same purpose
    else new Cow()
  }

  // an alternative factory method (use one or the other)
  def getAnimal(s: String): Animal = {
    if (s == "dog") return new Dog
    else return new Cat
  }
}

// its better code if we can include the class inside of Animal i.e factory class
class Cow extends  Animal{
  override def speak: Unit = println("Inside speak of Cow")
}
