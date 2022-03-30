import React from "react";
import PropTypes from "prop-types";

const Todo = ({ todo, isDone }) => {
	return (
		<div>
			<h3>{todo}</h3>
			<input type="checkbox" defaultChecked={isDone} />
		</div>
	);
};

Todo.propTypes = {
	todo: PropTypes.string.isRequired,
	isDone: PropTypes.bool.isRequired,
};

export default Todo;
