package main.scala.Scala_CookBook.Chapter_4

object Scala_Constructor {

  def main(args : Array[String]) : Unit ={

    val noArgCons = new ClassWithNoConstructor
    println("from ClassWithNoConstructor >> " + noArgCons.name)
    noArgCons.name = "sban B"
    val nameAfterChange = noArgCons.name
    println(s" from ClassWithNoConstructor after modify>>  $nameAfterChange")  // (using string interpolation in Scala )

    val multiArgCons = new ClassWithMultipleConstructor("Suman" , "Banerjee")
    println(multiArgCons.firstName)
    println(multiArgCons.lastName)
    multiArgCons.lastName = "B"
    println("Full  Name >> " + multiArgCons.fullName())
    //println("a >> " + multiArgCons.a)



  }

}


class ClassWithNoConstructor {

  var name = "sban"
  /*def getName = name
  def setName(newName :String) = {
    name =  newName
  }*/

}


class ClassWithMultipleConstructor (private var _firstName : String , var lastName : String){  //primary cons

  def firstName = _firstName
  def firstName (aName : String )= _firstName = aName   // actually this is not required , scala will do it for us. getter and setter for primary cons.

  def fullName() : String = {
    //firstName + " " + lastName

    s"$firstName $lastName"
  }

  //val a = _
}


