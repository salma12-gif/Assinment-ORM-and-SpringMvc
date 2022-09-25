
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page  isELIgnored="false"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
</head>
<body>
<h1>Customer Relationship Managment</h1>  
	<table border="2" width="70%" cellpadding="2">  
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<c:forEach var="cust" items="${customerList}">
		   <tr>
		   <td>${cust.firstName}</td>  
		   <td>${cust.lastName}</td>  
		   <td>${cust.email}</td>  
		   <td><a href="editemp/${emp.id}">Update</a> | <a href="deleteemp/${emp.id}">Delete</a></td>
		   </tr>  
   		</c:forEach> 
	</table>  
	<br/>   	
</body>
</html>