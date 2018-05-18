package tour.class_related

abstract class A {
  val message: String
}

class B extends A {
  val message = "I'm an instance of class B"
}

trait C extends A {
  def loudMessage = message.toUpperCase()
}

/**
  * Class D has a superclass B and a mixin C. Classes can only have one superclass but many mixins
  * (using the keywords extends and with respectively). The mixins and the superclass may have the same supertype.
  */
class D extends B with C

object MixinExample {
  def main(args: Array[String]): Unit = {
    val d = new D
    println(d.message)
    println(d.loudMessage)
  }
}
