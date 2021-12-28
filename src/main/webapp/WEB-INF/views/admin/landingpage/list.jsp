<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>LadiBook | My Landingpage</title>
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
<style>
	th {
		text-align: center
	}
	
	.dropbtn {
	  color: #8a8a8a;
	  padding: 16px;
	  font-size: 16px;
	  border: none;
	  cursor: pointer;
	}
	
	.dropbtn:hover, .dropbtn:focus {
	  color: black;
	}
	
	.ladi-menu {
	  position: relative;
	  display: inline-block;
	}
	
	.dropdown-content {
	  display: none;
	  position: absolute;
	  background-color: #f1f1f1;
	  min-width: 160px;
	  overflow: auto;
	  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	  z-index: 1;
	}
	
	.dropdown-content a {
	  color: black;
	  padding: 12px 16px;
	  text-decoration: none;
	  display: block;
	}
	
	.ladi-menu a:hover {color: black;}
	
	.show {display: block;}
</style>
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
													<h3 class="panel-title">MY LANDINGPAGE</h3>
													<div class="dropdown">
														<p class="demo-button">
															<a class="btn btn-success" href="list"
																style="background-color: #d9534f; padding: 4px 8px; text-decoration: none; border: none; margin-left: 7px">
																Tất cả</a> <a class="btn btn-success"
																href="list?status=active"
																style="background-color: #41B314; padding: 4px 8px; text-decoration: none; border: none; margin-left: 7px;">
																Đang hoạt động</a> <a class="btn btn-info"
																href="list?status=deactive"
																style="background-color: #E4CB10; padding: 4px 8px; text-decoration: none; border: none; margin-left: 5px;">
																Dừng hoạt động
															</a>
														</p>
														<div class="right">
															<button type="submit">
																<span class="label label-danger"
																	style="font-size: 15px; margin-right: 15px;">Delete</span>
															</button>
															<a href="/ladibook/admin/template/list"><span class="label label-success"
																style="font-size: 15px;">Create</span></a>
														</div>
												</div>
												<div class="panel-body no-padding">
													<table class="table" style="margin: auto; text-align: center;">
														<thead>
															<tr>
																<th  style="margin: auto; text-align: left;">
																<input type="checkbox" name="all" id="checkAll"
																	style="cursor: pointer;" /></th>
																<th style="width: 10%;">Thumbnail</th>
																<th>Thông tin</th>
																<th>Số lượt xem</th>
																<th>Số lượt order</th>
																<th>Tỷ lệ chuyển đổi</th>
																<th style="width: 20px"></th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${results}" varStatus="loop"
																var="landingpage">
																<tr>
																	<td style="vertical-align: middle; ">	
																	<input
																		class="checkbox" type="checkbox" name="id"
																		value="${landingpage.id}" id="${loop.count}"
																		style="cursor: pointer;" />
																	</td>
																																			
																	<td style="vertical-align: middle;"><img
																		style="width: 75px" src="${landingpage.thumbnailUrl}"></td>
																		
																	<td style="vertical-align: middle;">
																		<span>
																			${landingpage.landingPageName}(${landingpage.status})
																		</span><br>
																		<c:choose>
																		    <c:when test="${landingpage.domain!=null}">
																		    	<a target="_blank" href="${landingpage.domain}">
																		    		${landingpage.domain}
																		    	</a>
																		        <br />
																		    </c:when>    
																		    <c:otherwise>
																		    	<a target="_blank" href="/ladibook/landingpage/${landingpage.id}">
																		    		Xem
																		    	</a>
																		        <br />
																		    </c:otherwise>
																		</c:choose>
<%-- 																		<span>Last update: ${landingpage.updatedAt}</span> --%>
																	</td>
																	
																	<td style="vertical-align: middle;">${landingpage.viewCount}</td>
																	
																	<td style="vertical-align: middle;">${landingpage.orderCount}</td>
																	
																	<td style="vertical-align: middle;">${landingpage.orderPercent}%</td>
																	
																	<td style="vertical-align: middle;">
																		<div class="ladi-menu ">
																		  <div 
																		  	class="dropbtn fas fa-ellipsis-h"
																		  	onclick="return invokeDropdown(${landingpage.id})"
																		  >
																		  </div>
																		  <div id="myDropdown-${landingpage.id}" class="dropdown-content">
																		    <a href="/ladibook/admin/order/list?landingpageId=${landingpage.id}">Xem các yêu cầu</a>
																		    <a href="">Đặt domain</a>
																		  </div>
																		</div>
																	</td>
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
   <script>
	/* When the user clicks on the button, 
	toggle between hiding and showing the dropdown content */
	function invokeDropdown(landingPageId){
	  document.getElementById("myDropdown-" + landingPageId).classList.toggle("show");
	}
	
	// Close the dropdown if the user clicks outside of it
	window.onclick = function(event) {
	  if (!event.target.matches('.dropbtn')) {
	    var dropdowns = document.getElementsByClassName("dropdown-content");
	    var i;
	    for (i = 0; i < dropdowns.length; i++) {
	      var openDropdown = dropdowns[i];
	      if (openDropdown.classList.contains('show')) {
	        openDropdown.classList.remove('show');
	      }
	    }
	  }
	}
	</script>
</body>
</body>
</html>