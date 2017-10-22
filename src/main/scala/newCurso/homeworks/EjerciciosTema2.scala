package newCurso.homeworks

import scala.collection.mutable.ListBuffer

object EjerciciosTema2 {

 //Ejercicio1
  def penultimate(list:List[Any]):Option[Int]={

     list(list.size - 2) match {

       case a:Int => Some(a)
       case _=> None
     }
  }

  //Ejercicio2

  def duplicate(list:List[Int],n:Int):List[Int]={
     var aux : List[Int]=List()

    for(i<-list.indices){
      for(e<-0 to n){
       aux= aux:+list(i)
      }
    }
    aux
  }

  //Ejercicio3

  private def adjustRotate(pos: Int, len: Int): Int = {
    if (len == 0) 0 else ((pos % len) + len) % len
  }

  def rotate[A](n: Int, ls: List[A]): List[A] = {
    val tail = ListBuffer[A]()
    var cur = ls
    for (i <- 1 to adjustRotate(n, ls.length)) {
      tail += cur.head
      cur = cur.tail
    }
    cur ++=: tail toList
  }

  //Ejercicio4

  def isPalindrome(list:List[Int]):Boolean={

    list.equals(list.reverse)

  }
val list = List(1,2,3,2,1)
  val list2 = List(1,2,3,"example",1)
val list3 = List(1,2,3,4,5)
  def main(args: Array[String]): Unit = {
    println(isPalindrome(list))
    println(penultimate(list))
    println(penultimate(list2))
    println(duplicate(list,10))
    println(rotate(1,list3))
    println(rotate(-1,list3))

  }
}
