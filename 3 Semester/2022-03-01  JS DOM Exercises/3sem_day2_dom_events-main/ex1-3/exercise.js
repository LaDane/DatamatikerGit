
document.body.onload = startup;

// Create div's
const div1 = document.createElement("div"); 
div1.setAttribute("id", "idDiv1");

const div2 = document.createElement("div"); 
div2.setAttribute("id", "idDiv2");

const div3 = document.createElement("div"); 
div3.setAttribute("id", "idDiv3");

const divArray = [div1, div2, div3];
const divClicked = [1, 1, 1];

function startup() {
    handleDivContent();
    handleStyling();
    handleDivClicks();
}

function handleDivContent() {
    const container = document.getElementById("container");

    divArray.forEach(el => {
        let content = document.createTextNode("Times Clicked: 0"); // give it some content
        el.appendChild(content);
        document.body.insertBefore(el, container);
    });
}

function handleStyling() {
    divArray.forEach(el => {
        el.style.backgroundColor = getRandomColor();
        el.style.padding = "30px";
        el.style.fontSize = "30px";
        el.style.textAlign = "center";
        el.style.borderRadius = "25px";
        el.style.marginTop = "25px";
        el.style.marginBottom = "25px";
        el.style.marginLeft = "200px";
        el.style.marginRight = "200px";
        el.style.fontFamily = "Arial, Helvetica, sans-serif";
        el.style.userSelect = "none";
    });
}

function handleDivClicks() {
    for (let i = 0; i < divArray.length; i++) {
        divArray[i].addEventListener('click', (event) => {
            divArray[i].style.backgroundColor = getRandomColor();
            divArray[i].innerText = `Times Clicked: ${divClicked[i]++}`;
        })
    }
}

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}