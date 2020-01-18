package main.scala.Scala_CookBook.Chapter_8

/*
diamond problem
~~~~~~~~~~~~~~
Scala avoids the diamond problem by something called "trait linearization".
Basically, it looks up the method implementation in the traits you extend from right to left. Simple example:
NOT POSSIBLE IN JAVA
 */
object Trait_Program_1 {

  def main(args: Array[String]): Unit = {
    /*val obj = new A()
    val resultFromBarTrait = obj.op
    println("resultFromBarTrait " + resultFromBarTrait)*/

    val obj = new DogAnimalFourLeg()
    obj.walk() //
  }
}

trait Base {
  def op: String
}

trait Foo extends Base {
  override def op = {
    "foo"
  }
}

trait Bar extends Base {
  override def op = {
    "bar"
  }
}

class A extends Foo with Bar
class B extends Bar with Foo


// if there is commonn method in super classes , the in subclass will take the one which is defined from extream right to left direction
// as shown here FourLggedAnimal.walk  gets called in subclass DogAnimalFourLeg
trait BaseAnimal{
  def walk()
}

trait AnimalTrait extends BaseAnimal
{
  override def  walk(): Unit ={
    println("Inside AnimalTrait  walk ")
  }
}

trait FourLggedAnimal extends BaseAnimal // if its class also then no difference in the order .
{
  override def walk(): Unit ={
    println("Inside FourLggedAnimal trait walk ")
  }
  def run()
}

class DogAnimalFourLeg extends FourLggedAnimal with AnimalTrait {
/*  override def walk(): Unit = {
    println("Inside DogAnimalFourLeg.walk")
  }*/

  override def run(): Unit = {
    println("Inside DogAnimalFourLeg.run ")
  }
}

