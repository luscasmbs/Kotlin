var nome = ""
var email = ""
var senha = ""
data class usuariosc(var nome: String, var email: String, var senha: String)
var livros = mutableListOf<String>("O magico de oz", "Sitio do pica-pau amarelo", "Harry Potter", "Percy Jackson", "Narnia", "O senhor dos aneis")
var quant = mutableListOf<Int>(2, 3, 7, 5, 6, 6)
var uscadast = mutableListOf<usuariosc>()
var nomes = mutableListOf<String>()
var livross = mutableListOf<String>()
var esc = 0
var quants = 0

fun main(){
    println("Olá, bem vindo ao sistema de biblioteca, para começarmos, você já possui uma conta? \n 1- Sim\n 2- Não")
    var text = readLine()!!.toInt()
    if (text == 1){
        login()
    } else {
        cadastro()
    }
}

fun cadastro(){
    livros.add("O magico de oz")

    println("Olá, bem vindo ao cadastro! para começarmos, insira seu nome")
    nome = readLine()!!
    println("Agora insira o seu melhor e-mail")
    email = readLine()!!
    println("Agora crie sua senha:")
    senha = readLine()!!
    uscadast.add(usuariosc(nome, email, senha))
    println("Cadastro concluído com sucesso, redirecionando ao inicio")
    main()

}

fun login(){
    println("Insira seu e-mail já cadastrado")
    var emaill = readLine()!!
    println("Insira sua senha")
    var senhal = readLine()!!
    val usuarioenc = uscadast.find {it.email == email && it.senha == senha}

    if (usuarioenc != null) {
        println("Olá $nome, bem vindo de volta")
        inicio()
    } else{
        println("Email ou Senha invalidos, tente novamente mais tarde")
        main()
    }
}
fun inicio(){
    println("Olá, o que você gostaria de fazer? \n 1- Fazer reserva de livros \n 2- Ver reservas \n 3- Sair do sistema")
    esc = readLine()!!.toInt()
    if (esc == 1){
        reserva()
    } else if(esc == 2){
        verres()
    } else {
        main()
    }
}

fun reserva(){
    println("Olá, segue todos os livros disponiveis:")
    var cont = 0
    for (i in quant){

        println("${cont+1} - ${livros[cont]} qnt: ${quant[cont]}")
        cont++

    }
    println("Qual você gostaria de alugar?")
    var alug = readLine()!!.toInt()
    if (alug == 1){
        quant[0] -= 1
        println("Reserva feita!")
        nomes.add(nome)
        livross.add(livros[0])
        quants = quant[0]
        inicio()
        if (quant[0] <= 0){println("Esse livro está indisponivel ;( tente outro")
            reserva()

        }
    } else if (alug == 2){
        quant[1] -= 1
        println("Reserva feita!")
        nomes.add(nome)
        livross.add(livros[1])
        quants = quant[1]


        inicio()
        if (quant[1] <= 0){println("Esse livro está indisponivel ;( tente outro")
            reserva()

        }
    }
    else if (alug == 3){
        quant[2] -= 1
        println("Reserva feita!")
        nomes.add(nome)
        livross.add(livros[2])
        quants = quant[2]



        inicio()
        if (quant[2] <= 0){println("Esse livro está indisponivel ;( tente outro")
            reserva()

        }
    } else if (alug == 4){
        quant[3] -= 1
        println("Reserva feita!")
        nomes.add(nome)
        livross.add(livros[3])
        quants = quant[3]


        inicio()
        if (quant[3] <= 0){println("Esse livro está indisponivel ;( tente outro")
            reserva()

        }
    } else if (alug == 5){
        quant[4] -= 1
        println("Reserva feita!")
        nomes.add(nome)
        livross.add(livros[4])
        quants = quant[4]



        inicio()
        if (quant[4] <= 0){println("Esse livro está indisponivel ;( tente outro")
            reserva()

        }
    } else if (alug == 6){
        quant[5] -= 1
        println("Reserva feita!")
        nomes.add(nome)
        quants = quant[5]
        livross.add(livros[5])


        inicio()
        if (quant[5] <= 0){println("Esse livro está indisponivel ;( tente outro")
            reserva()
        }
    } else {
        println("Escolha um valor valido de 1 a 6")
        reserva()
    }


}
fun verres(){
    println("Olá, segue todos os livros disponiveis:")
    var cont = 0
    for (i in 0 until nomes.size){

        println("${cont+1} - ${livross[cont]} disponiveis: ${quants} feita por: ${nomes[cont]}")
        cont++

    }
    inicio()
}
