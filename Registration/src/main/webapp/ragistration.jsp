<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="regForm" method="post">
Name:<input type="text" name="name"><br><br>
Email:<input type="text" name="email"><br><br>
Password:<input type="password" name="pass"><br><br>
Gender:<input type="radio" name="gender"/>Male<input type="radio" name="gender"/>Female<br><br>
City:<select name="city">
<option>Select City</option>
<option>Delhi</option>
<option>Pune</option>
<option>Mumbai</option>
<option>Nagpur</option>
</select><br><br>

<input type="submit" value="Rejister" >
</form>
</body>
</html>