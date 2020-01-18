package main.scala.collection

/**
  * Created by suman.banerjee on 4/12/2017.
  */
object QueueImplementation {
  def main( args: Array[ String ] ): Unit = {
    val q  = new Q[Int](List())
    var q1 = q.push(1)
    q1 = q.push(2)
    q1 = q.push(3)
    println("q is >>> " + q1)
  }

}


class Q[A] (list : List[A])
{
  val localList : List[A] = list
  def isEmpty() : Boolean = {
    //return (list.size == 0 ? true : false )
    if(localList.size == 0)
      return true
    else
      return false
  }

  def push(item : A) : Q[A] ={
    val newQ = new Q[A](item :: localList)
    return newQ
  }

  def pop() : List[ A ] = {
    //val item : A = list.takeRight(1).
    return localList.takeRight(1)
  }

  override def toString: String = {
    return list.toString()
  }
}

