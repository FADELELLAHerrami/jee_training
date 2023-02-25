<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import ="java.util.Date" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Hello from Essaouira</p>
	<%
		String maVille = (String) request.getAttribute("maVille");
		out.println("Bienvenue à notre "+maVille);
	%> 
</body>
</html>