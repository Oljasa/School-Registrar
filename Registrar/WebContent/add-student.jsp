<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<div class="inputform">
		<form name="inputform" action="AddStudent?action=doPost" method="post" >
			ID:<br>
			<input type="text" name="id"/><br/>
			First Name:<br>
			<input type="text" name="firstname"/><br/>
			Last Name:<br>
			<input type="text" name="lastname"/><br/>
			
			<input type="radio" name="gender" value="M"> Male
			<input type="radio" name="gender" value="F"> Female
			<input type="radio" name="gender" value="O"> Other
			<br>
			
			Telephone:<br>
			<input type="text" name="telephone"/><br/>
			Email:<br>
			<input type="text" name="email"/><br/>
			<br>
			<input type="submit" value="Submit"/>  
		</form>
	</div>
</body>
</html>