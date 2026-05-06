import java.util.*

fun main(args: Array<String>) {
var harby = ""
    var maiorTamanho = 0
    var menorOrdem = Int.MAX_VALUE

    val listaYes = mutableSetOf<String>()
    val listaNo = mutableSetOf<String>()
    val ordem = mutableMapOf<String, Int>()
    var contador = 0

    while (true) {
        val linha = readLine()!!
        if (linha == "FIM") break

        val (nome, opcao) = linha.split(" ")

        if (!ordem.containsKey(nome)) {
            ordem[nome] = contador++
        }

        if (opcao == "YES") {
            listaYes.add(nome)
        } else {
            listaNo.add(nome)
        }
    }

    for (nome in listaYes) {
        val ord = ordem[nome]!!
        if (nome.length > maiorTamanho ||
            (nome.length == maiorTamanho && ord < menorOrdem)) {
            maiorTamanho = nome.length
            menorOrdem = ord
            harby = nome
        }
    }

    for (nome in listaYes.sorted()) println(nome)
    for (nome in listaNo.sorted()) println(nome)

    println()
    println("Amigo do Habay:")
    println(harby)
    
}
