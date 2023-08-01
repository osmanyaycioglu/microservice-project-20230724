

let obj1 = {
    name : "osman",
    lastName : "yaycıoğlu",
    title : "trainer",
};

console.log(JSON.stringify(obj1));

console.log("name 1 : " + obj1.name);
console.log("name 2 : " + obj1["name"]);

console.log("-----------------");

for (const key in obj1) {
    console.log(key + " : " + obj1[key]);
}