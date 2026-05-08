import java.util.*

fun main(args: Array<String>) {

    val fib = LongArray(61)

    fib[0] = 0
    fib[1] = 1

    for (i in 2..60) {
        fib[i] = fib[i - 1] + fib[i - 2]
    }

    val t = readLine()!!.toInt()

    repeat(t) {
        val n = readLine()!!.toInt()
        println("Fib($n) = ${fib[n]}")
    }

	
}
