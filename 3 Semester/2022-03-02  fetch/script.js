// npm install
// npm i node-fetch

// add to package.json
// "type": "module"

import fetch from "node-fetch";

let url1 = "https://api.instantwebtools.net/v1/airlines";
let url2 = "https://alekw.dk/MovieApp/api/movie/all";
let url2post = "https://alekw.dk/MovieApp/api/movie";

// POST
const body = {
    year: "6946",
    title: "Another one",
    actors: ["Someone", "Nobody", "Mr. Unknown"],
};

fetch(url2post, {
    method: "post",
    body: JSON.stringify(body),
    headers: { "Content-Type": "application/json" },
});

// Wait for response before continueing
/*
const response = await fetch(url2post, {
	method: 'post',
	body: JSON.stringify(body),
	headers: {'Content-Type': 'application/json'}
});
const data = await response.json();
console.log(data);
*/

// FETCH
fetch(url2)
    .then((result) => result.json())
    .then((data) => console.log(data));
