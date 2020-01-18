package main.scala.Scala_CookBook.Chapter_8

object Main_prog_Trait {

  def main(args: Array[String]): Unit = {

    val object1 = new Test_trait()


    val object2 = new Test_trait_1()

    println("object1.sayHello_Sealed() " + object1.sayHello_Sealed()) // since that class is defined in the same file where the sealed tait defined .



    println("object2.sayHello_Normal() " + object2.sayHello_Normal() )


  }

}

// COMPILE ERROR : This will not compile as SealedTraitTest trait is defined in another file .SealedTraitTest
// refer SealedTraitTest.scala
/*class Test_trait_1 extends SealedTraitTest {
  sayHello_Sealed()

}*/


class Test_trait_1 extends NormalTraitTest {
  sayHello_Normal()

}
