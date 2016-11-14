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
<h1>InsideManageVolunteerRequest</h1>
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
        <li><a href="EventHeadHomePage.htm">For Event Heads</a></li>
        <!--li class="active"><a href="ManageVolunteerRequest.htm">Manage Volunteer Request</a></li-->
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
                <h3>Volunteer Request</h3>
            </div>
        </div>
     		<c:out value="${sessionScope.eventId}"/>
     		<c:choose>
     		<c:when test="${!empty errorMessage}">
     		${ errorMessage}
     		</c:when>
     		<c:otherwise>
     		
     		<c:forEach var="vol" items="${volList}">
     		
	            <div class="col-md-4 col-sm-6 hero-feature">
	                    <div class="well well-lg">
	                        <h3>${vol.userName}</h3>
	                        <p><h4><b>Name:</b> ${vol.firstName} ${vol.lastName}</h4></p>
	                        <p>
	                        <form action ="volAccept.htm" method="GET">
	                        	<input type="hidden" name="username" value="${vol.userName}">
	                        	<input type="hidden" name="eventId" value="${sessionScope.eventId}">
	                             <button type="submit" class="btn btn-info btn-sm">Accept</button>
	                        </form><br>
	                        <!--form action ="volReject.htm" method="GET">
	                        	<input type="hidden" name="username" value="${vol.userName}">
	                        	<input type="hidden" name="eventId" value="${sessionScope.eventId}">
	                             <button type="submit" class="btn btn-info btn-sm">Reject</button>
	                        </form-->
	                        </p>
	                    </div>
	            </div>
     		
     		</c:forEach>
     		</c:otherwise>
</c:choose>

</div>
</body>
</html>