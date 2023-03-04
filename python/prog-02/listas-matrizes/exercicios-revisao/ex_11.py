# Escreva uma funcao que, dada a hora corrente e a hora do alarme, determine o numero de minutos que ela poderia dormir.

def alarme(horaAtual, minutoAtual, horaAlarme, minutoAlarme):
    if (horaAtual * 60 + minutoAtual) > (horaAlarme * 60 + minutoAlarme):
        print(1440 - (horaAtual * 60 + minutoAtual) + (horaAlarme * 60 + minutoAlarme))
    else:
        print((horaAlarme * 60 + minutoAlarme) - (horaAtual * 60 + minutoAtual))