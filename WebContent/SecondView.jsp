<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="edu.dtcc.csc214.aircraft.SystemDriver"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h4 {
	color: white;
}

fieldset {
	background: url(Airplane.gif) no-repeat;
	background-size: 100% 100%;
	margin-bottom: 15px;
	padding: 480px 20px 15px;
}

.controls {
	top: 350px;
	position: absolute;
}
</style>

<script>

	function initSytem() {
		
	}

	function setHeading() {
		
	}

	function setSpeed() {
		
	}

	function alertContents(httpRequest) {
		if (httpRequest.readyState == 4 && httpRequest.status == 200) {
			var data = httpRequest.responseText;
		}
	}

	function httpGet(theUrl) {
		counter = 0;
		var httpRequest = new XMLHttpRequest();
		httpRequest.onreadystatechange = function() {
			alertContents(httpRequest);
		};
		httpRequest.open("GET", theUrl, true);
		httpRequest.send(null);
	}

	var initCommandString = 'http://localhost:8080/Aircraft/GetSampleCount?sysinit=';
	var incrementHeadingCommandString = 'http://localhost:8080/Aircraft/GetSampleCount?setHeading=';
	var setSpeedCommandString = 'http://localhost:8080/Aircraft/GetSampleCount?setSpeed=';
	var getStatusCommandString = 'http://localhost:8080/Aircraft/GetSampleCount';

	setInterval(function() {
		getStatus();
	}, 3000);
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assignment 4</title>
</head>
<body>

	<%
		SystemDriver aSystemDriver = new SystemDriver();
	%>

	<h3>My Airplane Simulation</h3>

	<fieldset>
		<legend>Simulation Details</legend>

		<div class="controls">
			<button type="button" id="sysinit" onclick="initSystem()">Init
				System</button>
			<br>
			<button type="button" id="setHeading" onclick="setHeading()">Set
				Heading to 45 degrees</button>
			<br>
			<button type="button" id="setSpeed" onclick="setSpeed()">Set
				Speed to 500 miles per hour</button>

			<h4>Heading</h4>
			<input type="range" id="heading" value="180" min="-180" max="180">
			<h4>Speed</h4>
			<input type="range" id="speed" value="1000" min="400" max="1000">
		</div>

	</fieldset>


</body>
</html>