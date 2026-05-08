import java.util.*

fun main(args: Array<String>) {

  var n = readLine()!!.toInt()
    var numeros = mutableListOf<Int>()
    for (i in 1 .. n){
        var num = readLine()!!.toInt()
        numeros.add(num)
    }
    var freq = numeros.groupingBy { it }.eachCount()
    var nume = numeros.toSet()
    for (num in nume.sorted()){
        var c = 0
        println("${num} aparece ${freq[num]} vez(es)")
        c++
    }
	
}
