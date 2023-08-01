
var myOtherVar = 100; // function scoped
let myFirstVar = 10; // Block scoped

globalVar = "I'm global var";

let myNumber = 0.1 + 0.7;
let myLongNumber = 12345678901234567;
let myBigint = 12345678901234567n;

console.log("Type of 1 : " + (typeof myFirstVar));
myFirstVar = "osman";
console.log("Type of 2 : " + (typeof myFirstVar));

let result = myNumber + myFirstVar;

console.log("result  : " + result);


console.log("My first log : " + myFirstVar);
console.log("My first log : " + globalVar);
console.log("My number : " + myNumber);
console.log("My long number : " + myLongNumber);
console.log("My long number : " + myBigint);

for (var index = 0; index < 10; index++) {
    console.log("index : " + index);
}
console.log("----------------");
console.log("index : " + index);

const constant = "osman";

console.log("constant : " + constant);

constant = "test";

