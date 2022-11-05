//$ Funcao usada para obter o nivel do IMC do usuario
function nivelIMC (imc){

    //$ Classificando todos os niveis de IMC possiveis utilizandos condicionais, a funcao retornara a mensagem da primeira condicao a ser cumprida
    if(imc < 18.5){return `Abaixo do peso`}
    if(imc >= 18.5 && imc <= 24.9){return `Peso normal`}
    if(imc >= 25 && imc <= 29.9){return `Sobrepeso`}
    if(imc >= 30 && imc <= 34.9){return `Obesidade grau 1`}
    if(imc >= 35 && imc < 39.9){return `Obesidade grau 2`}
    if(imc > 40){return `Obesidade grau 3`}
}

//$ Funcao para checar se os dados inseridos pelo usuario sao "validos"
function checagemInput(peso, altura){

    //$ Checando se foi inserido um numero no campo de peso e retornando uma mensagem alertando o usuario caso a entrada seja invalida
    if (isNaN(peso)){return [false, `Peso inválido`]}

    //$ Checando se o numero inserido e maior que 3, se sim, entao a funcao retornara uma mensagem pedindo para o usuario inserir a altura em metros
    if(altura > 3){return [false, `Insira a altura em metros`]}

    //$ Checando se foi inserido um numero no campo de altura e retornando uma mensagem alertando o usuario caso a entrada seja invalida
    if (isNaN(altura)){return [false, `Altura inválida`]}

    //$ Se nenhuma das condicoes anteriores forem cumpridas as entradas serao consideradas como validas
    return [true, '']
}

//$ Definindo uma constante para o formulario
const form = document.querySelector('.form');

//$ Script principal, vai ser chamado quando o usuario pressionar o botao de envio do formulario
form.addEventListener('submit', function (evento){

    //$ Metodo usado para impedir  o navegador de executar seu comportamento padrao quando o usuario enviar o formulario(recarregar a página)
    evento.preventDefault();

    //$ Definindo a constante que ira exibir o resultado dos calculo do IMC do usuario como um elemento HTML(<p></p>)
    const resultado = document.createElement('p');
    //$ Adicionando uma classe ao elemento para que possamos estilizar o resultado usando CSS
    resultado.classList.add('resultado')

    //$ Obtendo as entradas do usuario utilizando as Classes e IDs dos campos do formulario
    const container = document.querySelector('.container')
    const peso = form.querySelector('#peso');
    const altura = form.querySelector('#altura');

    //$ Definindo constante que ira conter o valor de se as entradas do usuario foram validas, se uma entrada nao for valida a constante tambem armazenara qual entrada foi invalida
    const validacaoInput = checagemInput(peso.value, altura.value);

    //$ Validacao das entradas do usuario
    //$ Procedimento para quando ambas as entradas do usuario forem validas
    if (validacaoInput[0]){

        //$ Definindo constante com o valor do IMC do usuario e arredondando o mesmo para apenas uma casa decimal para evitar erros de imprecisao
        const imc = (peso.value / (altura.value ** 2)).toFixed(1);

        //$ Adicionando uma Classe que nos indicara o esilo de quando a resposta sera valida, para melhor entendimento leia o arquivo CSS
        resultado.classList.add('valido')

        //$ Definindo o conteudo da resposta(isso sera exibido para o usuario)
        resultado.innerHTML = `Seu IMC é ${imc} (${nivelIMC(imc)})`
    
    //$ Procedimento para quando uma ou ambas as entradas do usuario forem invalidas
    }else {

        //$ Adicionando uma Classe que nos indicara o esilo de quando a resposta sera invalida, para melhor entendimento leia o arquivo CSS
        resultado.classList.add('invalido')

        //$ Definindo o conteudo da resposta(isso sera exibido para o usuario)
        resultado.innerHTML = `${validacaoInput[1]}`
    }

    //$ Limpando o ultimo elemento HTML a ser inserido, apagara somente elementos inseridos pelo JavaScript, logo nao alterara o funcionamento do arquivo HTML inicial
    container.lastChild.remove()

    //$ Adicionando o elemento HTML(<p></p>) com o resultado do calculo e o nivel do IMC do usuario
    container.appendChild(resultado)
})
