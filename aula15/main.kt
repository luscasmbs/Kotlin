fun main() {
    println("Sistema de ordenação com busca binária \n insira valores inteiros a sua lista")
    val lista = readLine()!!.split(" ").map { it.toInt() }.sorted()
    println("Qual seu número alvo da lista?")
    val alvo = readLine()!!.toInt()
    var (resultado, comparacoes) = busca(lista, alvo)
    if (resultado != -1){
        println("O número alvo da lista foi encontrado com sucesso! Ele está na posição ${resultado} \n Você quer ver quantas comparações foram necessárias?  S |  N")
        var esc = readLine()!!.uppercase()
        if (esc == "S"){
            println("Foram necessárias $comparacoes comparações")
        }
    }
    else {
        println("O número que você inseriu não existe na lista!")
    }

}

fun busca(lista: List<Int>, alvo: Int): Pair<Int, Int> {
    var inicio = 0
    var comparacoes = 0
    var fim = lista.size - 1
    while (inicio <= fim) {
        val meio = (inicio + fim) / 2
        comparacoes++
        println("Verificando índice $meio -> valor ${lista[meio]}")
        if (lista[meio] == alvo) {
            return Pair(meio, comparacoes)
        }
        if (lista[meio] < alvo) {
            inicio = meio + 1
        } else {
            fim = meio - 1
        }
    }
    return Pair(-1, comparacoes)
}

