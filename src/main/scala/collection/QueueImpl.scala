package main.scala.collection

/**
  * Created by suman.banerjee on 4/12/2017.
  */
object QueueImplTest {

  def main( args: Array[ String ] ): Unit = {
    val  q  = new QueueImpl[Int](List(),List())
    var q1 = q.enqueue(1)
    q1 = q.enqueue(2)
    q1 = q.enqueue(3)

    println("Queue after enqueue >> " + q1)
  }



}

class QueueImpl[ T ](
                      private val leading: List[ T ],
                      private val trailing: List[ T ]
                    ) {
  private def mirror =
    if (leading.isEmpty)
      new QueueImpl( trailing.reverse,  Nil)
    else
      this

  def head = mirror.leading.head

  def tail = {
    val q = mirror
    new QueueImpl( q.leading.tail, q.trailing )
  }

  def enqueue( x: T ) =
    new QueueImpl( leading, x :: trailing )

  override def toString: String = {
    //println("Queue is >> " + leading.mkString(",") +  trailing.mkString(","))
    return leading.toString() +  trailing.toString()
  }
}
