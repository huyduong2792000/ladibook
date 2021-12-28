<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>LadiBook | Giao diện mẫu</title>
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
	.hover-template{
		display: flex;
		justify-content: center;
  		align-items: center;
		text-align: center;
	    position: absolute;
	    top: 0;
	    left: 0;
	    height: 100%;
	    width: 100%;
	    opacity: 0;
	}
	.main-detail {
		position: relative;
	}
	.hover-template:hover{
	  opacity: 1;
	  background: rgba(0, 0, 0, 0.3)
	}
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
													<h3 class="panel-title">Giao diện mẫu</h3>
												</div>
												<div class="panel-body no-padding">
												
													<c:forEach items="${results}" varStatus="loop"
																	var="template">
														<div class="col-md-3 main-detail">
														 	<div>
	                                                           	<img style="max-width: 100%; max-height: 100%;" class="card-img-top" src="${template.thumbnail}"
	                                                               alt="Card image cap">
	                                                        <div class="hover-template">
	                                                         <a target="_blank" href="/ladibook/admin/landingpage/editor/${template.templateNo}" class="btn btn-primary">
	                                                         	Sử dụng
	                                                         </a>
	                                                        </div>
														 	</div>
	                                                        <div class="card-body">
	                                                            <h5 class="card-title"><strong>${template.templateName}</strong></h5>
	                                                         </div>
                                                       </div>   	
													</c:forEach>
													           											
												</div>
											</div>
											<nav aria-label="Page navigation example"
												style="margin-top: -30px;">
												<ul class="pagination">
													<c:forEach begin="0" end="${totalPage-1}" var="i">
														<li class="page-item"><a class="page-link"
															href="product?pageIndex=${i}"
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