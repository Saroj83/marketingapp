<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lead</title>
</head>
<body>

	<h2>Update Lead</h2>


	<form action="updateReg" method="post">   
		<pre>
        <input type="hidden" name="id" value="${registration.id }" />
        FirstName:<input type="text" name="firstName"  value="${registration.firstName }" />
        LastName:<input type="text" name="lastName"  value="${registration.lastName }" />
        Email:<input type="email" name="email"  value="${registration.email }" />
        Mobile:<input type="number" name="mobile"  value="${registration.mobile }" />
        <input type="submit" value="Update" />
  </pre>
	</form>
   ${msg}


</body>
</html>