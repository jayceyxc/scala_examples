package logging

object Logger {
  def info(message: String) = {
    println(s"INFO: $message")
  }
}
