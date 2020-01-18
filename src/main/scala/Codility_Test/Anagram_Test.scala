package main.scala.Codility_Test

object Anagram_Test {

  def main(args: Array[String]): Unit = {
    val word = "listen"
    val wordsList = List("enlists" ,"google", "inlets" ,"banana")
    val matchedWordsList = checkAnagram(wordsList,word)
    matchedWordsList.foreach(e=>println(e))
  }

  def checkAnagram(wordList : List[String] , word : String ): Seq[String] ={
    val sorted_word = word.toLowerCase.sorted
    val origin_word = word.toLowerCase
    val result = List[String]()


    wordList.filter(w=> w.toLowerCase.sorted == sorted_word )
  }


}
