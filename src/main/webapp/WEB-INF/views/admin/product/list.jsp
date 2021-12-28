<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>LadiBook | List Product</title>
<meta charset="UTF-8">
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
	href="<c:url value='../../resource/admin/assets/img/favicon.png'/>">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<%@include file="../common/header.jsp"%>
		<jsp:include page="../common/category.jsp" />
		<!-- MAIN -->
		<!-- MAIN CONTENT -->
		<form action="delete-many" method="GET">
			<div class="main">
				<div class="main-content">
					<div class="container-fluid">
						<!-- OVERVIEW -->
						<div class="panel panel-headline">
							<div class="panel-body">
								<form action="delete-many" method="GET">
									<div class="row">
										<div class="col-md-12">
											<div class="panel">
												<div class="panel-heading">
													<h3 class="panel-title">PRODUCT LIST</h3>
													<p class="demo-button">
														<a class="btn btn-success" href="list?productType=product"
															style="background-color: #d9534f; padding: 4px 8px; text-decoration: none; border: none; margin-left: 7px">
															Sản Phẩm</a> <a class="btn btn-success"
															href="list?productType=promotion"
															style="background-color: #41B314; padding: 4px 8px; text-decoration: none; border: none; margin-left: 7px;">
															Khuyến mãi</a> <a class="btn btn-info"
															href="list?productType=service"
															style="background-color: #E4CB10; padding: 4px 8px; text-decoration: none; border: none; margin-left: 5px;">
															Dịch vụ </a> <a class="btn btn-primary"
															href="list?productType=combo"
															style="background-color: #00AAFF; padding: 4px 8px; text-decoration: none; border: none; margin-left: 5px;">
															Combo 
														</a>
													</p>
													<div class="right">
														<button type="submit">
															<span class="label label-danger"
																style="font-size: 15px; margin-right: 15px;">Delete</span>
														</button>
														<a href="create?productType=${productType}"><span class="label label-success"
															style="font-size: 15px;">Create</span></a>
													</div>
												</div>
												<div class="panel-body no-padding">
													<table class="table" style="margin: auto;">
														<thead>
															<tr>
																<th><input type="checkbox" name="all" id="checkAll"
																	style="cursor: pointer;" /></th>
																<th>ID</th>
																<th>Product Name</th>
																<th>Quantity</th>
																<th>Price</th>
																<th>PriceLabel</th>
																<th style="width: 10%;">Image</th>
																<th style="width: 22%;">Description</th>
																<th>Edit</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${results}" varStatus="loop"
																var="product">
																<tr>
																	<td style="vertical-align: middle;"><input
																		class="checkbox" type="checkbox" name="id"
																		value="${product.id}" id="${loop.count}"
																		style="cursor: pointer;" /></td>
																	<td style="vertical-align: middle;">${product.id}</td>
																	<td style="vertical-align: middle;">${product.productName}</td>
																	<td style="vertical-align: middle;">${product.quantity}</td>
																	<td style="vertical-align: middle;">${product.price}</td>
																	<td style="vertical-align: middle;">${product.priceLabel}</td>
																	<td style="vertical-align: middle;"><img
																		style="width: 70%;" src="${product.image}"></td>
																	<td style="vertical-align: middle;">${product.description}</td>
																	<td style="vertical-align: middle;"><a
																		href="${product.id}"> <span
																			class="label label-warning" style="font-size: 15px;">Update</span>
																	</a></td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
											<nav aria-label="Page navigation example"
												style="margin-top: -30px;">
												<ul class="pagination">
													<c:forEach begin="0" end="${totalPage-1}" var="i">
														<li class="page-item"><a class="page-link"
															href="?pageIndex=${i}"
															<c:if test="${pageIndex == i}">
														style="background-color: #F0AD4E; color: white;"
														</c:if>>${i+1}</a></li>
													</c:forEach>
												</ul>
											</nav>
										</div>
										<div id="headline-chart" class="ct-chart"></div>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!-- END OVERVIEW -->
				</div>
				<!-- END MAIN CONTENT -->
			</div>
		</form>
		<!-- END MAIN -->
		<div class="clearfix"></div>
		<footer>
			<div class="container-fluid">
				<p class="copyright">
					&copy; 2017 <a href="https://www.themeineed.com" target="_blank">Theme
						I Need</a>. All Rights Reserved.
				</p>
			</div>
		</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script>
            let userSelection = document.getElementsByClassName('checkbox');
            let checkAll = document.getElementById('checkAll')


            checkAll.addEventListener('click', () => {
                if (checkAll.checked == true) {
                    for (let i = 1; i <= userSelection.length; i++) {
                        document.getElementById(i).checked = true
                    }
                } else {
                    for (let i = 1; i <= userSelection.length; i++) {
                        document.getElementById(i).checked = false
                    }
                }

            })
   </script>
</body>
</body>
</html>