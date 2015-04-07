package br.com.home.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.home.model.Produtos;
import br.com.home.util.TipoProduto;

@Stateless
public class ProdutosDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	public void create(Produtos produto) {
		this.manager.persist(produto);
	}
	
	public void remove(Produtos produto) {
		manager.remove(manager.merge(produto));
	}
		
	public List<Produtos> listAll( ) {
		return this.manager.createQuery("SELECT p FROM Produtos p",
				Produtos.class).getResultList();
	}
	
	public List<Produtos> listaPorTipoProduto(TipoProduto tipo){
		
		String jpql = "SELECT p FROM Produtos p "
				+ "WHERE p.tipoProduto = :tipo";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("tipo", tipo);
		
		return query.getResultList();	
	}
}