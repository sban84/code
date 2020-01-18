package main.scala.Scala_CookBook.Chapter_8

object TraitTest_1 extends App  {

 val obj = new Sban()

  //Exmaple 3 : Adding trait to an instance not the entire class
  val hulk = new DavidBanner1 with Angry

}

class Org(name:String){
  var a = 10
  println(s"Org Class Body / Constructor called $name " )
}


// Exmaple 1 # This trait can only be used by classes extending Org as superclass.
trait EmployeeData extends Org {
  println("inside EmployeeData body ")

}

// This trait can only be used by classes extending Org as superclass. another way
trait EmployeeData_1 {
  this :  Org  =>
}
// Example of : This trait can only be used by classes extending Org as superclass.
class Sban extends Org("suman") with EmployeeData {

  println(s"Inside Sban Employee class extends Org and EmployeeData Trait " )
}



// Exmple 2 # this trait can only be used by classes which has this method
trait WarpCore {
  this: { def ejectWarpCore(password: String): Boolean } =>
}

class WarpCore_class extends WarpCore { // extend trait_name as it is extending only one trait. else use with keyword  ,.
  def ejectWarpCore(password : String ) : Boolean ={
    println("Iside WarpCore_class.ejectWarpCore " + password)
    true
  }
}
trait WarpCore_1 {
  this : Org =>
}


//Exmaple 3 : Adding trait to an instance not the entire class .

class DavidBanner1
trait Angry1 {
  println("You won't like me ...")
}

