import kotlin.io.print
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
        print("escolha uma opção: ")
        var op = readLine()!!

        // Verifica se a entrada é um número inteiro válido
        if (op.toIntOrNull() != null) {
            // Rejeita números fora do intervalo válido (0–5)
            if (op.toInt() > 5 || op.toInt()<0){
                println("ERRO: INSIRA UM NÚMERO VÁLIDO")
                continue // volta pro topo do while
            } else {
                // Redireciona para a função correspondente à opção escolhida
                when(op.toInt()) {
                    1 ->  adicionarContato()
                    2 ->  buscarContato()
                    3 -> listarContato()
                    4 -> atualizarContato()
                    5 -> removerContato()
                    0 ->  { sair(); return } // único ponto de saída do programa
                }
            }
        } else {
            // Entrada não numérica: exibe erro e volta pro topo do while
            println("ERRO: INSIRA UM NÚMERO VÁLIDO")
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
        println("ERRO: ID inválido")
        return
        // Impede IDs duplicados
    } else if(usuarioscadastrados.any { it.id == id.toInt() }){
        println("ERRO: ID já cadastrado")
        return
    }

    println("\nDigite o nome:")
    print("> ")
    var nome = readLine()!!
    if (nome == ""){
        println("ERRO: nome Inválido")
    }

    println("\nDigite o telefone:")
    print("> ")
    var telefone = readLine()!!

    // Remove formatação inserida pelo usuário para validar apenas os dígitos
    telefone = telefone.filterNot { it == '(' || it == ')' || it == '-' || it == ' ' }

    // Telefone brasileiro deve ter 11 dígitos (DDD + 9 dígitos)
    if(telefone.length != 11){
        println("ERRO: telefone inválido")
        return
    } else {
        // Aplica a máscara de formatação antes de salvar
        telefone = construirt(telefone)

        // Impede telefones duplicados na lista
        if(usuarioscadastrados.any { it.telefone == telefone} ){
            println("ERRO: telefone já cadastrado")
            return
        }

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
        println("ERRO: ID inválido")
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
        println("\nContato não encontrado")
    }
}

// Lista todos os contatos cadastrados em ordem crescente de ID
fun listarContato(){
    println("=================================\n " +
            "LISTAR CONTATOS\n" +
            "=================================")

    // Constrói um mapa auxiliar para ordenar por ID com toSortedMap()
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
        println("ERRO: ID inválido")
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
        println("\nContato não encontrado")
        return
    }

    // Exibe as opções de campo a ser atualizado
    println("Qual informação você quer atualizar?\n" +
            "1 - ID\n" +
            "2 - Nome\n" +
            "3 - Telefone")
    print("> ")
    var escolha = readLine()!!

    if (escolha.toInt() > 3 || escolha.toInt() < 1){
        println("ERRO: INSIRA UM NÚMERO VÁLIDO")
        return
    } else if (escolha.toIntOrNull() == null) {
        println("ERRO: INSIRA UM VALOR VÁLIDO")
        return
    } else {
        if (id.toIntOrNull() == null){
            println("ERRO: ID inválido")
            return
        }

        // Atualiza o ID do contato, garantindo que o novo ID seja único e positivo
        if (escolha.toInt() == 1){
            println("Digite o novo ID:")
            print("> ")
            var novoId = readLine()!!

            if(novoId.toIntOrNull() == null || novoId.toInt() <= 0){
                println("ERRO: ID inválido")
                return
            }
            if(usuarioscadastrados.any { it.id == novoId.toInt() }){
                println("ERRO: ID já cadastrado")
                return
            }

            usuariodoid?.id = novoId.toInt()
            println("ID atualizado com sucesso!")
            println("\nContato atualizado: \n\n" +
                    "ID: ${usuariodoid?.id}\n" +
                    "Nome: ${usuariodoid?.nome}\n" +
                    "Telefone: ${usuariodoid?.telefone}")

            // Atualiza o nome do contato, rejeitando o mesmo valor já salvo
        } else if (escolha.toInt() == 2){
            println("Digite o novo nome:")
            print("> ")
            var novoNome = readLine()!!

            if(usuarioscadastrados.any {it.nome == novoNome}){
                println("ERRO: esse já é o nome")
                return
            } else {
                usuariodoid?.nome = novoNome
                println("Nome atualizado com sucesso!")
                println("\nContato atualizado: \n\n" +
                        "ID: ${usuariodoid?.id}\n" +
                        "Nome: ${usuariodoid?.nome}\n" +
                        "Telefone: ${usuariodoid?.telefone}")
            }
        }
    }
}

// TODO: implementar remoção de contato pelo ID
fun removerContato(){

}

// TODO: implementar encerramento limpo do programa
fun sair(){

}

// Aplica a máscara de telefone no formato (XX) XXXXX-XXXX a partir de uma string de 11 dígitos
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
