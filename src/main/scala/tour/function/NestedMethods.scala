package tour.function

object NestedMethods {
  def factorial(x: Int): Int = {
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1)
        accumulator
      else
        fact(x - 1, accumulator * x)
    }
    fact(x, 1)
  }

  def main(args: Array[String]): Unit = {
    println("Factorial of 2:" + factorial(2))
    println("Factorial of 5:" + factorial(5))
    println("Factorial of 10:" + factorial(10))
  }
}
