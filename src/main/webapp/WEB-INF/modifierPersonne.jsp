<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/hee_training/modifPersonne">
		id : <input type="text" name="id" ><br />
		${ errorID } <br />
		${ MissingId }
		
		<div>
				<label for="nom">Nom :</label>
				<input id="nom" type="text" name="nom" value=${ nomSaisi } >
				${ nomIncorect }
			</div>
			<div>
				<label for="prenom">Prenom :</label>
				<input id="prenom" type="text" name="prenom" value=${ prenomSaisi } >
				${ nomIncorect }
			</div>
			
			<input type="submit" value="OK" />
	</form>
</body>
</html>