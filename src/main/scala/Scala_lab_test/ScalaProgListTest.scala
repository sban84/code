package main.scala.Scala_lab_test

/**
  * Created by suman.banerjee on 3/28/2017.
  * Why not append to lists?
Class List does offer an “append” operation —it’s written :+ and is
explained in Chapter 24—but this operation is rarely used, because
the time it takes to append to a list grows linearly with the size of the
list, whereas prepending with :: takes constant time. Your options if
you want to build a list efficiently by appending elements is to prepend
them, then when you’re done call reverse; or use a ListBuffer, a
mutable list that does offer an append operation, and when you’re done
call toList.
  *
  */
object ScalaProgListTest {

  def main( args: Array[String] ): Unit = {
    var list = List(1,2,3)
    list = 0 :: list
    //list = 0 :+ list
    list = list :+ 4
    listTest(list)

    tupleTest()
  }

  def listTest(list : List[Int]): Unit =
  {
    list.foreach( (l:Int) => print((l*2) + ",") )

    val oneTwo = List(1, 2)
    val threeFour = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(oneTwo +" and "+ threeFour +" were not mutated.")
    println("Thus, "+ oneTwoThreeFour +" is a new list.")
  }

  def tupleTest(): Unit =
  {
    val pair = (99, "Ninety Nine")
    println(pair._1)
    println(pair._2)
  }

}



/*
What it is What it does
List() or  The empty List

List("Cool", "tools", "rule") Creates a new List[String] with the
three values "Cool", "tools", and
"rule"
val thrill = "Will" :: "fill" ::
"until" ::
Creates a new List[String] with the
three values "Will", "fill", and
"until"
List("a", "b") ::: List("c", "d") Concatenates two lists (returns a new
List[String] with values "a", "b",
"c", and "d")
thrill(2) Returns the element at index 2 (zero
based) of the thrill list (returns
"until")
thrill.count(s => s.length == 4) Counts the number of string elements in
thrill that have length 4 (returns 2)
thrill.drop(2) Returns the thrill list without its first 2
elements (returns List("until"))
thrill.dropRight(2) Returns the thrill list without its
rightmost 2 elements (returns
List("Will"))
thrill.exists(s => s == "until") Determines whether a string element
exists in thrill that has the value
"until" (returns true)
thrill.filter(s => s.length == 4) Returns a list of all elements, in order, of
the thrill list that have length 4 (returns
List("Will", "fill"))
thrill.forall(s =>
s.endsWith("l"))
Indicates whether all elements in the
thrill list end with the letter "l"
(returns true)
thrill.foreach(s => print(s)) Executes the print statement on each of
the strings in the thrill list (prints
"Willfilluntil")
Cover · Overview · Contents · Discuss · Suggest · Glossary · Index
Step 8 Chapter 3 · Next Steps in Scala 89
Table 3.1 · continued
thrill.foreach(print) Same as the previous, but more concise
(also prints "Willfilluntil")
thrill.head Returns the first element in the thrill
list (returns "Will")
thrill.init Returns a list of all but the last element in
the thrill list (returns
List("Will", "fill"))
thrill.isEmpty Indicates whether the thrill list is
empty (returns false)
thrill.last Returns the last element in the thrill
list (returns "until")
thrill.length Returns the number of elements in the
thrill list (returns 3)
thrill.map(s => s + "y") Returns a list resulting from adding a "y"
to each string element in the thrill list
(returns
List("Willy", "filly", "untily"))
thrill.mkString(", ") Makes a string with the elements of the
list (returns "Will, fill, until")
thrill.remove(s => s.length == 4) Returns a list of all elements, in order, of
the thrill list except those that have
length 4 (returns List("until"))
thrill.reverse Returns a list containing all elements of
the thrill list in reverse order (returns
List("until", "fill", "Will"))
thrill.sort((s, t) =>
s.charAt(0).toLower <
t.charAt(0).toLower)
Returns a list containing all elements of
the thrill list in alphabetical order of
the first character lowercased (returns
List("fill", "until", "Will"))
thrill.tail Returns the thrill list minus its first
element (returns
List("fill", "until"))
 */