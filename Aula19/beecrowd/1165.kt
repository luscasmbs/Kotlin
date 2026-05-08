import java.util.*

fun main(args: Array<String>) {
    var n = readLine()!!.toInt()
    var numeros = mutableListOf<Int>()
    for (i in 1 .. n){
     var num = readLine()!!.toInt()
        if (num.primo() == true){
        println("$num eh primo")
            } else {
            println("$num nao eh primo")
            }
    }

    }
fun Int.primo(): Boolean {
    if (this < 2) return false
    return (2..Math.sqrt(this.toDouble()).toInt()).none { this % it == 0 }
}
