package br.com.home.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.home.dao.ProdutosDAO;
import br.com.home.model.Produtos;
import br.com.home.util.TipoProduto;

@ManagedBean(name="novoProdutoMB")
@ViewScoped
public class NovoProdutoMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Produtos produto = new Produtos();
	
	@Inject
	private ProdutosDAO produtoDao;
	
	public String grava(){
		if(this.produto.getCdProduto() == null){
			produtoDao.create(produto);
		}
		
		return "produtos?faces-redirect=true";
	}
	
	public TipoProduto[] getTiposDeProdutos(){
		return TipoProduto.values();
	}
		
	//Getters and Setters
	public ProdutosDAO getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutosDAO produtoDao) {
		this.produtoDao = produtoDao;
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}
}
