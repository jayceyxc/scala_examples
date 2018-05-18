package tour.class_related

import scala.util.Random

object CustomerID {

  def apply(name: String) = {
    println("call apply")
    s"$name--${Random.nextLong()}"
  }

  def unapply(customerID: String): Option[String] = {
    println("call unapply")
    val name = customerID.split("--").head
    if (name.nonEmpty) Some(name) else None
  }

  def main(args: Array[String]): Unit = {
    val customerID = CustomerID("Sukyoung")
    println("next call match")
    customerID match {
      case CustomerID(name) => println(name)
      case _ => println("Could not extract a CustomerID")
    }
    List
  }
}
