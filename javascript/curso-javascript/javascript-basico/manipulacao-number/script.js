const num = Number(prompt('Insira um número: '));
const numInserido = document.getElementById('num');
const text = document.getElementById('text');

numInserido.innerHTML = num;
text.innerHTML = `<p>Raiz quadrada: ${num ** 0.5}</p>`;
text.innerHTML += `<p>${num} é inteiro: ${Number.isInteger(num)}</p>`;
text.innerHTML += `<p>É NaN: ${Number.isNaN(num)}</p>`;
text.innerHTML += `<p>Arredondando para baixo: ${Math.floor(num)}</p>`;
text.innerHTML += `<p>Arredondando para cima: ${Math.ceil(num)}</p>`;
text.innerHTML += `<p>Com duas casas decimais: ${num.toFixed(2)}</p>`;