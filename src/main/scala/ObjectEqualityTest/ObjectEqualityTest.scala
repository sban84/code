package main.scala.ObjectEqualityTest

/**
  * Created by suman.banerjee on 4/19/2017.
  *
  * Refer this  :- canEqual()  very useful. we can implemt any requirement using canEqual() in respective classes to bypass / restrict equality of base class and subclass
  *
  * This is perfect exmaple of Object Equality considering all aspects of Equality like symmetry , transivity etc
  * like p equals cp and cp equals p -- same result and
  * Transivity ->  cp1 equals p , p equals cp2 and cp1 equals cp2 --- same result
  *
  * Also includes simple impl to show if we want to exclude subclass specific params and consider same as parent if the overridden
  * params are same .
  *
  *
  *
  *
  */
object ObjectEqualityTest {

  def main(args:Array[String]) : Unit ={
    val p1 = new Point(1,2)
    val p2 = new Point(1,2)
    val pAnonymous = new Point(1,2){ override val y=2}

    /*println("p1 equals p2 " + p1.equals(p2))
    println("p2 equals p1 " + p2.equals(p1))
    println("p1 equals pAnonymous " + p1.equals(pAnonymous))
    println("pAnonymous equals p1 " + pAnonymous.equals(p1))*/


    val cp1 = new ColorPoint(1,2,Color.Red)
    val cp2 = new ColorPoint(1,2,Color.Blue)
    val cp3 = new ColorPoint(1,2,Color.Red)

    println("P1 equals CP1 " + p1.equals(cp1))
    println("cp1 equals p1 " + cp1.equals(p1))

    println("cp1 equals cp2 " + cp1.equals(cp2))
    println("cp2 equals cp1 " + cp2.equals(cp1))
    println("cp1 equals cp3 " + cp1.equals(cp3))

    // Test for Part2

    /*val ap : AnotherPoint = new AnotherPoint(1,2)
    val acp : AnotherColorPoint = new AnotherColorPoint(1,2,Color.Red)

    println("ap equals acp " + ap.equals(acp))
    println("acp equals ap " + acp.equals(ap))*/


  }
}

class Point (val x:Int , val y:Int)
{
  override def hashCode( ): Int = {
    41*(41+x) + y
  }

  override def equals( obj: Any ): Boolean = obj match {
    case obj : Point => {obj.canEqual(this) && this.x == obj.x && this.y == obj.y}
    case _ => false
  }

  def canEqual(obj:Any) : Boolean = {
    return obj.isInstanceOf[Point]
  }
}

// scenario when subclass is present and we want subclass to different than base class
class ColorPoint( override val x:Int, override val y:Int, val color : Color.Value) extends Point( x, y){

  override def hashCode = 41 * super.hashCode + color.hashCode

  override def equals( obj: Any ): Boolean = obj match {
    case obj : ColorPoint => { obj.canEqual(this) && super.equals(obj) && this.color == obj.color}
    case _ => false
  }

  override def canEqual( obj: Any ): Boolean = {
    return obj.isInstanceOf[ColorPoint]
  }
}

object Color extends Enumeration {
  val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
}


// PART 2 :: if we want to consider parent and subclass are treated equal


class AnotherPoint (val x:Int , val y:Int)
{
  override def hashCode( ): Int = {
    41*(41+x) + y
  }

  override def equals( obj: Any ): Boolean = obj match {
    case obj : AnotherPoint => {this.x == obj.x && this.y == obj.y}
    case _ => false
  }
}

//ConsiderEqualAsAnotherPoint
class AnotherColorPoint( override val x:Int, override val y:Int, val color : Color.Value) extends AnotherPoint( x, y){

  override def hashCode = 41 * super.hashCode + color.hashCode

  override def equals( obj: Any ): Boolean = obj match {
    case obj : AnotherColorPoint => {  super.equals(obj) && this.color == obj.color}
    case obj : AnotherPoint => {super.equals(obj)}
    case _ => false
  }

}