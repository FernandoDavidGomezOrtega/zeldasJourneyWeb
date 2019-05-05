<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>

<script language="javascript">
	function validarPassword(){
		var passw= document.form.password_usuario.value;
		var validapassw= document.form.confirmar_password_usuario.value;
		
		if	(passw != validapassw){
			alert("Las contraseñas no coinciden");
			return false;
		} else return true;
	}
</script>
</head>
<body>
	<form action="Controller" method="post" id="form" onsubmit="return validarPassword()">
	<input type="hidden" value="dosignup" name="opcion"/>
		<h3>Regístrate como usuario</h3>
		<hr>
		<table>
			<tr>
				<td>Nombre: </td>
				<td><input type="text" name="nombre_usuario"/></td>
			</tr>
			<tr>
				<td>Apellido: </td>
				<td><input type="text" name="apellido_usuario"/></td>
			</tr>
			<tr>
				<td>Nick: </td>
				<td><input type="text" name="nick_usuario"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password_usuario" id="password_usuario"/></td>
			</tr>
			<tr>
				<td>Confirmar Password: </td>
				<td><input type="password" name="confirmar_password_usuario" id="confirmar_password_usuario"/></td>
			</tr>
			<tr>
				<td colspan = 2><input type="submit" name="submit" value="Registrarme"/>
		</table>
		 
	</form>
</body>
</html>