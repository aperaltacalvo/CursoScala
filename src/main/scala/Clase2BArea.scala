object Clase2BArea {

  def main(args: Array[String]): Unit = {
    Area(10)
  }

  def Area(var1:Double): Double = {

    val result = Math.PI * Square(var1)
    println(result)
    result
  }

  def Square(var1:Double): Double ={
    BigDecimal(var1).pow(2).doubleValue()

  }
}
