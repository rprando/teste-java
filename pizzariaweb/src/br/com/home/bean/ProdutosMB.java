package br.com.home.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.com.home.dao.ProdutosDAO;
import br.com.home.model.Produtos;
import br.com.home.util.TipoProduto;

@ManagedBean(name="produtosMB")
@ViewScoped
public class ProdutosMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Produtos> produtoPizza;
	private List<Produtos> produtoBebida;
	private List<Produtos> produtoSobremesa;
	private Produtos produtoSelecionado;
	private List<Produtos> listaPedido = new ArrayList<Produtos>();
	private Produtos pedidoSelecionado;
	private double total = 0;
	
	@Inject
	private ProdutosDAO produtoDao;
		
	public List<Produtos> getProdutoPizza() {
		if(produtoPizza == null){
			produtoPizza = produtoDao.listaPorTipoProduto(TipoProduto.PIZZAS);
		}
		
		return produtoPizza;
	}
	
	public List<Produtos> getProdutoBebida() {
		if(produtoBebida == null){
			produtoBebida = produtoDao.listaPorTipoProduto(TipoProduto.BEBIDAS);
		}
		
		return produtoBebida;
	}
	
	public List<Produtos> getProdutoSobremesa() {
		if(produtoSobremesa == null){
			produtoSobremesa = produtoDao.listaPorTipoProduto(TipoProduto.SOBREMESAS);
		}
		
		return produtoSobremesa;
	}
		
	public void adicionaProdutoPizza(){
		for (Produtos p : produtoPizza) {
			if(p.getCdProduto().equals(produtoSelecionado.getCdProduto())){
				listaPedido.add(produtoSelecionado);
				break;
			}
		}
		
		precoTotal();
	}
	
	public void adicionaProdutoBebida(){
		for (Produtos p : produtoBebida) {
			if(p.getCdProduto().equals(produtoSelecionado.getCdProduto())){
				listaPedido.add(produtoSelecionado);
				break;
			}
		}
		
		precoTotal();
	}
	
	public void adicionaProdutoSobremesa(){
		for (Produtos p : produtoSobremesa) {
			if(p.getCdProduto().equals(produtoSelecionado.getCdProduto())){
				listaPedido.add(produtoSelecionado);
				break;
			}
		}
		
		precoTotal();
	}
	
	public void removeProdutoPedido(){
		for (Produtos p : listaPedido) {
			if(p.getCdProduto().equals(pedidoSelecionado.getCdProduto())){
				listaPedido.remove(pedidoSelecionado);
				break;
			}
		}
		
		precoTotal();
	}
	
	public void precoTotal(){
		total = 0;
		for(Produtos p: listaPedido){
			total += p.getPrecoProduto();
		}	
	}
	
	public double getPrecoTotal(){		
		if(total == 0){
			precoTotal();
		}
		return total;
	}
	
	public String finalizarPedido(){
		return "produtos?faces-redirect=true";
	}
	
	//Getters and Setters
	public Produtos getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produtos produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	public List<Produtos> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Produtos> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public Produtos getPedidoSelecionado() {
		return pedidoSelecionado;
	}

	public void setPedidoSelecionado(Produtos pedidoSelecionado) {
		this.pedidoSelecionado = pedidoSelecionado;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ProdutosDAO getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutosDAO produtoDao) {
		this.produtoDao = produtoDao;
	}
}
