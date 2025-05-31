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
		<a href="Index.html">Home</a><br>
		<a href="Cadastro.jsp">Register</a><br>
		<a href="Consulta.jsp">View</a>
	</div>
	<h1>New Register</h1>	
	<table>
		<thead>
			<tr>
				<th>Id</th>			 
				<th>Name</th>			
				<th>Email</th>	
				<th>Edit</th>	
				<th>Delete</th>	
			</tr>		
		</thead>
		<tbody >
			<%
			List<Cliente> clientes = new ClienteDao().getAll();
				for(Cliente c : clientes){
					out.print("<tr>");
					out.print("<td>" + c.getId() + "</td>");
					out.print("<td>" + c.getNome() + "</td>");
					out.print("<td>" + c.getEmail() + "</td>");
					out.print("<td><a href='Cadastro.jsp?id="+c.getId()+"'>editar</a></td>");
					out.print("<td><a href='excluir.jsp?id="+c.getId()+"'>excluir</a></td>");				
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
	
</body>
</html>