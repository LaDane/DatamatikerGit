document.body.onload = startup;

const names = [
    "Lars",
    "Peter",
    "Jan",
    "Thomas"
]

function startup() {
    addEventHandlers();
    updateList();
}

function addEventHandlers() {
    let _elements = document.getElementsByClassName('inputButton');
    for (let element of _elements) {
        element.addEventListener("click", function(event) {
            event.preventDefault();
        }, false);
    }
}

function updateList() {
    let nameListElement = document.getElementById('nameList');
    while (nameListElement.lastChild) {
        nameListElement.removeChild(nameListElement.lastChild);
    }

    names.forEach(element => {
        addListElement(element);
    });
}



function addListElement(firstname) {
    const nameList = document.getElementById('nameList');
    
    var entry = document.createElement('li');
    entry.setAttribute("class", "list-group-item");
    entry.appendChild(document.createTextNode(firstname));
    
    nameList.appendChild(entry);
}

function onClick(elem) {
    var $this = $(elem);
    var val = $this.val();
    if (val == '') {
        console.log('no input');
    } else {
        addNameToList(val);
        document.getElementById('inputField').value = "";
    }
}

function addNameToList(firstname) {
    names.push(firstname);
    updateList();
}

function onClickRemoveFirst() {
    names.shift();
    updateList();
}

function onClickRemoveList() {
    names.pop();
    updateList();
}