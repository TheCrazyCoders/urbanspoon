<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Main.css">
<style type="text/css">

</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div id="container">
<div align="center" id="subcontainer">
<form action="RestaurantController" method="post">
<h3>Add Cuisines</h3>
<fieldset id="restaurant">
<input type="hidden" name="action" value="addcuisine">
<label for="Country">Country:</label><input type="text" name="name">
<label for="Country">Description:</label><input type="text" name="description" >
<label for="Name of cuisine">Name of Cuisine:</label><input type="text" name="country" ><br><br>
<input type="submit" value="Submit">
</fieldset>
</form>


</div>
</div>

<jsp:include page="footer.html"></jsp:include>
</body>
</html>