package newCurso


object Clase2 {

  val v = Vector(1,2,3)
  //Append and Prepend operators
  val f =     v:+1
  val c =     v.:+(5)

  val l  = List(1,2,3)

//ejercicios de operadores
  def addToList (list:List[Int], n:Int): List[Int] ={
    list.:+(n)
  }

  def isPalindrome(list:List[Int]):Boolean={

    list.equals(list.reverse)

  }

//ejercicios de tuplas

  val myTupple =(1,2,3,"hello")


  //Maps and sets

  val romanos = Map(1->"I", 2->"II", 3 ->"III", 4->"IV", 5 ->"V")

  val s = Set(1,2,3)

  def printMapinOrder(map:Map[Int , String]):Unit = {
    map.toList.sortBy(_._1).foreach(i => println(i._1 + "=>"+ i._2))
  }

  private def printMapWithoutOrder(map:Map[Int,String]) = {
    map.foreach({ case (k, v) => println(s"${k} => ${v}") })
  }


  //Options
  def applicarInteres(cant:Double, tipo:Option[Double]):Double = {

    cant + cant.*(tipo.getOrElse(0.0))./(100)

  }

  def applicarInteresMatching(cant:Option[Double], tipo:Option[Double]):Option[Double] = {
    cant match {
      case Some(a) => Option(a + a.*(tipo.getOrElse(0.0))./(100))
      case None => None
    }

  }

  //Either

  def applicarInteresEither1(cant:Option[Double], tipo:Option[Double]):Either[String,Double] = {

    cant match {
      case Some(a) => Right(a + a.*(tipo.getOrElse(0.0))./(100))
      case None => Left("Cantidad no insertada")
    }
  }

  def applicarInteresEither2(cant:Either[String,Double], tipo:Either[String,Double]):Either[String,Double] = {

    cant match {
      case Right(a) => Right(a + a.*(tipo.getOrElse(0.0))./(100))
      case Left(b) => Left(b)
    }
  }


  val option = Option("hi")
  val some = Some("hi")
  val none = None

  def main(args: Array[String]): Unit = {
    //append prepend
    println(v)
    println(f)
    println(c)

    //ejercicios operadores
    println(addToList(l,7))
    println(isPalindrome(l))
    //tuplas
    println(myTupple.getClass)
    println(myTupple._4)

    println(myTupple match {
      case(1,2,3,_) =>"ok"
      case(_,2,_,_) =>"ko"


    })

    //maps
    println(romanos.get(1))
    println(romanos(1))
    println(s.toList)
    printMapWithoutOrder(romanos)
    printMapinOrder(romanos)


    println(
      option match {

        case Some("hi") => "hi"
        case Some(a) => a
        case None => "nothing"

      }
    )
    //Options

    println(applicarInteres(2,Option(10)))
    println(applicarInteres(2,None))
    println(applicarInteresMatching(Option(1),None))
    println(applicarInteresMatching(None,None))
    println(applicarInteresMatching(Option(1),Option(2)))

    println(applicarInteresEither1(Option(1),Option(2)))
    println(applicarInteresEither1(None,Option(2)))
    println(applicarInteresEither1(Option(1),None))


    println(applicarInteresEither2(Right(1),Right(2)))
    println(applicarInteresEither2(Left("izquierda"),Right(2)))
    println(applicarInteresEither2(Right(1),Left("izquierda")))

  }



}
