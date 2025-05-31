<%@page import="controller.ClienteController"%>
<%@page import="Classes.Cliente"%>
<%@page import="dao.ClienteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(request.getMethod().equals("POST")){
			String id = request.getParameter("id");
			Cliente cliente = new ClienteDao().getById(Integer.parseInt(id));
			new ClienteController().delete(cliente);
			response.sendRedirect("Consulta.jsp");
		}
	%>
	<%
		String id = request.getParameter("id");
		Cliente cliente = new ClienteDao().getById(Integer.parseInt(id));
	%>
	
	<label>Name: "<%= cliente.getNome() %>"</label>
	<label>Email: "<%= cliente.getEmail() %>"</label>
	
	<form action="excluir.jsp" method="POST">
		<input type="hidden" name="id" value="<%= cliente.getId() %>"> 
		<button>Delete</button>
	</form>
</body>
</html>