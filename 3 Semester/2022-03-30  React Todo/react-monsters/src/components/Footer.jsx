import PropTypes from "prop-types";
import React from "react";

function Footer({ footerText }) {
	return (
		<footer style={footer}>
			<h3 style={text}>{footerText}</h3>
			<a href="https://www.bmw.com/en/index.html">
				<i className="fa fa-car fa-2x" aria-hidden="true" />
			</a>
		</footer>
	);
}

Footer.propTypes = {
	footerText: PropTypes.string,
};

export default Footer;

const footer = {
	width: "100%",
	height: "80px",
	display: "flex",
	justifyContent: "center",
	background: "#80d9ff",
};

const text = {
	color: "white",
};
