import java.util.*

fun main(args: Array<String>) {

        var n = readLine()!!.toInt()

        repeat(n) {
            var d = 0
            var c = 0.0
            c = readLine()!!.toDouble()

            while (c > 1) {
                c = c/2
                d++

            }
            println("$d dias")
        }

	
}
