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
<h1>Event Succesfully Added</h1>
</body>
</html>