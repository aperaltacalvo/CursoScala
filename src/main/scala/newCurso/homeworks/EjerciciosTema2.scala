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

  def penultimateSolution(list:List[Int]):Option[Int] = {
    list match {
      case h::Nil => None
      case h::t => Some(t.head)
      case _ => None
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

  def duplicateSolution(list:List[Int],k:Int):List[Int]={
    list.flatMap(e=>List.fill(k)(e))
  }

  def duplicateSolution2(list:List[Int],k:Int):List[Int]={
    list.flatMap(x => (1 to k).map(_=>x))
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

  def rotateSolution(list:List[Int], x: Int):List[Int]={

    list match {
      case Nil => list
      case h::Nil => list
      case h::t if x==0 => list
      case h::t if x>0 => rotateSolution(t:+h, x-1)
      case h::t if x<0 => rotateSolution(t.reverse.head::h::t.reverse.tail.reverse, x+1)

    }
  }

  //Ejercicio4

  def isPalindrome(list:List[Int]):Boolean={

    list.equals(list.reverse)

  }

  def isPalindromeString(list:String):Boolean={
    list.toUpperCase.reverse == list.toUpperCase
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
