import java.util.*

fun main(args: Array<String>) {
       val tec = Scanner(System.`in`);
    var senha = tec.nextLine()
    var senhac = "2002"

    while(senha!=senhac){
        println("Senha Invalida")
        senha = tec.nextLine()
    }
    println("Acesso Permitido")

	
}
