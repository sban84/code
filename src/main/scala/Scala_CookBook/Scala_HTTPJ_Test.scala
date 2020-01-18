/*package Scala_CookBook

import com.sun.deploy.net.HttpResponse

object TestHead extends App
{
  val response: HttpResponse[String] = Http("http://www.google.com")
    .method("HEAD")
    .timeout(connTimeoutMs = 2000, readTimeoutMs = 5000)
    .asString
  for ((k,v) <- response.headers) println(s"key:   $k\nvalue: $v\n")
}*/
