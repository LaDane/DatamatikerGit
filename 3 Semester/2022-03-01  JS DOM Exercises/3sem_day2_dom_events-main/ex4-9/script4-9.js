document.body.onload = startup;

function startup() {
    handleDivClicks("#outer");
    // handleDivClicks("#div2");
}

function handleDivClicks(id) {
    document.querySelector(id).addEventListener('click', (event) => {
        const log = document.getElementById('log');
        // const target = event.target
        // console.log(`Hi from ${target.id}`);
        log.textContent += ` ${event.target.id}`;
    })
}