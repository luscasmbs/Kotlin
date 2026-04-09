//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
println("Insira um valor qualquer");
var n1 = readln().toInt();
    println("Insira outro número")
    var n2 = readln().toInt();
    if (n1>n2){
        println("O número 1 é maior")
    } else{
        println("O numero 2 é o maior")
    }
    var numero = n1 - n2;
    println("A diferença entre os números é de: $numero")
}
