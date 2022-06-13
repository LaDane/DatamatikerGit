// Function Declaration
       //Observe: no return type, no type on parameters
function add(n1, n2){
   return n1 +n2;
}

// Function Expression
var sub = function(n1,n2){
  return n1 - n2
} 

// Callback example
var cb = function(n1,n2, callback){
  return "Result from the two numbers: "+n1+" and "+n2+" = "+callback(n1,n2);
};

/*
*******************************
***********CALLBACKS***********
*******************************
*/

console.log("--------------------------------------");

// 1)

// 1- What will this print?
 console.log(add(1,2))
// 2- What will it print and what does add represent?
// console.log(add("hund"))
// console.log("Write the answer here!");
// 3- What will it print  
// console.log(add(1,2,3));
// 4- What will it print 
// console.log(add(1));    
// 5- What will it print  
// console.log(cb(3,3,add));
// 6- What will it print
// console.log(cb(4,3,sub));
// 7- What will it print and what was the problem?
// console.log(cb(3,3,add()));
// console.log("Write the answer here!");
// 8- What will it print
// console.log(cb(3,"hh",add));

// 2)
// TODO: 

// 3)
// TODO:

/*
********************************************
***Callbacks(with map,filter and forEach)***
********************************************
*/

console.log("--------------------------------------");

// 1)
// TODO:

// 2)
// TODO:

// 3)
// TODO:

// 4)
var cars = [
  { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
  { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
  { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
  { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
  { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
  ];

const venture = cars.filter( (el, index) => {
  return el.model == 'Venture';
})

venture.forEach( (el, index) => {
  console.log(index);
  console.log(el);
})

const addVariable = cars.map( (el, index) => {
  // return american
})

console.log(addVariable);
// 

// 5)
// TODO:

/*
*******************************
********Error Handling*********
*******************************
*/

console.log("--------------------------------------");

// 1)
// TODO:

/*
*******************************
****Asynchronous Callbacks*****
*******************************
*/

console.log("--------------------------------------");

// 1)
// TODO:


/*
********************************
*************this***************
********************************
*/

console.log("--------------------------------------");

// 1)
// TODO:

// 2)
// TODO:

// 3)
// TODO:

// 4)
// TODO:


