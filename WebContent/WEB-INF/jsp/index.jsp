<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page import="com.workshops.database.WS_TEAM"%>
<%@ page import="java.util.List"%>

<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
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
				<button 
				onclick="document.getElementById('id02').style.display='block'"
				style="width: auto;">Register</button>
		</div>
	</div>



	<div id="id01" class="modal">
		<form class="modal-content animate" role="form" method="POST"
			action="welcome">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<label for="username" class="col-md-2 control-label">Username</label>
				<div class="col-md-9">
					<input id="usernsme" type="text" class="form-control"
						name="username" value="" required autofocus>
				</div>
				<label for="password" class="col-md-2 control-label">Password</label>

				<div class="col-md-9">
					<input id="password" type="password" class="form-control"
						name="password" required>
				</div>
				<div class="form-group">
					<div class="col-md-1 col-md-offset-2">
						<button type="submit" class="btn btn-success btn-md">Login</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div id="id02" class="modal">
		<form class="modal-content animate" role="form" method="POST"
			action="register">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id02').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<div class="form-group">
					<label class="control-label col-md-2 ">Team</label>
					<table class="col-md-9">
						<tr class="col-md-7">
							<%
								for (WS_TEAM WS_TEAM : list_WS_TEAM) {
							%>
							<td class="col-md-2"><input type="radio" name="team"
								value="<%=WS_TEAM.getTEAM_ID()%>"></input> <label
								style="font-size: 5px" class="control-label"><%=WS_TEAM.getTEAM_NAME()%></label></td>
							<%
								}
							%>
						</tr>
						<tr class="col-md-6">
							<%
								for (WS_TEAM WS_TEAM : list_WS_TEAM) {
							%>
							<td class="col-md-2"><img
								src="data:image/jpeg;base64,<%=WS_TEAM.getTEAM_IMAGE()%>"
								alt='<%=WS_TEAM.getTEAM_NAME()%>' width="90px;"></td>

							<%
								}
							%>
						</tr>

					</table>
				</div>
				<label for="usernsme_re" class="col-md-2 control-label">Username</label>
				<div class="col-md-9">
					<input id="usernsme" type="text" class="form-control"
						name="username_re" value="" required autofocus>
				</div>
				<label for="password" class="col-md-2 control-label">Password</label>
				<div class="col-md-9">
					<input id="password" type="password" class="form-control"
						name="password_re" required>
				</div>

				<label for="name" class="col-md-2 control-label">Player name</label>
				<div class="col-md-9">
					<input id="playername" type="text" class="form-control"
						name="playername_re" required>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label">Gender</label>
					<div class="col-md-9">
						<input type="radio" name="gender" value="0" checked>&nbsp;Male</input>
						<input type="radio" name="gender" value="1">&nbsp;Female</input>
					</div>
				</div>

				<div class="col-md-2 ">
					<button type="submit" class="btn btn-success ">Register</button>
				</div>
			</div>
		</form>
	</div>


</body>
</html>