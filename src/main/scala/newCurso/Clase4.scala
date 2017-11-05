package newCurso

import scala.annotation.tailrec

case class Persona2(val nombre:String, val apellidos:String, val edad:Int)
  object prueba {

    object Persona {
      def apply(nombre: String, apellidos: String, edad: Int): Persona = new Persona(nombre, apellidos, edad)


      def unapply(arg: Persona): Option[(String, String, Int)] = Some(arg.nombre, arg.apellidos, arg.edad)
    }
    val p:Persona = Persona("Alvaro","Peralta",28)
    val p2:Persona2 = Persona2("Alvaro","Peralta",28)


   /* def removeFilterElement[A1](list:List[Int],f:Int => Boolean):List[Int]={

      @tailrec
      def go(acc:List[A1], rest: List[A1] ) :List[A1] = {
          acc match {

          }
      }
      }
*/


val lista = List(1,2,3,3,4)

    def main(args: Array[String]): Unit = {
      println(p.toString)

      p match {
        case Persona("Alvaro","Peralta",28) => println("Yeah")
        case _ => println("No encontrado")
      }

      p2 match {
        case Persona2("Alvaro","Peralta",28) => println("Yeah")
        case _ => println("No encontrado")
      }

     // println(removeFilterElement(lista,i => i.isInstanceOf[Int]))

    }
  }

