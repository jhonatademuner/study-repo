# Faca um procedimeno que leia um numero N e a temperatura de N dias do ano. Em seguida, calcule a media de temperatura anual e imprima o numero de dias que a temperatura ficou abaixo da media.

def temperatura():
	l = []
	temperaturaAbaixo = 0
	numeroDias = int(input())
	for i in range(numeroDias):
		l.append(int(input()))
	media = sum(l) / numeroDias
	for i in l:
		if i < media:
			temperaturaAbaixo += 1
	print (f'Media da temperatura anual = {media}\nDias com temperatura abaixo da media = {temperaturaAbaixo}')
