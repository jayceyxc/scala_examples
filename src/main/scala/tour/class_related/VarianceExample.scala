package tour.class_related

abstract class Animal {
  def name: String
}

case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

class VarianceExample {

}

/**
  * A type parameter A of a generic class can be made covariant by using the annotation +A.
  * For some class List[+A], making A covariant implies that for two types A and B where A is a subtype of B,
  * then List[A] is a subtype of List[B]. This allows us to make very useful and intuitive subtyping relationships using generics.
  *
  * In the following example, the method printAnimalNames will accept a list of animals as an argument
  * and print their names each on a new line. If List[A] were not covariant,
  * the last two method calls would not compile, which would severely limit
  * the usefulness of the printAnimalNames method.
  */
object CovarianceTest extends App {
  def printAnimalName(animals: List[Animal]): Unit = {
    animals.foreach(animal => println(animal.name))
  }

  val cats: List[Cat] = List(Cat("whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  printAnimalName(cats)
  printAnimalName(dogs)
}
