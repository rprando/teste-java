package br.com.home.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.home.dao.ProdutosDAO;
import br.com.home.model.Produtos;

@ManagedBean(name="removeProdutoMB")
@ViewScoped
public class RemoveProdutoMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Produtos produto = new Produtos();
	private List<Produtos> listaProdutos;
	
	@Inject
	private ProdutosDAO produtoDao;
	
	public List<Produtos> getListaProdutos() {
		if(listaProdutos == null){
			listaProdutos = produtoDao.listAll();
		}
		
		return listaProdutos;
	}
	
	public void remove(Produtos produto){
		produtoDao.remove(produto);
		this.listaProdutos = produtoDao.listAll();
	}

	public Produtos getProduto() {
		return produto;
	}

	public void setProduto(Produtos produto) {
		this.produto = produto;
	}

	public ProdutosDAO getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutosDAO produtoDao) {
		this.produtoDao = produtoDao;
	}
}
