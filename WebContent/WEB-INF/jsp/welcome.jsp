<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.workshops.database.WS_USER_POKEDEX"%>
<%@page import="com.workshops.database.PokedexDetail"%>
<%@ page import="com.workshops.database.WS_TEAM"%>
<%@ page import="com.workshops.database.WS_USER"%>
<%@ page import="com.workshops.database.WS_POKEMON"%>
<%@ page import="com.workshops.database.HistoryDetail"%>
<%@ page import="com.workshops.database.WS_HUNT_TRANSACTION"%>
<%@ page import="com.workshops.database.WS_PURCHASE_TRANSACTION"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/welcome.css"/>" />
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" type="image/png"
	href="http://upic.me/i/bh/pikachu-png-icon-17349.png">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Unica One'
	rel='stylesheet'>
<!-- table -->

<script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet"
	href="maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
<title>Pokemon Game</title>
<style type="text/css">
.p-pokedex {
	display: block;
	-webkit-margin-before: 1em;
	-webkit-margin-start: 0px;
	-webkit-margin-end: 0px;
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
		@SuppressWarnings("unchecked")
		List<WS_TEAM> list_WS_TEAM = (List<WS_TEAM>) session.getAttribute("list_WS_TEAM");
		@SuppressWarnings("unchecked")
		List<HistoryDetail> listHistory = (List<HistoryDetail>) session.getAttribute("listHistory");
		@SuppressWarnings("unchecked")
		List<PokedexDetail> list_Pokedex = (List<PokedexDetail>) session.getAttribute("list_Pokedex");
		@SuppressWarnings("unchecked")
		List<WS_PURCHASE_TRANSACTION> list_WS_PURCHASE_TRANSACTION = (List<WS_PURCHASE_TRANSACTION>) session
				.getAttribute("list_WS_PURCHASE_TRANSACTION");
		int size = list_Pokedex.size();
		int box_size = 6;
		int box_empty = box_size - (size % box_size);
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
					<li><a href="logout"><span class="glyphicon glyphicon-log-in"></span>
							Logout</a></li>
				</ul>
			</div>
	</nav>


	<div class='container-fluid containner'>
		<div class="form-group">
			<div class="col-md-3 containnertb">

				<%
					if (WS_USER.getUSER_GENDER() == '0') {
				%>
				<img
					src="http://upic.me/i/m8/xy_oras_fullbody_experiment_by_ravenide-d8oc71d.png"
					height="350px;">
				<%
					}
				%>
				<%
					if (WS_USER.getUSER_GENDER() == '1') {
				%>
				<img src="http://upic.me/i/lz/8girl.png" height="350px;"><%} %></div>

			<div class="tabs col-md-6   containnertb">
				<ul class="tab-links ">
					<li class="active"><a href="#tab1">Dashboard</a></li>
					<li><a href="#tab2">Pokedex</a></li>
					<li><a href="#tab3">History</a></li>
					<li><a href="#tab4">Purchased</a></li>
				</ul>

				<div class="tab-content ">
					<div id="tab1" class="tab active">
						<table class="table th ">
							<thead>
								<tr>
									<td class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Team</td>
									<td class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Players</td>
									<td class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Pokemons</td>
									<td class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Pokemons/Player</td>
								</tr>
								<%
									for (WS_TEAM WS_TEAM : list_WS_TEAM) {
								%>
								<tr style="text-align: center">
									<td><label style="font-size: 5px" class="control-label"><%=WS_TEAM.getTEAM_NAME()%></label></td>
									<td><label style="font-size: 5px" class="control-label"><%=WS_TEAM.getCounting_player()%></label></td>
									<td><label style="font-size: 5px" class="control-label"><%=WS_TEAM.getSum_hunting()%></label></td>
									<td><label style="font-size: 5px" class="control-label"><%=WS_TEAM.getSum_hunting() / WS_TEAM.getCounting_player()%></label></td>
								</tr>
								<%
									}
								%>
							</thead>

						</table>
					</div>

					<div id="tab2" class="tab">
						<table 
							colspan="3">
							<tbody id="tablePokedex">
								<%
									if (size != 0) {
								%>
								<tr>
									<%
										int count_size = box_size;
											for (PokedexDetail PokedexDetail : list_Pokedex) {
												if (count_size == 0) {
													count_size = box_size;
									%>
								
								<tr>
									<%
										}
									%>
									<td style="width: 20%;"><center>
											<img
												src="data:image/jpeg;base64,<%=PokedexDetail.getPOKEMON_IMAGE()%>"
												alt='<%=PokedexDetail.getPOKEMON_NAME()%>' height="85px;">
											<p class="p-pokedex"><%=PokedexDetail.getPOKEMON_NAME()%></p>
										</center></td>
									<%
										count_size--;
											}
									%>
									<%
										while (box_empty != 0 && box_empty != box_size) {
									%>
									<td style="width: 20%;"></td>
									<%
										box_empty--;
									%>
									<%
										}
										} else {
											while (box_size != 0) {
									%>
									<td style="width: 20%;" height="85px;"></td>
									<%
										box_size--;
									%>
									<%
										}
										}
									%>
								</tr>
							</tbody>
						</table>
					</div>

					<div id="tab3" class="tab table-responsive">
						<table class="table th" id="myTable"
							class="table table-striped table-bordered" cellspacing="0"
							width="100%">
							<thead>
								<tr>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Time
									</th>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">
										Name
									</td>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Result
									</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Time</th>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Pokemon
										Name</th>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Result</th>
								</tr>
							</tfoot>
							<tbody>
								<%
									for (HistoryDetail HistoryDetail : listHistory) {
								%>
								<tr style="text-align: center" class="name">
									<td><label style="font-size: 5px" class="control-label"><%=HistoryDetail.getDATE_HUNT()%></label></td>
									<td><label style="font-size: 5px" class="control-label"><%=HistoryDetail.getPOKEMON_NAME()%></label></td>
									<td><label style="font-size: 5px" class="control-label"><%=HistoryDetail.getWIN_RESULT()%></label></td>
								</tr>

								<%
									}
								%>
							</tbody>
						</table>


					</div>

					<div id="tab4" class="tab table-responsive">
						<table class="table th" id="myTable2"
							class="table table-striped table-bordered" cellspacing="0"
							width="100%">
							<thead>
								<tr>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Time
									</th>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">
										Item
									</td>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Price(Baht)
									</th>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Transaction
										ID</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Time
									</th>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">
										Item
									</td>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Price(Baht)
									</th>
									<th class="no-event"
										style="width: 25%; text-align: center; color: #FFFFFF">Transaction
										ID</th>
								</tr>
							</tfoot>
							<tbody>
								<%
									for (WS_PURCHASE_TRANSACTION WS_PURCHASE_TRANSACTION : list_WS_PURCHASE_TRANSACTION) {
								%>
								<tr style="text-align: center" class="name">
									<td><label style="font-size: 5px" class="control-label"><%=WS_PURCHASE_TRANSACTION.getPURC_DATETIME()%></label></td>
									<td><label style="font-size: 5px" class="control-label"><%=WS_PURCHASE_TRANSACTION.getWS_SHOP().getITEM_NAME()%></label></td>
									<td><label style="font-size: 5px" class="control-label"><%=WS_PURCHASE_TRANSACTION.getWS_SHOP().getITEM_PRICE()%></label></td>
									<td><label style="font-size: 5px" class="control-label"><%=WS_PURCHASE_TRANSACTION.getTRANSACTION_ID()%></label></td>
								</tr>

								<%
									}
								%>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		<img class="col-md-2 containnertb" src="data:image/jpeg;base64,<%=WS_USER.getWS_TEAM().getTEAM_IMAGE()%>" alt='<%=WS_USER.getWS_TEAM().getTEAM_NAME()%>' height="350px;">
		</div>
	</div>

</body>
<script type="text/javascript">
	jQuery(document).ready(
			function() {
				jQuery('.tabs .tab-links a').on(
						'click',
						function(e) {
							var currentAttrValue = jQuery(this).attr('href');

							// Show/Hide Tabs
							jQuery('.tabs ' + currentAttrValue).show()
									.siblings().hide();

							// Change/remove current tab to active
							jQuery(this).parent('li').addClass('active')
									.siblings().removeClass('active');

							e.preventDefault();
						});
			});
	$('#myTable').DataTable();
	$('#myTable2').DataTable();
</script>
</html>