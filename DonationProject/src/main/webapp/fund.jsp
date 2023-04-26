<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
        <title>Causes | Charity / Non-profit responsive Bootstrap HTML5 template</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Fonts -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Dosis:400,700' rel='stylesheet' type='text/css'>

        <!-- Bootsrap -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">


        <!-- Font awesome -->
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">

        <!-- PrettyPhoto -->
        <link rel="stylesheet" href="assets/css/prettyPhoto.css">

        <!-- Template main Css -->
        <link rel="stylesheet" href="assets/css/style.css">
        
        <!-- Modernizr -->
        <script src="assets/js/modernizr-2.6.2.min.js"></script>
</head>
<body>
	<c:choose>
	<c:when test="${sessionScope.user == null }">
		<%@ include file="header.jsp" %>
	</c:when>
	<c:when test="${sessionScope.user.role == 'User' }">
	<%@ include file="header2.jsp" %>
	</c:when><c:when test="${sessionScope.user.role == 'Admin' }">
	<%@ include file="header2.jsp" %>
	</c:when>
</c:choose>


	<div class="page-heading text-center">

		<div class="container zoomIn animated">
			
			<h1 class="page-title">OUR CAUSES <span class="title-under"></span></h1>
			<p class="page-description">
				Lorem ipsum dolor sit amet, consectetur adipisicing elit Necessitatibus.
			</p>
			
		</div>

	</div>

	<div class="main-container">

		<div class="our-causes fadeIn animated">

	        <div class="container">

	            <h2 class="title-style-1">Our Causes <span class="title-under"></span></h2>

	            <div class="row">

	      				
		                <div class="col-md-3 col-sm-6">

		                    <div class="cause">

		                        <img src="assets/images/causes/cause-hunger.jpg" alt="" class="cause-img">

		                        <div class="progress cause-progress">
		                          <div class="progress-bar" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%;">
		                            10$ / 500$
		                          </div>
		                        </div>

		                        <h4 class="cause-title"><a href="#">HUNGER AND POVERTY </a></h4>
		                        <div class="cause-details">
		                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at eros rutrum turpis viverra elementum semper quis ex. Donec lorem nulla, aliquam quis neque vel, maximus lacinia urna.
		                        </div>

		                        <div class="btn-holder text-center">

		                          <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#donateModal"> DONATE NOW</a>
		                          
		                        </div>

		                        

		                    </div> <!-- /.cause -->
		                    
		                </div> 

		                <div class="col-md-3 col-sm-6">

		                    <div class="cause">

		                        <img src="assets/images/causes/cause-education.jpg" alt="" class="cause-img">

		                        <div class="progress cause-progress">
		                          <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
		                            400$ / 700$
		                          </div>
		                        </div>

		                        <h4 class="cause-title"><a href="#">EDUCATION AND TRAINING</a></h4>
		                        <div class="cause-details">
		                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at eros rutrum turpis viverra elementum semper quis ex. Donec lorem nulla, aliquam quis neque vel, maximus lacinia urna.
		                        </div>

		                        <div class="btn-holder text-center">

		                          <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#donateModal"> DONATE NOW</a>
		                          
		                        </div>

		                        

		                    </div> <!-- /.cause -->
		                    
		                </div>


		                <div class="col-md-3 col-sm-6">

		                    <div class="cause">

		                        <img src="assets/images/causes/cause-rights.jpg" alt="" class="cause-img">

		                        <div class="progress cause-progress">
		                          <div class="progress-bar" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
		                            400$ / 1000$
		                          </div>
		                        </div>

		                        <h4 class="cause-title"><a href="#">HUMAN RIGHTS</a></h4>
		                        <div class="cause-details">
		                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at eros rutrum turpis viverra elementum semper quis ex. Donec lorem nulla, aliquam quis neque vel, maximus lacinia urna.
		                        </div>

		                        <div class="btn-holder text-center">

		                          <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#donateModal"> DONATE NOW</a>
		                          
		                        </div>

		                        

		                    </div> <!-- /.cause -->
		                    
		                </div>

		                <div class="col-md-3 col-sm-6">

		                    <div class="cause">

		                        <img src="assets/images/causes/cause-culture.jpg" alt="" class="cause-img">

		                        <div class="progress cause-progress">
		                          <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
		                            400$ / 700$
		                          </div>
		                        </div>

		                        <h4 class="cause-title"><a href="#">ARTS AND CULTURE </a></h4>
		                        <div class="cause-details">
		                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at eros rutrum turpis viverra elementum semper quis ex. Donec lorem nulla, aliquam quis neque vel, maximus lacinia urna.
		                        </div>

		                        <div class="btn-holder text-center">

		                          <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#donateModal"> DONATE NOW</a>
		                          
		                        </div>

		                        

		                    </div> <!-- /.cause -->
		                    
		                </div>



		                <div class="col-md-3 col-sm-6">

		                    <div class="cause">

		                        <img src="assets/images/causes/cause-hunger.jpg" alt="" class="cause-img">

		                        <div class="progress cause-progress">
		                          <div class="progress-bar" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%;">
		                            10$ / 500$
		                          </div>
		                        </div>

		                        <h4 class="cause-title"><a href="#">HUNGER AND POVERTY </a></h4>
		                        <div class="cause-details">
		                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at eros rutrum turpis viverra elementum semper quis ex. Donec lorem nulla, aliquam quis neque vel, maximus lacinia urna.
		                        </div>

		                        <div class="btn-holder text-center">

		                          <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#donateModal"> DONATE NOW</a>
		                          
		                        </div>

		                        

		                    </div> <!-- /.cause -->
		                    
		                </div> 

		                <div class="col-md-3 col-sm-6">

		                    <div class="cause">

		                        <img src="assets/images/causes/cause-education.jpg" alt="" class="cause-img">

		                        <div class="progress cause-progress">
		                          <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
		                            400$ / 700$
		                          </div>
		                        </div>

		                        <h4 class="cause-title"><a href="#">EDUCATION AND TRAINING</a></h4>
		                        <div class="cause-details">
		                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at eros rutrum turpis viverra elementum semper quis ex. Donec lorem nulla, aliquam quis neque vel, maximus lacinia urna.
		                        </div>

		                        <div class="btn-holder text-center">

		                          <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#donateModal"> DONATE NOW</a>
		                          
		                        </div>

		                        

		                    </div> <!-- /.cause -->
		                    
		                </div>


		                <div class="col-md-3 col-sm-6">

		                    <div class="cause">

		                        <img src="assets/images/causes/cause-rights.jpg" alt="" class="cause-img">

		                        <div class="progress cause-progress">
		                          <div class="progress-bar" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
		                            400$ / 1000$
		                          </div>
		                        </div>

		                        <h4 class="cause-title"><a href="#">HUMAN RIGHTS</a></h4>
		                        <div class="cause-details">
		                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at eros rutrum turpis viverra elementum semper quis ex. Donec lorem nulla, aliquam quis neque vel, maximus lacinia urna.
		                        </div>

		                        <div class="btn-holder text-center">

		                          <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#donateModal"> DONATE NOW</a>
		                          
		                        </div>

		                        

		                    </div> <!-- /.cause -->
		                    
		                </div>

		                <div class="col-md-3 col-sm-6">

		                    <div class="cause">

		                        <img src="assets/images/causes/cause-culture.jpg" alt="" class="cause-img">

		                        <div class="progress cause-progress">
		                          <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
		                            400$ / 700$
		                          </div>
		                        </div>

		                        <h4 class="cause-title"><a href="#">ARTS AND CULTURE </a></h4>
		                        <div class="cause-details">
		                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at eros rutrum turpis viverra elementum semper quis ex. Donec lorem nulla, aliquam quis neque vel, maximus lacinia urna.
		                        </div>

		                        <div class="btn-holder text-center">

		                          <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#donateModal"> DONATE NOW</a>
		                          
		                        </div>

		                        

		                    </div> <!-- /.cause -->
		                    
		                </div>


	            </div>

	         </div>
	        
	    </div> <!-- /.our-causes -->

		


	</div> <!-- /.main-container  -->


  	<%@ include file="footer.jsp" %>

        <!-- Donate Modal -->
    <div class="modal fade" id="donateModal" tabindex="-1" role="dialog" aria-labelledby="donateModalLabel" aria-hidden="true">

      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="donateModalLabel">DONATE NOW</h4>
          </div>
          <div class="modal-body">

                <form class="form-donation">

                        <h3 class="title-style-1 text-center">Thank you for your donation <span class="title-under"></span>  </h3>

                        <div class="row">

                            <div class="form-group col-md-12 ">
                                <input type="text" class="form-control" id="amount" placeholder="AMOUNT(€)">
                            </div>

                        </div>


                        <div class="row">
                            <div class="form-group col-md-6">
                                <input type="text" class="form-control" name="firstName" placeholder="First name*">
                            </div>

                            <div class="form-group col-md-6">
                                <input type="text" class="form-control" name="lastName" placeholder="Last name*">
                            </div>
                        </div>


                        <div class="row">

                            <div class="form-group col-md-6">
                                <input type="text" class="form-control" name="email" placeholder="Email*">
                            </div>

                            <div class="form-group col-md-6">
                                <input type="text" class="form-control" name="phone" placeholder="Phone">
                            </div>

                        </div>

                        <div class="row">

                            <div class="form-group col-md-12">
                                <input type="text" class="form-control" name="address" placeholder="Address">
                            </div>

                        </div>


                        <div class="row">

                            <div class="form-group col-md-12">
                                <textarea cols="30" rows="4" class="form-control" name="note" placeholder="Additional note"></textarea>
                            </div>

                        </div>

                        <div class="row">

                            <div class="form-group col-md-12">
                                <button type="submit" class="btn btn-primary pull-right" name="donateNow" >DONATE NOW</button>
                            </div>

                        </div>



                       
                    
                </form>
            
          </div>
        </div>
      </div>

    </div> <!-- /.modal -->




       
        
        <!-- jQuery -->
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="assets/js/jquery-1.11.1.min.js"><\/script>')</script>

        <!-- Bootsrap javascript file -->
        <script src="assets/js/bootstrap.min.js"></script>

        <!-- PrettyPhoto javascript file -->
        <script src="assets/js/jquery.prettyPhoto.js"></script>



        <!-- Google map  -->
        <script src="http://maps.google.com/maps/api/js?sensor=false&amp;libraries=places" type="text/javascript"></script>


        <!-- Template main javascript -->
        <script src="assets/js/main.js"></script>

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
            e.src='//www.google-analytics.com/analytics.js';
            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
            ga('create','UA-XXXXX-X');ga('send','pageview');
        </script>
</body>
</html>