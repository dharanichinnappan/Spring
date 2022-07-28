<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
</head>
<body>
<div class="alert alert-success center" role="alert">
				<p>${NOTIFICATION}</p>
			</div>
<form action="<%=request.getContextPath()%>/addUser" method="post">
<div>
ID:
<input type="number" id="id" name="id" required="required"/> 
NAME:
<input type="text" id="name" name="name" required="required"/> 

</div>
<div>
EMAIL:
<input type="email" id="email" name="email" required="required"/>
</div>
<div>
country:
<input type="text" id="country" name="country" required="required"/>


</div>
<div><button type="submit">SUBMIT</button></div>
</form>
</body>
</html>