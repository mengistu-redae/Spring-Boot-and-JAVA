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
			use this request URL: http://localhost:8080/alienHome?aid=1&aname=Mengistu&lang=Java
		-->
		
		<br><br>
		Welcome <strong>${alien.aid}, ${alien.aname}, ${alien.lang}</strong>
		<br><br>
		Now, your full information is received using ModelAndView object as following: <br>
		Full Name: <strong>${alien.aname}</strong> <br>
		Address: <strong>${alien.lang}</strong>
</body>
</html>