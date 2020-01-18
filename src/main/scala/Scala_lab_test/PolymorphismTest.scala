package main.scala.Scala_lab_test

/**
  * Created by suman.banerjee on 4/6/2017.
  */
object PolymorphismTest {

  def main( args: Array[String] ): Unit = {
    
      var animal : Animal = new Cat()
    println(" Instance " + animal)
    println("color => " + animal.color + " And speed " + animal.speed)

    val an = new Animal()
    println("color " + an.color + " and speed " + an.speed)
    println("isSuperClass " + an.isSuperClass)
  }
}

class Animal {
  val color = "default"
  val speed = 0

  def getName() : String = {
    return "Base Class"
  }

  def isSuperClass : Boolean = {
    return true;
  }
}
class Cat extends Animal{
  override val color: String = "black"
  override val speed: Int = 2

  override def getName() : String = {
    return "Cat"
  }

}
