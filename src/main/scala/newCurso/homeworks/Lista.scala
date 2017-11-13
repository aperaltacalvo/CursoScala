package newCurso.homeworks

import scala.annotation.tailrec

/**
  * Created by scouto.
  */
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
      case Cons(h,t) => h + sum(t)
    }
  }

  def product(ints: Lista[Double]) : Double = {
    ints match {
      case Vacio => 1.0
      case Cons(h,t) => h * product(t)
    }
  }

  def tail[A](list: Lista[A]): Lista[A] = {
    list match {
      case Vacio => Vacio
      case Cons(_,t) => t
    }
  }

  def setHead[A](list: Lista[A], newHead: A): Lista[A] = {
    list match  {
      case Vacio => Lista(newHead)
      case Cons(h,t) => Cons(newHead, t)
    }

  }

  def drop[A](list: Lista[A],n: Int): Lista[A] = {

    @tailrec
    def go (rest: Lista[A], x: Int) : Lista[A] = {
      (rest, x) match {
        case (Vacio, _) => Vacio
        case (_, current) if current <= 0 => rest
        case (Cons(_,t), current) if current > 0 =>  go(t, x-1)
      }
    }

    go (list, n)

  }

  def dropWhile[A](list: Lista[A])(f: A => Boolean): Lista[A] = {

    @tailrec
    def go (rest: Lista[A]) : Lista[A] = {
      rest match {
        case Vacio => Vacio
        case Cons(h,t) if f(h) => go(t)
        case Cons(h,_) if !f(h) => rest
      }
    }

    go (list)
  }

  def append[A](l1: Lista[A], l2: Lista[A]): Lista[A] = {

    l1 match {
      case Vacio => l2
      case Cons(h,t) => Cons (h, append(t, l2))
    }
  }

  def init[A](l: Lista[A]): Lista[A] = {

    @tailrec
    def loop(acc: Lista[A], rest: Lista[A]): Lista[A] = {
//
      rest match {
        case Vacio => acc
        case Cons(_, Vacio) => acc
        case Cons(h, t) => loop(append(acc, Lista(h)), t)
      }


//
//      rest match {
//        case Vacio => acc
//        case Cons(h1, t) => t match {
//          case Vacio => acc
//          case _ => loop(append(acc, Lista(h1)), t)
//        }
//      }
    }
    loop(Lista(), l)
  }

  // -------------------- Sesion 6 --------------------

  def foldRight[A,B](as: Lista[A], z: B) (f: (A, B) => B) : B = {

    as match {
      case Vacio => z
      case Cons (h, t) => f(h, foldRight(t, z)(f))
    }
  }

  def sumFold(ints: Lista[Int]): Int = {
    foldRight(ints, 0)(_ +_ )
  }

  def productFold(ints: Lista[Double]) : Double = {
    foldRight(ints, 1.0)(_ *_ )

  }

  def length[A](as: Lista[A]): Int = {
    foldRight(as, 0)((_, acc) => acc + 1)
  }

  @tailrec
  def foldLeft[A,B](as: Lista[A], z: B) (f: (B, A) => B) : B = {
    as match {
      case Vacio => z
      case Cons(h,t) => foldLeft(t, f(z, h))(f)
    }
  }

  def sumFoldLeft(ints: Lista[Int]): Int = {
    foldLeft(ints, 0)(_ +_)
  }

  def productFoldLeft(ints: Lista[Double]) : Double = {
    foldLeft(ints, 1.0)(_ * _)
  }

  def lengthFoldLeft[A](as: Lista[A]): Int = {
    foldLeft(as, 0)((acc, _) => acc +1)
  }

  def reverse[A](as: Lista[A]): Lista [A] = {
    foldLeft(as, Lista[A]())((acc, elem) =>  Cons (elem, acc))
//    foldLeft(as, Lista[A]())((acc, elem) =>  append (Lista(elem), acc))
//    foldRight(as, Vacio: Lista[A])((elem, acc) => append(acc, Lista(elem)))
  }

  def foldRightbyLeft[A,B](as: Lista[A], z: B) (f: (A, B) => B) : B = {
    foldLeft(as, z)((acc,elem) => f(elem, acc))
  }

  def foldLeftbyRight[A,B](as: Lista[A], z: B) (f: (B, A) => B) : B = {
    foldRight(as, z)((elem, acc) => f(acc, elem))
  }

  def sumFoldRightLeft(ints: Lista[Int]) : Int = {
    foldRightbyLeft(ints, 0)(_ +_ )
  }

  def sumFoldLeftRight(ints: Lista[Int]) : Int = {
    foldLeftbyRight(ints, 0)(_ +_ )
  }

  def productFoldRightLeft(ints: Lista[Double]) : Double = {
    foldRightbyLeft(ints, 1.0)(_ *_ )
  }

  def productFoldLeftRight(ints: Lista[Double]) : Double = {
    foldLeftbyRight(ints, 1.0)(_ *_ )
  }

  def lengthLeftRight[A](as: Lista[A]): Int = {
    foldLeftbyRight(as, 0)((acc, _) => acc +1)
  }

  def lengthRightLeft[A](as: Lista[A]): Int = {
    foldRightbyLeft(as, 0)((_, acc) => acc +1)
  }

  def appendFoldRight[A](a1: Lista[A], a2: Lista[A]): Lista[A] = {
    foldRight(a1, a2)((elem, acc) => Cons(elem, acc))
  }

  def appendLists[A](as: Lista[Lista[A]]): Lista[A] = {
//    foldRight(as, Vacio: Lista[A])((elem, acc) => appendFoldRight(elem, acc))
//    foldRight(as, Vacio: Lista[A])(appendFoldRight(_, _))
    foldRight(as, Vacio: Lista[A])(appendFoldRight)
  }


  // -------------------- Sesion 7 --------------------

  def addOne(l: Lista[Int]): Lista[Int] = {

    foldRight(l,Vacio:Lista[Int])((a,b) => Cons(a+1,b))
  }

  def doubleToString(l: Lista[Double]): Lista[String] = {
    foldRight(l,Vacio:Lista[String])((a,b) => Cons(a.toString,b))

  }

  def map[A, B](l: Lista[A])(f: A => B): Lista[B] = {
    foldRight(l,Vacio:Lista[B])((a,b)=>Cons(f(a),b))
  }

  def filter[A](l: Lista[A])(f: A => Boolean): Lista[A] = {
    foldRight(l,Vacio:Lista[A])((a,b) =>
      if(f(a)){
      Cons(a,b)
      }else{
      b
      })
  }

  def flatMap[A, B](l: Lista[A])(f: A => Lista[B]): Lista[B] = {
    appendLists(map(l)(f))
  }

  def filterFlatMap[A](l: Lista[A])(f: A => Boolean): Lista[A] = {
    flatMap(l)((a)=>
      if(f(a)){
        Lista(a)
      }
      else{
      Vacio
    })
  }

  def addLists(l1: Lista[Int], l2: Lista[Int]): Lista[Int] = {
    @tailrec
    def go(_l1:Lista[Int],_l2:Lista[Int], l3:Lista[Int]):Lista[Int] = {
    (_l1,_l2) match {
      case (Vacio, Vacio) => l3
      case (Vacio, _) => Vacio
      case (_, Vacio) => Vacio
      case (Cons(h, t), Cons(h1, t1)) => go(t,t1,append(l3,Lista(h1 + h)))
    }
    }
    go(l1,l2,Vacio)
  }

  def zipWith[A,B,C](l1: Lista[A], l2: Lista[B])(f:(A,B) => C): Lista[C] = {

      @tailrec
      def go(_l1:Lista[A],_l2:Lista[B], l3:Lista[C]):Lista[C] = {
        (_l1,_l2) match {
          case (Vacio, Vacio) => l3
          case (Vacio, _) => Vacio
          case (_, Vacio) => Vacio
          case (Cons(h, t), Cons(h1, t1)) => go(t,t1,append(l3,Lista(f(h,h1))))
        }
      }
      go(l1,l2,Vacio)
    }

  def empiezaPor[A](lista: Lista[A], sub: Lista[A]): Boolean = {
    @tailrec
    def go(_lista: Lista[A], _sub: Lista[A]): Boolean = {
      (_lista, _sub) match {
        case (Vacio, Vacio) => true
        case (Vacio, Cons(_, _)) => false
        case (Cons(_, _), Vacio) => true
     //   case (Cons(h, t), Cons(h1, Vacio)) => if (h == h1) go(t, Vacio) else false
        case (Cons(h, t), Cons(h1, t1)) => if (h == h1) go(t, t1) else false
      }
    }
    go(lista,sub)
  }


  def tieneSubsecuencia[A](lista: Lista[A], sub: Lista[A]): Boolean = {

    @tailrec
    def go(_lista: Lista[A], _sub: Lista[A]): Boolean = {
      (_lista, _sub) match {
        case (Vacio, Vacio) => true
        case (Vacio, Cons(_, _)) => false
        case (Cons(_, _), Vacio) => true
       // case (Cons(h, t), Cons(h1, Vacio)) => if (h == h1) go(t, Vacio) else go(t, Cons(h1,Vacio))
        case (Cons(h, t), Cons(h1, t1)) => if (h == h1) go(t, t1) else go(t, Cons(h1,t1))
      }
    }

    go(lista, sub)
  }

}



