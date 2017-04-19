
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome User</title>
<style type="text/css">
img {
    max-width: 100%;
    max-height: 100%;
}
.square {
    height: 100%;
    width: 100%;
}
.row{
margin-top: 20px;
}
.thumb-nail-image{
    padding: 4px;
    line-height: 1.42857143;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 4px;
}

.thumb-nail-text{
    padding: 5px;
	 margin-top: 5px;
}

.thumb-nail-grid{
     padding: 4px;
	 margin-top: 5px;
    line-height: 1.42857143;
    background-color: #fff;
    border: 2px solid #ddd;
    border-radius: 4px;
}
</style>
</head>
<body>
	<div class="row layout-view">
		<c:forEach items="${prList}" var="pList">

			<div class="col-md-3">
				<div class="thumb-nail-grid">
					<div class="square thumb-nail-image">
						<img src="${path}${pList.id}.jpg" alt="${pList.name}">
					</div>
					<div class="thumb-nail-text">
						<h5>
							${pList.name}
						</h5>
						<h5>
							Cost : <b>${pList.price}</b>
						</h5>
						<a href="<c:url value='/addtocart/${pList.id}' />"
							class="btn btn-primary"><span
							class="glyphicon glyphicon-shopping-cart"> </span>Add to cart</a>
					</div>

				</div>
			</div>

			<%-- <div class="col-xs-2 col-md-3 ">
				<div class="grid-view">
					<div class="image-view">
						<img src="${path}${pList.id}.jpg" alt="${pList.name}">
					</div>
					<div class="label-view">
						<p>${pList.name}</p>

						<p>Cost: ${pList.price}</p>
						<a href="<c:url value='/addtocart/${pList.id}' />"
							class="btn btn-primary"><span
							class="glyphicon glyphicon-shopping-cart"> </span>Add to cart</a>


					</div>
				</div>
			</div> --%>
		</c:forEach>
	</div>


</body>
</html>