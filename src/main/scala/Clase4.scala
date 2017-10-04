import sun.plugin.javascript.navig.JSObject

object Clase4 {

  var hostias = List(6, 4, 3, 5, 3, 2)

  var pollas = List("elefante", "mierdaputa", "mermado", "culo")


  var carrito = List(List("articulo1", "articulo2"), List("brticulo1", "brticulo2"))

  var json: String =
    """{
      "hola" = "hola",
      "hola2" = {"q"="q",
                 "j"="j"}
      }""".stripMargin

  def main(args: Array[String]): Unit = {
    var h = hostias.map(z => z + 2)
    var o = pollas.map(z => z.toUpperCase())
    var osohormiguero = pollas.flatMap(z => z.substring(0))
    var carr = carrito.flatMap(z => z.map(y => y.toUpperCase()))
    var otro = json.flatMap(z => z.toString)

    for (i <- 0 to h.length - 1)
      println(h.apply(i))

    for (i <- 0 to o.length - 1)
      println(o.apply(i))

    for (i <- 0 to osohormiguero.length - 1)
      println(osohormiguero.apply(i))


    for (i <- 0 to carr.length - 1)
      println(carr.apply(i))


    for (i <- 0 to otro.length - 1)
      println(otro.apply(i))
  }

}