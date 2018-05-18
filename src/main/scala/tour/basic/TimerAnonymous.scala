package tour.basic

/**
  * anonymous functions, which are exactly that: functions without a name.
  */
object TimerAnonymous {

  def oncePerSecond(callback: () => Unit): Unit = {
    while (true) {
      callback()
      Thread sleep 1000
    }
  }

  def main(args: Array[String]): Unit = {
    /**
      * The presence of an anonymous function in this example is revealed by the right arrow => which separates the
      * function’s argument list from its body. In this example, the argument list is empty,
      * as witnessed by the empty pair of parenthesis on the left of the arrow.
      */
    oncePerSecond(() =>
      println("time flies like an arrow..."))
  }
}
