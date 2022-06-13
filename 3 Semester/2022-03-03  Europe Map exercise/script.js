document.body.onload = startup;

// import fetch from "node-fetch";

const apiUrl = "https://restcountries.com/v3.1/alpha/";

function startup() {
    addEventHandlers();
}

function addEventHandlers() {
    document.getElementById("svg2").addEventListener("click", function (event) {
        // event.preventDefault();      // only if button submit type
        console.log(event.target.id);
        onClickCountry(event.target.id);
    });
}

function onClickCountry(countryId) {
    fetch(apiUrl + countryId)
        .then((result) => result.json())
        .then((data) => console.log(data));
}
