package tour.class_related


/**
  * 这个类有一个抽象类型T 和一个标准遍历方法
  */
abstract class AbsInterator {
  type T
  def hasNext: Boolean
  def next(): T
}

/**
  * StringIterator使用一个String作为参数，可以用来遍历String
  *
  * @param s 需要遍历的字符串
  */
class StringIterator(s: String) extends AbsInterator {
  type T = Char
  private var i = 0

  override def hasNext: Boolean = {
    i < s.length()
  }

  override def next(): T = {
    val ch = s.charAt(i)
    i += 1
    ch
  }
}

/**
  * trait RichIterator通过连续地在下一个元素(next())上调用提供的函数f实现了一个foreach方法
  * 由于RichIterator是一个trait，所以它不需要实现AbsIterator中的抽象方法
  */
trait RichIterator extends AbsInterator {
  def foreach(f: T=> Unit): Unit = {
    while (hasNext)
      f(next())
  }
}

object StringIteratorTest {
  def main(args: Array[String]): Unit = {
    class RichStringIterator extends StringIterator("Scala") with RichIterator
    val richStringIterator = new RichStringIterator
    richStringIterator.foreach(println)
  }
}
