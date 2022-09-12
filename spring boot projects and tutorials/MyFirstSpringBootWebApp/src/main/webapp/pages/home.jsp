<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>	
</head>
<body>
		<!-- 
			use the following URL for "get" request:
			http://localhost:8080/home?firstName=Mengistu&lastName=Redae&address=AddisAbaba
		-->
		
		<br><br>
		Welcome <strong>${firstName} ${lastName}</strong>, your name received from server using the following methods: <br> 
		<ul>
			<li>Request object</li>
			<li>Session object</li>
			<li>Response object</li>
			<li>ModelAndView object of spring framework</li>
		</ul>
		<br><br>
		Now, your full information is received using ModelAndView object as following: <br>
		Full Name: <strong>${firstName} ${lastName }</strong> <br>
		Address: <strong>${address }</strong>
</body>
</html>