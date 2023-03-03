<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/hee_training/modifierPersonne">
		id : <br /><input type="text" name="id" ><br />
		${ errorID }
		<input type="submit" value="OK" />
	</form>
</body>
</html>