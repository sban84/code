package main.scala.HackerRank_2019

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object GetTheGroups_1 {

  def main(args: Array[String]): Unit = {

    //val result = getTheGroups(6,Array("Friend" , "Friend", "Total" , "Total"), Array(1,2,1,5),Array(2,3,4,6)) // 4 2

    //val result = getTheGroups(2,Array("Total"), Array(1),Array(2)) //2
    //val result = getTheGroups(5,Array("Friend" , "Friend", "Total"), Array(4,3,4),Array(2,4,3)) //6

    //val result = getTheGroups(7,Array("Friend" , "Friend", "Friend" , "Friend", "Friend","Total"), Array(1,3,5,3,1,2),Array(2,4,6,4,7,6)) // 5

    val result = getTheGroups(5,Array("Friend" , "Friend" , "Total"), Array(4),Array(2))

    for (i <- 0 until (result.length)) {
      print(result(i) + " ")
    }

  }

  def getTheGroups(n: Int, queryType: Array[String], students1: Array[Int], students2: Array[Int]): Array[Int] = {
    // Write your code here
    val STUDENT_IN_NO_GRP = 2
    var friendsMap = scala.collection.mutable.HashMap[scala.collection.mutable.HashSet[Int], Int]()
    var friendsMapMerged = scala.collection.mutable.HashMap[scala.collection.mutable.HashSet[Int], Int]()
    val resultBuffer = ArrayBuffer[Int]()

    var validInput = true
    // Handling edge cases , for the inputs
    if ((queryType.length != students1.length) || (students1.length != students2.length) || (queryType.length != students2.length)) {
      validInput = false
    }
    if (((n < 1 || n > 100000) || students1.length > 100000 || students2.length > 100000)) {

      validInput = false
    }
    for (i <- 0 until (students1.length)) {
      if ((students1(i) < 1 || students1(i) > 100000) || students1(i) > n) {
        validInput = false
      }

    }
    for (i <- 0 until (students2.length)) {
      if (students2(i) < 1 || students2(i) > 100000 || students2(i) > n) {
        validInput = false
      }
    }

    for (i <- 0 until (queryType.length)) {
      if ((queryType(i) != "Total") && (queryType(i) != "Friend")) {
        validInput = false
      }
    }

    if (validInput) {

      for (i <- 0 until (queryType.length)) {
        var executeFlag = true
        if (queryType(i) == "Friend") {

          if (friendsMap.size > 0) {

            friendsMap.keys.foreach(e => {

              if (executeFlag == true) {
                val currSet = e
                if (currSet.contains(students1(i)) || currSet.contains(students2(i))) {
                  friendsMap.remove(currSet)
                  currSet.add(students1(i))
                  currSet.add(students2(i))
                  friendsMap.put(currSet, currSet.size)
                }
                else {
                  var tempSet = scala.collection.mutable.HashSet[Int]()
                  tempSet.add(students1(i))
                  tempSet.add(students2(i))
                  friendsMap.put(tempSet, tempSet.size)

                }
                executeFlag = false
              }

            })
          }
          else {
            var tempSet = scala.collection.mutable.HashSet[Int]()
            tempSet.add(students1(i))
            tempSet.add(students2(i))
            friendsMap.put(tempSet, tempSet.size)
          }
        }
        else if (queryType(i) == "Total") {
          var totalCount = 0
          var localCount = 0
          var executeFlag = true
          val studentAlreadyCountedBuffer = ListBuffer[Int]()

          println(s"friendsMap >> $friendsMap" )
          friendsMapMerged = MergedMap.mergedCommonFriend(friendsMap)

          if (friendsMapMerged.size > 0) {
            friendsMapMerged.keys.foreach(e => {

            /*  println(s"executeFlag $executeFlag")
              println(s"students1(i) ${students1(i)}")
              println(s"students2(i) ${students2(i)}")
              println(s"e=  ${e}")*/

              if (executeFlag == true) {
                if (e.contains(students1(i)) && (e.contains(students2(i)))) {
                  localCount = 0
                  val groupFriendCount = friendsMapMerged.get(e).get
                  localCount += (2 * groupFriendCount)
                  executeFlag = false
                  studentAlreadyCountedBuffer.append(students1(i))
                  studentAlreadyCountedBuffer.append(students2(i))
                  totalCount += localCount
                }
                if (e.contains(students1(i)) && executeFlag == true) {
                  localCount = 0
                  val groupFriendCount = friendsMapMerged.get(e).get

                  localCount += groupFriendCount // one student in Query type is not in any group , so need to be added individually.
                  studentAlreadyCountedBuffer.append(students1(i))
                  totalCount += localCount

                }
                if (e.contains(students2(i)) && executeFlag == true) {
                  localCount = 0
                  val groupFriendCount = friendsMapMerged.get(e).get
                  localCount += groupFriendCount // one student in Query type is not in any group , so need to be added individually.
                  studentAlreadyCountedBuffer.append(students2(i))
                  totalCount += localCount

                }

                if (!(e.contains(students1(i))) && (!e.contains(students2(i))) && executeFlag == true) {

                  totalCount = STUDENT_IN_NO_GRP
                  studentAlreadyCountedBuffer.append(students1(i))
                  studentAlreadyCountedBuffer.append(students2(i))
                  executeFlag = false
                }
                if ((studentAlreadyCountedBuffer.contains(students1(i))) && (studentAlreadyCountedBuffer.contains(students2(i)))){
                  executeFlag = false
                }
                //executeFlag = true
              }

            })
            if (!(studentAlreadyCountedBuffer.contains(students1(i))) || (!studentAlreadyCountedBuffer.contains(students2(i)))) {
              totalCount += 1
            }
          }
          else {
            totalCount = STUDENT_IN_NO_GRP
          }

          resultBuffer.append(totalCount)
        }
      }

      println(s"friendsMapMerged $friendsMapMerged")
      println(s"resultBuffer $resultBuffer")


    }
    // In case result is empty , so returing 0 in the collection to avoid any accedental issues to client API
    if (resultBuffer.size == 0)
      resultBuffer.append(0)
    //Finally return the o/p
    resultBuffer.toArray
  }

}
