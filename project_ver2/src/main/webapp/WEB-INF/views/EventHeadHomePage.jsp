<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html>
<head>
  <title>Hope</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Welcome <c:out value="${sessionScope.username}"></c:out></h1>
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
        <li class="active"><a href="EventHeadHomePage.htm">For Event Heads</a></li>
        <!--li><a href="ManageVolunteerRequest.htm">Manage Volunteer Request</a></li-->
      </ul>
      <ul class="nav navbar-nav navbar-right">
    	<c:choose>
            <c:when test="${!empty sessionScope.username}">
				<li><a class="glyphicon glyphicon-user" > Hi ${sessionScope.username}</a></li>
				<li><a class="glyphicon glyphicon-log-out" href="logout.htm"> Logout</a></li>            
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
<div class="col-sm-8 text-left"> 
        <div class="row">
            <div class="col-lg-12">
                <h3>Events</h3>
            </div>
        </div>
		<c:forEach var="events" items="${sessionScope.event}">
		<div>
            <div class="col-md-4 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <img src="http://placehold.it/800x500" alt="">
                    <div class="well well-lg">
                        <h3>${events.eventName}</h3>
                        <p><input type="hidden" name="eventId" value="${events.eventId}"/>
                        <p><h4><b>Date:</b> ${events.eventDate}</h4></p>
                        <p><h4><b>Location:</b> ${events.address.streetName},${events.address.city}, ${events.address.state}, ${events.address.country}- ${events.address.zipCode} </h4></p>
                        <p>
	                        <form action ="ManageVolunteerRequest.htm" method="GET">
	                        	<input type="hidden" name="eventId" value="${events.eventId}">
	                             <button type="submit" class="btn btn-info btn-sm">Select</button>
	                        </form>
                             <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">More Info</a>
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

</body>
</html>