[HOME](/README.md)

## this keyword 

 **Regular function call:**
 The this keyword points at the global object, (the window object in the browser)
 
 **Method call:**
 The this variable points to the object that is calling the method.
 The this keyword is not assigned a value until the function where it is defined is actually called.
 

</br>

1. Call each method, one at a time, and try to understand the output.


    - That is the window(browser) object. The window object is the default object in JavaScript.
    
            console.log(this);


    - In web browsers, the window object is also the global object. (you have to write this in your developer tools web browser console)

            console.log(this === window); // true


    - this is a regular function call, so the this keyword still points to the window object.

            function calculateAge(year) {
                console.log(2022 - year)
                console.log(this)
            }

            calculateAge(1977); //output: 42 and window object


    - The this variable points to the object that is calling the method. The "john"object.

            var john = {
                name: 'John',
                yearOfBirth: 1977,
                calculateAge: function () {
                    console.log(this);
                    console.log(2019 - this.yearOfBirth);
                }
            }

            john.calculateAge();//output: john object and 42


    - A object with a regular function call. And again, the this keyword in the innerFunction points to the global window object.

            var hans = {
                name: 'Hans',
                yearOfBirth: 1977,
                calculateAge: function () {
                    console.log(this);
                    console.log(2019 - this.yearOfBirth);

                    function innerFunction() {
                        console.log(this + "hallo");

                    }
                    innerFunction();
                }
                
            }

            hans.calculateAge();// output: 42 and window object



