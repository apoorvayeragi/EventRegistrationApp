<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <li class="active"><a href="home.htm">Home</a></li>
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
<div class="container">
<form:form action="useradded.htm" commandName="user" method="post">
		<h4>Create Login</h4>
		<hr>
		<p><form:input path="userName" size="30" placeholder="userName"/> <font color="red"><form:errors path="userName"/></font></p>
		<p><form:input path="password" size="30" placeholder="Password"/> <font color="red"><form:errors path="password"/></font></p><br>
		<h4>Personal Info</h4>
		<hr>
		<p><form:input path="firstName" size="30" placeholder="First Name"/> <font color="red"><form:errors path="firstName"/></font></p>
		<p><form:input path="lastName" size="30" placeholder="Last Name"/> <font color="red"><form:errors path="lastName"/></font></p>								
		<p>	
		      <form:radiobutton path="gender" name="optradio1" checked="checked" value="Female"/>Female
		      <form:radiobutton path="gender" name="optradio1" value="Male"/>Male</p>
		<p><form:input path="email" size="30" type="email" placeholder="Email Id"/> <font color="red"><form:errors path="email"/></font></p> 
		<p><form:input path="phone" type="number" size="30" placeholder="Phone Number"/> <font color="red"><form:errors path="phone"/></font></p>
		<p>	
		      <form:radiobutton path="role" name="optradio2" checked="checked" value="Volunteer"/>Volunteer
		      <form:radiobutton path="role" name="optradio2" value="EventHead"/>EventHead</p>
		<h4>Address</h4>
		<hr>
		<p><form:input path="address.streetName" size="30" placeholder="Street Name"/> <font color="red"><form:errors path="address.streetName"/></font></p>
		<p><form:input path="address.city" size="30" placeholder="City"/> <font color="red"><form:errors path="address.city"/></font></p>								
		<p><form:input path="address.state" type="text" size="30" placeholder="State"/> <font color="red"><form:errors path="address.state"/></font></p>								
		<p><form:input path="address.country" type="text" size="30" placeholder="Country"/> <font color="red"><form:errors path="address.country"/></font></p>								
		<p><form:input path="address.zipCode" type="number" size="30" placeholder="Zip Code"/> <font color="red"><form:errors path="address.zipCode"/></font></p>								
		<p><form:input type="hidden" path="status" value="requested"/></p>
		<button type="submit" class="btn btn-primary">Register</button>
	</form:form>

</div>
</body>
</html>