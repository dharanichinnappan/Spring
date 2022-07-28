<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>

<body>
<h4>student-confirmation page</h4>
Confirmed student name is: ${modelStudent.firstName} ${modelStudent.lastName} 

<br><br>
Seleced country is:${modelStudent.country}

<br><br>
Seleced Language is:${modelStudent.language}  <!-- Here language is used (Language (wih capital T) is used in  jsp page.
											       Variable have to be written as in java page ..not as written in jsp page. )  
											  -->


<br><br>
 Seleced Operating Systems is:${modelStudent.operatingSystems} 
 
 <%-- Seleced Operating Systems is:
 <ul>
 <c:forEach var="ex" items="${modelStudent.operatingSystems}">
 <li>${ex}</li>
 </c:forEach>
 
 </ul>
  --%>
</body>

</html>