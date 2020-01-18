package main.scala.Functional_Prog_In_Scala.HackerRank_Test

import scala.collection.mutable

object CheckExpressionValid {

  def main(args: Array[String]): Unit = {

    //stackTest()
    checkValidity("{(2+3)}")
    //checkValidityUsingRecursion("(2+3)".toList)
  }

  /*def checkValidityUsingRecursion(input : List[Char])=  {

      def checkAccum(input : List[Char],stack : mutable.Stack[Char]) : List[Char] = input match {
        case e :: tail if(e.equals('(') || e.equals('{') || e.equals('[')) => {
          println("inside e" + e  )
          stack.push(e.asInstanceOf[Char])
          checkAccum(tail,stack)
        }
        case e :: tail  if(e.equals(')' ) || e.equals('}') || e.equals(']')) => {
          stack.pop()
          checkAccum(tail,stack)
        }
        case List() => {println(" inside empty " ); List[Char]()}
  }

    var stack = mutable.Stack[Char]()
    checkAccum(input, stack)
    println(s"stcak  $stack and size ${stack.size}")

  }*/

  def checkValidity(input : String)= {

    val stack = mutable.Stack[Char]()
    var isValid = true

    input.map(e => {
      println("e " + e)
      if (e.equals('(') || e.equals('{') || e.equals('[')){
        stack.push(e)
        println("stack " + stack)
      }

      else if (e.equals(')') || e.equals('}') || e.equals(']') ){
        if (stack.isEmpty)
        {
          isValid= false
        }
        else if (!isMatchingParenthesis(stack.pop(),e)){
          isValid=false
        }
        //stack.pop()
      }

    })

    println("Stack size " + stack.size)
    println(s"isValid $isValid"  )
    /* if (stack.isEmpty) {
      println("Valid")
    }
      else
      println("Invalid")
    }*/
  }

  def isMatchingParenthesis(character1:Char, character2: Char):Boolean ={
    if (character1 == '(' && character2 == ')')
      return true;
    else if (character1 == '{' && character2 == '}')
      return true;
    else if (character1 == '[' && character2 == ']')
      return true;
    else
      return false;
  }

  // simple version
  def stackTest(): Unit ={
    val array = Array[Char]('(' , '{' , '[')
    val input = "(2+3)+(1*2))"
    val stack = mutable.Stack[Char]()

    input.map(e=>{
      if (e.equals('(') || e.equals('{') || e.equals('['))
      stack.push(e)
      else if ( (e.equals(')') || e.equals('}') || e.equals(']') ) && stack.size > 0){
        stack.pop()
      }
    })

    println("Stack  " + stack)

    if (stack.size ==0)
      {
        println("valid")
      }
    else
      println("Invalid")
  }

}
