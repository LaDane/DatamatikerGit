////////////////////////////////////
// Coding Challenge #1

/*
Mark and John are trying to compare their BMI (Body Mass Index), 
which is calculated using the formula: 
BMI = mass / height ** 2 = mass / (height * height). (mass in kg and height in meter).

1. Store Mark's and John's mass and height in variables
2. Calculate both their BMIs using the formula (you can even implement both versions)
3. Create a boolean variable 'markHigherBMI' containing information about whether Mark has a higher BMI than John.

TEST DATA: Marks weights 78 kg and is 1.69 m tall. John weights 92 kg and is 1.95 m tall.

GOOD LUCK 😀

*/

const mark = {mass: 78, height: 1.69, bmi: 0};
const john = {mass: 92, height: 1.95, bmi: 0};
calcBMI(mark);
calcBMI(john);

function calcBMI(person) {
    person.bmi = person.mass / person.height ** 2;
}

let markHigherBMI = false;
if (mark.bmi > john.bmi) {
    markHigherBMI = true;
    console.log("Mark's BMI ("+ mark.bmi + ") is higher than John's ("+ john.bmi +")!");
}
else {
    console.log("Mark's BMI ("+ mark.bmi + ") is lower than John's ("+ john.bmi +")!");
}


// Ternary Operator
let isHigher = mark.bmi > john.bmi ? true : false;
console.log(isHigher);


// String formats
let literal = `The number ${mark.bmi} is larger than ${john.bmi}`;
console.log(literal);


// Constructors and class functions
class Human{
    constructor(fname, lname, age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    getFullName() {
        return `${this.fname} ${this.lname}`;
    }
}

const human = new Human("Steve", "Hanson", 25);
console.log(human.getFullName());