<%@page import="controller.ClienteController"%>
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
	<%
	       Cliente cliente = new Cliente();
	       String id = request.getParameter("id");
	       if(id != null){
	    	  out.print("<h1>Editar cliente:" + id +"</h1>");
	    	  int idcliente = Integer.parseInt(id);
	          cliente = new ClienteDao().getById(idcliente);
	       }
	       else{
	    	   out.print("<h1>Novo registro</h1>");
	       }
	 %>
<div>
		<a href="Index.html">Home</a><br>
		<a href="Cadastro.jsp">Register</a><br>
		<a href="Consulta.jsp">View</a>
	</div>

	<form method="POST" action="./Cadastro.jsp">
	 <input type="hidden" name="id" value="<%= cliente.getId() %>"/>
		<label for="nome">Informe Nome</label>
		<input type="text" id="nome" placeholder="Informe o nome" name="nome"
		value="<%= cliente.getNome() %>">
		
		<label for="email">Informe Email</label>
		<input type="text" id="nome" placeholder="Informe o email" name="email"
		value="<%= cliente.getEmail() %>">
		<button>Register</button>
	</form>
	
	<%
        String nome = request.getParameter("nome");
		String email = request.getParameter("email");
	    id = request.getParameter("id");

	    
	    if("POST".equals(request.getMethod())){
	    	cliente.setNome(nome);
		    cliente.setEmail(email);
		    
		    out.print("<p>"+id+"</p>");
		    int idcliente = Integer.parseInt(id);
		    if(idcliente > 0){
		    	cliente.setId(idcliente);
		    	new ClienteController().update(cliente);
		    }
		    else{
		    	new ClienteController().salvar(cliente);	
		    	out.print("<p>salvar</p>");
		    }		    	    
		    response.sendRedirect("./Consulta.jsp");
	    }	    
				
    %>
</body>
</html>