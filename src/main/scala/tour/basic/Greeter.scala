package tour.basic

class Greeter(prefix : String, suffix : String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}

object GreeterMain {
  def main(args: Array[String]): Unit = {
    val greeter = new Greeter("Hello, ", "!")
    greeter.greet("Scala developer")
  }
}