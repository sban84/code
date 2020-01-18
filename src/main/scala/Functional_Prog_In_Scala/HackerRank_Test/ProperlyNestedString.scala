package main.scala.Functional_Prog_In_Scala.HackerRank_Test

object ProperlyNestedString {

  def main(args: Array[String]): Unit = {

    println(checkProperlyNested("(()(())()"))
  }

  def checkProperlyNested(str : String) : Boolean ={


    val stack = scala.collection.mutable.Stack[Char]()
    var isValid = true
    str.map(e=>{


      if ( e.equals('('))
        stack.push(e)
      else if (e.equals(')')){
        if (stack.isEmpty)
        {
          isValid= false
        }
        else if (!isMatchingParenthesis(e,stack.pop())) {
          isValid = false
        }
      }


    })
    if (stack.size == 0)
      true
    else
      false


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

}
