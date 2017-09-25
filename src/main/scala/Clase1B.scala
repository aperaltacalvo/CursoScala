import com.sun.tools.javac.code.Attribute.Array

object Clase1B{
  def main(args: Array[String]): Unit = {
    Sumar(2,2)
  }

  def Sumar(var1:Integer, var2:Integer): Integer = {

    val result = var1 + var2
    println(result)
    result
  }
}

