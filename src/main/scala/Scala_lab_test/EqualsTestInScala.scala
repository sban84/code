package main.scala.Scala_lab_test



/**
  * Created by suman.banerjee on 4/18/2017.
  *
  * Background on why equals need CanEqual like function .
  * https://dzone.com/articles/equals-and-scala
  *
  * cp.equals(p) will fail in equals of cp , as match will not pass and will return false from  else _ => ...
  * p.equals(cp) will pass in equals of p as cp is object type of p , so it will go inside and then invoke canEqual of cp passing p as this instance.
  * in cp.canEqual(p) it will check p.instanceOf[cp] which will fail and return false finally
  */
object EqualsTestInScala {

  def main( args: Array[ String ] ): Unit = {
    var p : Point = new Point(1,2)
    var cp : ColorPoint = new ColorPoint(1,2,Color.Red)

    println(" p == cp " + p==cp)
    //println(" p.equals(cp)" + p.equals(cp))
    println(" cp.equals(p) " + cp.equals(p))

    var cpRed : ColorPoint = new ColorPoint(1,2,Color.Red)
    var cpBlue : ColorPoint = new ColorPoint(1,2,Color.Blue)

    println("cp.isInstanceOf[p] " + cp.isInstanceOf[Point])
    println( "p.inInstanecOf[cp] " + p.isInstanceOf[ColorPoint])


  }
}


class Point(val x:Int , val y:Int)
{
  def canEqual( obj: Any ) = { println("Point canEqual is called ") ; obj.isInstanceOf[Point]}
  override def hashCode = 41 * (41 + x) + y
  override def equals( obj: scala.Any ): Boolean = obj match {
    case obj : Point => { println("point class equal() is called ")
      obj.canEqual(this) && (this.x == obj.x && this.y == obj.y)}
    //case obj : Point => { obj.isInstanceOf[Point] && (this.x == obj.x && this.y == obj.y)}
    case _ => false
  }
}

class ColorPoint(x:Int , y :Int , val color : Color.Value) extends Point(x,y)
{
  override def hashCode = 41 * super.hashCode + color.hashCode
  override def equals(obj : Any) : Boolean = obj match{
    case obj : ColorPoint => {obj.canEqual(this) && (super.equals(obj) && this.color == obj.color)}
    case _ => {println("inside ColorPoint case _ flow ") ;false}
  }
  override  def canEqual(obj : Any):Boolean ={
    println("ColorPoint canEqual is called " + obj )
    obj.isInstanceOf[ColorPoint]
  }
}

object Color extends Enumeration {
  val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
}