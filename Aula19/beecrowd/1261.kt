import java.util.*

fun main(args: Array<String>) {

    var linha = readLine()
    while (linha != null) {
        var partes = linha.trim().split(" ")
        var m = partes[0].toInt()
        var n = partes[1].toInt()

        var dicionario = mutableMapOf<String, Int>()

        for (i in 0 until m) {
            var l = readLine()!!.trim().split(" ")
            var palavra = l[0]
            var valor = l[1].toInt()
            dicionario[palavra] = valor
        }

        for (i in 0 until n) {
            var salario = 0
            while (true) {
                var descricao = readLine()!!.trim()
                if (descricao == ".") break
                var palavras = descricao.split(" ")
                for (p in palavras) {
                    if (dicionario.containsKey(p)) {
                        salario += dicionario[p]!!
                    }
                }
            }
            println(salario)
        }

        linha = readLine()
    }

}
