package main.scala.Scala_CookBook.Chapter_8

// NOTE , this trait can only be accessible in this file . i.e. classes trying to subclass from this trait .
  sealed trait SealedTraitTest {

  def sayHello_Sealed() ={

    "hello from Sealed TRait "
  }



}



trait NormalTraitTest {
  def sayHello_Normal()={
    "hello from normal trait "
  }
}

class Test_trait extends SealedTraitTest {
  sayHello_Sealed()

}

