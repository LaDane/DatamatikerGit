import { useRef, useState } from "react";
import Footer from "./components/Footer";
import Header from "./components/Header";
import TodoList from "./components/TodoList";
import "./styles/App.css";

// rafcp setup component

function App() {
	const inputRef = useRef(null);
	const [search, setSearch] = useState("");
	const [todos, setTodos] = useState([
		{
			id: 0,
			todo: "Homework",
			isDone: false,
		},
		{
			id: 1,
			todo: "Eat",
			isDone: false,
		},
		{
			id: 2,
			todo: "Sleep",
			isDone: false,
		},
	]);

	const inputTodo = (event) => {
		const value = event.target.value;
		console.log(value);
		setSearch(value);
		// console.log(inputRef.current.value);
	};

	const addTodo = () => {
		inputRef.current.focus();
	};

	const searchTodos = todos.filter((el) => el.todo.toLowerCase().includes(search));

	return (
		<div>
			<Header title={"Todo Tracker"} />

			<div className="center">
				<label htmlFor="todo" style={{ marginRight: "5px" }}>
					Add Todos
				</label>
				<input id="todo" type="text" onChange={inputTodo} ref={inputRef} />

				<button onClick={addTodo}>ADD TODO</button>

				{/* <div>
					{todos.map((el) => (
						<li key={el.id}>{el.todo}</li>
					))}
				</div> */}
				<div>
					<TodoList todos={searchTodos} />
				</div>
			</div>

			<Footer footerText={"Goodbye"} />
		</div>
	);
}

export default App;
