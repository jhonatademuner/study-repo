/*

**Desafio**
Você é um desenvolvedor em início de carreira e foi contratado por um banco para criar um sistema básico de abertura de
contas. Sua tarefa é implementar uma classe chamada "ContaBancaria" que represente uma conta bancária com as seguintes
informações: número da conta, nome do titular e saldo.

**Entrada**
O programa deve solicitar ao usuário as informações necessárias para abrir uma conta bancária. A entrada deve ser feita
via console (linha de comando) e deve incluir o número da conta (um valor inteiro), o nome do titular (uma sequência de
caracteres) e o saldo inicial da conta (um valor decimal).

**Saída**
Após receber as informações da conta, o programa deve criar um objeto do tipo "ContaBancaria" e exibir na tela as
informações dessa conta, incluindo o número da conta, o nome do titular e o saldo atual. A saída deve ser formatada de
forma clara e legível para o usuário.

**Exemplos**
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de
testar seu programa com esses exemplos e com outros casos possíveis.

	_____________________________________________
	| Entrada			| Saída					|
	|___________________|_______________________|
	| 010101			| Informações:			|
	| Caio Carlos		| Conta: 010101			|
	| 98.0				| Titular: Caio Carlos	|
	|                   | Saldo: R$ 98.0		|
	|-------------------|-----------------------|
	| 212223			| Informações:			|
	| Carla Paiva		| Conta: 212223			|
	| 500.0				| Titular: Carla Paiva	|
	| 					| Saldo: R$ 500.0		|
	|-------------------|-----------------------|
	| 123456			| Informações:			|
	| Joao Silva		| Conta: 123456			|
	| 1000.0			| Titular: Joao Silva	|
	|					| Saldo: R$ 1000.0		|
	|___________________|_______________________|

*/

import java.util.Scanner

class ContaBancaria(private val numeroConta: Int, private val nomeTitular: String, private val saldo: Double) {
	fun getNumeroConta(): Int {
		return numeroConta
	}

	fun getNomeTitular(): String {
		return nomeTitular
	}

	fun getSaldo(): Double {
		return saldo
	}
}

fun main() {
	val scanner = Scanner(System.`in`)

	val numeroConta = scanner.nextInt()
	scanner.nextLine()

	val nomeTitular = scanner.nextLine()

	val saldo = scanner.nextDouble()

	val c1 = ContaBancaria(numeroConta, nomeTitular, saldo)

	println("Informacoes:")
	println("Conta: ${c1.getNumeroConta()}")
	println("Titular: ${c1.getNomeTitular()}")
	println("Saldo: R$ ${c1.getSaldo()}")

}