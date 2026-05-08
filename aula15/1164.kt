import java.util.*

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    repeat(n) {
        val x = readLine()!!.toInt()
        var soma = 0

        for (i in 1 until x) {
            if (x % i == 0) {
                soma += i
            }
        }

        if (soma == x) {
            println("$x eh perfeito")
        } else {
            println("$x nao eh perfeito")
        }
    }
}
