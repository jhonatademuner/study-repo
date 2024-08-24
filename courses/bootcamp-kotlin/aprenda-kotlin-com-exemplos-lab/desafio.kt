// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

class IncompatiblePlanException(message: String) : Exception(message)

class IncompatibleLevelException(message: String) : Exception(message)

enum class Nivel {
    Basico,
    Intermediario,
    Avancado
}

enum class Plano {
    Free,
    Premium
}

data class Usuario(
        val nome: String,
        val email: String,
        val nivel: Nivel = Nivel.Basico,
        val plano: Plano = Plano.Free
)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(
        val nome: String,
        var conteudos: List<ConteudoEducacional>,
        var nivel: Nivel,
        val plano: Plano
) {

    private val inscritos = mutableListOf<Usuario>()

    private fun separator() {
        println("===================================================")
    }

    fun listarInscritos() {
        println()
        separator()
        println("Inscritos na formação $nome:")
        if (inscritos.isEmpty()) {
            println("Ainda não há inscritos nesta formação.")
        } else {
            inscritos.forEach { println("- ${it.nome}") }
        }
        separator()
        println()
    }

    fun listarConteudos() {
        println()
        separator()
        println("Conteúdos da formação $nome:")
        if (conteudos.isEmpty()) {
            println("Ainda não há conteúdos cadastrados nesta formação.")
        } else {
            conteudos.forEach { println("- ${it.nome}") }
        }
        separator()
        println()
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        println()
        separator()
        try {
            conteudos += conteudo
            println("Conteúdo ${conteudo.nome} adicionado com sucesso na formação $nome")
        } catch (e: Exception) {
            println(e.message)
            return
        }
        separator()
        println()
    }

    private fun validaAcesso(usuario: Usuario) {
        if (usuario.plano < plano) {
            throw IncompatiblePlanException(
                    "Usuário ${usuario.nome} não possui plano compatível com a formação."
            )
        }
        if (usuario.nivel < nivel) {
            throw IncompatibleLevelException(
                    "Usuário ${usuario.nome} não possui nível de acesso compatível com a formação."
            )
        }
    }

    fun matricular(usuario: Usuario) {
        try {
            validaAcesso(usuario)
        } catch (e: Exception) {
            println(e.message)
            return
        }
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado com sucesso na formação $nome")
    }
}

fun main() {

    val usuario1 = Usuario("João", "joao@gmail.com")
    val usuario2 = Usuario("Maria", "maria@gmail.com", Nivel.Intermediario, Plano.Premium)
    val usuario3 = Usuario("José", "jose@gmail.com", Nivel.Avancado, Plano.Premium)

    val conteudo1 = ConteudoEducacional("Kotlin para iniciantes", 60)
    val conteudo2 = ConteudoEducacional("Kotlin para intermediários", 60)
    val conteudo3 = ConteudoEducacional("Kotlin para avançados", 60)

    val conteudo4 = ConteudoEducacional("Python para Machine Learning", 60)
    val conteudo5 = ConteudoEducacional("Aplicando Python em IAs reais", 60)
    val conteudo6 = ConteudoEducacional("Python para Data Science", 60)

    val conteudo7 = ConteudoEducacional("Python para Automação", 60)
    val conteudo8 = ConteudoEducacional("Python para Web", 60)
    val conteudo9 = ConteudoEducacional("Python para Desktop", 60)

    val formacao1 =
            Formacao(
                    "Dominando Kotlin",
                    listOf(conteudo1, conteudo2, conteudo3),
                    Nivel.Basico,
                    Plano.Free
            )
    val formacao2 =
            Formacao(
                    "Dominando Python",
                    listOf(conteudo4, conteudo5, conteudo6),
                    Nivel.Avancado,
                    Plano.Premium
            )

    formacao1.listarConteudos()
    formacao1.listarInscritos()

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao1.matricular(usuario3)

    formacao1.listarInscritos()

    formacao2.matricular(usuario1)
    formacao2.matricular(usuario2)
    formacao2.matricular(usuario3)

    formacao2.listarInscritos()

    formacao2.adicionarConteudo(conteudo7)
    formacao2.adicionarConteudo(conteudo8)
    formacao2.adicionarConteudo(conteudo9)

    formacao2.listarConteudos()
}
