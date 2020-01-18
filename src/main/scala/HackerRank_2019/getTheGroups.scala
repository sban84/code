package main.scala.HackerRank_2019

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, _}

object GetTheGroups {


  def main(args: Array[String]): Unit = {

    //val result = getTheGroups(6,Array("Friend" , "Friend", "Total" , "Total"), Array(1,2,1,5),Array(2,3,4,6))

   // val result = getTheGroups(6,Array("Friend" , "Friend", "Friend" , "Friend", "Friend" ,"Total"), Array(1,2,3,5,1,1),Array(2,3,4,6,1,6))
   val result = getTheGroups(7,Array("Friend" , "Friend", "Friend" , "Friend","Total"), Array(1,3,5,3,1,2),Array(2,2,6,4,7,6))
    //val result = getTheGroups(7,Array("Friend" , "Friend", "Friend"  ,"Total"), Array(1,2,5,1),Array(2,3,6,8))

    //val result = getTheGroups(5,Array("Friend" , "Friend" , "Total"), Array(4),Array(2))

    for(i <- 0 until(result.length)){
      print(result(i) + " ")
    }

  }


  /*
n = 3
queryType = ["Friends","Total"]
Friend
Total
2
1
2
2
2
3

students1 = [1,2]
students2 = [3]

   */



  def getTheGroups(n: Int, queryType: Array[String], students1: Array[Int], students2: Array[Int]):Array[Int] = {
    // Write your code here

    val STUDENT_IN_NO_GRP = 2

    val friendsMapTemp = scala.collection.mutable.HashMap[scala.collection.mutable.HashSet[Int] ,Int]()
    var friendsMap = scala.collection.mutable.HashMap[scala.collection.mutable.HashSet[Int] ,Int]()
    val resultBuffer = ArrayBuffer[Int]()

    var validInput = true
    if ((queryType.length != students1.length ) && (students1.length != students2.length)){
      println("1")
      validInput=false
    }
    if ( (( n < 1 || n > 100000 )|| students1.length > 100000 || students2.length > 100000)  ){

      validInput=false
    }
    for (i<- 0 until(students1.length)){
      if ((students1(i) < 1 || students1(i) > 100000) || students1(i) > n  ){

        validInput = false
      }

    }
    for (i <-0 until(students2.length)){
      if (students2(i) < 1 || students2(i) > 100000 || students2(i) > n ){

        validInput = false
      }
    }

    for (i <-0 until(queryType.length)){
      println(queryType(i))
      if ((queryType(i) != "Total") && (queryType(i) != "Friend")){

        validInput = false
      }
    }


    println("validInput " + validInput)
    if ( validInput ){

      for (i <-0 until(queryType.length)){
        var executeFlag = true
        if (queryType(i) == "Friend"){

          if (friendsMapTemp.size > 0){

            friendsMapTemp.keys.foreach(e =>{

              if (executeFlag == true){
                val currSet = e

                /*println(s"i = $i" )
                println(s"students1(i) ${students1(i)}")
                println(s"students2(i) ${students2(i)}")
                println(s"currSet $currSet")*/

                if (currSet.contains(students1(i)) || currSet.contains(students2(i))){
                  friendsMapTemp.remove(currSet)
                  //println(s"after removing ${currSet} , ${friendsMap}")
                  currSet.add(students1(i))
                  currSet.add(students2(i))
                  friendsMapTemp.put(currSet,currSet.size)
                  //println(s"after adding ${friendsMap}")

                }
                else{
                  //println("inside else >>>>")
                  var tempSet = scala.collection.mutable.HashSet[Int]()
                  tempSet.add(students1(i))
                  tempSet.add(students2(i))
                  friendsMapTemp.put(tempSet,tempSet.size)
                  //println(s"after adding first time ${friendsMap}")

                }
                executeFlag = false
              }

            })

          }
          else{
            var tempSet = scala.collection.mutable.HashSet[Int]()
            tempSet.add(students1(i))
            tempSet.add(students2(i))
            friendsMapTemp.put(tempSet,tempSet.size)
            //println(s"after adding first time >> ${friendsMap}")

          }

           friendsMap = friendsMapTemp

        }

        else if(queryType(i) == "Total"){
          var totalCount =0
          var localCount = 0
          var executeFlag = true

          val studentAlreadyCountedBuffer = ListBuffer[Int]()


          if (friendsMap.size > 0){
            friendsMap.keys.foreach(e =>{

              if (executeFlag == true){


                if (!(e.contains(students1(i))) && (!e.contains(students2(i))) ){
                  println(s"students1(i) ${students1(i)}")
                  println(s"students2(i) ${students2(i)}")
                  localCount = STUDENT_IN_NO_GRP
                  //executeFlag = false
                }

                /*println(s"i = $i" )
                println(s"students1(i) ${students1(i)}")
                println(s"students2(i) ${students2(i)}")
                println(s"currSet $e")*/
                //println("executeFlag" +executeFlag)
                if (e.contains(students1(i)) && (e.contains(students2(i)) )){
                  //println("*******")
                  localCount = 0
                  val groupFriendCount = friendsMap.get(e).get
                  localCount += ( 2 * groupFriendCount)
                  executeFlag = false
                  studentAlreadyCountedBuffer.append(students1(i))
                  studentAlreadyCountedBuffer.append(students2(i))
                  totalCount += localCount
                }
                if (e.contains(students1(i)) && executeFlag == true ){
                  localCount = 0
                  /* println(s"students1(i) ${students1(i)}")
                   println(s"students2(i) ${students2(i)}")
                   println(s"totalCount ${localCount}")*/

                  val groupFriendCount = friendsMap.get(e).get
                  //println(s"groupFriendCount ${groupFriendCount}")

                  localCount += groupFriendCount // one student in Query type is not in any group , so need to be added individually.
                  //println(s"localCount ${localCount}")
                  studentAlreadyCountedBuffer.append(students1(i))
                  totalCount += localCount

                }
                if (e.contains(students2(i)) && executeFlag == true){
                  localCount = 0
                  /*println(s"students1(i) ${students1(i)}")
                  println(s"students2(i) ${students2(i)}")
                  println(s"localCount ${localCount}")*/

                  val groupFriendCount = friendsMap.get(e).get
                  //println(s"groupFriendCount ${groupFriendCount}")

                  localCount += groupFriendCount  // one student in Query type is not in any group , so need to be added individually.
                  //println(s"localCount ${localCount}")
                  studentAlreadyCountedBuffer.append(students2(i))
                  totalCount += localCount

                }



                executeFlag = true

              }

            })
            //println("studentAlreadyCountedList " + studentAlreadyCountedBuffer)
            if (!(studentAlreadyCountedBuffer.contains(students1(i))) || (!studentAlreadyCountedBuffer.contains(students2(i))))
            {

              //println("special case " + studentAlreadyCountedBuffer)
              totalCount += 1
            }

          }
          else{

            totalCount = STUDENT_IN_NO_GRP
          }

          resultBuffer.append(totalCount)
        }

      }


      println(s"friendsMap $friendsMapTemp")
      println(s"resultBuffer $resultBuffer")


    }

    println(s"resultBuffer>> $resultBuffer")
    if (resultBuffer.size == 0)
      resultBuffer.append(0)
    resultBuffer.toArray

  }


  def mergedCommonFriends(map : mutable.HashMap[mutable.HashSet[Int] , Int]): mutable.HashMap[mutable.HashSet[Int] , Int ] = {

    val mergedMap = mutable.HashMap[mutable.HashSet[Int] , Int ]()
    var keyList = map.keys.toList
    //print(keyList)

    val listBuffer = ListBuffer[mutable.HashSet[Int]]()
    for(i <-0 until(keyList.size -1 )){
      var mergedSet = mutable.HashSet[Int]()

      var temp = keyList(i)
      for (j <- 1 until(keyList.size)){

        /*println(s"temp $temp")
        println(s"keyList(j) ${keyList(j)}")

        println(s"temp.intersect(keyList(j)).size ${temp.intersect(keyList(j)).size}")*/

        if (temp.intersect(keyList(j)).size >= 1 && !listBuffer.contains(keyList(j))){
          mergedMap.remove(temp)
          mergedMap.remove(keyList(j))
          mergedSet = temp.union(keyList(j))
          //println(s"mergedSet $mergedSet")
          temp= mergedSet
          listBuffer.append(keyList(j))


        }
        else if (!listBuffer.contains(keyList(j))){
          mergedSet = temp
          listBuffer.append(temp)
        }
        if (mergedSet.size > 0 ){
          mergedMap.put(mergedSet,mergedSet.size)
        }
      }

    }
    println(s"mergedMap $mergedMap")
    mergedMap
  }


  def test(array: Array[Int]): Unit ={

    val friendsSet = HashSet[Int]()
    val friendsMap = mutable.HashMap[Int,HashSet[Int]]()

    for (i <- 0 until(array.length)){

      if (friendsMap.contains(array(i))){
        var tempSet = friendsMap.get(array(i)).get
        tempSet.add(100)
        friendsMap.put(array(i),tempSet)
      }
      else{
        var tempSet = HashSet[Int](200)
          friendsMap.put(array(i),tempSet)
      }
    }

  }


  def getTheGroups_1(n: Int, queryType: Array[String], students1: Array[Int], students2: Array[Int]):Array[Int] = {
    // Write your code here

    val flagToHandleOneArg = false
    val friendSet = students1.toSet
    val resultBuffer = ArrayBuffer[Int]()
    val resultArray = Array[Int](n)

    //println(s"friendSet unique >>  $friendSet" )

    for (i <-0 until(students2.length) ){
      if (friendSet.contains(students2(i))){
        resultBuffer.append(friendSet.size)
      }
      else
      {
        resultBuffer.append(1)
      }

      // special case , if we pass one item in students2 list
      if (students2.length == 1){
        resultBuffer.append(1)
      }
    }

    //println(s"friendSet.size ${friendSet.size}" )
    //println(s"resultBuffer ${resultBuffer}" )
    resultArray(0) = resultBuffer.sum
    resultArray

  }
}
