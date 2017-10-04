object Clase4 {

  var hostias = List(6,4,3,5,3,2)

  var pollas = List("elefante","mierdaputa","mermado","culo")


  def main(args: Array[String]): Unit = {
    var h = hostias.map(z => z+2)
    var o = pollas.map(z=>z.toUpperCase())

    for(i <-0 to h.length-1)
      println(h.apply(i))

    for(i <-0 to o.length-1)
      println(o.apply(i))
  }
}
