


  object fruta {
    val arrayFrutas : Array[String] = Array("banana", "naranja", "pera")

    def main(args: Array[String]): Unit = {
      for(i<-0 to 2)
        println(arrayFrutas.apply(i))

    }

  }

