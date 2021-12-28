<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard | Klorofil - Free Bootstrap Dashboard Template</title>
<meta charset="utf-8">
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
	href="<c:url value='../resource/admin/assets/img/apple-icon.png'/>">
<link rel="icon" type="image/png" sizes="96x96"
	href="<c:url value='../resource/admin/assets/img/favicon.png'/>">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="<c:url value='../resource/css/style.css'/>">
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
							<h3 class="panel-title">CREATE NEW PRODUCT</h3>
							<a class="btn btn-warning" href="product-list"
								style="background-color: #D9534F; padding: 2px 10px; text-decoration: none; border: none; margin-right: 10px; height: 25px;">Back</a>
						</div>
						<form action="create" method="post"
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
										<th>Tên sản phẩm:</th>
										<td><input type="text" class="form-control"
											required="required" style="height: 30px;"
											placeholder="Enter product name..." name="productName" /></td>
									</tr>
									<tr>
										<th>Mô tả:</th>
										<td><textarea required="required" class="form-control"
												placeholder="Enter product description..." rows="4"
												name="description"></textarea></td>
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
<!-- 									<tr> -->
<!-- 										<th>Price:</th> -->
<!-- 										<td><input type="text" class="form-control" -->
<!-- 											required="required" style="height: 30px; width: 230px;" -->
<!-- 											placeholder="$0.00" name="price" /></td> -->
<!-- 									</tr> -->
									<tr>
										<th>Quantity:</th>
										<td><input type="text" class="form-control"
											required="required" style="height: 30px; width: 230px;"
											placeholder="0" name="quantity" /></td>
									</tr>
<!-- 									<tr> -->
<!-- 										<th>Image:</th> -->
<!-- 										<td><input type="file" required="required" -->
<!-- 											name="imageFile" /></td> -->
<!-- 									</tr> -->
									<tr>
										<th>Image:</th>
										<td><input type="text" required="required"
											name="image" value="https://itcafe.vn/wp-content/uploads/2021/01/anh-gai-xinh-4.jpg"/></td>
									</tr>
<!-- 									<tr> -->
<!-- 										<th>Sale code:</th> -->
<!-- 										<td><select name="saleId"> -->
<%-- 												<c:forEach items="${sales}" var="sale"> --%>
<%-- 													<option value="${sale.saleId}">${sale.salePercent}%</option> --%>
<%-- 												</c:forEach> --%>
<!-- 										</select> <a style="margin-left: 10px;" href="">More sale code</a></td> -->
<!-- 									</tr> -->
									<tr>
										<th></th>
										<td>
											<button type="submit" class="btn btn-primary"
												style="font-weight: bold;">CREATE</button>
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