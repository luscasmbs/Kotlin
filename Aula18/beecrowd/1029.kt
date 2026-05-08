import java.util.*

fun main(args: Array<String>) {
    val fib = LongArray(61)
    val cham = LongArray(61)

    cham[0] = 0
    cham[1] = 0
    fib[0] = 0
    fib[1] = 1


    for (i in 2..60) {
        fib[i] = fib[i - 1] + fib[i - 2]
        cham[i] = cham[i - 1] + cham[i - 2] + 2

    }

    val t = readLine()!!.toInt()

    repeat(t) {
        val n = readLine()!!.toInt()
        println("fib($n) = ${cham[n]} calls = ${fib[n]}")
    }
	
}
