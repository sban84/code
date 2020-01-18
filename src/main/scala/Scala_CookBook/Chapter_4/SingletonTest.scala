package main.scala.Scala_CookBook.Chapter_4

/**
  * Created by suman.banerjee on 4/24/2017.
  * // Refer Scala cookbook page 112
  */
class SingletonTest private {

  //override def toString = "Inside Singleton "
  val a =10
  def someMethod() = "Inside someMethod()"
}

// when we use object instead of class , then its by default singleton and what ever we define inside it will be
// accessed by simple object name , i.e no need to create any instance of that object , so static functionality can be achieved.
// the way we did :- val ins1 = SingletonTest.getInstance()
/*
In scala, when you have a class with same name as singleton object, it is called companion class and the singleton object is called companion object.
The companion class and its companion object both must be defined in the same source file.
 */
// This is companion object in scala as it's name is same as that class in the same file
// It can access all the parameters defined in class

object SingletonTest {
  val instance : SingletonTest = new SingletonTest
  def getInstance() : SingletonTest = { return instance}

  println("value of a = " + instance.a )
  println("calling someMethod = " + instance.someMethod())
}

object SingletonTestApp extends App  // no need of main as extending App
{
  //val obj = new SingletonTest() // won't compile

  val ins1 = SingletonTest.getInstance()
  println(ins1)

  val ins2 = SingletonTest.getInstance()
  println(ins2)
}

