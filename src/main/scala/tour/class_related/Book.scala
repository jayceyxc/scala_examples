package tour.class_related

case class Message(sender: String, recipient: String, body: String)

case class Book(isbn: String)

object Book {
  def main(args: Array[String]): Unit = {
    val frankenstein = Book("978-0486282114")
    println(frankenstein)

    val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")
    println(message1.sender)
    // prints guillaume@quebec.ca
//    message1.sender = "travis@washington.us"   // this line does not compile
  }
}