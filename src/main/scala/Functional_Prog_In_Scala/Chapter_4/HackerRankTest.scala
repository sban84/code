package main.scala.Functional_Prog_In_Scala.Chapter_4

import java.io.{File, PrintWriter}

import scala.annotation.tailrec
import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object HackerRankTest {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

   /* val curr_dir = System.getProperty("user.dir")
    println("curr_dir " + curr_dir)
    val printWriter = new PrintWriter(new File(s"$curr_dir/test_result.txt"))

   val arCount = stdin.readLine.trim.toInt

    println("aCount " + arCount)

    val ar = stdin.readLine.split(" ").map(e => e.trim.toInt)

    val result = simpleArraySum(ar)

    printWriter.println(result)

    printWriter.close()*/

    //groupArray()

    //findRepeatedCharCount("abc" , 2)

//    val sequence = createSequence("abca" , 10)
//    println(s"sequence " + sequence)
//
//    val sequence_1 = createSequenceUsingTailRec("a" , 100)
//    println(s"createSequenceUsingTailRec $sequence_1" )

    //countDuplicates(Array(1,2,1,3,4,3))

    //findTheMaxDuplicatedItem(Array(1,2,1,3,4,3,5,3))

    val revString = reverseAString("hello")
    println("revString " + revString)

    //justPrint()
    sumFromReadingFile()
    //sumFromReadingFile_1()
    //readFileTest()
  }

  def simpleArraySum(ints: Array[Int])={
    ints.sum
  }


  //
  def groupArray()={
    val ar = Array(10 , 20 ,20 ,10 ,10, 30, 50, 10, 20)
    val arGrouped = ar.groupBy(e=>e)
    println("arGrouped " + arGrouped)
    val mapValuesTotalValbyKey = arGrouped.map(e=>(e._1,e._2.length))  //scala.collection.immutable.Map[Int,Int] = Map(2 -> 3, 1 -> 3, 3 -> 1)
    val mapValuesHalfed = mapValuesTotalValbyKey.map(e=> (e._1,e._2/2))
    val sumofmapValues = mapValuesHalfed.foldLeft(0)((x,y) => x + y._2)

    println(s"sumofmapValues " + sumofmapValues)

    val sum = arGrouped.map(e=> (e._1,e._2.sum) )



  }

  //https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
  def findRepeatedCharCount(s:String,n:Long)=
  {

    if (n < s.length)
      s.slice(0,n.toInt)

    val sb : StringBuilder = new StringBuilder(s)
    println("length " + n)
    for (i<- 0 until n.toInt-s.length()) {
      sb.append(s.charAt(i))
    }
    println("sb " + sb.toString())
    var counter=0
    sb.map(e=>{ if (e == 'a')counter +=1 })
    println("counter " + counter)

  }

  // abca , 10
  // abca
  // ab
  def createSequence(s:String , n :Int): String =
  {

    if (n<=0 || n < s.length) s.slice(0,n)
    else
      {
        s + createSequence(s , n-s.length)
      }
  }


  def createSequenceUsingTailRec(s:String , n :Long): String =
  {
    @tailrec
    def createSequencAccum(result: String , s: String ,n:Long):String={
      if (n<=0 || n < s.length) result + s.slice(0,n.toInt)
      else
      {
        createSequencAccum(s+result , s , n-s.length)
      }
    }
    createSequencAccum("",s,n)
  }

  // countDuplicates and get the item with max count
  def countDuplicates(arr : Array[Int]) : Unit ={
    var tempMap = HashMap[Int,Int]()

    arr.map(e=> {
      if (tempMap.contains(e))
        {
          println("Element exist in Map and its count is  " + tempMap(e))
          val currCount = tempMap(e) + 1
          tempMap += (e -> currCount  )
        }
      else
        {
          tempMap += (e -> 1)
        }
    })

    // sort the tempMap by values descending order
    val sortedSeq = tempMap.toSeq.sortWith((x,y) => x._2 > y._2)
    println("SortedMap " + sortedSeq)  // sortedMap.take(1) return the first element but it will be a tuple (1,2) , so need to map the sequence and get only seconf item in the tuple.
    val itemCountInVectorTuple = sortedSeq.map(e=> e._2) // will be the count
    val itemInVectorTuple = sortedSeq.map(e=> e._1)  // will be the item
    println("secItemInVectorTuple " + itemCountInVectorTuple(0) )

  }

  // i/p Array(1,2,1,3,4,3,5,3)
  // This is another way of doing , groupBy is very useful
  def findTheMaxDuplicatedItem(arr : Array[Int] ) : Unit ={
    val sortedArr = arr.sorted
    sortedArr.foreach(e=>print(e))

    val mapOfItemAndCount = arr.groupBy(e=>e).mapValues(e=>e.size)
    val sortedMap = mutable.LinkedHashMap(mapOfItemAndCount.toSeq.sortWith((x, y)=> x._2 > y._2):_*) // descending order

    val firstKeyVal = sortedMap.take(1) // take returns the same collection on which its invoked , so this is Map
    println(s" firstKeyVal $firstKeyVal"  )

    firstKeyVal.keys.foreach(e=> {
      println(s" key $e and value is ${firstKeyVal(e)}"  )
    })
  }

 /* def countRepeatedCharsInSeq(s:String) ={

    s.map
  }*/
  // sample test
  def justPrint()={
    val printWriter = new PrintWriter(new File("/Users/sumanbanerjee/CODE_Reference/ScalaTest_2017/src/main/scala/Functional_Prog_In_Scala/Chapter_4/test.txt"))

    printWriter.write("100")
    printWriter.close()

  }


  def reverseAString(s:String) : String =  {
    // s.reverse

    // way 2
    val sb = new StringBuilder()
    for (i<- s.length-1 to 0 by -1)
    {
      sb.append(s.charAt(i))
    }
    println("sb " +sb)

    // way 3
    @tailrec
    def revStringAccum(result:String,s:String):String ={
      var len = s.length
      if (len ==0) result
      else  revStringAccum(result + s.substring(len-1,len), s.substring(0,len-1))
    }
    revStringAccum("",s)
  }

  def sumFromReadingFile() : Unit ={

    val arrBuff = new scala.collection.mutable.ArrayBuffer[Int]()

    println("Inside sumFromReadingFile Enter the i/p file path  ")
    // get the file with path from stdin
    val stdin = scala.io.StdIn
    val file = stdin.readLine().trim
    // read the file
    val bufferedSource = Source.fromFile(file)
    for (line <- bufferedSource.getLines()){
      println("lines " + line)
      val numbers = line.split(" ")
      println("size " + numbers.length)

      val numbers_each_line = numbers.map(e=>e.toInt)
      println("Sum in each line " + numbers_each_line.sum)

      numbers.map(e=>{  var temp = e.toInt; arrBuff += temp})

    }

    val sum = arrBuff.sum
    println("Sum " + sum)
    bufferedSource.close()

  }

  // NOTE :: all these are different ways to load a file and then make use separate collections for doing useful stuff.

  // In way we are reading the entire file contents at once and then we are doing groupBy by words to have their counts
  def sumFromReadingFile_1()= {

    //val fileCount = scala.io.StdIn.readInt()
    //val fileName = scala.io.StdIn.readLine().trim
    val file = "/Users/sumanbanerjee/CODE_Reference/ScalaTest_2017/src/main/scala/Functional_Prog_In_Scala/Chapter_4/words.txt"

    //var sortedMap = new mutable.LinkedHashMap[String,Int]
    var sortedMap = new HashMap[String,Int]
    var sortedMap_mutable = new scala.collection.mutable.HashMap[String,Int]


    /*for (line <- Source.fromFile(file).getLines()){ // line is Iterator[String] to convert to String we can use line.mkString
      val lineStringArray = line.mkString.split(" ")
      val wordCountMap = lineStringArray.map(e=> (e,1)).groupBy(e=>e._1).mapValues(e=> e.size)

      //print("wordCountMap" + wordCountMap)
      // if we want to sorting
      sortedSeq :+ wordCountMap.toSeq.sortWith((x, y)=> x._2 > y._2)

      println("sortedSeq "+ sortedSeq)
      sortedSeq.map(t=> {sortedMap += (t._1 -> t._2)} )

    }*/

    val line = Source.fromFile(file).getLines()
    println("lines " + line.mkString )
    val lineStringArray = line.mkString.split(" ")
    val wordCountMap = lineStringArray.map(e=> (e,1)).groupBy(e=>e._1).mapValues(e=> e.size)
    val sortedSeq = wordCountMap.toSeq.sortWith((x, y)=> x._2 > y._2)
    println("sortedSeq "+ sortedSeq)

    sortedSeq.map(t=> {sortedMap += (t._1 -> t._2)} )

    //sortedSeq.map(t=> {sortedMap_mutable.put(t._1,t._2)} ) // same as above
    print(s" $sortedMap")


  }


  // check similar programs in ListTest.wordCountTest() also
  // In this way we are just reading line by line and then storing that in ArrayBuffer and finally we are groupBy for finding words count
  //
  def readFileTest()={
    val file = "/Users/sumanbanerjee/CODE_Reference/ScalaTest_2017/src/main/scala/Functional_Prog_In_Scala/Chapter_4/words.txt"
    val arrayBuffer = new ArrayBuffer[String]()
    var list =  List[String]()

    for (line <- Source.fromFile(file).getLines())
      {
        println(" line " + line)
        val words = line.split(" ")
        //words.map(e=> arrayBuffer.append(e))
        words.map(e=>list = list :+ e) // even we can add head by e :: list // since its var so we are able re-assign
      }
    //val list = arrayBuffer.toList
    println("list " + list)
    val worrdCount = list.groupBy(e=>e).mapValues(e=>e.size)
    println("worrdCount " + worrdCount)


  }



}
