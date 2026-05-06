import java.util.*

fun main(args: Array<String>) {

    var n = readLine()!!.toInt()
    for (i in 1..n) {
        val conjunto = mutableSetOf<String>()

        var ln = readLine()!!
        for (letra in ln) {
            if (letra == ' ') {continue}
            if (letra == '.') {continue}
            if (letra == ',') {continue}
            else {
            conjunto.add(letra.toString())}
        }
        if (conjunto.size == 26) {
            println("frase completa")
        } else if (conjunto.size >= 13) {
            println("frase quase completa")
        } else {
            println("frase mal elaborada")
        }
    }
}
