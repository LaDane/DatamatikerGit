import React from "react";

function Welcome(props) {
    return <h1>Hello, {props.name}</h1>;
}

export default function MultiWelcome() {
    return (
        <div>
            <Welcome name="Sara" />
            <Welcome name="Cahal" />
            <Welcome name="Edith" />
        </div>
    );
}

export function WelcomePerson(props) {
    return (
        <div>
            <h2>First name: {props.person.firstName}</h2>
            <h2>Last name: {props.person.lastName}</h2>
            <h2>Email: {props.person.email}</h2>
        </div>
    );
}
