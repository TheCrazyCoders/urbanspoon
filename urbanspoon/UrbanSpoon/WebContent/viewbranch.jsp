<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
    width: 60%;
}
div#tittle {
	width: 100%;
	float: left;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">

		<c:forEach items="${restaurntList}" var="restaurant">
			<div id="tittle">
				<h2>${restaurant.registrationName}</h2>

				<c:forEach items="${restaurant. branchesList}" var="branch">
					<div class="row">
						<img alt="" src="images/branches/${branch.imagePath}">
						<h5>
							<c:out value="${branch.location}"></c:out>
						</h5>
						<p>${branch.phoneNumber}</p>
						<p>${branch.emailId}</p>
						<div>
						<a href="HomeController?action=AddFeedback&branch=<c:out value="${branch.location}"/>&recipeId=<c:out value="${recipeId}"/>"><input type="button" 
								value="share your feedback"></a>
						</div>
					</div>


				</c:forEach>

			</div>
		</c:forEach>
	
	
	<c:forEach items="${branchList}" var="branch">
		<div class="row">
			<img alt="" src="images/branches/${branch.imagePath}">
			<h5>
				<c:out value="${branch.location}"></c:out>
			</h5>
			<p>${branch.phoneNumber}</p>
			<p>${branch.emailId}</p>
			<div>
				<!--<a href="HomeController?action=AddFeedback">Share FeedBack</a>----->
				<input type="button" onclick="feedbackDiv()"
					value="share your feedback">
			</div>
		</div>


	</c:forEach>

</div>
	<jsp:include page="footer.html"></jsp:include>
</body>
</html>