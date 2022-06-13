[HOME](/README.md)

## Callbacks (with map, filter and forEach)

Let's get familiar with callbacks, using some of the array-type’s built-in methods.

</br>

1. Declare a JavaScript array and initialize it with some names (Lars, Jan, Peter, Bo, Frederik etc.). 
    - Use the filter method to create a new array with only names of length <=3.
    - Use the forEach method to iterate and print (console.log) both the original and the new array.

</br>

2. Use the names-array created above, and, using its map method, create a new array with all names uppercased.

</br>

3. Use map and join to create a function, which given the array of names, for example: ["Lars", "Peter", "Jan", "Ian"] returning a string with the HTML for the names in an \<ul> as sketched below:

        <ul>
        <li>Lars</li>
        <li>Peter</li>
        <li>Jan</li>
        <li>Ian</li>
        </ul>

   The output above was shown with newlines for readability, but this is actually what we want (why):

        <ul><li>Lars</li><li>Peter</li><li>Jan</li><li>Ian</li></ul>

</br>

4. Given this JavaScript array

        var cars = [
        { id: 1, year: 1997, make: 'Ford', model: 'E350', price: 3000 },
        { id: 2, year: 1999, make: 'Chevy', model: 'Venture', price: 4900 },
        { id: 3, year: 2000, make: 'Chevy', model: 'Venture', price: 5000 },
        { id: 4, year: 1996, make: 'Jeep', model: 'Grand Cherokee', price: 4799 },
        { id: 5, year: 2005, make: 'Volvo', model: 'V70', price: 44799 }
        ];

    -  Use the filter filter function to get arrays with only:
        - Cars newer than 1999
        - Al  Volvo’s
        - All cars with a price below 5000

</br>

5. Use map and join to implement a function, that, given the cars array used above, will create, and return a string with valid SQL statements to insert the data into a table with matching column names (id, year, make, model, price) as sketched below:

        
    ```INSERT INTO cars (id,year,make,model,price) VALUES ( 1, 1997 'Ford''E350', 3000 );```


