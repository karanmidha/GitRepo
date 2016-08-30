<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
								<li><a  href="about.html" data-hover="About">About</a></li>
							<!--<li><a href="typography.html" data-hover="Services">Services</a></li> -->
								<!--<li><a href="gallery.html" data-hover="Gallery">Gallery</a></li>-->
								<!--<li><a href="blog.html" data-hover="blog">Blog</a></li>-->
								<li><a href="contact.html" data-hover="Contact">Contact</a></li>
								  <div class="clearfix"></div>
								</ul>
							</div>
							<div class="logo">
							  <a href="index.jsp"><h1>Delete<span>Bus</span></h1></a>
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
<form action="./DeleteBusController" style="margin-top:80px;" >
<h2 class="feildstyle">Enter the number of the bus to be deleted:<h2><br><br>
<input type="text" name="DeleteBus" class="borderstyle" style="margin-left: 150px;"><br><br>
<input type="submit" value="Delete"class="feildstyle">
</form>
</body>
</html>