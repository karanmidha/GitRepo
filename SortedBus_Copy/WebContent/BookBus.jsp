<%@page import="redbus.model.DaoImpl.BusDaoImpl"%>
<%@page import="redbus.model.dao.BusDao"%>
<%@page import="java.util.*"%>
<%@page import="redbus.model.pojo.Schedule"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="redbus.model.pojo.Bus"%>

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
							  <a href="index.jsp"><h1>Book<span>Bus Page</span></h1></a>
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
<% String busSrc=request.getParameter("source");
	String busDest=request.getParameter("destination");
	Bus b = new Bus();
	BusDao bd = new BusDaoImpl();
	b.setBusSource(busSrc);
	b.setBusDestination(busDest);
	Schedule sc = new Schedule();
	
	int date=Integer.parseInt(request.getParameter("schDate"));	
	String month= request.getParameter("schMonth");
    char dest[] = new char[10];
	month.getChars(0, 3,dest, 0);
	month=dest[0]+""+dest[1]+""+dest[2];
	month=month.toUpperCase();
	int year= Integer.parseInt(request.getParameter("schyear"));
    String date_final=date+"-"+month+"-"+year;
    int monthnum=0;
    if(month.equals("Jan")){
    	monthnum=1;
    }else if(month.equals("Feb")){
    	monthnum=2;
    }else if(month=="Mar"){
    	monthnum=3;
    }else if(month.equals("Apr")){
    	monthnum=4;
    }else if(month.equals("May")){
    	monthnum=5;
    }else if(month.equals("Jun")){
    	monthnum=6;
    }else if(month.equals("Jul")){
    	monthnum=7;
    }else if(month.equals("Aug")){
    	monthnum=8;
    }else if(month.equals("Sep")){
    	monthnum=9;
    }else if(month.equals("Oct")){
    	monthnum=10;
    }else if(month.equals("Nov")){
    	monthnum=11;
    }else if(month.equals("Dec")){    	
    	monthnum=12;
    }
    
    Date d= new Date();
    d.setDate(date);
    d.setMonth(monthnum);
    d.setYear(year);
    
  //  java.util.Date utild = new java.util.Date();
	
	//@SuppressWarnings("deprecation")
	//Date curr_date = (new Date(utild.getYear(), utild.getMonth(), utild.getDate()));
	
//	System.out.println("date "+d+"d year="+d.getYear()+"   cuur yr ="+(curr_date.getYear()+1900));
	//System.out.println(d+"\n"+curr_date);
	 if(d.getYear()>=2016){
	    sc.setSchDate(date_final);
	    List<Bus> ls =bd.searchBus(b, sc);   
	    %>
	                       	  <h4>
	                          <table border="1"  width="80%" cellpadding="15px" cellspacing="15px"  height="100%" margin-left="80px" class="feildstyle">
	                          <tr bgcolor="orange" ><b>
	                          <th>Number</th>
	                          <th>Source</th>
	                          <th>Destination</th>                         
	                          </b>
	                          </tr>
	    <%
	    for(Bus l:ls){
	    %>
	    
	         <tr>
	             <td align="center"><% out.println(l.getBusNumber());%></td>
	             <td align="center"><%out.println (l.getBusSource());%></td>
	             <td align="center"><% out.println(l.getBusDestination());%></td>	                         
	         </tr>
	     <%} %>
	     </table>

	    <br><br><br>
	    <form action="./BookTicketController">
	    Enter The Bus Number You Want To Book From The List Shown Above:
	    <input type="number" name="busNum"><br>
	    Enter The Seats you Want To Book:
	    <input type="number" name="seatsBooked"><br>
	    <input type="submit" value="Book Ticket">
	    </form>
	    </body>
	    </html>
	    <% 
	}
	else{
	   	String msg="Enter Year After Current Year";
	   	session.setAttribute("Message", msg);
	   	response.sendRedirect("./DateError.jsp");
	    }
%>
