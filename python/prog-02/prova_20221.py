usuarios = { "hsjunior" : "Hilario Seibel Jr", "vale" : "Valentina da Silva" }

artistas = { "a0001" : "Ivete Sangalo", "a0002" : "Nirvana", "a0003" : "Molejo" }

musicas = { "x0001" : ("a0001", "Cheguei Pra Te Amar", (3,16)),
            "x0002" : ("a0001", "Tempo de Alegria", (3,42)),
            "x0003" : ("a0001", "Acelera Aê", (3,49)),
            "x0004" : ("a0001", "Festa", (3,43)),
            "x0005" : ("a0002", "Smells Like Teen Spirit", (5,1)),
            "x0006" : ("a0002", "Come As You Are", (3,37)),
            "x0007" : ("a0002", "Lithium", (4,15)),
            "x0008" : ("a0003", "Cilada", (3,42)),
            "x0009" : ("a0003", "Dança da Vassoura", (3,26)) }

playlists = [ ("SÓ SUCESSOS", "hsjunior" , ["x0001", "x0003", "x0004", "x0005"]),
              ("2022", "vale" , ["x0003", "x0008"]),
              ("Niver", "hsjunior", ["x0003", "x0007", "x0009"]) ]

def imprimirPlaylists(usuarios, musicas, playlists):
    for nomePlaylist, codigoUsuario, codigosMusicas in playlists:
        nomeUsuario = usuarios[codigoUsuario]
        segundosMusica = 0
        for musica in codigosMusicas:
            segundosMusica += musicas[musica][2][1]
            segundosMusica += musicas[musica][2][0] * 60
        segundosPlaylist = segundosMusica % 60
        minutosPlaylist = segundosMusica // 60
        horasPlaylist = segundosMusica // 3600
        print(f'{nomePlaylist} (by {nomeUsuario}) : {horasPlaylist:02d}:{minutosPlaylist:02d}:{segundosPlaylist:02d}')

# imprimirPlaylists(usuarios, musicas, playlists)

def contagemPlaylists(codigoMusica, playlists):
    contagem = 0
    for _,_,musicas in playlists:
        if codigoMusica in musicas:
            contagem += 1
    return contagem

def musicaHit(artistas, musicas, playlists):
    maiorContagem = 0
    for codigoMusica in musicas:
        contagem = contagemPlaylists(codigoMusica, playlists)
        if contagem > maiorContagem:
            maiorContagem = contagem
            musicaHit = codigoMusica
    print(f'Hit do ano: {musicas[musicaHit][1]} ({artistas[musicas[musicaHit][0]]})')

# musicaHit(artistas, musicas, playlists)