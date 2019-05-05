<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menú</title>
</head>
<body>
	<form action="Controller" method="post">
		<h3>Jugar como invitado</h3>
		<input type="submit" value="Entrar"></input>
		<input type="hidden" name="opcion" value="invitado"/>
	</form>
	<hr/>
		<form action="Controller" method="post">
		<h3>Iniciar Sesión</h3>
		<input type="submit" value="Entrar"></input>
		<input type="hidden" name="opcion" value="login"/>
	</form>
		<hr/>
		<form action="Controller" method="post">
		<h3>Regístrate</h3>
		<input type="submit" value="Entrar"></input>
		<input type="hidden" name="opcion" value="signup"/>
	</form>
</body>
</html>