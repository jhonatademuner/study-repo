/*

**Descrição**
Você foi contratado para desenvolver um sistema de cofres seguros. O objetivo é criar dois tipos de cofres: um Cofre
Digital, que é aberto por senha, e um Cofre Físico, que é aberto por chave.

**Entrada**
O programa irá solicitar ao usuário que digite o tipo de cofre a ser criado: "digital" ou "físico". Se for escolhido o
tipo "digital", o programa irá solicitar a senha e a confirmação de senha do cofre digital (ambas com apenas números).
Caso seja escolhido o tipo "físico", não é necessário nenhuma outra entrada.

**Saída**
O programa irá exibir as informações do cofre criado. Para o Cofre Digital, será exibido o tipo e o método de abertura
(senha). Para o Cofre Físico, será exibido apenas o tipo e o método de abertura (chave).

**Exemplos**
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de
testar seu programa com esses exemplos e com outros casos possíveis.

	_________________________________________________
	| Entrada			| Saída						|
	|___________________|___________________________|
	| digital			| Tipo: Cofre Digital		|
	| 12345				| Metodo de abertura: Senha	|
	| 1234				| Senha incorreta!			|
	|-------------------|---------------------------|
	| fisico			| Tipo: Cofre Fisico		|
	| 					| Metodo de abertura: Chave	|
	|-------------------|---------------------------|
	| digital			| Tipo: Cofre Digital		|
	| 2525				| Metodo de abertura: Senha	|
	| 2525				| Cofre aberto!				|
	|___________________|___________________________|

*/

import java.util.Scanner

abstract class Cofre(private val tipo: String, private val metodoAbertura: String) {

	fun imprimirInformacoes() {
		println("Tipo: $tipo")
		println("Metodo de abertura: $metodoAbertura")
	}
}

class CofreDigital(private val senha: Int) : Cofre("Cofre Digital", "Senha") {

	fun validarSenha(confirmacaoSenha: Int): Boolean {
		return confirmacaoSenha == senha
	}
}

class CofreFisico : Cofre("Cofre Fisico", "Chave")

fun main() {
	val scanner = Scanner(System.`in`)

	val tipoCofre = scanner.nextLine()
	if (tipoCofre == "digital") {
		val senha = scanner.nextInt()
		val confirmacaoSenha = scanner.nextInt()
		val cofreDigital = CofreDigital(senha)
		cofreDigital.imprimirInformacoes()
		if (cofreDigital.validarSenha(confirmacaoSenha)) {
			println("Cofre aberto!")
		} else {
			println("Senha incorreta!")
		}
	} else {
		val cofreFisico = CofreFisico()
		cofreFisico.imprimirInformacoes()
	}

}