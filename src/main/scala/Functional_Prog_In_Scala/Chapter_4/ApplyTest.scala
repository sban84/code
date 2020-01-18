package main.scala.Functional_Prog_In_Scala.Chapter_4

object ApplyTest extends App  {

  val t1 =  TestApply("sban")
  println("t1 " + t1)

  val t2 = TestApply("Scahin" , 100)
  println(t2)


}

object TestApply{

  def apply(s:String):String = {
    "hello " + s
  }

  def apply(name: String, score: Int): TestApply = {
    new TestApply(name, score)
  }

}

class TestApply (name:String,score:Int){

  override def toString: String = name + " and " + score
}



