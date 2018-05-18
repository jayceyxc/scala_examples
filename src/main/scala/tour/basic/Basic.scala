package tour.basic

object Basic {
  def add(x : Int, y : Int): Int = {
    println("call add")
    x + y
  }

  /**
    * 方法可以有多个参数列表
    * 将第一个参数列表中的参数相加，然后乘以第二个参数列表中的参数
    *
    * @param x 加法参数1
    * @param y 加法参数2
    * @param mulitiplier 乘数因子
    * @return
    */
  def addThenMultiply(x : Int, y : Int)(mulitiplier : Int): Int = {
    val result = (x + y) * mulitiplier
    println(result)
    result
  }
  def main(args: Array[String]): Unit = {
    val xmax, ymax = 100
    var greeting, message: String = "hello world"

    println(xmax)
    println(ymax)
    println(greeting)
    println(message)

    // 函数对象, => 左边是函数的参数列表，右边是使用这些参数的表达式
    val addOne = (x : Int) => x + 1
    println(addOne(5))

//    val add = (x : Int, y : Int) => x + y
//    println(add(4, 5))

    println(add(4, 8))
    println(addThenMultiply(5, 4)(40))
  }
}
