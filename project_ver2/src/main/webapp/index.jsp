<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
  <title>Hope</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style>
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }

    .carousel-inner img {
      width: 100%; /* Set width to 100% */
      min-height: 200px;
    }

    /* Hide the carousel text when the screen is less than 600 pixels wide */
    @media (max-width: 600px) {
      .carousel-caption {
        display: none; 
      }
    }
  </style>
</head>
<body>
<h1>HOPE</h1>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">For Volunteers</a></li>
        <li><a href="AdminHomePage.jsp">For Event Managers</a></li>
        <li><a href="AdminHomePage.jsp">For Admin</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
    	<c:choose>
            <c:when test="${!empty sessionScope.username}">
				<li><a class="glyphicon glyphicon-user" > Hi ${sessionScope.username}</a></li>
				<li><a class="glyphicon glyphicon-log-out" href="login.htm"> Logout</a></li>            
      		</c:when>		
			<c:otherwise>
				<li><a class="glyphicon glyphicon-log-in" href="useradded.htm"> Register</a></li>
				<li><a class="glyphicon glyphicon-log-in" href="login.htm"> Login</a></li>
			</c:otherwise>
		</c:choose>
	  </ul>
    </div>
  </div>
</nav>

<div class="container">
<div class="row">
  <div class="col-sm-7">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
      </ol>

      <!-- Wrapper for slides -->
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img src="http://placehold.it/800x400?text=IMAGE" alt="Image">
          <div class="carousel-caption">
            <h3>Sell $</h3>
            <p>Money Money.</p>
          </div>      
        </div>

        <div class="item">
          <img src="http://placehold.it/800x400?text=Another Image Maybe" alt="Image">
          <div class="carousel-caption">
            <h3>More Sell $</h3>
            <p>Lorem ipsum...</p>
          </div>      
        </div>
      </div>

      <!-- Left and right controls -->
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>
  </div>
	<div class="col-sm-5">
		<div class="form-body">
		
			<div class="well">
	        	<h3 align="center">Find a Volunteer Opportunity!</h3>
	            <form class="form-horizontal">
	                <div class="form-group">
						<label class="control-label col-sm-4" for="search">Search:</label>
						<div class="col-sm-8">
						  <input type="text" class="form-control" id="search" placeholder="keywords">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4" for="location">Location:</label>
						<div class="col-sm-8">
						  <input type="text" class="form-control" id="location" placeholder="near address">
						</div>
	                </div>
					<div class="form-group">
						<label class="radio-inline control-label col-sm-4" for="distance">Within:</label>
						<div class="col-sm-8">
							<input type="radio" name="optradio">5 mi
							<input type="radio" name="optradio">10 mi
							<input type="radio" name="optradio">25 mi
						</div>	
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4" for="location">Filter by Cause:</label>
						<div class="col-sm-8">
							<select class="form-control" name="" id="location">
								<option value="">Choose a Cause</option>
								<option value="">Education</option>
								<option value="">Environment</option>
								<option value="">Computers & Technology</option>
								<option value="">Family Wellness</option>
								<option value="">Art & Culture</option>
								<option value="">Health & Medicine</option>
								<option value="">Children & Youth</option>
							</select>
						</div>
	                </div>					
	                <p class="text-center"><a href="#" class="btn btn-danger glyphicon glyphicon-search" role="button"></a></p>
	            </form>
	        </div>
		</div>
	</div>
</div>
<hr>
</div>

<div class="container text-center">    
  <h3>Upcoming Events</h3>
  <br>
  <div class="row text-center">  
		<c:forEach var="event" items="${events}">
            <div class="col-md-4 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <img src="http://placehold.it/800x500" alt="">
                    <div class="caption">
                        <h4>${event.eventName}</h4>
                        <p><h5><b>Date:</b> ${event.eventDate}</h5></p>
                        <p><h5><b>Location:</b> ${event.address.streetName},${event.address.city}, ${event.address.state}, ${event.address.country}- ${event.address.zipCode} </h5></p>
                        <p>
                             <button type="button" class="btn btn-info btn-lg">Request</a>
                             <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">More Info</a>
                        </p>
                    </div>
                </div>
            </div>
	            <div class="modal fade" id="myModal" role="dialog">
				    <div class="modal-dialog">				    
				      <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          <h3 class="modal-title">${event.eventName}</h3>
				        </div>
				        <div class="modal-body">
                        <p><h4><b>Date:</b> ${event.eventDate}</h4></p>
                        <p><h4><b>Location:</b> ${event.address.streetName},${event.address.city}, ${event.address.state}, ${event.address.country}- ${event.address.zipCode} </h4></p>
                        <p><h4><b>Event Head Name:</b> ${event.eventHeadName}</h4></p>
                        <p><h4><b>Event Type:</b> ${event.eventType}</h4></p>
                        <p><h4><b>Event Description:</b> ${event.eventDesc}</h4></p>
				        </div>
				        <div class="modal-footer">
				          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				        </div>
				      </div>				      
				    </div>
			  </div>
		</c:forEach>		
	</div>
  <hr>
</div>

<div class="container text-center">    
  <h3>Our Partners</h3>
  <br>
  <div class="row">
    <div class="col-sm-2">
      <img src="http://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
      <p>Partner 1</p>
    </div>
    <div class="col-sm-2"> 
      <img src="http://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
      <p>Partner 2</p>    
    </div>
    <div class="col-sm-2"> 
      <img src="http://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
      <p>Partner 3</p>
    </div>
    <div class="col-sm-2"> 
      <img src="http://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
      <p>Partner 4</p>
    </div> 
    <div class="col-sm-2"> 
      <img src="http://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
      <p>Partner 5</p>
    </div>     
    <div class="col-sm-2"> 
      <img src="http://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image">
      <p>Partner 6</p>
    </div> 
  </div>
</div><br>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
