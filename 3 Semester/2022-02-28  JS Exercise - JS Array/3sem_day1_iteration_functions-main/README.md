# Excercise

## How to
Everything should be included in this repo for you to run this. But You need to have Nodejs installed on your machine.

From your terminal, navigate to the root of this project, and run `node assignment.js`. If everything is in order, you should see 'Running assignment...' in your terminal.

You can console.log your returned results in order to see them in the terminal.

## Basic filtering
Your first assignment is about basic filtering.

In assignment.js I have imported a dummy data set, containing an array of transactions. And I have started the assignment with defining the function `filterFunction`, you are to finish this function so it returns a filtered list of transactions that fulfills these requirements:
 1. 'credit_card_company' is 'VISA'
 2. 'transaction_date' is 2015 or later
 3. price is 50 or above


 ## Above average
 Your second assignment is a bit more advanced. 

 Here you are to finish the function `aboveAverageFunction` so it returns a new instance of the original array, where each entry has received a new boolean attribute `isPriceAboveAverage` stating if this entries price is above the average.

 The average is to be calculated from all the entries in the transactions array.

 ### Example input:
 ```
 [
    {
        credit_card_company: 'American Express',
        'iso-8601': '2018-03-17T05:51:36.152+01:00',
        price: '90.95',
        category: 'Home'
    },
    {
        credit_card_company: 'Discover',
        'iso-8601': '2021-01-30T19:24:01.120+01:00',
        price: '124',
        category: 'Clothing'
    },
]
 ```

 ### Example output:
 ```
 [
    {
        credit_card_company: 'American Express',
        'iso-8601': '2018-03-17T05:51:36.152+01:00',
        price: '90.95',
        category: 'Home',
        isPriceAboveAverage: false,
    },
    {
        credit_card_company: 'Discover',
        'iso-8601': '2021-01-30T19:24:01.120+01:00',
        price: '124',
        category: 'Clothing',
        isPriceAboveAverage: true,
    },
]
 ```


