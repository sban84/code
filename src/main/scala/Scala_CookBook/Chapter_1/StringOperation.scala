package main.scala.Scala_CookBook.Chapter_1

/**
  * Created by suman.banerjee on 4/20/2017.
  *
  * Excellent program to see the operation of String in Scala
  */
object StringOperation {

  def main( args: Array[ String ] ): Unit = {

    val str : String = "Hello world"

    //Test 1#
    val mkUpperCaseAllChar = str.map(c=>(c.toUpper))
    println("mkStrAllChar >> " + mkUpperCaseAllChar)
    val mkUpperCaseSpecificChar = str.map(c=>(if(c=='w' || c=='d') c.toUpper else c))
    println("mkStrSpecificChar >> " + mkUpperCaseSpecificChar)

    //Test2# , remove a char from String
    val filterStr = str.filter(c=> c!='w')
    println("filterStr >> " + filterStr)

    //Test3# , remove world from String , we need to split. then apply filter on Array[String]
    val strArray = str.split(" ")
    val filterStr1 = strArray.filter(p=>(p!="world"))
    filterStr1.foreach(x=>println("filterStr1 without world >> " + x))

    //Test 4 # Function and Function Value
    //val toUpperFunc = (c:Char)=>{(c.toByte + 32).toChar} // function value i.e. function assigned to a value
    println("calling f to convert hello string to upper case " + f("hello"))

    val func = (c:Char) => c.toUpper : Char // this way we can create function value in scala. here : Char is return type which is optional
    println("calling map by passing function value " + "hello".map(func))
    //println("calling map by passing function value " + "hello".map(c=>func(c)))  // same as above

    //Test 5#  powerful implicit feature in scala
    println("Using implicit class increamentAndMakeUpperCase >> " + "hello".increamentAndMakeUpperCase)
    println("Using implicit class toUpperCaseFirstCharOnly >> " + "hello".toUpperCaseFirstCharOnly())

  }

  def f(s:String) : String = {
    s.map(c=>(c.toUpper))
  }



  /*
  As you just saw, in Scala, you can add new functionality to closed classes by writing implicit conversions and bringing them into scope when you need them. A major benefit
  of this approach is that you don’t have to extend existing classes to add the new functionality. For instance, there’s no need to create a new class named MyString that extends
  String, and then use MyString throughout your code instead of String; instead, you define the behavior you want, and then add that behavior to all String objects in the
  current scope when you add the import statement.
   */
  implicit class StringImprovements(s:String)
  {
    def toUpperCaseFirstCharOnly() : String = {
      //var tempStr = s
      //tempStr = s(0).toUpper + s.substring(1,s.length)
      //return tempStr
      return s(0).toUpper + s.substring(1,s.length)

    }

    // custom made uppercase . to see how we can make use scala implicit , here we just increamented and uppercase
    // provided this methods should not be present in String class
    // This is for enhancement , so that we dont have to write any new utilities classes , we are just adding new
    //methods on String class using implicit conversions feature in Scala
    def increamentAndMakeUpperCase = {
      var temp = s.map(c=>(c+1).toChar)
      println("temp >> " + temp)
      temp.toUpperCase()
    }

    def increment = s.map(c => (c + 1).toChar)
  }
}

