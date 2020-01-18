package main.scala.Scala_CookBook.Chapter_4

/**
  * Created by suman.banerjee on 4/24/2017.
  */
object AbstractClassTest extends App{
  val dog = new Dog("Fido")
  val cat = new Cat("Morris")
  dog.sayHello
  cat.sayHello
  println(dog)
  println(cat)

  // verify that the age can be changed
  cat.age = 10
  println(cat)
}


abstract class Pet (name: String) {
  val greeting: String
  var age: Int =15
  final val PetProperty = "secret" // will not be overridden in sub class
  def sayHello { println(greeting) }
  override def toString = s"I say $greeting, and I'm $age"
}

class Dog (name: String) extends Pet (name) {
  val greeting = "Woof"
   //override var age = 2 // var variable in super class can not be overriden in sub class. wont compile
}
class Cat (name: String) extends Pet (name) {
  val greeting = "Meow"
  age = 5  // this is not overriding , its just hiding or reinitilalizing
}