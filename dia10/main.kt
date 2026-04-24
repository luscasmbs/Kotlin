 println("Você quer visualizar exemplos ou atividades? \n 1- Exemplos \n 2- Atividades")
    var p = readLine()!!.toInt()
    if (p == 1){
        println("Selecione o exemplo")
        var r = readLine()!!.toInt()
        if (r == 1) {
            cadastro()
        } else if (r == 2) {
            vdupli()
        }
        else if (r == 3) {
            rmvduplicados()
        }

    } else if (p == 2) {
        println("Selecione qual atividade você quer visualizar?")
        p = readLine()!!.toInt()
        if (p == 1) {
            ex1()
        } else if (p == 2) {
            ex2()
        } else if (p == 3) {
            ex3()
        } else if (p == 4) {
            ex4()
        }
    }


}



fun cadastro(){
    val lista = mutableSetOf<String>()
    var conjunto = lista.toSet()

    println(conjunto)
}

fun vdupli(){
    val conjunto = mutableSetOf<Int>()
    for(i in 0 until 10){
        val numero = readLine()!!.toInt()
        if(numero in conjunto){
            println("DUPLICADO")
        } else{
            conjunto.add(numero)
        }
    }

}

fun rmvduplicados(){
    val lista = listOf(1, 2, 2, 3, 4, 4)
    val conjunto = lista.toSet()
    println(conjunto)

}
fun ex1(){
    var lista = listOf(1,2,3, 3, 3, 4, 4)
    var conjunto = lista.toSet()

    println(conjunto.size)
}
fun ex2(){
    var lista = listOf(1,2,3, 4, 4, 2, 3)

    var conjunto = lista.toSet()
    println(conjunto)
}

fun ex3(){
    val conjunto = mutableSetOf<Int>()

    for (i in 1..5) {
        val n = readln().toInt()

        if (!conjunto.add(n)) {
            println("Duplicado")
        }
    }

}

fun ex4(){
    val palavras = listOf("a", "b", "a", "c")
    val frequencia = mutableMapOf<String, Int>()

    for (p in palavras) {
        frequencia[p] = (frequencia[p] ?: 0) + 1
    }

    println(frequencia)
