package newCurso.homeworks

import scala.collection.mutable.ListBuffer


object Operation {

  //Ejercicio1
  def sum(x:Any , y : Any):Any = {

x.asInstanceOf[Number].doubleValue() + y.asInstanceOf[Number].doubleValue()
  }


  def operar (f:(Any,Any)=>Any, x:Any, y:Any):Any = {
    f(x,y)
  }

  //Ejercicio2

    def Mayor(list: List[Int]): Int = {
      val cont = list.size - 1

      var result = 0
      if(cont > 0 && list(cont) > list(cont-1)){
      result=  Mayor(list.filter(_<list(cont)))
      }else if (cont > 0 && list(cont) <= list(cont-1)){
      result =  Mayor(list.filter(_>list(cont)))
      }else{

        result = list(0)
      }
      result
    }

  //Ejercicio 3

  def second(list:List[Int]):Int = {
    list(1)
  }

  //Ejercicio 4

  def nth(list:List[Int], n:Int):Int = {
    list(n)
  }

val list = List(1,-20,1,9,2,-3)

  def main(args: Array[String]): Unit = {
    println(operar(sum,2,3.2))
    println(Mayor(list))
    println(second(list))
    println(nth(list,1))

  }
}
