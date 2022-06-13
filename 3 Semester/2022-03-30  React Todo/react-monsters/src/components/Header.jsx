import PropTypes from "prop-types";
import React from "react";

const Header = ({ title }) => {
	return (
		<header style={header}>
			<h1 style={text}>{title}</h1>
		</header>
	);
};

Header.propTypes = {
	title: PropTypes.string.isRequired,
};

export default Header;

const header = {
	width: "100%",
	height: "80px",
	display: "flex",
	justifyContent: "center",
	background: "#80d9ff",
};

const text = {
	color: "white",
};
