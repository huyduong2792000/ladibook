<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fi">
<head>
<title>Dashboard | Thông tin khách hàng</title>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- VENDOR CSS -->
<link rel="stylesheet"
	href="<c:url value='../../resource/admin/assets/vendor/bootstrap/css/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='../../resource/admin/assets/vendor/font-awesome/css/font-awesome.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='../../resource/admin/assets/vendor/linearicons/style.css'/>">
<link rel="stylesheet"
	href="<c:url value='../../resource/admin/assets/vendor/chartist/css/chartist-custom.css'/>">
<!-- MAIN CSS -->
<link rel="stylesheet"
	href="<c:url value='../../resource/admin/assets/css/main.css'/>">
<link rel="stylesheet"
	href="<c:url value='../../resource/admin/assets/css/demo.css'/>">
<!-- GOOGLE FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700"
	rel="stylesheet">

<!-- ICONS -->
<link rel="apple-touch-icon" sizes="76x76"
	href="<c:url value='../../resource/admin/assets/img/apple-icon.png'/>">
<link rel="icon" type="image/png" sizes="96x96"
	href="<c:url value='../resource/admin/assets/img/favicon.png'/>">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="<c:url value='../../resource/css/style.css'/>">
</head>
<body>
	<div id="wrapper" style="max-width: 1250px; margin: auto;">
		<%@include file="../common/header.jsp"%>
		<jsp:include page="../common/category.jsp" />
		<!-- MAIN -->
		<!-- MAIN CONTENT -->
		<div class="main">
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
					<div class="panel panel-headline">
						<form action="${result.id}" method="post"
							enctype="multipart/form-data">
						<div class="panel-heading"
							style="display: flex; justify-content: space-between;">
							<h3 class="panel-title">Thông tin khách hàng</h3>
							<div>							
								<a class="btn btn-warning" href="/ladibook/admin/order/list"
									style="padding: 2px 10px; text-decoration: none; border: none; margin-right: 10px; height: 25px;">Back</a>
								<button type="submit" class="btn btn-success"
													style="background-color: #41B314; padding: 2px 10px; text-decoration: none; border: none; height: 25px;">Update</button>
							</div>
						</div>
						
							<div class="row"
								style="display: flex; justify-content: space-between;">
								<table style="margin: auto; margin-left: 60px;" class="col-md-6">
										<tr>
											<th>Email khách hàng:</th>
											<td><input type="text" class="form-control"
												style="height: 30px;"
												placeholder="Email khách hàng..." name="email"
												value="${result.email}" />
											</td>
										</tr>
										<tr>
											<th>Tên khách hàng:</th>
											<td><input type="text" class="form-control"
												style="height: 30px;"
												placeholder="Tên khách hàng..." name="fullname"
												value="${result.fullname}" />
											</td>
										</tr>
										<tr>
											<th>Số điện thoại:</th>
											<td><input type="text" class="form-control"
												style="height: 30px;"
												placeholder="Số điện thoại khách hàng..." name="phone"
												value="${result.phone}" />
											</td>
										</tr>
										<tr>
											<th>Địa chỉ:</th>
											<td><input type="text" class="form-control"
												style="height: 30px;"
												placeholder="Địa chỉ..." name="address"
												value="${result.address}" />
											</td>
										</tr>
										<tr>
											<th>Giới tính:</th>
											<td>
												<select name="gender">
													<c:choose>
														<c:when test='${result.gender == "male"}'>
														    <option value="male" selected="selected">Male</option>
														</c:when>
														<c:otherwise>
															<option value="male">Male</option>
														</c:otherwise>
													</c:choose>
													<c:choose>
														<c:when test='${result.gender == "female"}'>
														    <option value="female" selected="selected">Female</option>
														</c:when>
														<c:otherwise>
															<option value="female">Female</option>
														</c:otherwise>
													</c:choose>
												</select>
											</td>
										</tr>
										<tr>
											<th>Mua hàng gần đây:</th>
											<td>
												<a
													href="/ladibook/admin/order/list?customerId=${contact.id}"> <span
														class="label label-warning" style="font-size: 15px;">Xem</span>
												</a>
											</td>
										</tr>
								</table>
							</div>
						</form>
					</div>

				</div>
				<div id="headline-chart" class="ct-chart"></div>
			</div>

			<!-- END OVERVIEW -->
		</div>
		<!-- END MAIN CONTENT -->
	</div>
</body>

</html>