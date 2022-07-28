<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>

<body>

<h4>student-form page</h4>


<form:form action="processForm" modelAttribute="modelStudent">

First name: <form:input path="firstName"/>

<br><br>
Last name: <form:input path="lastName"/>
<br><br>

			<!-- Select Options -->
country :   <form:select path="country">

				<!-- Giving country options in jsp page  -->
				<%-- <form:option value="ind" label="India"></form:option>
				<form:option value="ger" label="Germany"></form:option>
				<form:option value="uk" label="United Kingdom"></form:option>
				<form:option value="us" label="United States"></form:option> --%>

				<!-- getting country options  from java code. -->
				<form:options items="${modelStudent.countryOptions}" />				
				
			</form:select>
			<br><br>
			
			
			<!-- Radio Buttons -->
			
Programming Language: 

				 JAVA: <form:radiobutton path="Language" value="JAVA"/>	 
				 PHP: <form:radiobutton path="Language" value="PHP"/>
		 		 C: <form:radiobutton path="Language" value="C"/>
		 		 C++: <form:radiobutton path="Language" value="C++"/>
		 		 <br><br>
		 	<!-- CHECK BOX	 --> 
Operating Systems:
				Linux<form:checkbox path="operatingSystems" value="Linux"/>
				Windows<form:checkbox path="operatingSystems" value="Windows"/>
				Mac<form:checkbox path="operatingSystems" value="Mac"/>

		 		 
		 		 
<input type="submit" value="submit"/>
</form:form>
</body>
</html> 