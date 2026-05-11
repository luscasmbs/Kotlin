import kotlin.io.print
import kotlin.text.toInt

data class usuarios(var id: Int, var nome: String, var telefone: String)
var usuarioscadastrados = mutableListOf<usuarios>()

fun main(){
    println("=================================\n " +
            "SISTEMA DE CONTATOS\n" +
            "=================================\n\n" +
            "1 - Adicionar contato\n" +
            "2 - Buscar contato\n" +
            "3 - Listar contatos\n" +
            "4 - Atualizar contato\n" +
            "5 - Remover contato\n" +
            "0 - Sair\n")
    print("escolha uma opção: ")
    var op = readLine()!!.toInt()
    when(op){
        1 ->  adicionarContato()
        2 ->  buscarContato()
        3 -> listarContato()
        4 -> atualizarContato()
        5 -> removerContato()
        0 ->  sair()
    }

}

fun adicionarContato(){
    println("=================================\n " +
            "ADICIONAR CONTATO\n" +
            "=================================\n\n" +
            "Digite o ID:")
    print("> ")
    var id = readLine()!!
    println("\nDigite o nome:")
    print("> ")
    var nome = readLine()!!
    println("\nDigite o telefone:")
    print("> ")
    var telefone = readLine()!!
    telefone = telefone.filterNot { it == '(' || it == ')' || it == '-' || it == ' ' }
    if (id.toIntOrNull() == null){
        println("ERRO: ID inválido")
        main()
    } else if(usuarioscadastrados.any { it.id == id.toInt() }){
        println("ERRO: ID já cadastrado")
        main()
    } else if(telefone.length != 11){
        println("ERRO: TELEFONE INVÁLIDO")
        main()
    }
    else{
        usuarioscadastrados.add(usuarios(id.toInt(), nome, telefone))
        println("Contato cadastrado com sucesso!")
        main()
    }
}

fun buscarContato(){
    println("=================================\n " +
            "BUSCAR CONTATO\n" +
            "=================================\n\n" +
            "Digite o ID do contato:")
            print("> ")
    var c = 0
    var id = readLine()!!.toInt()

    if (usuarioscadastrados.any { it.id == id}){
        while (usuarioscadastrados.any { it.id != id}){
            c++
        }
        println("\n Contato encontrado: \n\n" +
                "ID: ${id}\n" +
                "Nome: ${usuarioscadastrados[c].nome}")
    }

}
fun listarContato(){
    println("=================================\n " +
            "LISTAR CONTATOS\n" +
            "=================================\n\n")
}
fun atualizarContato(){

}
fun removerContato(){

}
fun sair(){

}

