
  object prueba {

    class Clase3 {
      def iterate(n: Int, f: Int => Int, x: Int): Integer = {
        var result = 0
        if (n==0) {
          result = x
        }else {
          result = iterate(n-1, f, f(x))
          println(x)


        }
        result
      }

      def suma(x: Int): Int = {
        x+1
      }
    }
    var clase3 = new Clase3

    def main(args: Array[String]): Unit = {
      clase3.iterate(10,clase3.suma,5)

    }

  }

