//$ Escreva uma função chamada ePaisagem que recebe dois argumentos, largura e altura
//$ de uma imagem (number). Retorne true se a imagem estiver no modo paisagem.

function ePaisagem1(largura, altura){
    if (largura > altura) return true;
}

function ePaisagem2(largura, altura){
    return largura > altura ? true : false;
}

const ePaisagem3 = (largura, altura) => largura > altura;