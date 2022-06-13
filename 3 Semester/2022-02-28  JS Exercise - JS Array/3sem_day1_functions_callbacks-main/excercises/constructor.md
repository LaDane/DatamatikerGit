[HOME](/README.md)

## this and constructor functions 

The value of **this** passed to all functions, is based on the context in which the function is called at runtime. Pay attention here, because this is one of those quirks you just need to memorize.
In the example below, we actually have two versions of **this** in play (one for the outer function, and one for the asynchronous callback).

</br>

1. Add this code

        function Person(name) {
        this.name = name;
        console.log("Name: " + this.name);

        setTimeout(function(){
            console.log("Hi " + this.name);  // Explain this
        }, 2000);
        }

        // call it like this (do it, even if you know it’s silly ;-)
        Person("Kurt Wonnegut");  // This calls the function
        console.log("I'm global: " + name);  // Explain this

    That was silly. How do we use a function starting with a capitalized letter?, and what do we call such a function?

</br>

2. Create a Person instance and rerun the example as sketched below:

        var p = new Person("Kurt Wonnegut");  // Create an instance using the constructor function
        console.log("I'm global: "+ name);  // What’s difference ?

    We still need to fix the problem with the callback, not having access to the **outer this**.

</br>

3. Change your code to fix the problem, using both strategies given below.

        //Store a reference to the outer this
        function Person(name){
        this.name = name;
        var self = this;
        console.log("Name: "+ this.name);
        setTimeout(function(){
            console.log("Hi  "+self.name);  
        },2000);
        }

    or

        //Using the bind(..) function
        function Person(name){
        this.name = name;  
        console.log("Name: "+ this.name);
        setTimeout(function(){
            console.log("Hi  "+this.name);  
        }.bind(this),2000);
        }

</br>

4. The bind method will be extremely important to understand for our future journey into javascript.
React uses a component-based strategy, for “components” that must be rendered in a browser window. You will often find yourself in situations where you hook up an event handler in one “component”, but actually execute the handler code in another. Here it’s important that we can control which this are used.

- Write, run and UNDERSTAND the example below:

        var greeter = function(){
        console.log(this.message);
        };
        var comp1 = { message: "Hello World" };
        var comp2 = { message: "Hi" };

        var g1 = greeter.bind(comp1 );//We can store a reference, with a specific “this” to use
        var g2 = greeter.bind(comp2 );//And here another “this”
        setTimeout(g1,500);
        setTimeout(g2,1000);
