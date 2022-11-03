const form = document.querySelector('.form');

function nivelIMC (imc){
    if(imc < 18.5){return `Abaixo do peso`}
    if(imc >= 18.5 && imc <= 24.9){return `Peso normal`}
    if(imc >= 25 && imc <= 29.9){return `Sobrepeso`}
    if(imc >= 30 && imc <= 34.9){return `Obesidade grau 1`}
    if(imc >= 35 && imc < 39.9){return `Obesidade grau 2`}
    if(imc > 40){return `Obesidade grau 3`}
}

function checagemInput(peso, altura){
    if (isNaN(peso)){return [false, `Peso inválido`]}
    if (isNaN(altura)){return [false, `Altura inválida`]}
    return [true, '']
}

form.addEventListener('submit', function (evento){

    evento.preventDefault();

    const resultado = document.createElement('p');
    resultado.classList.add('resultado')

    const container = document.querySelector('.container')
    const peso = form.querySelector('#peso');
    const altura = form.querySelector('#altura');

    const validacaoInput = checagemInput(peso.value, altura.value);

    if (validacaoInput[0]){

        const imc = (peso.value / (altura.value ** 2)).toFixed(1);
        resultado.classList.add('valido')
        resultado.innerHTML = `Seu IMC é ${imc} (${nivelIMC(imc)})`

    }else {

        resultado.classList.add('invalido')
        resultado.innerHTML = `${validacaoInput[1]}`

    }

    container.lastChild.remove()
    container.appendChild(resultado)
})
