# The JavaScript Array


Use this [link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Indexed_collections#array_object) as the main reference

This excercise is meant to introduce the JavaScript array, the only built-in list type in JavaScript (pre ES6, but still the most used by far), and the functionality it offers.
Whenever you encounter a new language the very first thing you usually should focus on is its collection framework. 
All questions are one-liners, so the main task is to figure out which method to use (hints are given for each question).

- go to ```script.js```
- to run the script type `node script.js`

***

</br>

| Array methods   | Discription   |  Link                             |
| --------------- | ------------- | --------------------------------- |
| concat() | merge two or more arrays | [link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/concat) |
| join() | creates and returns a new string by concatenating all of the elements in an array | [link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/join) |
|unshift()|adds one or more elements to the beginning of an array and returns the new length of the array.|[link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/unshift)|
|push()|adds one or more elements to the end of an array and returns the new length of the array|[link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/push)|
|shift()|removes the first element from an array|[link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/shift)|
|pop()|removes the last element from an array|[link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/pop)|
|splice()|changes the contents of an array by removing or replacing existing elements and/or adding new elements|[link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/splice)|
|reverse()|method reverses an array|[link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reverse)|
|sort()|sorts the elements of an array in place and returns the sorted array.|[link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/sort)|
|map()|creates a new array populated with the results of calling a provided function on every element in the calling array|[link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map)|
|filter()|method creates a new array with all elements that pass the test implemented by the provided function|[link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/filter)|
|spread operator||[link](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Spread_syntax)|

</br>

***

## Excercises

1. The array type has  a method concat() to merge two or more arrays (see the end of the README file for an alternative)

</br>

2. Create a new array called **all**, which should be a concatenation of the two arrays given above, starting with the boys and ending with the girls.

</br>

3. The array type has a cool method to **reduce** an array into a single string **join()** (you will love this method)
    1. Create a comma-separated string containing all the names from the all-array, separated by commas.
    2. Create a hyphen (-) separated string containing all the names from the all-array, separated by hyphens.

</br>

4. Add the names Lone and Gitte to the end of the array (remember, all can be done in one-liners)
    - Hint:  **push(..)**

</br>

5. Add the names, Hans and Kurt, to the start of the array (See end of document for a better/newer way)
    - Hint:  **unshift()**
 
</br>

6. Remove the first name in the array (Hans)
    - Hint: **shift()**

</br>

7. Remove the last name from the array (Gitte)
    - Hint: **pop(..)** 

</br>

8. Remove Ole and Janne from the middle of the array
    1. Hint: **splice(..)**

</br>

9. Sanne thinks it’s unfair that the boys have to come first, reverse the all array, so that the girls comes first.
    - Hint: **reverse()** 

</br>

10. Peter thinks that this is just as unfair and suggests that the array should be sorted. Sort the array.
    - Hint: **sort()**
    
</br>

11. The default sort algorithm doesn’t handle the situation where the name can be either capitalized or not. Write a user-defined sort method to fix this problem.

</br>

12. Convert all the names in the array to uppercase using **map()**.

</br>

13. Create a new array containing all the names that start with either “l” or “L”.
    - Hint: use the **filter** function with a sufficient callback.

</br>

***

Today you would use the **spread operator** as demonstrated below:
```
let all = [...boys, ...girls];
output: [ 'Peter', 'lars', 'Ole', 'Janne', 'hanne', 'Sanne' ] 

[...girls,  “Lone”, “Gitte”]
output: [ 'Janne', 'hanne', 'Sanne', 'Lone', 'Gitte' ]

[“Hans”, “Kurt”, … boys]
output: [ 'Hans', 'Kurt', 'Peter', 'lars', 'Ole' ]
```
