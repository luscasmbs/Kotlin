import java.util.*

fun main(args: Array<String>) {
    val linha = readLine()!!
    val vogais = listOf('a', 'e', 'i', 'o', 'u')

    val filtrado = linha.filter { it in vogais }

    if (filtrado == filtrado.reversed()) {
        println("S")
    } else {
        println("N")
    }

}
