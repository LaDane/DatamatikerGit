// var = Variable that can be accesed throughout the script
var fname = "Hans";
console.log(fname);

// let = Variable that can only be accesed within the given scope
let lName = "Flans";
console.log(lName);

if (true) {
    var scopedVar = "Hans";
    let scopedLet = "Flans";
}

console.log(scopedVar);
// console.log(scopedLet);     --> Throws error = not defined

// const = Variable that never changes, but things defined in object can be changed
const person1 = {firstName: "Steve"};
person1.firstName = "Steve Jobs";

console.log(person1.firstName);