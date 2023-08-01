let myarr = [1, 2, 3, 4, "osman", 'ali', true, () => "deneme"];

console.log("Array type : " + (typeof myarr));
console.log("Array : " + myarr);
console.log(myarr[7]());
console.log(myarr[4]);

console.log("*----------------------*");

for (let index = 0; index < myarr.length; index++) {
    const element = myarr[index];
    console.log(element);
};

for (const el of myarr) {
    console.log(el);
}
console.log("*----------------------*");

myarr.forEach(el => console.log(el));

let myargs1 = [1, 2, 3, 4, 5];
let myargs1a = [1, 2, 3];
let myargs1b = myargs1;
let myargs2 = [4, 5, 6];

let myargs3 = myargs1.concat(myargs2);
console.log("*----------------------*");
myargs1.push(4);
myargs1.pop();
console.log(myargs1);
console.log(myargs2);
console.log(myargs3);
console.log("*----------------------*");
let myargs1Copy = [...myargs1];
myargs1Copy.push(4, 5);
console.log(myargs1);
console.log(myargs1Copy);

let myArrayTotal = [...myargs1, 10, 20, 30, ...myargs2]
console.log("*----------------------*");
console.log(myArrayTotal);
console.log("*----------------------*");
if (isArraysEqual(myargs1, myargs1a)) {
    console.log("eşitler");
}

function isArraysEqual(arr1, arr2) {
    if (arr1.length !== arr2.length) {
        return false;
    }
    for (let [index, x] of arr1.entries()) {
        if (x !== arr2[index]) {
            return false;
        }
    }
    return true;
}

function add(x, y, z) {
    return x + y + z;
}
console.log("*----------------------*");

console.log(add(...myargs1));