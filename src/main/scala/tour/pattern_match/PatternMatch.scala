package tour.pattern_match

import scala.util.Random

object PatternMatch {
  /**
    * match expression have a value
    * @param x the parameter to match
    * @return the return value
    */
  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  def main(args: Array[String]): Unit = {
    val x: Int = Random.nextInt(10)

    x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "three"
      // case _ means catch all
      case _ => "many"
    }
    println(matchTest(3))
    println(matchTest(1))
  }
}
