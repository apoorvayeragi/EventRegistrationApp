<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>Insert title here</title>
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
        <li class="active"><a href="AddHomePage.htm">Events</a></li>
        <li><a href="AddNewEvents.htm">Add New Events</a></li>
        <li><a href="ManageEventHeadRequest.htm">Manage Requests</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
		<li><a class="glyphicon glyphicon-user" > Hi Admin</a></li>
		<li><a class="glyphicon glyphicon-log-out" href="logoutAdmin.htm"> Logout</a></li>
	  </ul>
    </div>
  </div>
</nav>


<div class="container-fluid text-center">    
  <div class="row content">
  	<!-- Search -->
    <!--div class="col-sm-2 sidenav">
	   	<div class="well">
			<form>
			    <fieldset>
			        <div class="form-group">
			            <label for="query"><h3>Search:</h3></label>
						<form action="search.htm">
				            
				            <input type="text" class="form-control" name="query" id="query" required placeholder="Start typing something to search..."/> <br><br>
				            
				            <label><h4>Search By:</h4></label><br>
				            <input type="radio" class="text-left" name="searchkey" value="eventName" checked="checked">Event Name<br>
				            <input type="radio" class="text-left" name="searchkey" value="eventType">Event Type<br>
				            <input type="radio" class="text-left" name="searchkey" value="eventDate">Event Date<br>
				            <input type="radio" class="text-left" name="searchkey" value="city">City <br>
				            <input type="radio" class="text-left" name="searchkey" value="country">Country <br>
				            <input type="radio" class="text-left" name="searchkey" value="zipCode">Zip Code <br>
				            <input type="radio" class="text-left" name="searchkey" value="state">State <br><br>
				            <input type="hidden" name="action" value="searchuser"/>
			        		<button type="submit" class="btn btn-primary">Search</button>
				        </form>
			        </div>
			    </fieldset>
			</form>
		</div>
    </div-->
    <!-- List of Events -->
    <div class="col-sm-8 text-left"> 
        <div class="row">
            <div class="col-lg-12">
                <h3>Events</h3>
            </div>
        </div>

        <!-- Page Features -->
        <div id="searchUsingAjax" class="row text-center">
        
		<c:forEach var="events" items="${event}">
		<div>
            <div class="col-md-4 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <img src="http://placehold.it/800x500" alt="">
                    <div class="caption">
                        <h3>${events.eventName}</h3>
                        <p><h4><b>Date:</b> ${events.eventDate}</h4></p>
                        <p><h4><b>Location:</b> ${events.address.streetName},${events.address.city}, ${events.address.state}, ${events.address.country}- ${events.address.zipCode} </h4></p>
                        <p>
                             <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">More Info</a>
	                        <!--form action ="updateEvent.htm" method="GET">
	                        	<input type="hidden" name="username" value="${events.eventId}">
	                             <button type="submit" class="btn btn-info btn-sm">Update</button>
	                        </form><br>
	                        <form action ="deleteEvent.htm" method="GET">
	                        	<input type="hidden" name="eventId" value="${events.eventId}">
	                             <button type="submit" class="btn btn-info btn-sm">Delete</button>
	                        </form><br-->

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
				          <h3 class="modal-title">${events.eventName}</h3>
				        </div>
				        <div class="modal-body">
                        <p><h4><b>Date:</b> ${events.eventDate}</h4></p>
                        <p><h4><b>Location:</b> ${events.address.streetName},${events.address.city}, ${events.address.state}, ${events.address.country}- ${events.address.zipCode} </h4></p>
                        <p><h4><b>Event Head Name:</b> ${events.eventHeadName}</h4></p>
                        <p><h4><b>Event Type:</b> ${events.eventType}</h4></p>
                        <p><h4><b>Event Description:</b> ${events.eventDesc}</h4></p>
				        </div>
				        <div class="modal-footer">
				          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>			          
				        </div>
				      </div>				      
				    </div>
			  </div>
			</div>
		</c:forEach>		
 
        </div>
        <hr>

     </div>
    <!-- Upcoming Events -->
    <!--div class="col-sm-2 sidenav">
      <div class="well">
        <h3>Upcoming Events</h3>
        
                <div class="thumbnail">
                    <img src="http://placehold.it/800x500" alt="">
                    <div class="caption">
                        <h3>${events.eventName}</h3>
                        <p><h4><b>Date:</b> ${events.eventDate}</h4></p>
                        <p><h4><b>Location:</b> ${events.address.streetName},${events.address.city}, ${events.address.state}, ${events.address.country}- ${events.address.zipCode} </h4></p>
                        <p>
                             <a href="#" class="btn btn-primary">More Info</a>
                        </p>
                    </div>
                </div>
        
      </div>

    </div-->
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>