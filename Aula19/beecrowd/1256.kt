import java.util.*

fun main(args: Array<String>) {

   var n = readLine()!!.toInt()

    for (caso in 0 until n) {
        var linha = readLine()!!.trim().split(" ")
        var m = linha[0].toInt()
        var c = linha[1].toInt()

        var chaves = readLine()!!.trim().split(" ")

        var tabela = Array(m) { mutableListOf<Int>() }

        for (i in 0 until c) {
            var chave = chaves[i].toInt()
            var endereco = chave % m
            tabela[endereco].add(chave)
        }

        for (i in 0 until m) {
            var saida = "$i ->"
            for (v in tabela[i]) {
                saida += " $v ->"
            }
            saida += " \\"
            println(saida)
        }

        if (caso < n - 1) println()
    }

	
}
