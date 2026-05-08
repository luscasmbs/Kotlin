import java.util.*

fun main(args: Array<String>) {
    while (true) {
        val n = readLine()!!.toInt()
        if (n == 0) break

        val C = readLine()!!
        var s = 0

        for (d in C) {
            if (d == 'D') {
                s++
                if (s > 3) s = 0
            } else if (d == 'E') {
                s--
                if (s < 0) s = 3
            }
        }

        if (s == 0) println("N")
        else if (s == 1) println("L")
        else if (s == 2) println("S")
        else if (s == 3) println("O")
    }
}
