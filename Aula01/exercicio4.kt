
fun main() {
println("Insira a sua altura")
    var altura = readln().toDouble()
    println("Insira seu peso")
    var peso = readln().toDouble()
    var imc = peso/(altura*altura)
    if (imc <18.5){
        println("Você está abaixo do peso")
    } else if (imc >= 25){
        println("Você está sobrepeso")
    } else {
        println("Você está no peso ideal")
    }
}
