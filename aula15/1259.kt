import java.util.*

fun main(args: Array<String>) {

    var num = 0
var listageral = mutableListOf<Int>()
    var n = readLine()!!.toInt()
    for (i in 1..n) {
        num = readLine()!!.toInt()
        listageral.add(num)

    }
    var (par, impar) = listageral.partition { it % 2 == 0}

    var par2 = par.sorted()
    var impar2 = impar.sortedDescending()
    for (i in par2){
        println(i)
    }
    for (i in impar2){
        println(i)
    }
}
