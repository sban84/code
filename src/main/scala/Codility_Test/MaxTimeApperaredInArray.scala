package main.scala.Codility_Test

/*
  A zero-indexed array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.
  For example, consider array A such that
  A[0] = 3    A[1] = 4    A[2] =  3
  A[3] = 2    A[4] = 3    A[5] = -1
  A[6] = 3    A[7] = 3
  The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
  Write a function
  object Solution { def solution(A: Array[Int]): Int }
  that, given a zero-indexed array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.
  Assume that:
  N is an integer within the range [0..100,000];
  each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
  For example, given array A such that
  A[0] = 3    A[1] = 4    A[2] =  3
  A[3] = 2    A[4] = 3    A[5] = -1
  A[6] = 3    A[7] = 3
  the function may return 0, 2, 4, 6 or 7, as explained above.
  Complexity:
  expected worst-case time complexity is O(N);
  expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
  Elements of input arrays can be modified.
   */

object MaxTimeApperaredInArray {

  def main(args: Array[String]): Unit = {

    //val leader = println("Leader " + solution_1(Array(3, 2, 3, 4, 3, 3, 3, -1)))

    //val leaderByAnotherWay = println("Leader " + solution(Array(3, 2, 3, 4, 3, 3, 3, -1)))

    val leaderBySolution_2 = println("Solution_2 " + solution_2(Array(2, 3, 3, 5, 3, 4, 1, 7),8,8))

    //println("Test " + Array(3, 2, 3, 4, 3, 3, 3, -1).indexOf(3))

  }

  // Using Extra Space
  def solution(A: Array[Int]): Int = {
    val B = A.sorted
    var leader =B(0)
    var finalLeader = B(0)
    var counter = 0
    var maxCounter =0
    for(i<- 0 until B.length)
      {
        println("Item " + B(i))
        if(leader == B(i))
          {

            counter +=1
            //println("Item found " + counter)
          }
        else
          {

            leader = B(i)
            counter =1
            //println("New found " +counter)
          }
        if(counter > maxCounter){

          maxCounter = counter
          //println("Inside MaxCounter Set " + counter + ": " + maxCounter + " : " + i)
          finalLeader = leader
        }

      }
    if(maxCounter >= (B.length)/2)
      A.indexOf(finalLeader)
    else
      -1

  }

  // Without using Extra space
  def solution_1(A: Array[Int]): Int = {
    val n = A.length
    var size = 0
    var value = -1
    for (i <- 0 until n) {
      if (size == 0) {
        size = size + 1
        value = A(i)
      } else if (value != A(i)) size = size - 1
      else size = size + 1
    }
    var candidate = -1
    if (size > 0) candidate = value
    var leader = -1
    var count = 0
    for (k <- 0 until n) if (A(k) == candidate) count = count + 1
    if (count >= n / 2) leader = candidate
    A.indexOf(leader)
    //leader
  }

  def solution_2(arr : Array[Int] , n:Int , K:Int): Unit =
  {
    for(i <- 0 until 8)
      {
        arr(arr(i%K)) += K

      }

    var max:Int = arr(0)
    var result = 0

    for(i <- 0 until n)
      {
        arr(i) > max
        result = i
      }
    result
  }
}
