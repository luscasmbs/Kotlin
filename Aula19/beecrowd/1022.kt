import java.util.*

fun main(args: Array<String>) {
     var x = 0
    var op = "0.0"
    var y = 0
    var n = 0
    var d = 0

    var N = readLine()!!.toInt()
    for (i in 0 until N) {
        var tec = readLine()!!.split(" ")

        var n1 = tec[0].toInt()
        var d1 = tec[2].toInt()
        var op = tec[3]
        var n2 = tec[4].toInt()
        var d2 = tec[6].toInt()
        if (op == "+"){
            n =     (n1*d2 + n2*d1)
            d = d1*d2
        } else if (op == "-"){
             n = n1*d2-n2*d1
             d = d1*d2
        } else if (op == "*"){
             n = n1*n2
             d = d1*d2
        } else if (op == "/") {
             n = n1*d2
             d = n2*d1
        }
        var a = Math.abs(n)
        var b = Math.abs(d)
        while (b != 0){
            val resto = a % b
            a = b
            b = resto
        }
        var nsimples = n/a
        var dsimples = d/a
        println("$n/$d = $nsimples/$dsimples")



    }
}
