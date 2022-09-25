<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Save Customer</h1>  
       <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>First Name : </td>   
          <td><form:input path="firstName"  /></td>  
         </tr>    
         <tr>    
          <td>Last Name :</td>    
          <td><form:input path="lastName" /></td>  
         </tr>   
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>
<a href="index">Back to List</a>
</body>
</html>