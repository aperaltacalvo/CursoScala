package newCurso.homeworks

import scala.annotation.tailrec


object EjerciciosTema1 {

  //Ejercicio1
  def sum(x:Any , y : Any):Any = {

x.asInstanceOf[Number].doubleValue() + y.asInstanceOf[Number].doubleValue()
  }


  def operar (f:(Any,Any)=>Any, x:Any, y:Any):Any = {
    f(x,y)
  }

  def operarSolution[A,B] (f:(A,A)=>B,a:A,b:A):B={
      f(a,b)
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

  def max(list:List[Int]) {
    @tailrec
    def go(current: Int, rest: List[Int]): Unit ={
      rest match {
        case Nil => current
        case h::t => if(h>current) go(h,t) else go(current,t)
      }
    }
  }
  //Ejercicio 3

  def second(list:List[Int]):Int = {
    list(1)
  }

  def secondSolution(list:List[Int]):Option[Int]={
    list match {
      case h::h2::t => Some(h2)
      case _ => None

  }

  }

  //Ejercicio 4

  def nth(list:List[Int], n:Int):Int = {
    list(n)
  }

  def nthSolution(list:List[Int],n:Int):Option[Int] = {

    list match {
      case h::t if n == 0 => Some(h)
      case h::t if n > 0 => nthSolution(t,n-1)
      case _ => None

    }

  }

val list = List(1,-20,1,9,2,-3)

  def main(args: Array[String]): Unit = {
    println(operar(sum,2,3.2))
    println(Mayor(list))
    println(second(list))
    println(nth(list,1))

  }
}
