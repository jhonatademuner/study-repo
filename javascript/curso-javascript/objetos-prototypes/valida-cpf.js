let cpf1 = '705.484.450-52';
let cpf2 = '070.987.720-03';

CpfPessoa.prototype.limpo = function limpaCPF(cpf) {
    return this.cpf.replace(/\D/g, '');
}

CpfPessoa.prototype.valido = function validaCPF(cpf) {
    cpf = this.limpo(cpf);
    const cpfArray = Array.from(cpf).map(digit => parseInt(digit));
    cpfArray.splice(-2, 2);
    for(let i = 0; i < 2; i++) {
        let multiplier = cpfArray.length + 1;
        const validateDigitSum = cpfArray.reduce((acc, digit) => {
            return acc + (digit * multiplier--);
        }, 0);
        cpfArray.push((11 - (validateDigitSum % 11)) % 10)
    }
    return cpfArray.join('') === cpf;
};

function CpfPessoa(cpf) {
    this.cpf = cpf;
}

const pessoa1 = new CpfPessoa(cpf1);
console.log(pessoa1)
console.log(pessoa1.limpo());
console.log(pessoa1.valido());

const pessoa2 = new CpfPessoa(cpf2);
console.log(pessoa2)
console.log(pessoa2.limpo());
console.log(pessoa2.valido());
