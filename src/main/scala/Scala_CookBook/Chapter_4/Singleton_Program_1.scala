package main.scala.Scala_CookBook.Chapter_4

object Singleton_Program_1 {

  def main(args: Array[String]): Unit = {
    Singleton.printMessage()
    //println("Singleton object " + Singleton.hashCode())
    //println("Singleton object " + Singleton.hashCode())


    val obj1 = Singleton.getInstance()
    val obj2 = Singleton.getInstance()

    //println("obj1 " + obj1)
    //println("obj2 " + obj2)

    println("obj1.DoSomething " + obj1.DoSomething)
    println("obj2.DoSomething " + obj2.DoSomething())


    println("\n Calling the Singleton_1 directly ")

    println("Singleton_1.DoSomething " + Singleton_1.DoSomething)
    println("Singleton_1.DoSomething " + Singleton_1.DoSomething())

  }

}


class SingletonClass (var state :Int){
  def DoSomething() = {
    state += 1
    System.out.println("I did something for the " + this.state + " time")
  }
}
object Singleton {

  var instance : SingletonClass = null
  private var state = 0

  // Lazy evaluation
  def getInstance(): SingletonClass ={
    if (instance == null)
      {
        instance = new SingletonClass(0)
      }
    instance
  }

  def printMessage(): Unit ={
    println("Inside Singleton object and printMessage ")
  }
}

// same as above ( i.e. creating separate class and a companion object ), we are maitaining the state inside object itself and which is Singleton bydefault.
// So no of times DoSomething called it operates on same instance.

// REMEMBER :: This is just to know . for Sigleton its better to have a class and companion object as shown in SingletonClass and Singleton object above.
object Singleton_1{
  private var state =0
  def DoSomething() = {
    state += 1
    System.out.println("I did something for the " + this.state + " time")
  }
}

