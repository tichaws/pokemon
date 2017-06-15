<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page import="com.workshops.database.WS_TEAM"%>
<%@ page import="java.util.List"%>

<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=Caveat'
	rel='stylesheet'>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/index.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/index.js" />"></script>
<link rel="icon" type="image/png"
	href="http://upic.me/i/bh/pikachu-png-icon-17349.png">
<title>Pokemon Game</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Pokemon Game</title>
<style>
body {
	font-family: 'Caveat';
	font-size: 22px;
}
</style>
</head>
<body>
	<%
		@SuppressWarnings("unchecked")
		List<WS_TEAM> list_WS_TEAM = (List<WS_TEAM>) session.getAttribute("list_WS_TEAM");
	%>
	<div class="hero-image">
		<div class="hero-text">
			<h1 style="font-size: 60px;">POKEMON GAME</h1>
			<p>Let's go start !</p>
			<button
				onclick="document.getElementById('id01').style.display='block'"
				style="width: auto;">Login</button>
			<button action="reg"
				onclick="document.getElementById('id02').style.display='block'"
				style="width: auto;">Register</button>
		</div>
	</div>
	
</body>
</html>