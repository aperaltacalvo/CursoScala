import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader

import scala.annotation.tailrec

object Factorial {

  def fact( value : Int  ):Int ={
     if ( value == 0 ) {
       1

     } else {
       value * fact( value -1 )

     }

   }


  def factB( value : Int ):Int = {
    @tailrec
    def factB_(cont: Int, value:Int): Int = {

      if (cont == 0) {
        value

      } else {
        factB_(cont - 1, (value * (cont)))

      }

    }

    factB_( value-1, value)

  }



  def main(args: Array[String]): Unit = {
    println(factB(10))
      println(fact(10))

  }
}
