//$ Escreva uma função que receba 2 numeros e retorne o maior entre eles

function max1(num1, num2){
    if (num1 > num2) return num1;
    return num2;
}

function max2 (num1, num2){
    return num1 > num2 ? num1 : num2;
}

const max3 = (num1, num2) => {
    return num1 > num2 ? num1 : num2;
}

const max4 = (num1, num2) => num1 > num2 ? num1 : num2;

console.log(max4(5, 9))