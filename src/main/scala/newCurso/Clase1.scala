package newCurso

import scala.annotation.tailrec

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

  def operar (f:(Int,Int)=>Int, x:Int, y:Int):Int = {
    f(x,y)
  }

  val l  = List(1,2,3)
  val l1 = List(1,2,3)

  val l2 = List(l,l1)

  def factB( value : Int ):Int = {
    @tailrec
    def factB_(cont: Int, value:Int): Int = {

      if (cont == 0) {
        value

      } else {
        factB_(cont - 1, (value * (cont)))

      }

    }

    factB_( value-1, value)

  }




  def main(args: Array[String]): Unit = {
    println(sum(2,2))
    println(rest(2,2))
    println(div(2,2))
    println(mult(2,2))
    println(operar(sum,1,2))

    println(l.map(x => x+1))
    println(l.foreach(x => x+1))
    println(l2.flatMap(x => x))

    println(l:::l1)
    println(1::l1)
    //Pattern Matching

   println( l1 match{
      case x :: i :: j :: z => x+i+j
      case _ => 5

    })
  }



}