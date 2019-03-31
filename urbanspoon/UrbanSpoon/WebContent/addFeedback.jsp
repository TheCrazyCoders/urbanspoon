<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<style type="text/css">
#container {
	height: 70%;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
<form action="HomeController" method="post">
	<div class="container-fluid">
	<h2>${branch}</h2>
	<fieldset>
	<input type="hidden" value="Comments" name="action">
	<input type="hidden" value= <c:out value="${branch}"/> name="branch">
	<input type="hidden" value= <c:out value="${recipeId}"/> name="recipeId">
	Comments<br><br>
	<textarea rows="10px" cols="60px" name="comments">
	</textarea><br><br>
	Ratings
	<input type="text" name="ratings">
	<input type="submit" value="submit">
	</fieldset>
	</div>
	</form>
	

	<jsp:include page="footer.html"></jsp:include>
</body>
</html>
 