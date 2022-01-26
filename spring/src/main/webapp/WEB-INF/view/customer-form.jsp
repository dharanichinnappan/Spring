<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Customer Form Page</title>
	<style >
	.error{color:red;}
	</style>
</head>
<body>

<b>(*) means required</b>
<br><br>
<form:form action="processForm" modelAttribute="OurCustomer">

	First Name: <form:input path="firstName"/>
	<br><br>
	
	Last Name(*): <form:input path="lastName"/>
	<form:errors path="lastName" cssClass="error"></form:errors>
	<br><br>
	Free passes: <form:input path="freePasses"/>
	<form:errors path="freePasses" cssClass="error"></form:errors>
	
	<br><br>
	Postal Code: <form:input path="postalCode"/>
	<form:errors path="postalCode" cssClass="error"></form:errors>
	
	<br><br>
	Passes Integer: <form:input path="passes"/>
	<form:errors path="passes" cssClass="error"></form:errors>
	<br><br>
	
	
	<input type="submit" value="Submit"> 
</form:form>

</body>

</html>