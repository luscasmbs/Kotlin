import java.util.*

fun main(args: Array<String>) {
var posi = 0


    var n = readLine()!!.toInt()
    var v = 0


    var tec = readLine()!!.split(" ")
    while (n<1 || n>1000){
        n = readLine()!!.toInt()
    }
    var x = IntArray(n)


    for (i in 0..n-1){
        v = tec[i].toInt()
        x[i] = v
    }
    var menor = x[0]


    for (i in x){


        if (i<menor){
            menor = i
            posi = x.indexOf(i)
        }


    }
    println("Menor valor: $menor")
    println("Posicao: $posi")

}
