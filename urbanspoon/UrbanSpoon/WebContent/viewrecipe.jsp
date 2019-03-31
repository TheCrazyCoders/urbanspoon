<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/Main.css">
<style type="text/css">

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
img{
    width: 100%;
}

</style>
</head>
<body>

		<jsp:include page="header.jsp"></jsp:include>
	
	<div class="container-fluid">
		<c:forEach items="${recipesList}" var="recipe">
			<div class="row">
				<h5>
					<c:out value="${recipe.name}"></c:out>
				</h5>
				<a
					href="RestaurantController?action=displaybranch&id=<c:out value="${recipe.recipeId}"/>"><img
					alt="" src="images/recipes/${recipe.imagePath}"></a>
				<p>${recipe.description}</p>
			</div>
		</c:forEach>
	</div>


		<jsp:include page="footer.html"></jsp:include>


</body>
</html>