package tour.singleton_objects

import scala.math._

case class Circle(radius: Double) {
  import Circle._
  def area: Double = {
    calculateArea(radius)
  }
}

object Circle {
  private def calculateArea(radius: Double): Double = {
    Pi * pow(radius, 2.0)
  }

  def main(args: Array[String]): Unit = {
    val circle1 = new Circle(5.0)
    println(circle1.area)
  }
}
