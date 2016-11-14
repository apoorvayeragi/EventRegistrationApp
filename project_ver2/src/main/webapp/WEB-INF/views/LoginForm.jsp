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
		<li><a class="glyphicon glyphicon-log-in" href="useradded.htm"> Register</a></li>
		<li><a class="glyphicon glyphicon-log-in" href="login.htm"> Login</a></li>
	  </ul>
    </div>
  </div>
</nav>
<div class="container">
	<h4>Welcome Back!</h4>
	<hr>
	<form method="post" action='verifyLogin.htm' name="login_form">
		<p><input type="text" class="span3" name="username" id="usrnme" placeholder="Username"></p>
		<p><input type="password" class="span3" name="password" placeholder="Password"></p>
		<p>	
		      <input type="radio" path="role" name="role" checked="checked" value="Volunteer"/>Volunteer
		      <input type="radio" path="role" name="role" value="EventHead"/>EventHead</p>		
		      <p><button type="submit" class="btn btn-primary">Sign in</button>
		<a href="#">Forgot Password?</a>
		</p>
	</form>
	<p>${requestScope.error}</p>					
</div>

</body>
</html>