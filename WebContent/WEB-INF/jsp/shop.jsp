<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.workshops.database.WS_USER_POKEDEX"%>
<%@page import="com.workshops.database.PokedexDetail"%>
<%@page import="com.workshops.database.ShopDetail"%>
<%@ page import="com.workshops.database.WS_TEAM"%>
<%@ page import="com.workshops.database.WS_USER"%>
<%@ page import="com.workshops.database.WS_POKEMON"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<meta charset="utf-8">
<meta name="robots" content="noindex">
<style>
.modal-backdrop.in {
	
}
</style>
<title>Pokemon Shop</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/shop.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/shop.js" />"></script>
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
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
}
</style>

</head>
<body class="hero-image">
	<%
		WS_USER WS_USER = (WS_USER) session.getAttribute("WS_USER");
		@SuppressWarnings("unchecked")
		List<WS_TEAM> list_WS_TEAM = (List<WS_TEAM>) session.getAttribute("list_WS_TEAM");
		@SuppressWarnings("unchecked")
		List<ShopDetail> list_shop = (List<ShopDetail>) session.getAttribute("list_shop");
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

	<div class="col-md-2 col-md-offset-3 column productbox containertb"
		data-pocketslot_qty="<%=list_shop.get(0).getPOKEBALL_QTY()%>"
		data-item="<%=list_shop.get(0).getITEM_ID()%>"
		data-order="item: <%=list_shop.get(0).getITEM_NAME()%>, Qty: <%=list_shop.get(0).getPOKEBALL_QTY()%>, Price: <%=list_shop.get(0).getITEM_PRICE()%> Baht">
		<img src="http://upic.me/i/5l/76db1.png" class="img-responsive">
		<div class="producttitle"><%=list_shop.get(0).getITEM_NAME()%></div>
		<div class="productprice">
			<div class="pull-right">
				<button style="width: auto;" class="btn btn-danger btn-sm btnbuy">BUY</button>
			</div>
			<div class="pricetext"><%=list_shop.get(0).getITEM_PRICE()%>$
			</div>
		</div>
	</div>
	<div class="col-md-2 column productbox containertb"
		data-pocketslot_qty="<%=list_shop.get(1).getPOKEBALL_QTY()%>"
		data-item="<%=list_shop.get(1).getITEM_ID()%>"
		data-order="item: <%=list_shop.get(1).getITEM_NAME()%>, Qty: <%=list_shop.get(1).getPOKEBALL_QTY()%>, Price: <%=list_shop.get(1).getITEM_PRICE()%> Baht">
		<img src="http://upic.me/i/qe/dmmb3.png" class="img-responsive">
		<div class="producttitle"><%=list_shop.get(1).getITEM_NAME()%></div>
		<div class="productprice">
			<div class="pull-right">
				<button style="width: auto;" class="btn btn-danger btn-sm btnbuy">BUY</button>
			</div>
			<div class="pricetext"><%=list_shop.get(1).getITEM_PRICE()%>$
			</div>
		</div>
	</div>
	<div class="col-md-2 column productbox containertb"
		data-pocketslot_qty="<%=list_shop.get(2).getPOKEBALL_QTY()%>"
		data-item="<%=list_shop.get(2).getITEM_ID()%>"
		data-order="item: <%=list_shop.get(2).getITEM_NAME()%>, Qty: <%=list_shop.get(2).getPOKEBALL_QTY()%>, Price: <%=list_shop.get(2).getITEM_PRICE()%> Baht">
		<img src="http://upic.me/i/ex/ilqb2.png" class="img-responsive">
		<div class="producttitle"><%=list_shop.get(2).getITEM_NAME()%></div>
		<div class="productprice">
			<div class="pull-right">
				<button style="width: auto;" class="btn btn-danger btn-sm btnbuy">BUY</button>
			</div>
			<div class="pricetext"><%=list_shop.get(2).getITEM_PRICE()%>$
			</div>
		</div>
	</div>
	<div id="buy1" class="modal" role="dialog">
		<form class="modal-content animate" role="form">
			<div class="imgcontainer" data-dismiss="modal">
				<span onclick="document.getElementById('id02').style.display='none'"
					class="close" title="Close Modal">&times;</span>

			</div>
			<div class="container">
				<label class="col-md-2 control-label">Order</label>
				<div class="col-md-9">
					<label type="text" data-name="order"></label>
				</div>
				<label class="control-label col-md-2">Account Number</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="account_number"
						placeholder="account">
				</div>
				<label class="control-label col-md-2">Amount</label>
				<div class="col-md-9">
					<input type="text" class="form-control" name="amount"
						placeholder="amount">
				</div>
				<label class="control-label col-md-2">PIN</label>
				<div class="col-md-9">
					<input type="password" class="form-control" name="pin"
						placeholder="PIN">
				</div>
				<div class="form-group">
					<div class="col-md-1 col-md-offset-2">
						<button type="button" class="btn btn-primary" id="paySubmit"
							data-dismiss="modal">Pay</button>
					</div>
				</div>
			</div>
		</form>
	</div>

	<div id="confirm" class="modal" role="dialog">
		<form class="modal-content animate" role="form">
			<div class="imgcontainer" data-dismiss="modal">
				<span onclick="document.getElementById('id02').style.display='none'"
					class="close" title="Close Modal">&times;</span>

			</div>
			<div class="container">
				<div class="form-group">
					<label class="control-label col-md-2">Order</label>
					<div class="col-md-9">
						<label data-name="order"></label>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">Transaction ID</label>
					<div class="col-md-9">
						<label data-name="tran_id"></label>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">Account Number</label>
					<div class="col-md-9">
						<label data-name="account_number"></label>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">Account Name</label>
					<div class="col-md-9">
						<label data-name="account_name"></label>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2">Amount</label>
					<div class="col-md-9">
						<label data-name="amount"></label>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-1 col-md-offset-2">
						<button type="button" class="btn btn-success" id="payment_confSubmit" data-dismiss="modal">Confirm</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	<div id="modalPayment_result" class="modal" role="dialog">
		<form class="modal-content animate" role="form">
			<div class="imgcontainer" data-dismiss="modal">
				<span onclick="document.getElementById('id02').style.display='none'"
					class="close" title="Close Modal">&times;</span>
			</div>
			<div class="container">
				<div class="form-group">
					<label class="control-label col-md-1"> Msg : </label>
					<div class="col-md-9">
						<label data-name="payment_result"></label>
					</div>
				</div>
			</div>
		</form>
	</div>

	<script type="text/javascript">
		window.alert = function() {
		};
		var defaultCSS = document.getElementById('bootstrap-css');
		function changeCSS(css) {
			if (css)
				$('head > link')
						.filter(':first')
						.replaceWith(
								'<link rel="stylesheet" href="'+ css +'" type="text/css" />');
			else
				$('head > link').filter(':first').replaceWith(defaultCSS);
		}
	</script>
</body>

</html>