<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.workshops.database.WS_TEAM"%>
<%@ page import="com.workshops.database.WS_USER"%>
<%@ page import="com.workshops.database.WS_POKEMON"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png"
	href="http://upic.me/i/bh/pikachu-png-icon-17349.png">
<title>Pokemon Game</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/welcome.css"/>" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
.containner {
	margin-top: 2%;
}

.containnerPg {
	margin-top: 1%;
}

.containnertb {
	margin-top: 7%;
}

.containnerbt {
	margin-top: 3%;
}

.bottom {
	margin-bottom: 1.5%;
}

body, html {
	height: 100%;
	font-family: "Comic Sans MS", cursive, sans-serif;
	font-style: italic;
	background-attachment: fixed;
}

</style>
<meta name="viewport" content="width=device-width,initial-scale=1">
</head>
<body class="hero-image">
	<%
		WS_USER WS_USER = (WS_USER) session.getAttribute("WS_USER");
		WS_POKEMON WS_POKEMON = (WS_POKEMON) session.getAttribute("WS_POKEMON");
		Integer CP = (int) session.getAttribute("CP");
		@SuppressWarnings("unchecked")
		List<WS_TEAM> list_WS_TEAM = (List<WS_TEAM>) session.getAttribute("list_WS_TEAM");
	%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img
					src="http://upic.me/i/bh/pikachu-png-icon-17349.png" width="30"
					height="30" alt="">
				</a>

			</div>

			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">


				</ul>
				<ul class="nav navbar-nav">
					<li><a href="#"><span class="glyphicon"></span><label
							style="color: #FF0000">LEVEL <%=WS_USER.getCURRENT_LEVEL()%>
						</label></a></li>
				</ul>
				<div class="col-md-4 containnerPg">
					<div class="progress">
						<div class="progress-bar progress-bar-danger" role="progressbar"
							aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"
							style="width: <%=Math.ceil((WS_USER.getCURRENT_EXP() * 100.0) / WS_USER.getMAX_LEVEL_EXP())%>%"><%=(int) Math.ceil((WS_USER.getCURRENT_EXP() * 100.0) / WS_USER.getMAX_LEVEL_EXP())%>%
						</div>
					</div>
				</div>

				<ul class="nav navbar-nav">
					<li><a href="#"><span class="glyphicon"><img
								src="https://assets.jalantikus.com/assets/cache/300/300/apps/2016/07/27/pokeball-icon.png"
								width="30" height="30" alt=""></a></li>
					<li><a href="#"><span class="glyphicon"
							style="color: black"></span><%=WS_USER.getCURRENT_POCKET_SLOT()%>
							Pokeball</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<a class="navbar-brand" href="dashboard"> <img
						src="http://upic.me/i/wb/icones-png-theme-home-19.png" width="30"
						height="30" alt="">
					</a>
					<a class="navbar-brand" href="standby"> <img
						src="http://upic.me/i/ra/circle-icons-gamecontroller.svg.png"
						width="30" height="30" alt="">
					</a>
					<a class="navbar-brand" href="shop"> <img
						src="http://upic.me/i/rn/czaaa.png" width="30" height="30" alt="">
					</a>
					<li><a href="/"><span class="glyphicon glyphicon-log-in"></span>
							Logout</a></li>
				</ul>
			</div>
	</nav>
	<div class='container-fluid containner'>
		<div class="col-md-6 col-md-offset-3  containnertb" align="center">
		<form action="waepon" method="POST">
			<div>
				<label style="font-size: 15px" class="control-label"><%=WS_POKEMON.getPOKEMON_NAME()%>&nbsp;:&nbsp;CP&nbsp;<%=CP%></label>
			</div>
			<div >
				<img src="data:image/png;base64,<%=WS_POKEMON.getPOKEMON_IMAGE()%>"
					alt='<%=WS_POKEMON.getPOKEMON_NAME()%>' style="height:200px;">
			</div>

			<div class="form-group containnerPg">
				<div class="col-md-2 col-md-offset-4">
					<a href="standby" class="btn btn-primary">SKIP</a>
				</div>
				<div class="col-md-2 ">
					<button type="submit" class="btn btn-danger ">PLAY</button>
				</div>
				
			</div>
			</form>
		</div>
		
	</div>
	


</body>
</html>