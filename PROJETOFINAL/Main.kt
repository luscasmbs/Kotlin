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
    if (id.toIntOrNull() == null ||id.toInt() <=0 ){
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
        telefone = construirt(telefone)
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
    var id = readLine()!!
    if (id.toIntOrNull() == null){
        println("ERRO: ID inválido")
        main()
    }


    var usuariodoid = usuarioscadastrados.find { it.id == id.toInt() }
    if (usuariodoid != null){
        println("\nContato encontrado: \n\n" +
                "ID: ${usuariodoid.id}\n" +
                "Nome: ${usuariodoid.nome}\n" +
                "Telefone: ${usuariodoid.telefone}")
        main()
    } else {
        println("\nContato não encontrado")
        main()
    }

}

fun listarContato(){
    println("=================================\n " +
            "LISTAR CONTATOS\n" +
            "=================================\n")
    var usuarios = mutableMapOf<Int, usuarios>()
    for (usuario in usuarioscadastrados){
        usuarios[usuario.id] = usuario
    }
    for ((id, usuario) in usuarios.toSortedMap()){
        println("\nID: ${usuario.id}\n" +
                "Nome: ${usuario.nome}\n" +
                "Telefone: ${usuario.telefone}\n" +
                "---------------------------------")
    }

}
fun atualizarContato(){

}
fun removerContato(){

}
fun sair(){

}
fun construirt(t: String): String{
    var contador = 0
    var telefone = ""
    for(c in t){
        if (contador == 0){
            telefone+= '('
        }
        if (contador == 2){
            telefone+= ')'
            telefone+= ' '
        }
        if (contador == 7){
            telefone += '-'
        }
        telefone+= c
        contador++

    }

    return telefone
}

