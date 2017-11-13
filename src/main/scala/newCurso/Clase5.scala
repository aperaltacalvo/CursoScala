package newCurso

import scala.annotation.tailrec

class Clase5 {
  def mSort[T]( l:List[T]) (implicit less:(T,T)=>Boolean):List[T] = {
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
      merge(mSort(a), mSort(b))
    }
  }

  //covarancia

 // A subtype B => Lista[A] subtype Lista[B] varianza
 // A subtype B => Lista[B] subtype Lista [A] covarianza

  object main5 {
    def main(args: Array[String]): Unit = {
     val l= List(1,2,3,4,5)
     // println(mSort(l))
    }
  }

  sealed trait Lista[+A]
  case object Vacio extends Lista[Nothing]
  case class Cons[+A](head:A, tail:Lista[A]) extends Lista[A]


  object Lista {


    def apply[A](as: A*): Lista[A] =
      if (as.isEmpty) Vacio
      else Cons(as.head, apply(as.tail: _*))

    def sum(ints: Lista[Int]): Int = {
      ints match {
        case Vacio => 0
        case Cons(h,t) => sum(t) + h
      }
    }

    def product(ints: Lista[Double]) : Double = {
      ints match {
        case Vacio => 1
        case Cons(h,t) => product(t) * h
      }

    }

    def tail[A](list: Lista[A]): Lista[A] = {
      list match {
        case Vacio => Vacio
        case Cons(h, t) => t
      }
    }

    def setHead[A](list: Lista[A], newHead: A): Lista[A] = {
      list match {
        case Vacio => Cons(newHead, Vacio)
        case Cons(h, t) => Cons(newHead, t)
      }
    }

    def drop[A](list: Lista[A],n: Int): Lista[A] = {
      @tailrec
      def go(list: Lista[A], n: Int): Lista[A] = {
        list match {
          case Vacio => Vacio
          case Cons(h, Vacio) => Vacio
          case Cons(h, t) =>
            if (n == 0) Cons(h, t)
            else if (n == 1) t
            else if (n<0) Cons(h,t)
            else go(t, n - 1)
        }

      }
      go(list,n)
    }

    def dropWhile[A](list: Lista[A], f: A => Boolean): Lista[A] = {

      @tailrec
      def go(list: Lista[A]): Lista[A] = {
        list match {
          case Vacio => Vacio
          case Cons(h, Vacio) => Vacio
          case Cons(h, t) if (f(h)) => go(t)
          case Cons(h,t) if (!f(h)) => list
        }

      }
      go(list)

    }

    def dropWhile2[A](list: Lista[A], f: A => Boolean): Lista[A] = {

      @tailrec
      def go(list: Lista[A]): Lista[A] = {
        list match {
          case Vacio => Vacio
          case Cons(_, Vacio) => Vacio
          case Cons(h, t) if (f(h)) => go(t)
          case Cons(h,_) if (!f(h)) => list
        }

      }
      go(list)

    }


    def append[A](l1: Lista[A], l2: Lista[A]): Lista[A] = {

      l1 match {
        case Vacio => l2
        case Cons(h, t) => Cons(h, append(t, l2))
      }
    }


    def init[A](l: Lista[A]): Lista[A] = {
      @annotation.tailrec
      def loop(acc: Lista[A], rest: Lista[A]): Lista[A] = {

        rest match {
          case Vacio => Vacio
          case Cons(h,Vacio) => acc
          case Cons(h, t) => loop(append(acc, Lista(h)), t)

        }
      }

      loop(Lista(), l)
    }

  }

}
