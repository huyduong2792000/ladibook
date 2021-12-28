<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard | LadiBook</title>
<meta charset="utf-8">
</head>

<body>
	<div th:fragment="header">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<img src="/ladibook/resource/admin/assets/img/ladibook_logo_horizon.png"
					alt="Klorofil Logo" class="img-responsive logo" style="height: 25px;">
			</div>
			<div class="container-fluid">
				<div id="navbar-menu">
					<form class="navbar-form navbar-left">
						<div class="input-group">
							<input type="text" value="" class="form-control"
								placeholder="Search dashboard..."> <span
								class="input-group-btn"><button type="button"
									class="btn btn-primary">Go</button></span>
						</div>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="home"> <i class="fa fa-home"
								style="font-size: 18px;"></i><span> Home</span>
						</a></li>
						<li><a href="#"> <img
								src="/ladibook/resource/admin/assets/img/avatar.svg.png"
								class="img-circle" alt="Avatar"> <span>${sessionScope.username}</span>
						</a></li>
						<li><a href="../logout"> <i class="material-icons"
								style="color: red;">&#xe8ac;</i><span>Logout</span>
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!-- END NAVBAR -->
</body>
</html>