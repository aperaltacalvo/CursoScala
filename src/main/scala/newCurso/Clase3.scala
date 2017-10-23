package newCurso

object Clase3 {

  //Curry and unCurry
def sum(x:Int, y :Int):Int={
  x+y
}

  def sumCurry(x:Int)(y:Int):Int={

    x+y
  }

def uncurry(f:Int => Int => Int) : (Int,Int)=>Int={
  (a,b) => f(a) (b)

}

  def curry(f:(Int,Int)=>Int):Int=>Int=>Int = {
    a => b => f(a,b)
  }

  //Composicion de funciones


  def composicion(f:Int => String , g:Int=>Int):Int => String = {
    a=>f(g(a))
  }

  def composicion2(f:Int => String , g:Int=>Int):Int => String = {
    f compose(g)
  }


  // funciones genericas

  def uncurryGen[A,B,C](f:A => B => C) : (A,B)=>C={
    (a,b) => f(a) (b)

  }

  def curryGen[A,B,C](f:(A,B)=>C):A=>B=>C = {
    a => b => f(a,b)
  }

  def composicionGen[A,B,C](f:B=> C , g:A=>B):A => C = {
    a=>f(g(a))
  }

  //

  def main(args: Array[String]): Unit = {
    val f1=curry(sum)
    val f2=uncurry(sumCurry)
    println(f1(1)(2))
    println(f2(2,1))

    //composicion
    println(composicion(a => a.toString, a=>a))

  }
}
