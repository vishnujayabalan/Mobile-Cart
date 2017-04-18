<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link  rel="stylesheet" href="Resources/Bootstrap/bootstrap.min.css">
<title></title>
</head>
<style>

*[role="form"] {
    max-width: 530px;
    padding: 15px;
    margin: 0 auto;
    background-color: #fff;
    border-radius: 0.3em;
}

*[role="form"] h2 {
    margin-left: 5em;
    margin-bottom: 1em;
}
</style>
<body>
<div class="container">
            <form class="form-horizontal" action="manage_Supplier_edit" method="post" role="form">
                <h2>Supplier Details</h2>
                <div class="form-group">
			<label for="supplier id" class="col-sm-3 control-label">Supplier ID</label>
			<div class="col-sm-9">
                        <input type="text" name="id" value="${supFound.id}"  class="form-control" readonly>
                </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-3 control-label">Supplier Name</label>
                    <div class="col-sm-9">
                        <input type="text" name="name" value="${supFound.name} "class="form-control" autofocus>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-sm-3 control-label">Supplier Address</label>
                    <div class="col-sm-9">
                        <input type="text" name="address" value="${supFound.address}" class="form-control">
                        <br/><br/>
                        <button type="submit" class="btn btn-primary">Update</button>
                    </div>  
                    
                </div>
              </form>
              </div>  

</body>
</html>
