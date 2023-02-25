<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import ="java.util.Date" %>
 <%@ page import ="Modele.Personne" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Hello from Essaouira</p>
	
	<h4>J'aime le ${ sport.get(0) } et le ${ sport[3] }.
		Je deteste le ${ sport['1'] } et le ${ sport["3"] }.
	</h4>
	
</body>
</html>