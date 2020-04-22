<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
<h1>Login form</h1>




<form action="${pageContext.request.contextPath}/login" method="post">
	
	Email: <input type="email" name="email"  required="required" /><br/>
	Password: <input type="text" name="password"  required="required" /><br/>
	
	<mark>Email: admin@gmail.com</mark> and <mark>Password: admin</mark>
	<input id="sub" type="submit" value="Login"/>
	<input type="reset" value="Clear"/>
	

</form>

</body>
</html>