<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page  isELIgnored="false"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
<style type="text/css">
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: center;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

</style>
<script>
	function getAlert(){
		alert("Are you sure you want to delete?");
	}
</script>
</head>
<body>

<h1 style="background-color: green;opacity: 1; text-align: center;  padding: 30px;">Customer Relationship Management</h1><br>

<button class="btn btn-primary btn-lg" id="submit" onclick="location.href ='customerForm'" style="padding: 10px 24px;">Add Employee</button>
<br><br>
	<table>  
		<tr style="background-color: green;opacity: 1;" cellpadding="3">
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
		   <td><a href="update/${cust.custId}">Update</a> | <a href="deleteCustomer/${cust.custId}" onclick="getAlert()">Delete</a></td>
		   </tr>  
   		</c:forEach> 
	</table>  
	<br/>   	
</body>
</html>