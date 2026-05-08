import java.util.*

fun main(args: Array<String>) {
    while (true) {
        val n = readLine()!!.trim().toInt()
        if (n == 0) break

        val alunos = mutableMapOf<String, String>()

        repeat(n) {
            val entrada = readLine()!!.split(" ")
            val nome = entrada[0]
            val assinatura = entrada[1]

            alunos[nome] = assinatura
        }

        val m = readLine()!!.trim().toInt()
        var falsas = 0

        repeat(m) {
            val entrada = readLine()!!.split(" ")
            val nome = entrada[0]
            val assinaturaAula = entrada[1]

            val assinaturaOriginal = alunos[nome]!!

            var diferencas = 0

            for (i in assinaturaOriginal.indices) {
                if (assinaturaOriginal[i] != assinaturaAula[i]) {
                    diferencas++
                }
            }

            if (diferencas > 1) {
                falsas++
            }
        }

        println(falsas)
    }
}
