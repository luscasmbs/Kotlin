import java.util.*

fun main(args: Array<String>) {

    var p = 0
    var s = 1
    val n = readLine()!!.toInt()
    var r = mutableListOf<Int>()

    for (i in 1..n) {
        r.add(p)
        val proximo = p + s
        p = s
        s = proximo
    }
    println(r.joinToString(" "))
	
}
