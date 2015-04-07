package br.com.home.util;

public enum TipoProduto {
	
	PIZZAS(1, "Pizzas"),
	BEBIDAS(2, "Bebidas"),
	SOBREMESAS(3, "Sobremesas");
	
	private Integer cod;
	private String descricao;
	
	private TipoProduto(Integer cod, String descricao){
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
