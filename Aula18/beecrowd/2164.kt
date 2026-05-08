import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {

    var n = readLine()!!.toInt()
    var fib = ((((1+ sqrt(5.0)) / 2.0).pow(n))-(((1- sqrt(5.0)) / 2.0).pow(n)))/sqrt(5.0)
    println("%.1f".format(fib))

}
