package tour.basic

trait GreeterTrait {
  // method in trait only defines the parameter list and return type
  def greetInterface(name: String): Unit

  // method in trait can also have default implementations
  def greet(name: String): Unit = {
    println("Hello, " + name + "!")
  }
}

abstract class DefaultGreeter extends GreeterTrait

class CustormizableGreeter(prefix: String, suffix: String) extends GreeterTrait {
  override def greetInterface(name: String): Unit = {
    println(prefix + name + suffix)
  }

  override def greet(name: String): Unit = {
    println("in greet " + prefix + name + suffix)
  }
}

object GreeterTraitMain {
  def main(args: Array[String]): Unit = {
    val custormizableGreeter = new CustormizableGreeter("How are you, ", "?")
    custormizableGreeter.greet("yuxuecheng")
  }
}


