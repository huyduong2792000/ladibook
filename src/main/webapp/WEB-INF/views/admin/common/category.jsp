<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- LEFT SIDEBAR -->
	<div th:fragment="category">
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll" style="padding-top: 20px;">
				<nav>
					<ul class="nav">
						<li><a href="/ladibook/admin/home" class=""><i class="lnr lnr-home"></i>
								<span>Trang chủ</span></a></li>
						<li><a href="/ladibook/admin/landingpage/list" class=""><i
								class="lnr lnr-gift"></i> <span>Landing Pages</span></a></li>
						<li><a href="/ladibook/admin/template/list" class=""><i
								class="lnr lnr-gift"></i> <span>Giao diện mẫu</span></a></li>
<!-- 						<li><a href="/ladibook/admin/product/list" class=""><i -->
<!-- 								class="lnr lnr-gift"></i> <span>Product</span></a></li> -->
						<li><a href="/ladibook/admin/order/list" class=""><i class="lnr lnr lnr-dice"></i>
								<span>Yêu cầu khách hàng</span></a></li>
						<li><a href="/ladibook/admin/customer/list" class=""><i class="lnr lnr lnr-dice"></i>
								<span>Khách hàng</span></a></li>
						<li><a href="/ladibook/admin/user/list" class=""><i class="lnr lnr-users"></i>
								<span>Nhân viên</span></a></li>
						<li><a href="" class=""><i class="lnr lnr-cog"></i> <span>Phân quyền</span></a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<!-- END LEFT SIDEBAR -->
</body>
</html>