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
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>

 <c:if test="${ clicklogin==true}">
  <jsp:include page="login.jsp"></jsp:include>  
      </c:if>
    <c:if test="${clickreg==true}">
	<jsp:include page="Register.jsp"></jsp:include>  
</c:if>
<c:if test="${slide==true}">
	<jsp:include page="crosel.jsp"></jsp:include> 
</c:if>
<c:if test="${clickpro==true}">
	<jsp:include page="ProductView.jsp"></jsp:include> 
</c:if>
<c:if test="${not empty product}">
	<jsp:include page="ProductView.jsp"></jsp:include> 
</c:if>
<c:if test="${afterlogin==true}">
	<jsp:include page="ProductView.jsp"></jsp:include> 
</c:if>
<c:if test="${clickcart==true}">
	<jsp:include page="Mycart.jsp"></jsp:include> 
</c:if>
<c:if test="${admin==true}">
	<jsp:include page="Admin.jsp"></jsp:include> 
</c:if>
<c:if test="${not empty category}">
	<jsp:include page="Categoryadd.jsp"></jsp:include> 
</c:if>
<c:if test="${not empty product}">
	<jsp:include page="Productadd.jsp"></jsp:include> 
</c:if>
<c:if test="${not empty supplier}">
	<jsp:include page="Supplieradd.jsp"></jsp:include> 
</c:if>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>