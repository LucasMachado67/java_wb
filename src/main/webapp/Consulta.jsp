<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.ClienteDao"%>
<%@page import="Classes.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="index.html">Home</a>
		<a href="Cadastro.jsp">Register</a>
		<a href="Consulta.jsp">View</a>
	</div>
	<h1>New Register</h1>	
	<table>
		<thead>
			<tr>
				<th>Id</th>			 
				<th>Name</th>			
				<th>Email</th>	
			</tr>		
		</thead>
		<tbody >
			<%
			List<Cliente> clientes = ClienteDao.getAll();
				for(Cliente c : clientes){
					out.print("<tr>");
					out.print("<td>" + c.getId() + "</td>");
					out.print("<td>" + c.getNome() + "</td>");
					out.print("<td>" + c.getEmail() + "</td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
	
</body>
</html>