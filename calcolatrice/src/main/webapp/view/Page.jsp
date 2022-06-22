<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calcolatrice</title>
</head>
<body>
	<%! 
	public static String tryThis(String n){
		if(n != null && !n.isEmpty())
			return n;
		
		return "";
		}
	
	%>
	<h1>Calcola</h1>
	<form action="/calcolatrice/Calc" method="post">
		<input type="number" placeholder="num1" name="num1" value="<%= tryThis(request.getParameter("num1")) %>"> 
		<input type="text" placeholder="met" name="met" value="<%= tryThis(request.getParameter("met")) %>"> 
		<input type="number" placeholder="num2" name="num2" value="<%= tryThis(request.getParameter("num2")) %>">
		<button type="submit">calcola</button>
	</form>
	
	<% 
	Double val = (Double) request.getAttribute("risultato");
	String err = (String) request.getAttribute("errore");
	
	if(err != null && !err.isEmpty()){
	%>
			<h3><%= err %></h3>
	<%
	} else if(val != null){
	%>
		<h3>Il risultato è: <%= val %></h3>
	<%
	}
	%>

</body>
</html>