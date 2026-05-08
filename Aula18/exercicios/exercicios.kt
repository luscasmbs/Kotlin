var chamadas = 0

fun fibonacciIterativo(n: Int): Int {
    var a = 0
    var b = 1
    for (i in 2..n) {
        val temp = a + b
        a = b
        b = temp
    }
    return if (n == 0) 0 else b
}

fun fibonacci(n: Int): Int {
    chamadas++

    if (n <= 1) {
        return n
    }

    return fibonacci(n - 1) + fibonacci(n - 2)
}

fun main() {
    var chamadas = 0

    println("Insira um valor para n:")
    var n = readLine()!!.toInt()
    println("Fibonacci de $n:")
    println("Recursivo: ${fibonacci(n)}")
    println("Iterativo: ${fibonacciIterativo(n)}")
    println("Houve $chamadas chamadas na função fibonacci")
}
