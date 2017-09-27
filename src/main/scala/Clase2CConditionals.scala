object Clase2CConditionals {

  def main(args: Array[String]): Unit = {
    abs(2)
    abs(-2)
  }

  def abs(var1:Integer):Integer ={
    val result:Integer = if(var1 >=0) var1 else -var1
    println(result)
    result
  }

}
