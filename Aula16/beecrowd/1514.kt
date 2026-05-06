import java.util.*

fun main(args: Array<String>) {


    while (true) {
        var linha = readLine()!!.trim().split(" ")
        var n = linha[0].toInt()
        var m = linha[1].toInt()

        if (n == 0 && m == 0) break

        var matriz = Array(n) { IntArray(m) }

        for (i in 0 until n) {
            var tec = readLine()!!.trim().split(" ")
            for (j in 0 until m) {
                matriz[i][j] = tec[j].toInt()
            }
        }

        var carac = 0

        var algumResolveuTudo = false
        for (i in 0 until n) {
            if (matriz[i].sum() == m) algumResolveuTudo = true
        }
        if (!algumResolveuTudo) carac++

        var todoProblemaResolvido = true
        for (j in 0 until m) {
            var soma = 0
            for (i in 0 until n) soma += matriz[i][j]
            if (soma == 0) todoProblemaResolvido = false
        }
        if (todoProblemaResolvido) carac++

        var algumProblemaPorTodos = false
        for (j in 0 until m) {
            var soma = 0
            for (i in 0 until n) soma += matriz[i][j]
            if (soma == n) algumProblemaPorTodos = true
        }
        if (!algumProblemaPorTodos) carac++

        var todosResolveramUm = true
        for (i in 0 until n) {
            if (matriz[i].sum() == 0) todosResolveramUm = false
        }
        if (todosResolveramUm) carac++

        println(carac)
    }
	
}