def menu():
	print('''
1 - Cadastrar telefone
2 - Visualizar agenda
3 - Sair
	''')
	opcao = input("Escolha uma opcao: ")
	return opcao

def cadastrarTelefone(bancoTelefones):
	nome = input("Insira  o nome do contato: ")
	telefone = input("Insira  o telefone do contato: ")
	if nome not in bancoTelefones:
		bancoTelefones[nome] = telefone
	else:
		print("ERRO. Contato ja inserido.")
	return bancoTelefones
	
def visualizarAgenda(bancoTelefones):
	for nome in bancoTelefones:
		print(f'Nome: {nome} \t Telefone: {bancoTelefones[nome]}')
		
def lerArquivo():
	bancoTelefones = {}
	try:
		r = open("agenda.txt", "r")
		tamanhoAgenda = r.readline()
		for _ in range(int(tamanhoAgenda)-1):
			nome = r.readline().strip()
			telefone = r.readline().strip()
			bancoTelefones[nome] = telefone
		r.close()
	except:
		None
	return bancoTelefones
	
def escreverArquivo(bancoTelefones):
	with open("agenda.txt", "w") as f:
		f.write(str(len(bancoTelefones))+"\n")
		for nome in bancoTelefones:
			f.write(nome+"\n")
			f.write(bancoTelefones[nome]+"\n")
			
def main():
	bancoTelefones = lerArquivo()
	
	opcao = menu()
	while opcao != "3":
		if opcao == "1":
			cadastrarTelefone(bancoTelefones)
		elif opcao == "2":
			visualizarAgenda(bancoTelefones)
		opcao = menu()
	escreverArquivo(bancoTelefones)		
	
if __name__ == '__main__':
	main()
			
