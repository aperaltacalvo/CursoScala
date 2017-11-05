package newCurso


class Alumno(var _nombre:String, var _apellido:String){

  var nombre = _nombre
  var apellido = _apellido

}
class Asignatura(var _nombre:String, var _limiteAlumnos:Int = 30, var _descripcion:Option[String]){
    var nombre = _nombre;
    var limiteAlumnos = _limiteAlumnos
    var descripcion = _descripcion match {
      case _ => None
      case a => Some(a)
    }
}

class Administracion(val relacion: Map[Asignatura,List[Alumno]] =Map()){

  /**
    * Debe dar de alta un alumno si no supera el máximo y el alumno no está ya presente
    * @param alumno
    * @param asignatura
    * @return
    */
    def alta(alumno: Alumno,asignatura:Asignatura): Option[Administracion]={

        relacion.getOrElse(asignatura,List()) match {
          case Nil => Some(new Administracion(relacion + (asignatura -> List(alumno))))
          case l if l.contains(alumno) => None
          case l if l.size<=asignatura.limiteAlumnos && !l.contains(alumno) => Some(new Administracion(relacion + (asignatura ->(alumno::l))))
          case _ => None
        }


    }
  /**
    * Debe dar de baja un alumno o levantar un error si no es posible
    * @param alumno
    * @param asignatura
    * @return
    */
  def baja(alumno: Alumno, asignatura: Asignatura): Either[String, Administracion] = {

  relacion.getOrElse(asignatura,List()) match {
    case _ => Left("Error")
    case l if !l.contains(alumno) => Left("Alumno no encontrado")
    case l if l.contains(alumno) => Right(new Administracion(relacion + (asignatura ->l.filter(a=>a == alumno))))

  }
  }
}

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
