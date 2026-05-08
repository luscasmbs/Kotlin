import java.util.*
import kotlin.math.abs


fun main(args: Array<String>) {

var n = readLine()!!.toInt()
    var an = 2015
    repeat(n) {
        var c = 0
        var t = readLine()!!.toInt()
        c = t - an

        if (c < 0){

            c = abs(c)
            println("$c D.C.")
        } else if (c == 0){
            c++
            println("$c A.C.")
        }
        else if (c > 0){
c++
            println("$c A.C.")
        }

    }

	
}
