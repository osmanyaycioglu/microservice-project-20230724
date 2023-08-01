
function myFirstFunc1(name, surname) {
    console.log("my first function");
    return "deneme fonksiyonu " + name + " " + surname;
};

console.log(myFirstFunc1("osman"));

let myFunc = myFirstFunc1();

console.log("myFunc : " + myFunc);

let myOtherFunc = function (name, surname) {
    console.log("my other function");
    return "Other function  " + name + " " + surname;
};

console.log(myOtherFunc("osman", "yaycıoğlu"));

let myArrowFunction = (n, s) => {
    console.log("my arrow function");
    return "Arrow function  " + n + " " + s;
};

console.log(myArrowFunction("ali", "veli"));

let myArrowFunction2 = (n, s) => "Arrow function 2 " + n + " " + s;

console.log(myArrowFunction2("ayşe", "alaz"));

let myArrowFunction3 = n => "Arrow function 3 " + n;

console.log(myArrowFunction3("ayşe", "alaz"));

let myObj = {
    name: "osman",
    surname: "yaycıoğlu",
    writerFunc: myArrowFunction3
};

console.log(myObj.writerFunc("test"));


function myFirstFunc4(name, surname) {
    console.log("my first function");
    let innerFunction = function () {

    }
    function inner2Function() {

    }
    return () => "deneme fonksiyonu " + name + " " + surname;
};

let myCurriedFunction = x => y => x + y;

let myCurriedFunction2 = function (x) {
    return function (y) {
        return x + y;
    }
};

console.log("curried 1 : " + myCurriedFunction(10));

console.log("curried 2 : " + myCurriedFunction(10)(20));

console.log("curried 3 : " + myCurriedFunction2(10)(20));
