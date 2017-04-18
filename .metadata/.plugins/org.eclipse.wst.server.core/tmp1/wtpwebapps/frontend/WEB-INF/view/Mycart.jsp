<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<title>cart</title>
</head>
<body>
<div class="container"> 
<center><h4>MYCART</h4> </center>        
   <table class="table table-bordered">
    <thead>
      <tr>
        <th>ID</th>
        <th>UserID</th>
        <th>Product Name</th>      
       <th>Status</th>
       <th>Price</th>
        <th>Quantity</th>
       <th>Date Added</th>
         <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="mycart" items="${showcartlist}">
			<tr>
				<td>${mycart.id}</td>
				<td>${mycart.user_id}</td>
				<td>${mycart.productname}</td>
				<td>${mycart.status}</td>
				<td>${mycart.price}</td>
				<td><a href="<c:url value='/increasequantity/${mycart.id}' />">
  	<button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-plus"></span>
  	</button></a>&nbsp;${mycart.quantity}&nbsp;<a href="<c:url value='/decreasequantity/${mycart.id}' />">
  	<button type="submit" class="btn btn-default" style="color:#FF3349;">
  	<span class="glyphicon glyphicon-minus"></span></button></a></td>
				<td>${mycart.date_added}</td>
				<td><a href="<c:url value='/deletecart/${mycart.id}' />">Delete</a></td>
			</tr>
		</c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>