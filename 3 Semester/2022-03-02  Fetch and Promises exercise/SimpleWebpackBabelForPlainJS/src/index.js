import "./style.css";
import "bootstrap/dist/css/bootstrap.css";
import * as bootstrap from "bootstrap";
import "@popperjs/core";
import "./jokeFacade";
import jokeFacade from "./jokeFacade";
// import fetch from "node-fetch";

document.getElementById("all-content").style.display = "block";

/* 
  Add your JavaScript for all exercises Below or in separate js-files, which you must the import above
*/

/* JS For Exercise-1 below */
const allJokes = jokeFacade.getJokes();
const jokeList = document.getElementById("jokes");
const jokeSearch = document.getElementById("joke-search");
const jokeButton = document.getElementById("joke-button");
const jokePara = document.getElementById("joke-para");
const jokeText = document.getElementById("joke-text");
const jokeSubmit = document.getElementById("joke-submit");
updateJokes();

function updateJokes() {
    while (jokeList.lastChild) {
        jokeList.removeChild(jokeList.lastChild);
    }

    allJokes.forEach((element) => {
        var entry = document.createElement("li");
        entry.appendChild(document.createTextNode(element));
        jokeList.appendChild(entry);
    });
}

jokeButton.addEventListener(
    "click",
    function (event) {
        event.preventDefault();
        jokePara.innerHTML = allJokes[jokeSearch.value];
        jokeSearch.value = "";
    },
    false
);

jokeSubmit.addEventListener("click", function (event) {
    event.preventDefault();
    jokeFacade.addJoke(jokeText.value);
    updateJokes();
});

/* JS For Exercise-2 below */
document
    .getElementById("chuck-button")
    .addEventListener("click", function (event) {
        fetch("https://api.chucknorris.io/jokes/random")
            .then((result) => result.json())
            .then(
                (data) =>
                    (document.getElementById("chuck-p").innerHTML = data.value)
            );
    });

/* JS For Exercise-3 below */

/* 
Do NOT focus on the code below, UNLESS you want to use this code for something different than
the Period2-week2-day3 Exercises
*/

function hideAllShowOne(idToShow) {
    document.getElementById("about_html").style = "display:none";
    document.getElementById("ex1_html").style = "display:none";
    document.getElementById("ex2_html").style = "display:none";
    document.getElementById("ex3_html").style = "display:none";
    document.getElementById(idToShow).style = "display:block";
}

function menuItemClicked(evt) {
    const id = evt.target.id;
    switch (id) {
        case "ex1":
            hideAllShowOne("ex1_html");
            break;
        case "ex2":
            hideAllShowOne("ex2_html");
            break;
        case "ex3":
            hideAllShowOne("ex3_html");
            break;
        default:
            hideAllShowOne("about_html");
            break;
    }
    evt.preventDefault();
}
document.getElementById("menu").onclick = menuItemClicked;
hideAllShowOne("about_html");
