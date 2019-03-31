<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Urban Spoon</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/Main.css">
	<style type="text/css">	
	.row{
    width: 275px;
    background-color:#ddd;
    padding: 20px;
    height: 308px;
    margin: 30px 0px 0px 24px;
    float: left;
    border-radius: 15px;
    font-family: fantasy;
	}
	img {
    vertical-align: middle;
    width: 230px;
}
	</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">

		
			<c:forEach items="${recipesList}" var="recipe">
            <div class="row">

					<a href="HomeController?action=ViewRestaurantviseBranches&id=<c:out value="${recipe.recipeId}"/>"><img
						alt="" src="images/recipes/${recipe.imagePath}"></a>
				
						<p>${recipe.name}</p><hr>
				    <c:out value="${recipe.description}"></c:out>
					<a href="HomeController?action=feedback&recipeId=<c:out value="${recipe.recipeId}"/>"><button>Feedback</button></a>
				</div>
				
			</c:forEach>


</div>
		<jsp:include page="footer.html"></jsp:include>
		
</body>
</html>
