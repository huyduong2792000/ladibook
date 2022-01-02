<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fi">
<head>
<title>Dashboard | Thêm quyền</title>
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
						<form action="create" method="post"
							enctype="multipart/form-data">
						<div class="panel-heading"
							style="display: flex; justify-content: space-between;">
							<h3 class="panel-title">Thêm quyền</h3>
							<div>							
								<a class="btn btn-warning" href="/ladibook/admin/role/list"
									style="padding: 2px 10px; text-decoration: none; border: none; margin-right: 10px; height: 25px;">Back</a>
								<button type="submit" class="btn btn-success"
													style="background-color: #41B314; padding: 2px 10px; text-decoration: none; border: none; height: 25px;">Create</button>
							</div>
						</div>
						
							<div class="row"
								style="display: flex; justify-content: space-between;">
								<table style="margin: auto; margin-left: 60px;" class="col-md-6">
										<tr>
											<th>Tên:</th>
											<td><input type="text" class="form-control"
												style="height: 30px;"
												placeholder="Tên đầy đủ..." name="roleName"
												value="${result.roleName}" />
											</td>
										</tr>
										<tr>
											<th>Các quyền hạn:</th>
										</tr>
										
								</table>
								
								
							</div>
							
							<div class="row panel-body no-padding"
								style="display: flex; justify-content: space-between;">
									<table style="margin: auto; margin-left: 60px;" class="col-md-6 table">
											<thead>
												<tr>
													<th ><input type="checkbox" name="all" id="checkAll"
														style="cursor: pointer;" /></th>
													<th style="margin: auto;">Tên quyền hạn</th>
												</tr>
											</thead>
											<c:forEach items="${allPermissions}" var="permission" varStatus="loop">
																					
												<tr>
													<c:set var="contains" value="false" />
													<c:forEach var="permissionOfRole" items="${result.permissions}">
													  <c:if test="${permissionOfRole.id eq permission.id}">
													    <c:set var="contains" value="true" />
													  </c:if>
													</c:forEach>
													
													
													<td style="vertical-align: middle;">
														<c:choose>
															<c:when test="${contains == true}">
															    <input
																			checked class="checkbox" type="checkbox" name="permissionIds"
																			value="${permission.id}" id="${loop.count}"
																			style="cursor: pointer;" />
															</c:when>
															<c:otherwise>
																<input
																			class="checkbox" type="checkbox" name="permissionIds"
																			value="${permission.id}" id="${loop.count}"
																			style="cursor: pointer;" />
															</c:otherwise>
														</c:choose>
													</td>
													<td style="vertical-align: middle;">${permission.permissionName}</td>
												</tr>
											</c:forEach>
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

</html>