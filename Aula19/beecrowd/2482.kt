import java.util.*

fun main(args: Array<String>) {

    var n = readLine()!!.toInt()

    var traducoes = mutableMapOf<String, String>()

    for (i in 0 until n) {
        var lingua = readLine()!!.trim()
        var traducao = readLine()!!.trim()
        traducoes[lingua] = traducao
    }

    var m = readLine()!!.toInt()

    for (i in 0 until m) {
        var nome = readLine()!!.trim()
        var lingua = readLine()!!.trim()
        println(nome)
        println(traducoes[lingua])
        println()
    }

}
