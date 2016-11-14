<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
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
        <li><a href="AddHomePage.htm">Events </a></li>
        <li class="active"><a href="AddNewEvents.htm">Add New Events</a></li>
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

    <div class="col-sm-12 text-left"> 
      <h1>Welcome</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
      <hr>
      	<div class="well well-lg">
      		<h2>Event Form</h2>
      		<div class="row">  			      	
	      		<form:form method="post" action='eventAdded.htm' commandName="event">
	      		<div class="col-sm-4 text-left">
	      		<h4>Event Details</h4>
	      		<hr>
	      		<p><form:input path="eventName" size="30" placeholder="Event Name"/> <font color="red"><form:errors path="eventName"/></font></p>
	      		<form:input path="eventHeadName" size="30" placeholder="Event Head Name"/> <font color="red"><form:errors path="eventHeadName"/></font></p>
				<!--form:select path="eventHeadName" type="text" name="receiver" class="form-control input-sm" placeholder="Send to"
                  items="${list}" itemValue="personID" itemLabel="emailId"/-->
	      		<p><form:input path="eventDate" size="30" placeholder="Event Date"/> <font color="red"><form:errors path="eventDate"/></font></p>
						<p><form:select path="eventType" >
								<option value="Choose a Cause">Choose a Cause</option>
								<option value="Education">Education</option>
								<option value="Environment">Environment</option>
								<option value="Computers & Technology">Computers & Technology</option>
								<option value="Family Wellness">Family Wellness</option>
								<option value="Art & Culture">Art & Culture</option>
								<option value="Health & Medicine">Health & Medicine</option>
								<option value="Children & Youth">Children & Youth</option>
							</form:select>

	      		<p><form:input path="eventDesc" size="30" placeholder="Event Desc"/> <font color="red"><form:errors path="eventDesc"/></font></p>
	      		</div>
	      		<div class="col-sm-4 text-left">
	      		<h4>Event Location</h4>
	      		<hr>
	      		<p><form:input path="address.streetName" size="30" placeholder="Street Name"/> <font color="red"><form:errors path="address.streetName"/></font></p>
	      		<p><form:input path="address.city" size="30" placeholder="City"/> <font color="red"><form:errors path="address.city"/></font></p>
	      		<p><form:input path="address.state" size="30" placeholder="State"/> <font color="red"><form:errors path="address.state"/></font></p>
	      		<p><form:input path="address.country" size="30" placeholder="country"/> <font color="red"><form:errors path="address.country"/></font></p>
	      		<p><form:input path="address.zipCode" type="number" size="30" placeholder="zipCode"/> <font color="red"><form:errors path="address.zipCode"/></font></p>
				</div>
				<div class="col-sm-4 text-left">
	      		<h4>Upload Event Image</h4>
	      		<hr>
	      		<p><form:input type="file" path="eventImagePath" size="30" placeholder="Event Image Path"/> <font color="red"><form:errors path="eventImagePath"/></font></p>
	      		</div>
	      		<p><button type="submit" class="btn btn-primary">Submit</button>
				</p>
				</form:form>
			</div> 	
		</div>	
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>

</body>
</html>