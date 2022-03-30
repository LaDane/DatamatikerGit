// import { useEffect, useLayoutEffect } from 'react';
import './styles/App.css';
import person from './components/file2';
import { males, females, persons } from './components/file2';
import HelloHeader from './components/HelloHeader';
import MultiWelcome, { WelcomePerson } from './components/file3';

function App() {
  // useLayoutEffect(() => {
  //   console.log("Hello from Layout");
  // })

  // useEffect(() => {
  //   console.log('Hello from useEffect');
  // })

  // console.log(males[0], males[1], females[0], females[1]);
  // console.log(...males, "Kurt", "Helle", ...females, "Tina");

  let person2 = {
    email: person.email,
    firstName: person.firstName,
    friends: [...males, ...females],
    gender: person.gender,
    lastName: person.lastName,
    phone: 123456
  };

  person2["test"] = "testing";

  // console.log(person2);

  return (
    <div className="App">
      <h1>Hello world</h1>
      <h2>Ex2</h2>
      <p>{person.firstName} {person.email}</p>

      <HelloHeader name="Hello there" />

      <h2>Ex3</h2>
      <MultiWelcome />
      <br />
      <WelcomePerson person={persons[0]} />
      <br />
      <WelcomePerson person={persons[1]} />
      <br />
      <WelcomePerson person={persons[2]} />

    </div>
  );
}

export default App;
