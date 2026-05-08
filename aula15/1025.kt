import java.util.*

fun main(args: Array<String>) {

    var caso = 1

    while (true) {
        val entrada = readLine()!!.split(" ")
        val n = entrada[0].toInt()
        val q = entrada[1].toInt()

        if (n == 0 && q == 0) {
            break
        }

        val marmores = mutableListOf<Int>()

        repeat(n) {
            val numero = readLine()!!.toInt()
            marmores.add(numero)
        }

        marmores.sort()

        println("CASE# $caso:")

        repeat(q) {
            val consulta = readLine()!!.toInt()
            val posicao = marmores.indexOf(consulta)

            if (posicao == -1) {
                println("$consulta not found")
            } else {
                println("$consulta found at ${posicao + 1}")
            }
        }

        caso++
    }
	
}
