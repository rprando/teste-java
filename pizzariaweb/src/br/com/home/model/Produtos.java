package br.com.home.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.home.util.TipoProduto;

@Entity
@Table(name="pw_pizzas")
public class Produtos implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cd_produto")
	private Integer cdProduto;
	
	@Column(name="nm_produto", nullable=false, length=20)
	private String nmProduto;
	
	@Column(name="de_produto", nullable=false, length=150)
	private String deProduto;
	
	@Column(name="preco_produto", nullable=false)
	private Double precoProduto;
	
	@Column(name="tp_produto")
	@Enumerated(EnumType.STRING)
	private TipoProduto tipoProduto;
	
	public Produtos(){
		
	}

	public Integer getCdProduto() {
		return cdProduto;
	}

	public void setCdProduto(Integer cdProduto) {
		this.cdProduto = cdProduto;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public String getDeProduto() {
		return deProduto;
	}

	public void setDeProduto(String deProduto) {
		this.deProduto = deProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
}
