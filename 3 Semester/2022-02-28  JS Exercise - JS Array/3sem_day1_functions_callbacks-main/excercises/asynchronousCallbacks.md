[HOME](/README.md)

## Asynchronous Callbacks

Most of the javascript callbacks you will be using will be asynchronous, in contrary to map, filter and forEach which are synchronous (MAKE SURE you understand the difference).

1. Given the code below answer, don’t execute the code, in what order you would expect to see the outputs:

        var msgPrinter = function(msg,delay){
        setTimeout(function(){
            console.log(msg);
        },delay);
        };

        console.log("aaaaaaaaaa");
        msgPrinter ("bbbbbbbbbb",2000);
        console.log("dddddddddd");
        msgPrinter ("eeeeeeeeee",1000);
        console.log("ffffffffff");

2. Add the code to a JavaScript file, execute and verify whether you answer to 1. was right.