import java.util.*

fun main(args: Array<String>) {

var i = readLine()!!.toInt()
    var res = i%2
    if (res == 0){
        i++
    }
    var c = 0
    while (c < 6){
        println(i)
        i = i+2
        c++
    }
	
}
