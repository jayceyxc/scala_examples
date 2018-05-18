package tour.function


case class WeeklyWeatherForecast(temperatures: Seq[Double]) {
  private def convertCtoF(temp: Double): Double = {
    temp * 1.8 + 32
  }

  def forecastInFahrenheit: Seq[Double] = {
    temperatures.map(convertCtoF)
  }
}

/**
  * 这是一个接受函数作为参数的例子
  */
private class FunctionAcceptFunction {

  /**
    *
    *
    * @param salaries 需要进行转换的薪资列表
    * @param promotionFunction 薪资转换函数,该函数入参为Double, 返回值也是Double
    * @return 返回转换后的薪资列表
    */
  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] = {
    salaries.map(promotionFunction)
  }

  def smallPromotion(salaries: List[Double]): List[Double] = {
    promotion(salaries, salary => salary * 1.1)
  }

  def bigPromotion(salaries: List[Double]): List[Double] = {
    promotion(salaries, salary => salary * math.log(salary))
  }

  def hugePromotion(salaries: List[Double]): List[Double] = {
    promotion(salaries, salary => salary * salary)
  }
}

/**
  * Higher order functions take other functions as parameters or return a function as a result. This is possible
  * because functions are first-class values in Scala. The terminology can get a bit confusing at this point,
  * and we use the phrase “higher order function” for both methods and functions that
  * take functions as parameters or that return a function.
  */
object HigherOrderFunctionTest {

  /**
    *
    * @param ssl 是否是https网站
    * @param domainName 网站域名
    * @return 返回获取url的函数，函数形式为 (String, String) => String
    */
  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }

  def main(args: Array[String]): Unit = {
    val salaries = Seq(20000, 70000, 40000)

    // doubleSalary是一个函数，需要一个Int类型参数x，返回 x * 2
    // 通常 => 箭头左边的tuple是参数列表，右边表达式的值是返回值。
    val doubleSalary = (x: Int) => x * 2
    val newSalaries = salaries.map(doubleSalary)
    newSalaries.foreach(println)

    // 使用匿名函数实现同样的功能
    val newSalaries2 = salaries.map(x => x * 2)
    newSalaries2.foreach(println)

    val temp = List(1.0, 2.0, 4.0)

    val forecast = WeeklyWeatherForecast(temp)

    forecast.forecastInFahrenheit.foreach(println)

    val functionAcceptFunction = new FunctionAcceptFunction
    val smallSalaries = functionAcceptFunction.smallPromotion(temp)
    smallSalaries.foreach(println)
    val bigSalaries = functionAcceptFunction.bigPromotion(temp)
    bigSalaries foreach println
    val hugeSalaries = functionAcceptFunction.hugePromotion(temp)
    hugeSalaries foreach println

    val domainName = "www.example.com"
    def getUrl = urlBuilder(ssl=true, domainName)
    val endpoint = "users"
    val query = "id=1"
    val url = getUrl(endpoint, query)
    println(url)
  }
}
