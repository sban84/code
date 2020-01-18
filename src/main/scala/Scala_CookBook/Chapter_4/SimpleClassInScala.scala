package main.scala.Scala_CookBook.Chapter_4

/**
  * Created by suman.banerjee on 4/24/2017.
  */
object SimpleClassInScala {

  def main(args: Array[String]) : Unit = {
    // Test 1 #
    val  P1 = new Person("sban" , "Banerjee" , 20)

    //Test 2#
    println("firstName = " + P1.firstName)
    println("accessing age by getAge as its not var / val so no default getter available " + P1.getAge)
    P1.lastName = "new Banerjee"
    println("lastName = " + P1.lastName)
    //P1.printHome()
    //P1.printFullClassValues
    //val  P2 = new Person("xyz" , "abc" , 23)

    // Test 3 #
    val s1 = new Socket()
    val s2 = new Socket(1000)
    println("s1 = " + s1)
    println("s2 = " + s2)


  }

}

/*
for var constructor argument getter / setter will be generated
for val constructor argument only getter will be generated
These getter / setter methods can be overridden
if not defined anything ,then there will not be any getter / setter for those fields.
for private var / val , nothing is generated

NOTE::
Anything defined within the body of the class other than method declarations is a part of the primary class constructor. Because auxiliary
constructors must always call a previously defined constructor in the same class, auxiliary constructors will also execute the same code
 */
class Person(var firstName:String , var lastName:String , age:Int){

  print("Person class's constructor called ")
  var a =10
  private val HOME = System.getProperty("user.home")
  def printHome() : Unit = {println("HOME Value is = " + HOME)}
  def printFullClassValues = {println(this)}

  override def toString: String = s"$firstName $lastName is $age years old."
  printHome()
  printFullClassValues
  def getAge : Int =  age

  println("Still in Person class's constructor")

  //2 args auxiliary constructor , which internally call primary constructor
  def this(firstName : String , lastName : String){
    this(firstName,lastName,0)
  }



}

class Socket (val timeout: Int = 5) {
  // timeout = 60 // reassignment will not be allowed as timeout is initialized in the same context at constructor level and everything in class body also belong to primary constructor
  override def toString: String = "timeout value is " + timeout
}

/*
Visibility Accessor? Mutator?
var Yes Yes
val Yes No
Default visibility (no var or val) No No
Adding the private keyword to var or val No No
 */