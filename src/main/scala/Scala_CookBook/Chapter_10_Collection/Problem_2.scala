package main.scala.Scala_CookBook.Chapter_10_Collection

object Problem_2 {

  def main(args: Array[String]): Unit = {
    val a = 10
    println(" + is a function in Scala " + a.+(20))

    // test 1
    val data = Array(11,21,3,4,50,6)
    println(data.reduce((x,y) => x+y))

    //test2
    for (i<- data)
      println(i)

    //test 3
    val evenArray1 = data.filter(e=>e%2==0)
    println("SIZE " + evenArray1.length)
    for (i <- 0 until evenArray1.length )
      println("Even Array using filter method " + evenArray1(i))

    //test4
    val result = for (i<-data) yield {
      i+1
    }
    result.foreach(e=>println(e))

    // test5
    //arrayTest()
    arrayTest_1()


  }

  def arrayTest() = {
    val array = Array[Int](11, 21, 3, 4, 50, 6)
    println("2nd element " + array(1))
    var i = 0;
    val evenArray = Array[Int](array.length)
    array.map(e => {
      println(e);
      ;
      //val oddArray = Array[Int](array.length);

      if (e % 2 == 0) {
        //print("i  " + i)
        evenArray(i) = e
        i = i + 1
        //print("after i  " + i)
      }
      for (i <- evenArray)
        println("evenArray " + i)
    }

    )
  }

  def arrayTest_1(): Unit = {
    val data = Array(11, 21, 3, 4, 50, 60)
    for (i <- data if(i > 21) if (i < 60 )){
      println("safeguard test using for loop " + i)
    }
  }

}
