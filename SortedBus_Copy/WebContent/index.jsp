<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>Sorted Bus</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Taksi Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />	
<script src="js/jquery.min.js"> </script>
<!--webfonts-->
  <link href='//fonts.googleapis.com/css?family=PT+Mono|Abril+Fatface' rel='stylesheet' type='text/css'>
<!--//webfonts-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>

</head>
<body>
	<!--start-header-->
			<div id="home" class="header">
					<div class="top-header">
						<div class="container">
					     <div class="top-menu">
							<span class="menu"> </span>
								<ul class="cl-effect-16">
								 <li><a class="active" href="index.jsp" data-hover="Home">Home</a></li>									 								
								 <li><a  href="Login.jsp" data-hover="Login">Login</a></li>
								<li><a  href="about.html" data-hover="About">About</a></li>
							<!--<li><a href="typography.html" data-hover="Services">Services</a></li> -->
								<!--<li><a href="gallery.html" data-hover="Gallery">Gallery</a></li>-->
								<!--<li><a href="blog.html" data-hover="blog">Blog</a></li>-->
								<li><a href="contact.html" data-hover="Contact">Contact</a></li>
								  <div class="clearfix"></div>								
								</ul>
							</div>
							<div class="logo">
							  <a href="index.jsp"><h1>Sorted<span>Bus</span></h1></a>
						    </div>
							<!-- script-for-menu -->
								<script>
									$("span.menu").click(function(){
										$(".top-menu ul").slideToggle("slow" , function(){
										});
									});
								</script>
								<!-- script-for-menu -->
							<div class="clearfix"> </div>
					</div>
				</div>
				  <div class="banner">
					<div class="container">
						<div  id="top" class="callbacks_container">
						<ul class="rslides" id="slider4">
						<li>
									<div class="banner-info">
										<h3>We will take you</h3>
										<h4>Wherever You Need</h4>
									</div>
								</li>
								<li>
									<div class="banner-info">
									   <h3>Call Us : 800-2345-6789</h3>
										<h4>24 Hour Bus Service</h4>
									</div>
								</li>
								<li>
									<div class="banner-info">
										<h3>We will take you</h3>
										<h4>Wherever You Need</h4>
									</div>								
								</li>
							</ul>
						</div>
						<!--- banner Slider starts Here --->
					<script src="js/responsiveslides.min.js"></script>
				 <script>
					// You can also use "$(window).load(function() {"
					$(function () {
					  // Slideshow 4
					  $("#slider4").responsiveSlides({
						auto: true,
						pager:false,
						nav: true,
						speed: 500,
						namespace: "callbacks",
						before: function () {
						  $('.events').append("<li>before event fired.</li>");
						},
						after: function () {
						  $('.events').append("<li>after event fired.</li>");
						}
					  });
				
					});
				  </script>
					</div>
				
				   </div>
			</div>
		<!--//end-slider-->
		<!--start-about-->
	<div class="about">
		<div class="container">
		 <h3 class="tittle wel">Welcome to Our Bus</h3>
				<div class="about-top">
					<div class="col-md-7 about-top-right">
						<h4>Our culture - Learn, Implement, Grow - and have fun.</h4>
						<p>We regularly solicit feedback from our customers. This helps us understand what we are doing wrong and what we are getting right. This feedback is invaluable for us. And we have you, our customers, to thank for taking time off to write back to us. There are times when there are hiccups. It's a learning organization, but we are learning the ropes like our lives depend on it.</p>
						<p>It doesn't stop at that. We ensure that the same mistakes are not repeated. People are encouraged to speak their minds and they don't fear sharing their mistakes, so that everyone can benefit from the learning, no matter how small.</p>
					</div>
					<div class="col-md-5 about-top-left">
						<img src="images/inside.jpg" class="img-responsive" alt=""/>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>	 
	</div>
		 <!--start-services-->
     <div class="service-section">
	    <div class="container">
			<div class="tittle-head">
		       <h3 class="tittle">Services</h3>
			</div>
		    <div class="serve-grids">
			      <div class="col-md-6 serve-left">
							<div class="col-md-6 service-grid">
								<div class="icon">
								 <i class="glyphicon glyphicon-time"></i>
								</div>
								<h5>Fast & Safe</h5>
								<p>Travel at a Lightning speed, with the best safety measures provided by us</p>
							</div>
							<div class="col-md-6 service-grid">
								<div class="icon">
								 <i class="glyphicon glyphicon-thumbs-up"></i>
								</div>
								<h5>Best Prices</h5>
								<p>We offer you the best prices across the country.</p>
							</div>
							<div class="clearfix"></div>
					 </div>
					 <div class="col-md-6 serve-img">
					    <img src="images/Bangalore.jpg"/>
					 </div>
					 <div class="clearfix"></div>
					<div class="col-md-6 serve-img two">
					    <img src="images/merc.jpg"/>
					 </div>
					  <div class="col-md-6 serve-left two">
							<div class="col-md-6 service-grid">
								<div class="icon">
								 <i class="glyphicon glyphicon-cog"></i>
								</div>
								<h5>Luxury Buses</h5>
								<p>We provide you with the best in class buses.</p>
							</div>
							<div class="col-md-6 service-grid">
								<div class="icon">
								 <i class="glyphicon glyphicon-briefcase"></i>
								</div>
								<h5>Package Delivery</h5>
								<p>We ensure that your package reaches the destination safely.</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>

					</div>
				</div>
			</div>
    <!--//services-->
	 <!--start-services--> 
	 <!--start-mid-section-->
     <div class="mid-section">
	    <div class="container">
		     <div class="mid-top">
		        <h2>We are Always There at Your Services</h2>
				<p>We are always there for you, 24x7, all days of the year.We ensure that your traveling experience never gets interrupted </p>
		     </div>
		</div>
	</div>
	 <!--/contact-->
		<!--footer-->
			<div class="footer">
				<div class="container">
					<div class="copy">
		              <p>Copyright &copy; 2016 SortedBus. All Rights Reserved | Design by SortedBhaiLog </p>
		            </div>
					
				</div>
			</div>
				<!--start-smoth-scrolling-->
						<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>


</body>
</html>