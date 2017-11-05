package newCurso.homeworks

import scala.annotation.tailrec


object EjericiosTema3 {
  //f(n) = f(n-1) + f(n-2)
  def fib(x:Int):BigInt = {
    def go(x:Int):BigInt = x match {
      case (0) =>0
      case (1) => 1
      case _ => go(x-2)+go(x-1)
    }
  go(x)
  }

  def fibRec(x:Int):BigInt = {
    @tailrec def go(x: Int, prev: BigInt = 0, next: BigInt = 1): BigInt = x match {
      case 0 => prev
      case 1 => next
      case _ => go(x - 1, next, (next + prev))
    }
    go(x)
  }

  def mSort[T](less:(T,T)=>Boolean, l:List[T]) :List[T] = {
      val m = l.length / 2
      if (m == 0) l
      else {
        @tailrec
        def merge(ls: List[T], rs: List[T], acc: List[T] = List()): List[T] = (ls, rs) match {
          case (Nil, _) => acc ++ rs
          case (_, Nil) => acc ++ ls
          case (l :: ls1, r :: rs1) =>
            if (less(l, r)) merge(ls1, rs, acc :+ l)
            else merge(ls, rs1, acc :+ r)
        }
        val (a, b) = l splitAt m
        merge(mSort(less,a), mSort(less,b))
      }
    }
  def less(x: Int, y: Int) = x < y

  def isSort[T](less:(T,T)=>Boolean, l:List[T]):Boolean= {
    val m = l.length / 2
    if (m == 0) true
    else {
      @tailrec
      def merge(ls: List[T], rs: List[T], acc: List[T] = List()): Boolean = (ls, rs) match {
        case (Nil, _) => true
        case (_, Nil) => false
        case (l :: ls1, r :: rs1) =>
          if (less(l, r)) merge(ls1, rs, acc :+ l)
          else merge(ls, rs1, acc :+ r)
      }
      val (a, b) = l splitAt m
      merge(mSort(less,a), mSort(less,b))
    }
  }

  def main(args: Array[String]): Unit = {
    println(fibRec(5))
    var l : List[Int] = List(5,8,1,0,-3)
    var l2 : List[Int] = List(1,2,3,4,5)
    println(isSort(less,mSort(less,l)))
    println(isSort(less,l2))
    println(isSort(less,l))


  }
}
