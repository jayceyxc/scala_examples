package tour.basic

import scala.io.StdIn

object StandIOTest {
  def main(args: Array[String]): Unit = {
    val name = StdIn.readLine("你的名字：")
    println(name)
  }
}
