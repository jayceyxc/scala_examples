package tour.regex

import scala.util.matching.Regex

object RegexExample {

  def regexTest() = {
    val numberPattern: Regex = "[0-9]"r

    numberPattern.findFirstMatchIn("awesomepassword") match {
      case Some(_) => println("Password OK")
      case None => println("Password must contain a number")
    }
  }

  def regexGroupTest(): Unit = {
    val keyValuePattern: Regex = "([0-9a-zA-Z-#() ]+): ([0-9a-zA-Z-#() ]+)".r

    val input: String =
      """background-color: #A03300;
        |background-image: url(img/header100.png);
        |background-position: top center;
        |background-repeat: repeat-x;
        |background-size: 2160px 108px;
        |margin: 0;
        |height: 108px;
        |width: 100%;""".stripMargin

    for (patternMatch <- keyValuePattern.findAllMatchIn(input)) {
      println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")

      /**
        * key: background-color value: #A03300
        * key: background-image value: url(img
        * key: background-position value: top center
        * key: background-repeat value: repeat-x
        * key: background-size value: 2160px 108px
        * key: margin value: 0
        * key: height value: 108px
        * key: width value: 100
        */
    }
  }

  def main(args: Array[String]): Unit = {
    regexTest()
    regexGroupTest()
  }
}
