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
	<%
		Personne perso = (Personne) request.getAttribute("Personne");
		out.println("Bonjour votre prénom :"+perso.getPrenom()+" ,votre nom est "+ perso.getNom()+" ,votre numéro est "+perso.getNum());
	%> 
</body>
</html>