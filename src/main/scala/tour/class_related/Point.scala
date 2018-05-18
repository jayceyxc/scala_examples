package tour.class_related

/**
  * Point 类有两个变量x和y，如果在x和y前面没有var 关键字，就不能在move函数对器进行赋值
  * 和其他语言不同的是，主构造器是类的签名(var x: Int, var y: Int)
  *
  * 构造器中可以通过提供默认值来提供可选参数。
  * @param x 变量x
  * @param y 变量y
  */
case class Point(var x: Int = 0, var y: Int = 0) {

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String = {
    s"($x, $y)"
  }
}

class PointWithPrivateParam {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x = _x
  def x_= (newValue: Int): Unit = {
    println("call x_")
    if (newValue < bound) _x = newValue else printWarning
  }

  def y = _y
  def y_= (newValue: Int): Unit = {
    println("call y_")
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")
}

object PointMain {
  def main(args: Array[String]): Unit = {
    val point = Point(1, 2)
    val anotherPoint = Point(1, 2)
    val yetAnotherPoint = Point(2, 2)
    val defaultPoint = Point()
    val onlyYPoint = Point(y = 2)

    if (point == anotherPoint) {
      println(point + " and " + anotherPoint + " are the same.")
    } else {
      println(point + " and " + anotherPoint + " are different.")
    }
    // Point(1,2) and Point(1,2) are the same.

    if (point == yetAnotherPoint) {
      println(point + " and " + yetAnotherPoint + " are the same.")
    } else {
      println(point + " and " + yetAnotherPoint + " are different.")
    }
    // Point(1,2) and Point(2,2) are different.

    println(defaultPoint)
    println(onlyYPoint)

    val pointWithPrivateParam = new PointWithPrivateParam()
    pointWithPrivateParam.x = 99
    pointWithPrivateParam.y = 101
    println(pointWithPrivateParam.x + ": " + pointWithPrivateParam.y)
  }
}
