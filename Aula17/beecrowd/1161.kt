import java.util.*

fun main(args: Array<String>) {

    while (true) {
        var n = readLine()?.split(" ")
        if (n == null ) break
        var n1 = n[0].toInt()
        var n2 = n[1].toInt()


        var fat1 = 1L
        for (i in 2..n1) {
            fat1 *= i
        }

        var fat2 = 1L
        for (i in 2..n2) {
            fat2 *= i
        }

        println(fat1 + fat2)

    }


	
}
