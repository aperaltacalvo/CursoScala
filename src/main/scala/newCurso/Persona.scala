package newCurso

class Persona(val nombre:String, val apellidos:String, val edad:Int){

  override def toString: String = (s"Persona: $nombre $apellidos $edad")

}

