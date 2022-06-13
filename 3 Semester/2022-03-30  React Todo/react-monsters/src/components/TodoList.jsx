import React from "react";
import PropTypes from "prop-types";
import Todo from "./Todo";

const TodoList = ({ todos }) => {
	return (
		<div>
			{todos.map((todo) => {
				return <Todo key={todo.id} todo={todo.todo} isDone={todo.isDone} />;
			})}
		</div>
	);
};

TodoList.propTypes = {
	todos: PropTypes.array.isRequired,
};

export default TodoList;
