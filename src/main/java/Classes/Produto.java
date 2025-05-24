package Classes;

public class Produto {
	
	private int code;
	private String descricao;
	private double preco;
	private String unidadeMedida;
	private int estoque;
	private String categoria;
	
	
	public Produto() {
		
	}

	public Produto(int code, String descricao, double preco, String unidadeMedida, int estoque, String categoria) {
		super();
		this.code = code;
		this.descricao = descricao;
		this.preco = preco;
		this.unidadeMedida = unidadeMedida;
		this.estoque = estoque;
		this.categoria = categoria;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
