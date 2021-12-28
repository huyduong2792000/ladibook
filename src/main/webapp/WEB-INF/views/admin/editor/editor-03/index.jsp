<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vn"> 
<head>
	    <title>DevBook | LadiBook template</title>
	    
		<!-- Meta -->
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="Xiaoying Riley at 3rd Wave Media">    
	    <link rel="shortcut icon" href="favicon.ico"> 
	    
		<!-- Google Font -->
	    <link href="https://fonts.googleapis.com/css?family=Quicksand:700|Roboto:400,400i,700&display=swap" rel="stylesheet">
    
<!--     FontAwesome JS -->
<!--     <script defer src="/ladibook/resource/editor/editor-03/assets/fontawesome/js/all.min.js"></script> -->

		<!-- Theme CSS -->
    	<link id="theme-style" rel="stylesheet" href="/ladibook/resource/editor/editor-03/assets/css/theme.css">

		<!-- GRAPES -->
	    <link rel="stylesheet" href="/ladibook/resource/admin/assets/vendor/grapes/toastr.min.css">
	    <link rel="stylesheet" href="/ladibook/resource/admin/assets/vendor/grapes/grapes.min.css">
	    <link rel="stylesheet" href="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-preset-webpage.min.css">
	    <link rel="stylesheet" href="/ladibook/resource/admin/assets/vendor/grapes/tooltip.css">
	    <link rel="stylesheet" href="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-plugin-filestack.css">
	    <link rel="stylesheet" href="/ladibook/resource/admin/assets/vendor/grapes/demos.css">
	    <link href="/ladibook/resource/admin/assets/vendor/grapes/grapick.min.css" rel="stylesheet">
		<link href="https://unpkg.com/grapesjs@0.14.62/dist/css/grapes.min.css" rel="stylesheet"></link>
	    <script async="" src="/ladibook/resource/admin/assets/vendor/grapes/analytics.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/jquery.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/toastr.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/grapes.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-preset-webpage.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-lory-slider.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-tabs.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-custom-code.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-touch.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-parser-postcss.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-tooltip.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-tui-image-editor.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-typed.min.js"></script>
	    <script src="/ladibook/resource/admin/assets/vendor/grapes/grapesjs-style-bg.min.js"></script>

</head> 

<body>    
	<div style="display: none">
      <div class="gjs-logo-cont">
        <a href="https://grapesjs.com"><img class="gjs-logo" src="https://ps.mediacdn.vn/crop/80x80/huydq/ladibook_logo_white.png"></a>
        <div class="gjs-logo-version"></div>
      </div>
    </div>
<!--     <div style="width: 60px; height: 20vh; border-color: #d278c9; border-width: 2px; border-style: solid; border-radius: 5px; position: fixed; margin-top: 40vh; z-index: 9999;"> -->
<!-- <!--     	<div style="position: relative; height: 100px; background-color: red;"></div> -->
<!--     </div> -->
<div id="gjs" class="ladi-wraper">
    <header class="header">	    
        <div class="branding">
            <div class="container-fluid position-relative py-3">
                <div class="logo-wrapper">
	                <div class="site-logo"><a class="navbar-brand" href="index.html"><img class="logo-icon me-2" src="/ladibook/resource/editor/editor-03/assets/images/site-logo.svg" alt="logo" ><span class="logo-text">DevBook</span></a></div>    
                </div><!--//docs-logo-wrapper-->
	        
            </div><!--//container-->
        </div><!--//branding-->
    </header><!--//header-->
    
    <section class="hero-section">
	    <div class="container">
		    <div class="row">
			    <div class="col-12 col-md-7 pt-5 mb-5 align-self-center">
				    <div class="promo pe-md-3 pe-lg-5">
					    <h1 class="headline mb-3">
						    Free Book &amp; eBook <br>Landing Page Template   
					    </h1><!--//headline-->
					    <div class="subheadline mb-4">
						    A free Bootstrap 5 template for developers and programmers who want to self-publish books. Download now and start selling your book right away!
						    
					    </div><!--//subheading-->
					    
					    <div class="cta-holder row gx-md-3 gy-3 gy-md-0">
						    <div class="col-12 col-md-auto">
						        <a class="btn btn-primary w-100 order-btn" href="#form-section">Tôi quan tâm</a>
						    </div>
						    <div class="col-12 col-md-auto">
						        <a class="btn btn-secondary scrollto w-100" href="#benefits-section">Tìm hiểu thêm</a>
						    </div>
					    </div><!--//cta-holder-->
					    
					    <div class="hero-quotes mt-5">
						    <div id="quotes-carousel" class="quotes-carousel carousel slide carousel-fade mb-5" data-bs-ride="carousel" data-bs-interval="8000">
								<ol class="carousel-indicators">
									<li data-bs-target="#quotes-carousel" data-bs-slide-to="0" class="active"></li>
									<li data-bs-target="#quotes-carousel" data-bs-slide-to="1"></li>
									<li data-bs-target="#quotes-carousel" data-bs-slide-to="2"></li>
								</ol>
							  
							    <div class="carousel-inner">
								    <div class="carousel-item active">
								        <blockquote class="quote p-4 theme-bg-light">
									        "Excellent Book! Add your book reviews here consectetur adipiscing elit. Aliquam euismod nunc porta urna facilisis tempor. Praesent mauris neque, viverra quis erat vitae, auctor imperdiet nisi."     
								        </blockquote><!--//item-->
								        <div class="source row gx-md-3 gy-3 gy-md-0 align-items-center">
									        <div class="col-12 col-md-auto text-center text-md-start">
									            <img class="source-profile" src="/ladibook/resource/editor/editor-03/assets/images/profiles/profile-1.png" alt="image" >
									        </div><!--//col-->
									        <div class="col source-info text-center text-md-start">
										        <div class="source-name">James Doe</div>
										        <div class="soure-title">Co-Founder, Startup Week</div>
										    </div><!--//col-->
								        </div><!--//source-->
								    </div><!--//carousel-item-->
								    <div class="carousel-item">
								        <blockquote class="quote p-4 theme-bg-light">
									        "Highly recommended consectetur adipiscing elit. Proin et auctor dolor, sed venenatis massa. Vestibulum ullamcorper lobortis nisi non placerat praesent mauris neque"     
								        </blockquote><!--//item-->
								        <div class="source row gx-md-3 gy-3 gy-md-0 align-items-center">
									        <div class="col-12 col-md-auto text-center text-md-start">
									            <img class="source-profile" src="/ladibook/resource/editor/editor-03/assets/images/profiles/profile-2.png" alt="image" >
									        </div><!--//col-->
									        <div class="col source-info text-center text-md-start">
										        <div class="source-name">Jean Doe</div>
										        <div class="soure-title">Co-Founder, Startup Week</div>
										    </div><!--//col-->
								        </div><!--//source-->
								    </div><!--//carousel-item-->
								    <div class="carousel-item">
								        <blockquote class="quote p-4 theme-bg-light">
									        "Awesome! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam euismod nunc porta urna facilisis tempor. Praesent mauris neque, viverra quis erat vitae."     
								        </blockquote><!--//item-->
								        <div class="source row gx-md-3 gy-3 gy-md-0 align-items-center">
									        <div class="col-12 col-md-auto text-center text-md-start">
									            <img class="source-profile" src="/ladibook/resource/editor/editor-03/assets/images/profiles/profile-3.png" alt="image" >
									        </div><!--//col-->
									        <div class="col source-info text-center text-md-start">
										        <div class="source-name">Andy Doe</div>
										        <div class="soure-title">Frontend Developer, Company Lorem</div>
										    </div><!--//col-->
								        </div><!--//source-->
								    </div><!--//carousel-item-->
								</div><!--//carousel-inner-->
							</div><!--//quotes-carousel-->
							
					    </div><!--//hero-quotes-->
				    </div><!--//promo-->
			    </div><!--col-->
			    <div class="col-12 col-md-5 mb-5 align-self-center">
				    <div class="book-cover-holder">
					    <img class="img-fluid book-cover" src="/ladibook/resource/editor/editor-03/assets/images/devbook-cover.png" alt="book cover" >
					    <div class="book-badge d-inline-block shadow">
						    New<br>Release
					    </div>
				    </div><!--//book-cover-holder-->
				    <div class="text-center"><a class="theme-link scrollto" href="#reviews-section">See all book reviews</a></div>
			    </div><!--col-->
		    </div><!--//row-->
	    </div><!--//container-->
    </section><!--//hero-section-->
    
    <section id="benefits-section" class="benefits-section theme-bg-light-gradient py-5">
	    <div class="container py-5">
		    <h2 class="section-heading text-center mb-3">What Will You Get From This Book?</h2>
		    <div class="section-intro single-col-max mx-auto text-center mb-5">Section intro goes here. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit consequat consequat. Orci varius natoque penatibus et magnis. </div>
		    <div class="row text-center">
			    <div class="item col-12 col-md-6 col-lg-4">
				    <div class="item-inner p-3 p-lg-4">
					    <div class="item-header mb-3">
						    <div class="item-icon"><i class="fas fa-laptop-code"></i></div>
						    <h3 class="item-heading">Build Lorem Ipsum lobortis nec mauris habitant morbi</h3>
					    </div><!--//item-heading-->
					    <div class="item-desc">
						    List one of your book's benefits here. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer blandit consequat consequat. 
					    </div><!--//item-desc-->
				    </div><!--//item-inner-->
			    </div><!--//item-->
			    <div class="item col-12 col-md-6 col-lg-4">
				    <div class="item-inner p-3 p-lg-4">
					    <div class="item-header mb-3">
						    <div class="item-icon"><i class="fab fa-js-square"></i></div>
						    <h3 class="item-heading">Learn from lorem ipsum dolor sit amet consectetur</h3>
					    </div><!--//item-heading-->
					    <div class="item-desc">
						    List one of your book's benefits here. Orci varius natoque penatibus et magnis dis parturient montes.
					    </div><!--//item-desc-->
				    </div><!--//item-inner-->
			    </div><!--//item-->
			    <div class="item col-12 col-md-6 col-lg-4">
				    <div class="item-inner p-3 p-lg-4">
					    <div class="item-header mb-3">
						    <div class="item-icon"><i class="fab fa-rocketchat"></i></div>
						    <h3 class="item-heading">Discover phasellus id egestas tellus maximus</h3>
					    </div><!--//item-heading-->
					    <div class="item-desc">
						    List one of your book's benefits here. Orci varius natoque penatibus et magnis dis parturient montes. 
					    </div><!--//item-desc-->
				    </div><!--//item-inner-->
			    </div><!--//item-->
			    <div class="item col-12 col-md-6 col-lg-4">
				    <div class="item-inner p-3 p-lg-4">
					    <div class="item-header mb-3">
						    <div class="item-icon"><i class="fab fa-angular"></i></div>
						    <h3 class="item-heading">Master aliquet augue ac ipsum lobortis interdum</h3>
					    </div><!--//item-heading-->
					    <div class="item-desc">
						    List one of your book's benefits here. Orci varius natoque penatibus et magnis dis parturient montes. 
					    </div><!--//item-desc-->
				    </div><!--//item-inner-->
			    </div><!--//item-->
			    <div class="item col-12 col-md-6 col-lg-4">
				    <div class="item-inner p-3 p-lg-4">
					    <div class="item-header mb-3">
						    <div class="item-icon"><i class="fas fa-code-branch"></i></div>
						    <h3 class="item-heading">Deploy elementum mauris tincidunt tempus sagittis</h3>
					    </div><!--//item-heading-->
					    <div class="item-desc">
						    List one of your book's benefits here. Orci varius natoque penatibus et magnis dis parturient montes. 
					    </div><!--//item-desc-->
				    </div><!--//item-inner-->
			    </div><!--//item-->
			    <div class="item col-12 col-md-6 col-lg-4">
				    <div class="item-inner p-3 p-lg-4">
					    <div class="item-header mb-3">
						    <div class="item-icon"><i class="fas fa-hand-holding-usd"></i></div>
						    <h3 class="item-heading">Become mattis est et mauris tempus non imperdiet</h3>
					    </div><!--//item-heading-->
					    <div class="item-desc">
						    List one of your book's benefits here. Orci varius natoque penatibus et magnis dis parturient montes. 
					    </div><!--//item-desc-->
				    </div><!--//item-inner-->
			    </div><!--//item-->
		    </div><!--//row-->
	    </div><!--//container-->
    </section><!--//benefits-section-->
    
    <section id="content-section" class="content-section">
	    <div class="container">
		    <div class="single-col-max mx-auto">
		    <h2 class="section-heading text-center mb-5">What's Included</h2>
			    <div class="row">
				    <div class="col-12 col-md-6">
					    <div class="figure-holder mb-5">
						    <img class="img-fluid" src="/ladibook/resource/editor/editor-03/assets/images/devbook-devices.png" alt="image" >
					    </div><!--//figure-holder-->
				    </div><!--//col-->
				    <div class="col-12 col-md-6 mb-5">
					    <div class="key-points mb-4 text-center">
						    <ul class="key-points-list list-unstyled mb-4 mx-auto d-inline-block text-start">
							    <li><i class="fas fa-check-circle me-2"></i>List your book's content here.</li>
							    <li><i class="fas fa-check-circle me-2"></i>PDF fermentum tincidunt erat.</li>
							    <li><i class="fas fa-check-circle me-2"></i>EPUB curabitur fermentum.</li>
							    <li><i class="fas fa-check-circle me-2"></i>Lorem ipsum dolor sit amet.</li>
							    <li><i class="fas fa-check-circle me-2"></i>Praesent molestie odio risus. </li>
							    <li><i class="fas fa-check-circle me-2"></i>Kindle curabitur fermentum.</li>
							    <li><i class="fas fa-check-circle me-2"></i>Kindle curabitur fermentum.</li>
							    <li><i class="fas fa-check-circle me-2"></i>Kindle curabitur fermentum.</li>
						    </ul>
						    <div class="text-center"><a class="btn btn-primary" href="https://themes.3rdwavemedia.com/bootstrap-templates/startup/devbook-free-bootstrap-5-book-ebook-landing-page-template-for-developers/">I want this book</a></div>
					    </div><!--//key-points-->
					    
				    </div><!--//col-12-->   
			    </div><!--//row-->
		    </div><!--//single-col-max-->
	    </div><!--//container-->
    </section><!--//content-section-->
    
    <section id="audience-section" class="audience-section py-5">
	    <div class="container">
		    <h2 class="section-heading text-center mb-4">Who This Book Is For</h2>
		    <div class="section-intro single-col-max mx-auto text-center mb-5">
			    List your target readers in this section and back up with reviews. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales sit amet neque sit amet molestie. Vivamus hendrerit nisi condimentum erat tempus, vitae accumsan odio euismod.
		    </div><!--//section-intro-->
		    <div class="audience mx-auto">
			    <div class="item row gx-3">
				    <div class="col-auto item-icon"><i class="fas fa-user-check"></i></div>
				    <div class="col">
					    <h4 class="item-title">Software Developers</h4>
					    <div class="item-desc">Learn lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales sit amet neque sit amet molestie.</div>
				    </div><!--//col-->
			    </div><!--//item-->			    
			    <div class="item row gx-3">
				    <div class="col-auto item-icon"><i class="fas fa-user-check"></i></div>
				    <div class="col">
					    <h4 class="item-title">App Developers</h4>
					    <div class="item-desc">Learn lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales sit amet neque sit amet molestie.</div>
				    </div><!--//col-->
			    </div><!--//item-->			    
			    <div class="item row gx-3">
				    <div class="col-auto item-icon"><i class="fas fa-user-check"></i></div>
				    <div class="col">
					    <h4 class="item-title">Web Developers</h4>
					    <div class="item-desc">Learn lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales sit amet neque sit amet molestie.</div>
				    </div><!--//col-->
			    </div><!--//item-->
			    <div class="item row gx-3">
				    <div class="col-auto item-icon"><i class="fas fa-user-check"></i></div>
				    <div class="col">
					    <h4 class="item-title">Product Designers</h4>
					    <div class="item-desc">Learn lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales sit amet neque sit amet molestie.</div>
				    </div><!--//col-->
			    </div><!--//item-->
		    </div><!--//audience-->
	    </div><!--//container-->
    </section><!--//audience-section-->
    
    <section id="form-section" class="form-section">
	    <div class="container">
		    <div class="lead-form-wrapper single-col-max mx-auto theme-bg-light rounded p-5">
			    <h2 class="form-heading text-center">Get A Free Preview</h2>
			    <div class="form-intro text-center mb-3">Sign up to get a free preview of the book. <br>You can offer visitors free book previews to generate leads.</div>
			    <div class="form-wrapper mx-auto">					
					<form class="signup-form row g-2 align-items-center" action="/ladibook/order/save-order" method="post">
	                    <div class="col-12 col-lg-9">
	                        <input type="email" id="semail" name="customerEmails" class="form-control me-md-1 semail" placeholder="Email của bạn">
	                    </div>
	                    <div class="col-12 col-lg-3">
	                        <button type="submit" class="btn btn-primary btn-submit w-100 order-btn">Gửi</button>
	                    </div>
	                </form><!--//signup-form-->
			    </div><!--//form-wrapper-->
		    </div><!--//lead-form-wrapper-->
	    </div><!--//container-->
    </section><!--//form-section-->
    
    <section id="reviews-section" class="reviews-section py-5">
	    <div class="container">
		    <h2 class="section-heading text-center">Book Reviews</h2>
		    <div class="section-intro text-center single-col-max mx-auto mb-5">See what our readers are saying. </div>
		    <div class="row justify-content-center">
			    <div class="item col-12 col-lg-4 p-3 mb-4">
				    <div class="item-inner theme-bg-light rounded p-4">
					    
					    <blockquote class="quote">
					        "Excellent Book! Add your book review here consectetur adipiscing elit. Aliquam euismod nunc porta urna facilisis tempor. "     
				        </blockquote><!--//item-->
				        <div class="source row gx-md-3 gy-3 gy-md-0">
					        <div class="col-12 col-md-auto text-center text-md-start">
					            <img class="source-profile" src="/ladibook/resource/editor/editor-03/assets/images/profiles/profile-1.png" alt="image" >
					        </div><!--//col-->
					        <div class="col source-info text-center text-md-start">
						        <div class="source-name">James Doe</div>
						        <div class="soure-title">Co-Founder, Startup Week</div>
						    </div><!--//col-->
				        </div><!--//source-->
				        <div class="icon-holder"><i class="fas fa-quote-right"></i></div>
				    </div><!--//inner-->
			    </div><!--//item-->
			    <div class="item col-12 col-lg-4 p-3 mb-4">
				    <div class="item-inner theme-bg-light rounded p-4">
					    <blockquote class="quote">
					        "Great Book! Add your book review here consectetur adipiscing elit. Aliquam euismod nunc porta urna facilisis tempor. Praesent mauris neque."     
				        </blockquote><!--//item-->				        
				        <div class="source row gx-md-3 gy-3 gy-md-0 align-items-center">
					        <div class="col-12 col-md-auto text-center text-md-start">
					            <img class="source-profile" src="/ladibook/resource/editor/editor-03/assets/images/profiles/profile-2.png" alt="image" >
					        </div><!--//col-->
					        <div class="col source-info text-center text-md-start">
						        <div class="source-name">Jean Doe</div>
						        <div class="soure-title">Co-Founder, Company Tristique</div>
						    </div><!--//col-->
				        </div><!--//source-->
				        
				         <div class="icon-holder"><i class="fas fa-quote-right"></i></div>
				    </div><!--//inner-->
			    </div><!--//item-->
			    <div class="item col-12 col-lg-4 p-3 mb-4">
				    <div class="item-inner theme-bg-light rounded p-4">
					    <blockquote class="quote">
					        "Excellent Book! Add your book review here consectetur adipiscing elit. Pellentesque ac leo turpis. Phasellus imperdiet id ligula tempor imperdiet."     
				        </blockquote><!--//item-->
				        <div class="source row gx-md-3 gy-3 gy-md-0 align-items-center">
					        <div class="col-12 col-md-auto text-center text-md-start">
					            <img class="source-profile" src="/ladibook/resource/editor/editor-03/assets/images/profiles/profile-3.png" alt="image" >
					        </div><!--//col-->
					        <div class="col source-info text-center text-md-start">
						        <div class="source-name">Tom Doe</div>
						        <div class="soure-title">Product Designer, Company Lorem</div>
						    </div><!--//col-->
				        </div><!--//source-->
				         <div class="icon-holder"><i class="fas fa-quote-right"></i></div>
				    </div><!--//inner-->
			    </div><!--//item-->
			    <div class="item col-12 col-lg-4 p-3 mb-4">
				    <div class="item-inner theme-bg-light rounded p-4">
					    <blockquote class="quote">
					        "Another book review here consectetur adipiscing elit. Pellentesque ac leo turpis. Phasellus imperdiet id ligula tempor imperdiet."     
				        </blockquote><!--//item-->
				        <div class="source row gx-md-3 gy-3 gy-md-0 align-items-center">
					        <div class="col-12 col-md-auto text-center text-md-start">
					            <img class="source-profile" src="/ladibook/resource/editor/editor-03/assets/images/profiles/profile-4.png" alt="image" >
					        </div><!--//col-->
					        <div class="col source-info text-center text-md-start">
						        <div class="source-name">Alice Doe</div>
						        <div class="soure-title">App Developer, Company Ipsum</div>
						    </div><!--//col-->
				        </div><!--//source-->
				        <div class="icon-holder"><i class="fas fa-quote-right"></i></div>
				    </div><!--//inner-->
			    </div><!--//item-->
			    <div class="item col-12 col-lg-4 p-3 mb-4">
				    <div class="item-inner theme-bg-light rounded p-4">
					    <blockquote class="quote">
					        "Another book review here consectetur adipiscing elit. Pellentesque ac leo turpis. Phasellus imperdiet id ligula tempor imperdiet."     
				        </blockquote><!--//item-->
				        <div class="source row gx-md-3 gy-3 gy-md-0 align-items-center">
					        <div class="col-12 col-md-auto text-center text-md-start">
					            <img class="source-profile" src="/ladibook/resource/editor/editor-03/assets/images/profiles/profile-5.png" alt="image" >
					        </div><!--//col-->
					        <div class="col source-info text-center text-md-start">
						        <div class="source-name">Sam Doe</div>
						        <div class="soure-title">Co-Founder, Company Integer</div>
						    </div><!--//col-->
				        </div><!--//source-->
				        <div class="icon-holder"><i class="fas fa-quote-right"></i></div>
				    </div><!--//inner-->
			    </div><!--//item-->
		    </div><!--//row-->
		    <div class="text-center">
		        <a class="btn btn-primary" href="https://themes.3rdwavemedia.com/bootstrap-templates/startup/devbook-free-bootstrap-5-book-ebook-landing-page-template-for-developers/">Get Your Copy Today</a>
		    </div>
	    </div><!--//container-->
    </section><!--//reviews-section-->
    
    <section id="author-section" class="author-section section theme-bg-primary py-5">
	    <div class="container py-3">
		    <div class="author-profile text-center mb-5">
			    <img class="author-pic" src="/ladibook/resource/editor/editor-03/assets/images/profiles/author-profile.png" alt="image" >
		    </div><!--//author-profile-->
		    <h2 class="section-heading text-center text-white mb-3">About The Author</h2>
		    <div class="author-bio single-col-max mx-auto">
			    <p>This book landing page template is made by product designer <a class="theme-link" href="http://themes.3rdwavemedia.com" target="_blank">Xiaoying Riley</a> for developers. You can use this template to self-publish and promote your book/ebook. You can easily use platforms such as <a class="theme-link" href="https://gumroad.com/" target="_blank">Gumroad</a> to handle your book payment and delivery.</p>
			    <p> This template is 100% FREE as long as you <strong>keep the footer attribution link</strong>. You do not have the rights to resell, sublicense or redistribute (even for free) the template on its own or as a separate attachment from any of your work. If youâd like to use this template without the footer attribution link, you can buy the <a class="theme-link" href="https://themes.3rdwavemedia.com/bootstrap-templates/startup/devbook-free-bootstrap-5-book-ebook-landing-page-template-for-developers/" target="_blank"><strong>commercial license</strong></a>.</p>
			    <div class="author-links text-center pt-4">
			        <h5 class="text-white mb-4">Follow Author</h5>
				    <ul class="social-list list-unstyled">
					    <li class="list-inline-item"><a href="https://twitter.com/3rdwave_themes"><i class="fab fa-twitter"></i></a></li>
					    <li class="list-inline-item"><a href="https://github.com/xriley"><i class="fab fa-github-alt"></i></a></li> 
			            <li class="list-inline-item"><a href="https://medium.com/@3rdwave_themes"><i class="fab fa-medium-m"></i></a></li>
			            
			            <li class="list-inline-item"><a href="https://themes.3rdwavemedia.com/"><i class="fas fa-globe-europe"></i></a></li>
			        </ul><!--//social-list-->
			    </div><!--//author-links-->
			    
		    </div><!--//author-bio-->
		    
	    </div><!--//container-->
    </section><!--//author-section-->
    
    

    <footer class="footer">

	    <div class="footer-bottom text-center py-5">

	        <!--/* This template is free as long as you keep the footer attribution link. If you'd like to use the template without the attribution link, you can buy the commercial license via our website: themes.3rdwavemedia.com Thank you for your support. :) */-->
            <small class="copyright">Designed with <i class="fas fa-heart" style="color: #fb866a;"></i> by <a class="theme-link" href="http://themes.3rdwavemedia.com" target="_blank">Xiaoying Riley</a> for developers</small>
 
	    </div>
	    
    </footer>
</div>

	<div id="info-panel" style="display:none">
      <br/>
      <svg class="info-panel-logo" xmlns="https://www.w3.org/2000/svg" version="1"><g id="gjs-logo">
        <path d="M40 5l-12.9 7.4 -12.9 7.4c-1.4 0.8-2.7 2.3-3.7 3.9 -0.9 1.6-1.5 3.5-1.5 5.1v14.9 14.9c0 1.7 0.6 3.5 1.5 5.1 0.9 1.6 2.2 3.1 3.7 3.9l12.9 7.4 12.9 7.4c1.4 0.8 3.3 1.2 5.2 1.2 1.9 0 3.8-0.4 5.2-1.2l12.9-7.4 12.9-7.4c1.4-0.8 2.7-2.2 3.7-3.9 0.9-1.6 1.5-3.5 1.5-5.1v-14.9 -12.7c0-4.6-3.8-6-6.8-4.2l-28 16.2" style="fill:none;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;stroke-width:10;stroke:#fff"/>
      </g></svg>
      <br/>
      <div class="info-panel-label">
        <b>GrapesJS Webpage Builder</b> is a simple showcase of what is possible to achieve with the
        <a class="info-panel-link gjs-four-color" target="_blank" href="https://github.com/artf/grapesjs">GrapesJS</a>
        core library
        <br/><br/>
        For any hint about the demo check the
        <a class="info-panel-link gjs-four-color" target="_blank" href="https://github.com/artf/grapesjs-preset-webpage">Webpage Preset repository</a>
        and open an issue. For problems with the builder itself, open an issue on the main
        <a class="info-panel-link gjs-four-color" target="_blank" href="https://github.com/artf/grapesjs">GrapesJS repository</a>
        <br/><br/>
        Being a free and open source project contributors and supporters are extremely welcome.
        If you like the project support it with a donation of your choice or become a backer/sponsor via
        <a class="info-panel-link gjs-four-color" target="_blank" href="https://opencollective.com/grapesjs">Open Collective</a>
      </div>
    </div>
    <div id="publish-ladibook" style='display: none'>
      <div class="info-panel-label">
        <div style="display: flex; align-items: center;">
	      	<input value="${landingpage.landingPageName}" id="ladibook-name-input" style="width: 95%; height: 50px; background-color: white; font-size: 20px;" placeholder="Nhập tên landingpage mới"/>
	        <div
	        	style="width: 50px;
			    height: 50px;
			    text-align: center;
			    line-height: 50px;
			    margin-left: 10px;
			    cursor: pointer;"
			    onclick="saveLandingpage()"
			  >
			  <i id="save-landingpage"  class="fa fa-check-circle" style="font-size: 50px; color: #d278c9;"></i>
			  </div>
        </div>
		 <div id="view-landingpage-container" style='display: none'>
		 	<br/><br/>
		 	Đã xuất bản landingpage thành công bạn có thể xem tại đây 
	        <a id="view-landingpage" class="info-panel-link gjs-four-color" target="_blank" href="/ladibook/landingpage/${landingpage.id}">Link</a>
		 </div>
      </div>
    </div>
    
    <div id="order-modal" class="order-modal">

	  <!-- Modal content -->
	  <div class="order-modal-content">
	    <span class="close">&times;</span>
	    <p>Some text in the Modal..</p>
	  </div>
	
	</div>
	<script>
	var lp = './img/';
    var plp = '//placehold.it/350x250/';
    var images = [
      lp+'team1.jpg', lp+'team2.jpg', lp+'team3.jpg', plp+'78c5d6/fff/image1.jpg', plp+'459ba8/fff/image2.jpg', plp+'79c267/fff/image3.jpg',
      plp+'c5d647/fff/image4.jpg', plp+'f28c33/fff/image5.jpg', plp+'e868a2/fff/image6.jpg', plp+'cc4360/fff/image7.jpg',
      lp+'work-desk.jpg', lp+'phone-app.png', lp+'bg-gr-v.png'
    ];
    var styles = ['/ladibook/resource/editor/editor-03/assets/css/theme.css', '/ladibook/resource/editor/editor-03/assets/css/custom.css'];
    var scripts = ['/ladibook/resource/editor/editor-03/assets/plugins/popper.min.js',
		'/ladibook/resource/editor/editor-03/assets/plugins/bootstrap/js/bootstrap.min.js',
		'/ladibook/resource/editor/editor-03/assets/plugins/smoothscroll.min.js',
		'/ladibook/resource/editor/editor-03/assets/js/main.js',
		'/ladibook/resource/editor/editor-03/assets/js/order.js',];
    
    var editor  = grapesjs.init({
      avoidInlineStyle: 1,
      height: '100vh',
      width: '100%',
      container : '#gjs',
      fromElement: 1,
      showOffsets: 1,
      assetManager: {
        embedAsBase64: 1,
        assets: images
      },
      selectorManager: { componentFirst: true },
      styleManager: { clearProperties: 1 },
		canvas: {
			'scripts': scripts,
			'styles': styles
		},
      plugins: [
        'grapesjs-lory-slider',
        'grapesjs-tabs',
        'grapesjs-custom-code',
        'grapesjs-touch',
        'grapesjs-parser-postcss',
        'grapesjs-tooltip',
        'grapesjs-tui-image-editor',
        'grapesjs-typed',
        'grapesjs-style-bg',
        'gjs-preset-webpage',
      ],
      pluginsOpts: {
        'grapesjs-lory-slider': {
          sliderBlock: {
            category: 'Extra'
          }
        },
        'grapesjs-tabs': {
          tabsBlock: {
            category: 'Extra'
          }
        },
        'grapesjs-tui-image-editor': {
            config: {
              includeUI: {
                initMenu: 'filter',
              },
              icons: {
                  'menu.normalIcon.path': '/ladibook/resource/admin/assets/vendor/grapes/icon-a.svg',
                  'menu.activeIcon.path': '/ladibook/resource/admin/assets/vendor/grapes/icon-b.svg',
                  'menu.disabledIcon.path': '/ladibook/resource/admin/assets/vendor/grapes/icon-a.svg',
                  'menu.hoverIcon.path': '/ladibook/resource/admin/assets/vendor/grapes/icon-c.svg',
                  'submenu.normalIcon.path': '/ladibook/resource/admin/assets/vendor/grapes/icon-d.svg',
                  'submenu.activeIcon.path': '/ladibook/resource/admin/assets/vendor/grapes/icon-c.svg',
                },
            }
        },
        'grapesjs-typed': {
          block: {
            category: 'Extra',
            content: {
              type: 'typed',
              'type-speed': 40,
              strings: [
                'Text row one',
                'Text row two',
                'Text row three',
              ],
            }
          }
        },
        'gjs-preset-webpage': {
          modalImportTitle: 'Import Template',
          modalImportLabel: '<div style="margin-bottom: 10px; font-size: 13px;">Paste here your HTML/CSS and click Import</div>',
          modalImportContent: function(editor) {
            return editor.getHtml() + '<style>'+editor.getCss()+'</style>'
          },
          filestackOpts: null, //{ key: 'AYmqZc2e8RLGLE7TGkX3Hz' },
          aviaryOpts: false,
          blocksBasicOpts: { flexGrid: 1 },
          customStyleManager: [{
            name: 'General',
            buildProps: ['float', 'display', 'position', 'top', 'right', 'left', 'bottom'],
            properties:[{
                name: 'Alignment',
                property: 'float',
                type: 'radio',
                defaults: 'none',
                list: [
                  { value: 'none', className: 'fa fa-times'},
                  { value: 'left', className: 'fa fa-align-left'},
                  { value: 'right', className: 'fa fa-align-right'}
                ],
              },
              { property: 'position', type: 'select'}
            ],
          },{
              name: 'Dimension',
              open: false,
              buildProps: ['width', 'flex-width', 'height', 'max-width', 'min-height', 'margin', 'padding'],
              properties: [{
                id: 'flex-width',
                type: 'integer',
                name: 'Width',
                units: ['px', '%'],
                property: 'flex-basis',
                toRequire: 1,
              },{
                property: 'margin',
                properties:[
                  { name: 'Top', property: 'margin-top'},
                  { name: 'Right', property: 'margin-right'},
                  { name: 'Bottom', property: 'margin-bottom'},
                  { name: 'Left', property: 'margin-left'}
                ],
              },{
                property  : 'padding',
                properties:[
                  { name: 'Top', property: 'padding-top'},
                  { name: 'Right', property: 'padding-right'},
                  { name: 'Bottom', property: 'padding-bottom'},
                  { name: 'Left', property: 'padding-left'}
                ],
              }],
            },{
              name: 'Typography',
              open: false,
              buildProps: ['font-family', 'font-size', 'font-weight', 'letter-spacing', 'color', 'line-height', 'text-align', 'text-decoration', 'text-shadow'],
              properties:[
                { name: 'Font', property: 'font-family'},
                { name: 'Weight', property: 'font-weight'},
                { name:  'Font color', property: 'color'},
                {
                  property: 'text-align',
                  type: 'radio',
                  defaults: 'left',
                  list: [
                    { value : 'left',  name : 'Left',    className: 'fa fa-align-left'},
                    { value : 'center',  name : 'Center',  className: 'fa fa-align-center' },
                    { value : 'right',   name : 'Right',   className: 'fa fa-align-right'},
                    { value : 'justify', name : 'Justify',   className: 'fa fa-align-justify'}
                  ],
                },{
                  property: 'text-decoration',
                  type: 'radio',
                  defaults: 'none',
                  list: [
                    { value: 'none', name: 'None', className: 'fa fa-times'},
                    { value: 'underline', name: 'underline', className: 'fa fa-underline' },
                    { value: 'line-through', name: 'Line-through', className: 'fa fa-strikethrough'}
                  ],
                },{
                  property: 'text-shadow',
                  properties: [
                    { name: 'X position', property: 'text-shadow-h'},
                    { name: 'Y position', property: 'text-shadow-v'},
                    { name: 'Blur', property: 'text-shadow-blur'},
                    { name: 'Color', property: 'text-shadow-color'}
                  ],
              }],
            },{
              name: 'Decorations',
              open: false,
              buildProps: ['opacity', 'border-radius', 'border', 'box-shadow', 'background-bg'],
              properties: [{
                type: 'slider',
                property: 'opacity',
                defaults: 1,
                step: 0.01,
                max: 1,
                min:0,
              },{
                property: 'border-radius',
                properties  : [
                  { name: 'Top', property: 'border-top-left-radius'},
                  { name: 'Right', property: 'border-top-right-radius'},
                  { name: 'Bottom', property: 'border-bottom-left-radius'},
                  { name: 'Left', property: 'border-bottom-right-radius'}
                ],
              },{
                property: 'box-shadow',
                properties: [
                  { name: 'X position', property: 'box-shadow-h'},
                  { name: 'Y position', property: 'box-shadow-v'},
                  { name: 'Blur', property: 'box-shadow-blur'},
                  { name: 'Spread', property: 'box-shadow-spread'},
                  { name: 'Color', property: 'box-shadow-color'},
                  { name: 'Shadow type', property: 'box-shadow-type'}
                ],
              },{
                id: 'background-bg',
                property: 'background',
                type: 'bg',
              },],
            },{
              name: 'Extra',
              open: false,
              buildProps: ['transition', 'perspective', 'transform'],
              properties: [{
                property: 'transition',
                properties:[
                  { name: 'Property', property: 'transition-property'},
                  { name: 'Duration', property: 'transition-duration'},
                  { name: 'Easing', property: 'transition-timing-function'}
                ],
              },{
                property: 'transform',
                properties:[
                  { name: 'Rotate X', property: 'transform-rotate-x'},
                  { name: 'Rotate Y', property: 'transform-rotate-y'},
                  { name: 'Rotate Z', property: 'transform-rotate-z'},
                  { name: 'Scale X', property: 'transform-scale-x'},
                  { name: 'Scale Y', property: 'transform-scale-y'},
                  { name: 'Scale Z', property: 'transform-scale-z'}
                ],
              }]
            },{
              name: 'Flex',
              open: false,
              properties: [{
                name: 'Flex Container',
                property: 'display',
                type: 'select',
                defaults: 'block',
                list: [
                  { value: 'block', name: 'Disable'},
                  { value: 'flex', name: 'Enable'}
                ],
              },{
                name: 'Flex Parent',
                property: 'label-parent-flex',
                type: 'integer',
              },{
                name      : 'Direction',
                property  : 'flex-direction',
                type    : 'radio',
                defaults  : 'row',
                list    : [{
                          value   : 'row',
                          name    : 'Row',
                          className : 'icons-flex icon-dir-row',
                          title   : 'Row',
                        },{
                          value   : 'row-reverse',
                          name    : 'Row reverse',
                          className : 'icons-flex icon-dir-row-rev',
                          title   : 'Row reverse',
                        },{
                          value   : 'column',
                          name    : 'Column',
                          title   : 'Column',
                          className : 'icons-flex icon-dir-col',
                        },{
                          value   : 'column-reverse',
                          name    : 'Column reverse',
                          title   : 'Column reverse',
                          className : 'icons-flex icon-dir-col-rev',
                        }],
              },{
                name      : 'Justify',
                property  : 'justify-content',
                type    : 'radio',
                defaults  : 'flex-start',
                list    : [{
                          value   : 'flex-start',
                          className : 'icons-flex icon-just-start',
                          title   : 'Start',
                        },{
                          value   : 'flex-end',
                          title    : 'End',
                          className : 'icons-flex icon-just-end',
                        },{
                          value   : 'space-between',
                          title    : 'Space between',
                          className : 'icons-flex icon-just-sp-bet',
                        },{
                          value   : 'space-around',
                          title    : 'Space around',
                          className : 'icons-flex icon-just-sp-ar',
                        },{
                          value   : 'center',
                          title    : 'Center',
                          className : 'icons-flex icon-just-sp-cent',
                        }],
              },{
                name      : 'Align',
                property  : 'align-items',
                type    : 'radio',
                defaults  : 'center',
                list    : [{
                          value   : 'flex-start',
                          title    : 'Start',
                          className : 'icons-flex icon-al-start',
                        },{
                          value   : 'flex-end',
                          title    : 'End',
                          className : 'icons-flex icon-al-end',
                        },{
                          value   : 'stretch',
                          title    : 'Stretch',
                          className : 'icons-flex icon-al-str',
                        },{
                          value   : 'center',
                          title    : 'Center',
                          className : 'icons-flex icon-al-center',
                        }],
              },{
                name: 'Flex Children',
                property: 'label-parent-flex',
                type: 'integer',
              },{
                name:     'Order',
                property:   'order',
                type:     'integer',
                defaults :  0,
                min: 0
              },{
                name    : 'Flex',
                property  : 'flex',
                type    : 'composite',
                properties  : [{
                        name:     'Grow',
                        property:   'flex-grow',
                        type:     'integer',
                        defaults :  0,
                        min: 0
                      },{
                        name:     'Shrink',
                        property:   'flex-shrink',
                        type:     'integer',
                        defaults :  0,
                        min: 0
                      },{
                        name:     'Basis',
                        property:   'flex-basis',
                        type:     'integer',
                        units:    ['px','%',''],
                        unit: '',
                        defaults :  'auto',
                      }],
              },{
                name      : 'Align',
                property  : 'align-self',
                type      : 'radio',
                defaults  : 'auto',
                list    : [{
                          value   : 'auto',
                          name    : 'Auto',
                        },{
                          value   : 'flex-start',
                          title    : 'Start',
                          className : 'icons-flex icon-al-start',
                        },{
                          value   : 'flex-end',
                          title    : 'End',
                          className : 'icons-flex icon-al-end',
                        },{
                          value   : 'stretch',
                          title    : 'Stretch',
                          className : 'icons-flex icon-al-str',
                        },{
                          value   : 'center',
                          title    : 'Center',
                          className : 'icons-flex icon-al-center',
                        }],
              }]
            }
          ],
        },
      },
    });

    editor.I18n.addMessages({
      en: {
        styleManager: {
          properties: {
            'background-repeat': 'Repeat',
            'background-position': 'Position',
            'background-attachment': 'Attachment',
            'background-size': 'Size',
          }
        },
      }
    });
//     gjs-pn-buttons
    var pn = editor.Panels;
    var modal = editor.Modal;
    var cmdm = editor.Commands;
    cmdm.add('canvas-clear', function() {
      if(confirm('Areeee you sure to clean the canvas?')) {
        var comps = editor.DomComponents.clear();
        setTimeout(function(){ localStorage.clear()}, 0)
      }
    });
    cmdm.add('set-device-desktop', {
      run: function(ed) { ed.setDevice('Desktop') },
      stop: function() {},
    });
    cmdm.add('set-device-tablet', {
      run: function(ed) { ed.setDevice('Tablet') },
      stop: function() {},
    });
    cmdm.add('set-device-mobile', {
      run: function(ed) { ed.setDevice('Mobile portrait') },
      stop: function() {},
    });

    


    // Add info command
    var mdlClass = 'gjs-mdl-dialog-sm';
    var infoContainer = document.getElementById('info-panel');
    cmdm.add('open-info', function() {
      var mdlDialog = document.querySelector('.gjs-mdl-dialog');
      mdlDialog.className += ' ' + mdlClass;
      infoContainer.style.display = 'block';
      modal.setTitle('About this demo');
      modal.setContent(infoContainer);
      modal.open();
      modal.getModel().once('change:open', function() {
        mdlDialog.className = mdlDialog.className.replace(mdlClass, '');
      })
    });
    pn.addButton('options', {
      id: 'open-info',
      className: 'fa fa-question-circle',
      command: function() { editor.runCommand('open-info') },
      attributes: {
        'title': 'About',
        'data-tooltip-pos': 'bottom',
      },
    });
    
    var currentLandingpageId = '${landingpage.id}';
    var templateNo = '${template.templateNo}';
    const saveLandingpage = async() => {
    	var page = `<!DOCTYPE html>
    	<html lang="vn">
    	<head>
    	    <title>DevBook | LadiBook template</title>
    	    <meta charset="utf-8">
    	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    	    <meta name="description" content="">
    	    <meta name="author" content="Xiaoying Riley at 3rd Wave Media">    
    	    <link rel="shortcut icon" href="favicon.ico"> 
    	    
    	    <link href="https://fonts.googleapis.com/css?family=Quicksand:700|Roboto:400,400i,700&display=swap" rel="stylesheet">\n`;

        for ( style of styles){
        	style = '<link id="theme-style" rel="stylesheet" href="' + style + '"> \n';
        	page += style;
        }
        for ( scriptjs of scripts){
        	scriptjs = '<script src="' + scriptjs + '"><' +'/script>\n';
        	page += scriptjs;
        }
        page += '<style>'+editor.getCss()+'</style>';
    	page += '</head>';
    	page += '<body>' + editor.getHtml() + '</body>';
    	page += '</html>';    	
    	
    	
    	var body = JSON.stringify({
    		pageContent: page,
    		templateNo: templateNo,
    		landingPageName: document.getElementById("ladibook-name-input").value
	    }); // string or object
    	if (currentLandingpageId){
    		var response = await fetch('/ladibook/admin/landingpage/editor/save-landingpage/' + currentLandingpageId, {
    		    method: 'PUT',
    		    body: body,
    		    headers: {
    		      'Content-Type': 'application/json'
    		    }
    		  });
    	}else{    
    		var response = await fetch('/ladibook/admin/landingpage/editor/save-landingpage', {
    		    method: 'POST',
    		    body: body,
    		    headers: {
    		      'Content-Type': 'application/json'
    		    }
    		  });
    	}
    	const res = await response.json();
    	console.log(res);
    	currentLandingpageId = res.result.id;
    	document.getElementById("view-landingpage-container").style.display = "block";
    	var viewLanding = document.getElementById('view-landingpage'); //or grab it by tagname etc
    	viewLanding.href = "/ladibook/landingpage/" + res.result.id;
    	window.history.pushState("object or string", "Title", "/ladibook/admin/landingpage/editor/${template.templateNo}/" + res.result.id);
    }
    // Add publish command
   	var publishContainer = document.getElementById('publish-ladibook');
    cmdm.add('publish-ladibook', function() {
    	var mdlDialog = document.querySelector('.gjs-mdl-dialog');
        mdlDialog.className += ' ' + mdlClass;
        publishContainer.style.display = 'block';
        modal.setTitle('Nhập tên landingpage');
        modal.setContent(publishContainer);
        modal.open();
        modal.getModel().once('change:open', function() {
        	document.getElementById("view-landingpage-container").style.display = "none";
          mdlDialog.className = mdlDialog.className.replace(mdlClass, '');
        })

    });
    pn.addButton('options', {
        id: 'export',
        className: 'fa fa-cloud-upload',
        command: function() { editor.runCommand('publish-ladibook') },
        attributes: {
          'title': 'Xuất bản',
          'data-tooltip-pos': 'bottom',
        },
      });

    // Simple warn notifier
    var origWarn = console.warn;
    toastr.options = {
      closeButton: true,
      preventDuplicates: true,
      showDuration: 250,
      hideDuration: 150
    };
    console.warn = function (msg) {
      if (msg.indexOf('[undefined]') == -1) {
        toastr.warning(msg);
      }
      origWarn(msg);
    };


    // Add and beautify tooltips
    [['sw-visibility', 'Show Borders'], ['preview', 'Preview'], ['fullscreen', 'Fullscreen'],
     ['export-template', 'Export'], ['undo', 'Undo'], ['redo', 'Redo'],
     ['gjs-open-import-webpage', 'Import'], ['canvas-clear', 'Clear canvas']]
    .forEach(function(item) {
      pn.getButton('options', item[0]).set('attributes', {title: item[1], 'data-tooltip-pos': 'bottom'});
    });
    [['open-sm', 'Style Manager'], ['open-layers', 'Layers'], ['open-blocks', 'Blocks']]
    .forEach(function(item) {
      pn.getButton('views', item[0]).set('attributes', {title: item[1], 'data-tooltip-pos': 'bottom'});
    });
    var titles = document.querySelectorAll('*[title]');

    for (var i = 0; i < titles.length; i++) {
      var el = titles[i];
      var title = el.getAttribute('title');
      title = title ? title.trim(): '';
      if(!title)
        break;
      el.setAttribute('data-tooltip', title);
      el.setAttribute('title', '');
    }

    // Show borders by default
    pn.getButton('options', 'sw-visibility').set('active', 1);


    // Store and load events
    editor.on('storage:load', function(e) { console.log('Loaded ', e) });
    editor.on('storage:store', function(e) { console.log('Stored ', e) });


    // Do stuff on load
    editor.on('load', function() {
      var $ = grapesjs.$;

      // Show logo with the version
      var logoCont = document.querySelector('.gjs-logo-cont');
      document.querySelector('.gjs-logo-version').innerHTML = 'v' + grapesjs.version;
      var logoPanel = document.querySelector('.gjs-pn-commands');
      logoPanel.appendChild(logoCont);


      // Load and show settings and style manager
      var openTmBtn = pn.getButton('views', 'open-tm');
      openTmBtn && openTmBtn.set('active', 1);
      var openSm = pn.getButton('views', 'open-sm');
      openSm && openSm.set('active', 1);

      // Add Settings Sector
      var traitsSector = $('<div class="gjs-sm-sector no-select">'+
        '<div class="gjs-sm-title"><span class="icon-settings fa fa-cog"></span> Settings</div>' +
        '<div class="gjs-sm-properties" style="display: none;"></div></div>');
      var traitsProps = traitsSector.find('.gjs-sm-properties');
      traitsProps.append($('.gjs-trt-traits'));
      $('.gjs-sm-sectors').before(traitsSector);
      traitsSector.find('.gjs-sm-title').on('click', function(){
        var traitStyle = traitsProps.get(0).style;
        var hidden = traitStyle.display == 'none';
        if (hidden) {
          traitStyle.display = 'block';
        } else {
          traitStyle.display = 'none';
        }
      });

      // Open block manager
      var openBlocksBtn = editor.Panels.getButton('views', 'open-blocks');
      openBlocksBtn && openBlocksBtn.set('active', 1);

      // Move Ad
      $('#gjs').append($('.ad-cont'));
    });
	</script>
</body>
</html> 

