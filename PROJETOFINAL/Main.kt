import kotlin.io.print
import kotlin.system.exitProcess
import kotlin.text.toInt

data class usuarios(var id: Int, var nome: String, var telefone: String)
//Lista com todos os usuarios já cadastrados
var usuarioscadastrados = mutableListOf<usuarios>()

//inicio
fun main(){
    while(true) {
        println("=================================\n " +
                "SISTEMA DE CONTATOS\n" +
                "=================================\n\n" +
                "1 - Adicionar contato\n" +
                "2 - Buscar contato\n" +
                "3 - Listar contatos\n" +
                "4 - Atualizar contato\n" +
                "5 - Remover contato\n" +
                "0 - Sair\n")
        print("Escolha uma opção: ")
        var op = readLine()!!

        // Verifica se a entrada é um número inteiro válido
        if (op.toIntOrNull() != null) {
            // Rejeita números fora do intervalo válido (0–5)
            if (op.toInt() > 5 || op.toInt()<0){
                println("ERRO: Digite um número entre 0 e 5.")
                continue // volta pro topo do while
            } else {
                // Redireciona para a função correspondente à opção escolhida
                when(op.toInt()) {
                    1 ->  adicionarContato()
                    2 ->  buscarContato()
                    3 -> listarContato()
                    4 -> atualizarContato()
                    5 -> removerContato()
                    0 -> sair() // único ponto de saída do programa
                }
            }
        } else {
            // Entrada não numérica: exibe erro e volta pro topo do while
            println("ERRO: Digite um número válido.")
            continue
        }
    }
}

// Solicita os dados do novo contato, valida cada campo e o adiciona à lista
fun adicionarContato(){
    println("=================================\n " +
            "ADICIONAR CONTATO\n" +
            "=================================\n\n" +
            "Digite o ID:")
    print("> ")
    var id = readLine()!!

    // Valida se o ID é um número positivo
    if (id.toIntOrNull() == null ||id.toInt() <=0 ){
        println("ERRO: ID inválido. Digite um número maior que 0.")
        return
        // Impede IDs duplicados
    } else if(usuarioscadastrados.any { it.id == id.toInt() }){
        println("ERRO: Já existe um contato com esse ID.")
        return
    }

    println("\nDigite o nome:")
    print("> ")
    var nome = readLine()!!
    if (nome == ""){
        println("ERRO: Nome inválido. Digite um nome válido.")
    }

    println("\nDigite o telefone:")
    print("> ")
    var telefone = readLine()!!

    // Remove formatação inserida pelo usuário para validar apenas os dígitos
    telefone = telefone.filterNot { it == '(' || it == ')' || it == '-' || it == ' ' }

    // Telefone brasileiro deve ter 11 dígitos (DDD + 9 dígitos)
    if(telefone.length != 11){
        println("ERRO: Telefone inválido. Digite um telefone com 11 dígitos.")
        return
    } else {
        // Chama a função para o telefone ficar no formato (xx) xxxxx-xxxx
        telefone = construirt(telefone)

        // Impede telefones duplicados na lista
        if(usuarioscadastrados.any { it.telefone == telefone} ){
            println("ERRO: Já existe um contato com esse telefone.")
            return
        }
        nome = nomepadronizado(nome)

        // Cria e salva o novo contato
        usuarioscadastrados.add(usuarios(id.toInt(), nome, telefone))
        println("Contato cadastrado com sucesso!")
    }
}

// Busca e exibe um contato pelo seu ID
fun buscarContato(){
    println("=================================\n " +
            "BUSCAR CONTATO\n" +
            "=================================\n\n" +
            "Digite o ID do contato:")
    print("> ")
    var id = readLine()!!

    if (id.toIntOrNull() == null){
        println("ERRO: ID inválido. Digite um número válido.")
        return
    }

    // Procura o contato na lista pelo ID informado
    var usuariodoid = usuarioscadastrados.find { it.id == id.toInt() }

    if (usuariodoid != null){
        println("\nContato encontrado: \n\n" +
                "ID: ${usuariodoid.id}\n" +
                "Nome: ${usuariodoid.nome}\n" +
                "Telefone: ${usuariodoid.telefone}")
    } else {
        println("\nContato não encontrado.")
    }
}

// Lista todos os contatos cadastrados em ordem crescente de ID
fun listarContato(){
    println("=================================\n " +
            "LISTAR CONTATOS\n" +
            "=================================")

    // Constrói um mapa para ordenar por ID com toSortedMap()
    var usuarios = mutableMapOf<Int, usuarios>()
    for (usuario in usuarioscadastrados){
        usuarios[usuario.id] = usuario
    }

    // Exibe cada contato na ordem do ID
    for ((id, usuario) in usuarios.toSortedMap()){
        println("\nID: ${usuario.id}\n" +
                "Nome: ${usuario.nome}\n" +
                "Telefone: ${usuario.telefone}\n" +
                "---------------------------------")
    }
}

// Permite alterar o ID, nome ou telefone de um contato existente
fun atualizarContato(){
    println("=================================\n " +
            "ATUALIZAR CONTATO\n" +
            "=================================\n" +
            "Digite o ID do contato que você quer atualizar:")
    print("> ")
    var id = readLine()!!

    if(id.toIntOrNull() == null){
        println("ERRO: ID inválido. Digite um número válido.")
        return
    }

    // Localiza o contato a ser editado
    var usuariodoid = usuarioscadastrados.find { it.id == id.toInt() }

    if (usuariodoid != null){
        println("\nContato encontrado: \n\n" +
                "ID: ${usuariodoid.id}\n" +
                "Nome: ${usuariodoid.nome}\n" +
                "Telefone: ${usuariodoid.telefone}")
    } else {
        println("\nContato não encontrado.")
        return
    }

    // Exibe as opções de campo a ser atualizado
    println("Qual informação você quer atualizar?\n" +
            "1 - ID\n" +
            "2 - Nome\n" +
            "3 - Telefone")
    print("> ")
    var escolha = readLine()!!

    //Garantir que vai ser um número inteiro
    if (escolha.toIntOrNull() == null) {
        println("ERRO: Digite um valor numérico válido.")
        return
    } else if (escolha.toInt() > 3 || escolha.toInt() < 1){
        println("ERRO: Escolha uma opção entre 1 e 3.")
        return
    }  else {
        if (id.toIntOrNull() == null){
            println("ERRO: ID inválido. Digite um número válido.")
            return
        }

        // Atualiza o ID do contato fazendo que o novo ID seja único e positivo
        if (escolha.toInt() == 1){
            println("Digite o novo ID:")
            print("> ")
            var novoId = readLine()!!

            if(novoId.toIntOrNull() == null || novoId.toInt() <= 0){
                println("ERRO: ID inválido. Digite um número maior que 0.")
                return
            }
            if(usuarioscadastrados.any { it.id == novoId.toInt() }){
                println("ERRO: Já existe um contato com esse ID.")
                return
            }

            usuariodoid?.id = novoId.toInt()
            println("ID atualizado com sucesso!")
            println("\nContato atualizado: \n\n" +
                    "ID: ${usuariodoid?.id}\n" +
                    "Nome: ${usuariodoid?.nome}\n" +
                    "Telefone: ${usuariodoid?.telefone}")

            // Atualiza o nome do contato e rejeitando o mesmo valor já salvo
        } else if (escolha.toInt() == 2){
            println("Digite o novo nome:")
            print("> ")
            var novoNome = readLine()!!

            if(usuarioscadastrados.any {it.nome == novoNome}){
                println("ERRO: Esse nome já está cadastrado.")
                return
            } else {
                usuariodoid?.nome = novoNome
                println("Nome atualizado com sucesso!")
                println("\nContato atualizado: \n\n" +
                        "ID: ${usuariodoid?.id}\n" +
                        "Nome: ${usuariodoid?.nome}\n" +
                        "Telefone: ${usuariodoid?.telefone}")
            }
        } else if (escolha.toInt() == 3){
            println("Digite o novo telefone:")
            print("> ")
            var novoTelefone = readLine()!!
            //Vai coletar o telefone novo e vai verificar se já tem um usuário com esse telefone
            if(usuarioscadastrados.any {it.telefone == novoTelefone}){
                println("ERRO: Esse telefone já está cadastrado.")
                return
            } else {
                //Vai passar o telefone do usuário para esse novo telefone
                usuariodoid?.telefone = novoTelefone
                println("Telefone atualizado com sucesso!")
                println(
                    "\nContato atualizado: \n\n" +
                            "ID: ${usuariodoid?.id}\n" +
                            "Nome: ${usuariodoid?.nome}\n" +
                            "Telefone: ${usuariodoid?.telefone}"
                )
            }
        }
    }
}

fun removerContato(){
    println("=================================\n " +
            "EXCLUIR CONTATO\n" +
            "=================================\n\n" +
            "Digite o ID do contato que você quer excluir:")
    print("> ")
    var id = readLine()!!
//Vai coletar o id do contato
    if (id.toIntOrNull() == null){
        println("ERRO: ID inválido. Digite um número válido.")
        return
    }
    if(id.toIntOrNull()!!< 1){
        println("ERRO: ID inválido. Digite um número maior que 0.")
        return
    }

    // Procura o contato na lista pelo ID informado
    var usuariodoid = usuarioscadastrados.find { it.id == id.toInt() }
//Se tiver o ID existir, ele vai perguntar se você quer excluir esse contato
    if (usuariodoid != null){
        println("\nContato encontrado: \n\n" +
                "ID: ${usuariodoid.id}\n" +
                "Nome: ${usuariodoid.nome}\n" +
                "Telefone: ${usuariodoid.telefone}\n\n" +
                "Você tem certeza que quer excluir esse contato? (S/N)")
        var escolha = readLine()!!.lowercase()
        if (escolha == "s"){
            //Se sim, ele vai remover o contato
            usuarioscadastrados.remove(usuariodoid)
            println("Contato removido com sucesso!")
            return
        } else if (escolha == "n") {
            println("Cancelando a operação...")
            return
        } else{
            println("ERRO: Digite apenas S para sim ou N para não.")
            return
        }
    } else {
        println("\nContato não encontrado.")
    }
}

fun sair(){
    println("\nEncerrando o sistema...")
    print("Obrigado por usar o nosso sistema!")
    exitProcess(0)
}

// faz o telefone ficar no formato (XX) XXXXX-XXXX a partir de uma string de 11 dígitos
fun construirt(t: String): String{
    var contador = 0
    var telefone = ""

    for(c in t){
        if (contador == 0){
            telefone+= '(' // abre o DDD
        }
        if (contador == 2){
            telefone+= ')' // fecha o DDD
            telefone+= ' '
        }
        if (contador == 7){
            telefone += '-' // separador do número
        }
        telefone+= c
        contador++
    }
    return telefone
}

fun nomepadronizado(nome: String): String{
    var contador = 0
    var nomec = ""
    for(c in nome){
        if (contador == 0){ //Se for a primeira letra do nome, vai transformar em maíuscula
            nomec += c.uppercase()
            contador++
        } else if (c == ' '){ //se tiver um espaço, a próxima letra após ele vai ser maíuscula
            nomec += ' '
            contador = 0
        } else {
            nomec += c //vai adicionando as outras letras a frase
        }
    }
    return nomec
}