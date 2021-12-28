<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fi">
<head>
<title>Dashboard | Klorofil - Free Bootstrap Dashboard Template</title>
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
						<div class="panel-heading"
							style="display: flex; justify-content: space-between;">
							<h3 class="panel-title">UPDATE PRODUCT</h3>
							<a class="btn btn-warning" href="product-list"
								style="background-color: #D9534F; padding: 2px 10px; text-decoration: none; border: none; margin-right: 10px; height: 25px;">Back</a>
						</div>
						<form action="${result.id}" method="post"
							enctype="multipart/form-data">
							<div class="row"
								style="display: flex; justify-content: space-between;">
								<table style="margin: auto; margin-left: 60px;" class="col-md-6">
									<tr>
										<th>Loại:</th>
										<td>
											<select name="productTypeNo">
													<c:forEach items="${allProductType}" var="productType">
														<c:choose>
															<c:when test="${productType.productTypeNo == currentProductType}">
															    <option value="${productType.productTypeNo}" selected="selected">${productType.productTypeName}</option> 
															</c:when>
															<c:otherwise>
																<option value="${productType.productTypeNo}">${productType.productTypeName}</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
											</select>
										</td>
									</tr>
									<tr>
										<th>Product name:</th>
										<td><input type="text" class="form-control"
											required="required" style="height: 30px;"
											placeholder="Enter product name..." name="productName"
											value="${result.productName}" />
										</td>
									</tr>
									<tr>
										<th>Description:</th>
										<td><textarea required="required" class="form-control"
												placeholder="Enter product description..." rows="4"
												name="description">${result.description}</textarea></td>
									</tr>
									<tr>
										<th></th>
										<td></td>
									</tr>
									<tr>
										<th></th>
										<td></td>
									</tr>
								</table>
								<table
									style="margin: auto; margin-left: 50px; margin-right: -40px;"
									class="col-md-6">
									<tr>
										<th>Quantity:</th>
										<td><input type="text" class="form-control"
											required="required" style="height: 30px; width: 230px;"
											placeholder="0" name="quantity" value="${result.quantity}" /></td>
									</tr>
									<tr>
										<th>Image:</th>
										<td>
											<img src="${result.image}"
												style="width: 20%; margin-top: -20px;"> 
											<input
												type="hidden" name="image" value="${result.image}" /> 
											<input
												type="file" name="imageFile" /> 
<!-- 											<input type="hidden" -->
<%-- 												name="image" value="${result.image}"> --%>
									</tr>
									<tr>
										<th></th>
										<td>
											<button type="submit" class="btn btn-primary"
												style="font-weight: bold;">UPDATE</button>
										</td>
									</tr>
									<tr>
										<th></th>
										<td></td>
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
</html>