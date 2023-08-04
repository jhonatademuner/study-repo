//$ Definindo uma constante para o container
const container = document.querySelector('.container');

//$ Funcao para obter o nome do dia da semana a partir do numero do dia da semana
function getDiaSemana (dia){

    //$ Procedimento para retornar o nome do dia da semana para cada caso possivel de dia da semana recebido como argumento
    switch (dia){
        case 0:
            return `Domingo`;
        case 1:
            return `Segunda-feira`;
        case 2:
            return `Terça-feira`;
        case 3:
            return `Quarta-feira`;
        case 4:
            return `Quinta-feira`;
        case 5:
            return `Sexta-feira`;
        case 6:
            return `Sábado`;
    }
}

//$ Funcao para obter o nome do mes a partir do numero do dia do mes
function getMes(mes){

    //$ Procedimento para retornar o nome do mes para cada caso possivel de dia do mes recebido como argumento
    switch (mes){
        case 0:
            return `janeiro`;
        case 1:
            return `fevereiro`;
        case 2:
            return `março`;
        case 3:
            return `abril`;
        case 4:
            return `maio`;
        case 5:
            return `junho`;
        case 6:
            return `julho`;
        case 7:
            return `agosto`;
        case 8:
            return `setembro`;
        case 9:
            return `outubro`;
        case 10:
            return `novembro`;
        case 11:
            return `dezembro`;
    }
}

//$ Script principal, vai ser chamado quando o usuario carregar a pagina
function escopo(){

    //$ Definicao da constante com a data atual
    const data = new Date();

    //$ Definicao da constante com o dia da semana usando a funcao para obter o nome do dia da semana
    const diaSemana = getDiaSemana(data.getDay());

    //$ Definicao da constante com o dia do mes
    const diaMes = data.getDate();

    //$ Definicao da funcao com o mes usando a funcai para obter o nome do mes
    const mes = getMes(data.getMonth());

    //$ Definicao da constante com o ano
    const ano = data.getFullYear();

    //$ Definicao da constante com as horas usando um metodo de string para adicionar uma casa com 0 a esquerda quando o numero tiver apenas uma casa
    const horas = data.getHours().toString().padStart(2, '0');

    //$ Definicao da constante com os minutos usando um metodo de string para adicionar uma casa com 0 a esquerda quando o numero tiver apenas uma casa
    const minutos = data.getMinutes().toString().padStart(2, '0');

    //$ Definindo a constante que ira exibir o resultado dos calculo do IMC do usuario como um elemento HTML(<p></p>)
    const saida = document.createElement('p');

    //$ Adicionando uma classe ao elemento para melhor estilização pelo CSS posteriormente
    saida.classList.add('saida');

    //$ Definindo o conteudo do elemento HTML que sera exibido para o usuario
    saida.innerHTML = `${diaSemana}, ${diaMes} de ${mes} de ${ano}<br>${horas}:${minutos}`

    //$ Adicionando o elemento HTML(<p></p>) com a data atual como elemento filho do "container"
    container.appendChild(saida)
}
escopo()