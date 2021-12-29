<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fi">
<head>
<title>Dashboard | Chi tiết yêu cầu</title>
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
<script src="https://cdn.ckeditor.com/ckeditor5/31.1.0/decoupled-document/ckeditor.js"></script>

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
						<div action="send-mail" method="post"
							enctype="multipart/form-data">
						<div class="panel-heading"
							style="display: flex; justify-content: space-between;">
							<h3 class="panel-title">Send email</h3>
							<div>							
								<a class="btn btn-warning" href="/ladibook/admin/order/list"
									style="padding: 2px 10px; text-decoration: none; border: none; margin-right: 10px; height: 25px;">Back</a>
								<button onclick="sendMail()" class="btn btn-success"
													style="background-color: #41B314; padding: 2px 10px; text-decoration: none; border: none; height: 25px;">Send</button>
							</div>
						</div>
						
							<input type="hidden" id="customerId" name="customerId" value="${customerId}" />
							<div class="row"
								style="display: flex; justify-content: space-between;">
								<table style="margin: auto; margin-left: 60px;" class="col-md-6">
									<tr>
										<th>Tiêu đề:</th>
										<td><input type="text" id="title" class="form-control"
											required="required" style="height: 30px;"
											placeholder="Tiêu đề..." name="title" /></td>
									</tr>
									<tr>
										<th>Nội dung:</th>
									</tr>

									
								</table>

							</div>
							<div class="row center-block" style="margin-left:45px;margin-top:40px;">							
								<div id="toolbar-container" style="width: 90%;"></div>
								<div name="content" id="editor" style="width: 90%; height: 100px;border-width: 1px; border-color: #cecece;margin-bottom:40px;"></div>
							</div>
						</div>
					</div>

				</div>
				<div id="headline-chart" class="ct-chart"></div>
			</div>

			<!-- END OVERVIEW -->
		</div>
		<!-- END MAIN CONTENT -->
	</div>
	
	<script defer>
		var myEditor;
		DecoupledEditor
            .create( document.querySelector( '#editor' ) )
            .then( editor => {
            	myEditor = editor
                const toolbarContainer = document.querySelector( '#toolbar-container' );

                toolbarContainer.appendChild( editor.ui.view.toolbar.element );
            } )
            .catch( error => {
                console.error( error );
            } );
        
        const sendMail = async() => {
        	
        	var title = document.getElementById("title").value;
        	var customerId = document.getElementById("customerId").value;
        	var content = myEditor.getData().replace(/<[^>]+>/g, '');;
        	var body = JSON.stringify({
        		title: title,
        		content: content,
        		customerId: customerId
    	    }); // string or object
        	var response = await fetch('/ladibook/admin/order/send-mail', {
    		    method: 'POST',
    		    body: body,
    		    headers: {
    		      'Content-Type': 'application/json'
    		    }
    		  });
        	await response.json();
	        alert("Mail đã được gửi!");
        }
    </script>
	
</body>

</html>