<%@page import="controller.ProductController"%>
<%@page import="dao.ProdutoDao"%>
<%@page import="Classes.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	
	<%
		String descricao = request.getParameter("descricao");
		String precoStr = request.getParameter("preco");
		String medida = request.getParameter("medida");
		String estoqueStr = request.getParameter("estoque");
		String categoria = request.getParameter("categoria");
	
		Double preco = Double.parseDouble(precoStr);
		int estoque = Integer.parseInt(estoqueStr);
		
		
		if(descricao != null && preco != null && medida != null && categoria != null){
			
			try{
				Produto produto = new Produto();
				produto.setDescricao(descricao);
				produto.setPreco(preco);
				produto.setUnidadeMedida(medida);
				produto.setEstoque(estoque);
				produto.setCategoria(categoria);
				
				new ProductController().salvar(produto);
				
				response.sendRedirect("./consultarProdutos.jsp");
			}catch(RuntimeException e){
				System.out.println("Erro: " + e);
			}
			
		}
	%>
