package newCurso.homeworks
import org.scalatest.{FlatSpec, Matchers}

class EjerciciosTema3Test extends FlatSpec with Matchers{
  "fibonacci(5)" should "return 5" in {
    EjericiosTema3.fibRec(5) shouldBe(5)
  }

}
