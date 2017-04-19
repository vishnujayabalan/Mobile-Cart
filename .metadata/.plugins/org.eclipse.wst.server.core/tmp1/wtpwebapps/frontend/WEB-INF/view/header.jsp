<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>header</title>
<style >

html, body {
  font-family: 'Lato', serif;  
}
.navbar-fault {
  font-size: 1.15em;
  font-weight: 400;
  background-color: #006b96 ;
  padding: 10px;
  border: 0px;
  border-radius: 0px;
}
.navbar-fault .navbar-nav>li>a {
  color: white ;
}
.navbar-fault .navbar-nav>li>a:hover {
  color: #006b96;
}
.navbar-fault .navbar-brand {
  color: #002433;
}
.navbar-fault .navbar-brand:hover {
  color:  #006b96;
  text-shadow: 1px -1px 8px #b3e9ff;
}

.navbar-fault .navbar-nav>.open>a, .navbar-default .navbar-nav>.open>a:hover, .navbar-default .navbar-nav>.open>a:focus {
  background-color: #004059;
  color: white;
}

.navbar-fault .navbar-toggle {
  border: none;
}

.navbar-fault .navbar-collapse, .navbar-default .navbar-form {
  border: none;
}

.navbar-fault .navbar-toggle:hover, .navbar-default .navbar-toggle:focus {
  background-color:  #006b96;
}

.navbar-fault .navbar-toggle .icon-bar {
  background-color: #ffffff;
}
</style>
</head>

<body>
 <nav class="navbar navbar-fault">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" >
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>

   
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
       <li class="active"><a href="click"><span class="glyphicon glyphicon-home"></span>HOME</a></li>
      <li><a href="about">ABOUT US</a></li>
      
  <c:if test="${home==true }">
    <li><a href="regis">REGISTER</a></li>
      </c:if>
      <c:if test="${!empty thisadmin}">
      <li><a href="admin">ADMIN</a>
      </li>
      </c:if>
      <c:if test="${user==true }">
      <li><a href="mycart">MYCART</a></li>
      </c:if> 
     <li><a href="selProductView">PRODUCTS</a>
       </ul>
   <div class="nav navbar-nav navbar-right">
       <ul class="nav navbar-nav">
       <c:if test="${home==true}"> 
         <li><a href="clicklog"><span class="glyphicon glyphicon-user"></span>Login</a></li>
     </c:if>
    <c:if test="${user==true }">  
 <li><a href="clickout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
 </c:if>
  <c:if test="${!empty thisadmin}">  
 <li><a href="clickout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
 </c:if>
         </ul>
    </div>
  </div>
  </div>
</nav>


</body>
</html>
