package main.scala.Scala_lab_test

import scala.collection.immutable.HashSet

/**
  * Created by suman.banerjee on 4/17/2017.
  */
object EqualsAndHashCodeTest {

  def main( args: Array[ String ] ): Unit = {
    //Test Object equality
    //val p1 : Point = new Point(1,2)
    //val p2 : Point = new Point(1,2)

    val p1 , p2 = new Point(1,2)

    println("p1 == p2 " +  p1 == p2)  // This should call equals internally
    println("p1.equals(p2) " +  p1.equals(p2))  // NOT same as eq , eq is same as Java's reference equality ( i.e == )

    var set  = HashSet[Point]()
    set += p1
    println("HashSet before adding  " + set + " set.contains(p2) " + set.contains(p2))  // requires equals() and hashCode both to be overriden to work properly.



    /*val sban1 = new Person("sban", 82)
    val sban2 = new Person("sban", 82)
    println("WWWWWW" + sban1==sban2 )
    //println("sasasasaasas" + nimoy==nimoy2)*/
  }

}

/*class Point(val x: Int, val y: Int) {
  override def hashCode = 41 * (41 + x) + y
  override def equals(other: Any) = other match {
    case that: Point =>
      (that canEqual this) &&
        (this.x == that.x) && (this.y == that.y)
    case _ =>
      false
  }
  def canEqual(other: Any) = other.isInstanceOf[Point]
}*/

/*class Point(val x: Int, val y: Int) {
  override def hashCode= 41 * (41 + x) + y
  /*override  def hashCode() : Int = {
    return 41 * (41 + x) + y
  }*/
  override def equals(other: Any) : Boolean = other match {
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false
  }

  /* Compiler will not allow this , as == is final in AnyRef
  override def == (that:AnyRef) : Boolean = {
    if(null eq this )
      {null eq that}
    else
      {
        this equals that
      }
  }*/
}*/


/*class Person (val name: String, val age: Int) {
  def canEqual(a: Any) = a.isInstanceOf[Person]
  override def equals(other: Any): Boolean =
    other match {
      case that: Person => that.canEqual(this) && this.hashCode == that.hashCode
      //case that: Person => this.name == that.name && this.age == that.age
      case _ => false
    }
  override def hashCode: Int = {
    val prime = 31
    var result = 1
    result = prime * result + age;
    result = prime * result + (if (name == null) 0 else name.hashCode)
    return result
  }
}*/
