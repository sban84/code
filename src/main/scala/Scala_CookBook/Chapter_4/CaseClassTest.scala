package main.scala.Scala_CookBook.Chapter_4

/**
  * Created by suman.banerjee on 4/24/2017.
  */
object CaseClassTest extends App{

  val caseObj = PersonCaseClass("test" , "testRelation")
  println("caseObj.name" + caseObj.name + " and relation " + caseObj.relation )
  //caseObj.name = "new Name " // not allowed

  val testPersonCaseClassObject = caseObj match {
    case PersonCaseClass(n,r) => PersonCaseClass(n,r)
    case _ => "Not matched"
  }
  println(caseObj)
  println(testPersonCaseClassObject.equals(caseObj))
}

case class PersonCaseClass(name:String , relation : String ) // by default params are val

