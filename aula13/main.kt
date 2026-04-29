
fun main() {
    println("Olá, bem vindo ao nosso sistema, escolha quantos produtos serão cadastrados")
    val n = readln().toInt()
    val ids = mutableListOf<Int>()
    val nomes = mutableListOf<String>()
    val qtd = mutableListOf<Int>()
    println("Cadastre cada produto seguindo o modelo: ID | Nome | Quantidade")
    repeat(n) {
        val entrada = readln().split(" ")
        ids.add(entrada[0].toInt())
        nomes.add(entrada[1])
        qtd.add(entrada[2].toInt())
    }
    var trocas = 0

    for (i in 0 until ids.size - 1) {
        for (j in 0 until ids.size - 1 - i) {
            println("Comparando ID ${ids[j]} com ${ids[j + 1]}")
            if (ids[j] > ids[j + 1]) {
                println("Trocando posições $j e ${j + 1}")

                var tempId = ids[j]
                ids[j] = ids[j + 1]
                ids[j + 1] = tempId
                trocas++

                var tempNome = nomes[j]
                nomes[j] = nomes[j + 1]
                nomes[j + 1] = tempNome

                var tempQtd = qtd[j]
                qtd[j] = qtd[j + 1]
                qtd[j + 1] = tempQtd
            }
        }
    }

    println("\nProdutos ordenados:")
    for (i in ids.indices) {
        println("${ids[i]} ${nomes[i]} ${qtd[i]}")
    }
    println("Trocas: $trocas")
}
