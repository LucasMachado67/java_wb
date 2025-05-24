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

	<form method="POST" action="./Cadastro.jsp">
		<label for="nome">Informe Nome</label>
		<input type="text" id="nome" placeholder="Informe o nome" name="nome">
		
		<label for="email">Informe Email</label>
		<input type="text" id="nome" placeholder="Informe o email" name="email">
		<button>Register</button>
	</form>
	
	<%
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");		
		if(nome != null){
			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setEmail(email);
			ClienteDao.insert(cliente);
			
			response.sendRedirect("./Consulta.jsp");
				
		}
	%>
</body>
</html>