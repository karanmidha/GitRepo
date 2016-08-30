<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Register Page</title>
</head>
<body>
<form action="./InsertPassengerController">
Enter Your Name:<input type="text" name="userName" Required><br>
Enter Your Address:<input type="text" name="userAdd" Required><br>
Enter Your Phone Number:<input type="text" name="userPno" Required placeholder="Enter 10 digit number"><br>
Enter Your Password:<input type="password" name="userPass" Required><br>
<input type="submit" value="Register">
</form></body>
</html>