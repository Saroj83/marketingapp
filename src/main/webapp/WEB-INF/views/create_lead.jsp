<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Lead</title>
</head>
<body>

	<h2>Create Lead</h2>


	<form action="saveReg" method="post">   
		<pre>

        FirstName:<input type="text" name="firstName" />
        LastName:<input type="text" name="lastName" />
        Email:<input type="email" name="email" />
        Mobile:<input type="number" name="mobile" />
        <input type="submit" value="Save" />
  </pre>
	</form>
   ${msg}


</body>
</html>