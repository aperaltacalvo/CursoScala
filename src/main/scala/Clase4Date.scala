import java.text.SimpleDateFormat
import java.util.Calendar

import scala.concurrent.duration.Duration

object Clase4Date {

  val now = Calendar.getInstance()
  val currentHour = now.get(Calendar.HOUR)
  val currentMinute = now.get(Calendar.MINUTE)
  val fechaActual = Duration.fromNanos(999999999999999L).toMinutes
  val hourFormat = new SimpleDateFormat("hh")
  def convertToHours(seconds:Int):Int =
    seconds/60

  def main(args: Array[String]): Unit = {
    println(currentHour+":"+currentMinute)
    println(convertToHours(90))
    println(fechaActual)

    println(now.getTime)

    println(hourFormat.format(now.getTime))

  }


}
