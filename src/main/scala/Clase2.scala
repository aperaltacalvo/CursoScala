object Clase2{
  def main(args: Array[String]): Unit = {
    SumarSquare(2,2)
  }

  def SumarSquare(var1:Double, var2:Double): Double = {

    val result = Square(var1) + Square(var2)
    println(result)
    result
  }

  def Square(var1:Double): Double ={
    BigDecimal(var1).pow(2).doubleValue()
  }
}