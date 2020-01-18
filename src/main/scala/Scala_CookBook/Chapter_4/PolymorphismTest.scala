package main.scala.Scala_CookBook.Chapter_4

/**
  * Created by suman.banerjee on 4/24/2017.
  * Refer Scala cook book page-124
  */
object PolymorphismTest {

  def main ( args: Array[ String ] ): Unit = {
    println("Inside PolymorphismTest")

    val person : PersonInfo = new PersonInfo("sban" , new Address("BLR" , "KA" , 612))
    person.callPerson()
    println("name = " + person.name)

    val personRef = new Employee("sbanEmp" , new Address("KOL" , "WB" , 6),22)
    personRef.callPerson()
    println("name = " + personRef.name) // this is different than Java as in Java instance variable can't be overridden , only instance methods
  }
}

class Address(val city : String , val state : String , val zipCode : Int)

class PersonInfo(val name : String ,  val address : Address){
  override def toString = if (address == null ) name else s"name $name , address $address"
  def callPerson() = {println("calling Person ")}

}
class Employee(name : String, address : Address , val age:Int ) extends PersonInfo(name,address)
{
  override def toString: String = "Inside Employee constructor"

  override def callPerson ( ): Unit = { println("calling Employee ") }
}
