
  object stringTest{

  val word = "word"

    def longitud(palabra:String):Int = {
        palabra.length
    }

    def letra(index:Int, palabra:String): Char ={
      palabra.charAt(index)
    }

    def main(args: Array[String]): Unit = {
      println(longitud(word))
      println(letra(0,word))
    }
}

