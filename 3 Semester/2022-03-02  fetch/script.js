
import "./style.css"
import "bootstrap/dist/css/bootstrap.css"
import * as bootstrap from 'bootstrap';
import '@popperjs/core';
import "./jokeFacade"
import jokeFacade from "./jokeFacade"

document.getElementById("all-content").style.display = "block"

/* 
  Add your JavaScript for all exercises Below or in separate js-files, which you must the import above
*/

/* JS For Exercise-1 below */
// document
//     .getElementById("fetch-button")
//     .addEventListener("click", function (event) {
//         fetch("https://alekw.dk/ca1/api/person/count")
//             .then((result) => result.json())
//             .then((data) => console.log(data));
//     });

document
.getElementById("fetch-button")
.addEventListener("click", function (event) {
  fetch(urlpost, {
    method: "post",
    body: JSON.stringify(body),
    headers: { "Content-Type": "application/json" },
    });


/* JS For Exercise-2 below */
let urlpost = "https://alekw.dk/ca1/api/person/";

// POST
const body = {
  email: "BobbyRaev@mail.dk",
  firstName: "Bobby",
  lastName: "Raev",
  addressDTO: {

    street: "Skovej",
    additionalInfo: "54",
    cityInfoDTO: {

      zipCode: "2500",
      city: "Valby"
    }
  },
  phoneList: [
    {
    number: "1029401",
    description: "Home"
  }
  ],
  hobbyDTOList: [
    {
      id: 1
    }
  ]
};

// fetch(urlpost, {
//     method: "post",
//     body: JSON.stringify(body),
//     headers: { "Content-Type": "application/json" },
// });


/* JS For Exercise-3 below */


/* 
Do NOT focus on the code below, UNLESS you want to use this code for something different than
the Period2-week2-day3 Exercises
*/

function hideAllShowOne(idToShow)
{
  document.getElementById("about_html").style = "display:none"
  document.getElementById("ex1_html").style = "display:none"
  document.getElementById("ex2_html").style = "display:none"
  document.getElementById("ex3_html").style = "display:none"
  document.getElementById(idToShow).style = "display:block"
}

function menuItemClicked(evt)
{
  const id = evt.target.id;
  switch (id)
  {
    case "ex1": hideAllShowOne("ex1_html"); break
    case "ex2": hideAllShowOne("ex2_html"); break
    case "ex3": hideAllShowOne("ex3_html"); break
    default: hideAllShowOne("about_html"); break
  }
  evt.preventDefault();
}
document.getElementById("menu").onclick = menuItemClicked;
hideAllShowOne("about_html");
