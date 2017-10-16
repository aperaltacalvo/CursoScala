package newCurso

object Clase1 {

  def sum(x:Int , y : Int):Int = {

    x+y
  }
  def mult(x:Int , y : Int):Int = {

    x*y
  }
  def rest(x:Int , y : Int):Int = {

    x-y
  }
  def div(x:Int , y : Int):Int = {

    x/y
  }

  def main(args: Array[String]): Unit = {
    println(sum(2,2))
    println(rest(2,2))
    println(div(2,2))
    println(mult(2,2))
  }

}