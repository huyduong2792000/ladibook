<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>LadiBook | Đơn hàng</title>
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
													<h3 class="panel-title">Danh sách đơn hàng</h3>
													<p class="demo-button">
														<a class="btn btn-success" href="list"
															style="background-color: #d9534f; padding: 4px 8px; text-decoration: none; border: none; margin-left: 7px">
															Tất cả</a> <a class="btn btn-success"
															href="list?status=create"
															style="background-color: #41B314; padding: 4px 8px; text-decoration: none; border: none; margin-left: 7px;">
															Mới yêu cầu</a> 
															<a class="btn btn-success"
															href="list?status=processing"
															style="background-color: #41B314; padding: 4px 8px; text-decoration: none; border: none; margin-left: 7px;">
															Đang xử lý</a>
															<a class="btn btn-info"
															href="list?status=done"
															style="background-color: #E4CB10; padding: 4px 8px; text-decoration: none; border: none; margin-left: 5px;">
															Đã xong
														</a>
													</p>
													<div class="right">
														<button type="submit">
															<span class="label label-danger"
																style="font-size: 15px; margin-right: 15px;">Delete</span>
														</button>
														<a href="mail-editor"><span class="label label-success"
															style="font-size: 15px;">Gửi mail</span></a>
													</div>
												</div>
												<div class="panel-body no-padding">
													<table class="table" style="margin: auto;">
														<thead>
															<tr>
																<th><input type="checkbox" name="all" id="checkAll"
																	style="cursor: pointer;" /></th>
																<th>Mã yêu cầu</th>
																<th>Landingpage</th>
																<th>Trạng thái</th>
																<th>Người phụ trách</th>
																<th style="width: 22%;">Email khách hàng</th>
																<th>Edit</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${results}" varStatus="loop"
																var="order">
																<tr>
																	<td style="vertical-align: middle;"><input
																		class="checkbox" type="checkbox" name="id"
																		value="${order.id}" id="${loop.count}"
																		style="cursor: pointer;" /></td>
																	<td style="vertical-align: middle;">${order.id}</td>
																	<td style="vertical-align: middle;">
																	<a target="_blank" href="${order.landingPage.domain}">
																	<img
																		style="width: 75px" src="${order.landingPage.thumbnailUrl}">
																	</a>
																	</td>
																	<td style="vertical-align: middle;">${order.status}</td>
																	<td style="vertical-align: middle;">${order.employee.email}</td>
																	<td style="vertical-align: middle;">
																			${order.customer.email}
<%-- 																		<c:forEach items="${order.customers}" varStatus="loop" var="customer"> --%>
<%-- 																			<span>${customer.email}</span><br> --%>
<%-- 																		</c:forEach> --%>
																	</td>
																	<td style="vertical-align: middle;"><a
																		href="${order.id}"> <span
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