[HOME](/README.md)

## Error Handling

- Number 7 will fail due to missing/wrong arguments. But it will fail at runtime, and not as with Java, at compile time.

- We can check arguments in JavaScript as sketched below and provide better errors by throwing our own exceptions:

```
// Will fail if n1 is undefined, or is not a number
typeof n1 === "number"
// Will fail if callback is undefined or is not a function
typeof callback === "function" 
```

</br>

1. Rewrite the Callback function expression (cb) to make a check for all its three required arguments, and throw an Error if any of the arguments do not match as explained here. 
    - Surround the call to the function with a try-catch block, and provide a more user-friendly error message if the function throws an error.