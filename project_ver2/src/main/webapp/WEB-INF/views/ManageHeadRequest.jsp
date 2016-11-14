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
<h1>Hope</h1>
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
        <li><a href="AddHomePage.htm">Events</a></li>
        <li><a href="AddNewEvents.htm">Add New Events</a></li>
        <li class="active"><a href="ManageEventHeadRequest.htm">Manage Requests</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
		<li><a class="glyphicon glyphicon-user" > Hi Admin</a></li>
		<li><a class="glyphicon glyphicon-log-out" href="logoutAdmin.htm"> Logout</a></li>
	  </ul>
    </div>
  </div>
</nav>

<!-- Team Members Row -->
	<div class="col-sm-2 text-left"> 
	</div>

    <div class="col-sm-8 text-left"> 
        <div class="row">
            <div class="col-lg-12">
                <h2>Manage Event Head Requests</h2>
            </div>
        </div>
    
    <div class="row text-center">
      
    <c:forEach var="reqList" items="${headRequest}">
            <div class="col-md-4 col-sm-6 hero-feature">
                     <div class="well well-lg">
                        <h3>${reqList.userName}</h3>
                        <p><h4><b>Name:</b> ${reqList.firstName} ${reqList.lastName}</h4></p>
                        <p>
                        <form action ="headAccept.htm" method="GET">
                        	<input type="hidden" name="username" value="${reqList.userName}">
                             <button type="submit" class="btn btn-info btn-sm">Accept</button>
                        </form><br>
                        <form action ="headReject.htm" method="GET">
                        	<input type="hidden" name="username" value="${reqList.userName}">
                             <button type="submit" class="btn btn-info btn-sm">Reject</button>
                        </form>
                        </p>
                    </div>
            </div>
     </c:forEach>       
        
	</div>
	</div>
	<div class="col-sm-2 text-left"> 
	</div>
</body>
</html>