import java.util.*

fun main(args: Array<String>) {

    var t = readLine()!!.toInt()

    while (t > 0) {
        var linha = readLine()!!.trim().split(" ")
        var c = linha[0].toInt()
        var d = linha[1].toInt()

        if (c == 0 && d == 0) {
            println(0)
        } else {
            var resultado = Math.pow(26.0, c.toDouble()).toLong() * Math.pow(10.0, d.toDouble()).toLong()
            println(resultado)
        }

        t--
    }

}