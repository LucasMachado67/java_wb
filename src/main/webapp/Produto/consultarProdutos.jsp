<%@page import="dao.ProdutoDao"%>
<%@page import="Classes.Produto"%>
<%@page import="java.util.List"%>
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
		<a href="./index.html">Home</a><br>
		<a href="./cadastrarProduto.html">Register new product</a><br>
	</div>
	<h1>All Products</h1>	
	<table>
		<thead>
			<tr>
				<th>Code</th>			 
				<th>Description</th>			
				<th>Price</th>	
				<th>Unit</th>	
				<th>Stock</th>	
				<th>Category</th>	
			</tr>		
		</thead>
		<tbody >
			<%
			List<Produto> produtos = ProdutoDao.getAll();
				for(Produto p : produtos){
					out.print("<tr>");
					out.print("<td>" + p.getCode() + "</td>");
					out.print("<td>" + p.getDescricao() + "</td>");
					out.print("<td>" + p.getPreco() + "</td>");
					out.print("<td>" + p.getUnidadeMedida() + "</td>");
					out.print("<td>" + p.getEstoque() + "</td>");
					out.print("<td>" + p.getCategoria() + "</td>");
					out.print("</tr>");
				}
			%>
		</tbody>
	</table>
</body>
</html>