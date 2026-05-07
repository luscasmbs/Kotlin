import java.util.*

fun main(args: Array<String>) {
    var n = readLine()!!.toInt()
    var f = n
    for(i in n downTo 2){
        f = f*(i-1)
        
    }
    println(f)
	
}
