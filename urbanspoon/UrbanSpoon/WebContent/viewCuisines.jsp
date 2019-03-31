<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/Main.css">
<style>
.row {
	width: 275px;
	background-color: #ddd;
	padding: 20px;
	height: 308px;
	margin: 30px 0px 0px 24px;
	float: left;
	border-radius: 15px;
	font-family: fantasy;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container-fluid">
		<c:forEach items="${cuisineList}" var="cuisine">
			<div class="row">
				<h5>
					<c:out value="${cuisine.name}"></c:out>
				</h5>
		
				<p>${cuisine.country}</p>
			</div>
		</c:forEach>
	</div>


		<jsp:include page="footer.html"></jsp:include>

</body>
</html>